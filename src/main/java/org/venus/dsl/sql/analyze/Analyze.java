package org.venus.dsl.sql.analyze;

import lombok.Data;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.venus.dsl.sql.ast.DslLexer;
import org.venus.dsl.sql.ast.DslParser;
import org.venus.dsl.sql.parse.AstParse;
import org.venus.dsl.sql.parse.node.*;
import org.venus.dsl.sql.visitor.BaseVisitor;
import org.venus.dsl.sql.visitor.MultipleRuleVisitor;
import org.venus.dsl.sql.visitor.SingleRuleVisitor;

import java.util.HashMap;
import java.util.List;

/**
 * 进行语义分析完成之后的结果
 */
@Data
public class Analyze {

    private final HashMap<String, RuleGroupNode> ruleGroups = new HashMap<>();

    private Boolean isSingleRule;

    public Analyze(SingleRuleNode singleRuleNode) {
        this.isSingleRule = true;
        RuleGroupNode groupNode = singleRuleNode.getRuleGroup();
        String ruleCode = groupNode.getRuleDeclare().getRuleCode();
        ruleGroups.put(ruleCode, groupNode);
    }

    public Analyze(MultipleRuleNode multipleRuleNode) {
        this.isSingleRule = false;
        List<RuleGroupNode> groups = multipleRuleNode.getRuleGroups();
        for (RuleGroupNode groupNode : groups) {
            String ruleCode = groupNode.getRuleDeclare().getRuleCode();
            ruleGroups.put(ruleCode, groupNode);
        }
    }

    public RuleGroupNode getRuleGroup(String ruleCode) {
        return ruleGroups.get(ruleCode);
    }

    public RuleDefinitionNode getRuleDefinitionNode(String ruleGroupID,
                                                    String ruleDefinitionID) {
        RuleGroupNode ruleGroupNode = ruleGroups.get(ruleGroupID);
        HashMap<String, RuleDefinitionNode> definitionMap = ruleGroupNode.getRuleDefinitionMap();
        RuleDefinitionNode node = definitionMap.get(ruleDefinitionID);
        return node;
    }

    public RuleDefinitionNode getRuleDefinitionNode(String ruleDefinitionID) {
        return ruleGroups
                .values()
                .stream()
                .findFirst()
                .map(ruleGroupNode -> getRuleDefinitionNode(ruleGroupNode.getRuleDeclare().getRuleCode(), ruleDefinitionID))
                .orElse(null);
    }

    public static BaseVisitor parse(String input) {
        CharStream charStream = CharStreams.fromString(input);
        DslLexer lexer = new DslLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DslParser parser = new DslParser(tokens);
        ParseTree root = parser.dsl();
        AstParse dslVisitor = new AstParse();
        Node node = dslVisitor.visit(root);
        // 单节点
        if(node instanceof SingleRuleNode) {
            Analyze analyze = new Analyze((SingleRuleNode) node);
            return new SingleRuleVisitor((SingleRuleNode) node, analyze);
        } else if (node instanceof MultipleRuleNode) {
            Analyze analyze = new Analyze((MultipleRuleNode) node);
            return new MultipleRuleVisitor((MultipleRuleNode) node, analyze);
        }
        throw new RuntimeException("Unreachable");
    }

}
