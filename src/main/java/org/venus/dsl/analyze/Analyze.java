package org.venus.dsl.analyze;

import lombok.Data;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.venus.dsl.ast.DslLexer;
import org.venus.dsl.ast.DslParser;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.AstParse;
import org.venus.dsl.parse.node.*;

import java.util.HashMap;
import java.util.List;

/**
 * 进行语义分析完成之后的结果
 */
@Data
public class Analyze {

    private final HashMap<String, RuleGroupNode> ruleGroups = new HashMap<>();

    private Boolean isSingleRule;

    private final HashMap<String, TreeNode> roots = new HashMap<>();

    public Analyze() {}

    public TreeNode getRoot(String tableName) {
        TreeNode root = roots.get(tableName);
        if (root == null) {
            throw new NullPointerException("There is no root for table " + tableName);
        }
        return root;
    }

    public void addRoot(String tableName, TreeNode root) {
        roots.put(tableName, root);
    }

    public void initSingleRule(SingleRuleNode singleRuleNode) {
        this.isSingleRule = true;
        RuleGroupNode groupNode = singleRuleNode.getRuleGroup();
        String ruleCode = groupNode.getRuleDeclare().getRuleCode();
        ruleGroups.put(ruleCode, groupNode);
    }

    public void initMultipleRules(MultipleRuleNode multipleRuleNode) {
        this.isSingleRule = false;
        List<RuleGroupNode> groups = multipleRuleNode.getRuleGroups();
        for (RuleGroupNode groupNode : groups) {
            String ruleCode = groupNode.getRuleDeclare().getRuleCode();
            ruleGroups.put(ruleCode, groupNode);
        }
    }

    public RuleGroupNode getRuleGroup(String ruleGroupCode) {
        return ruleGroups.get(ruleGroupCode);
    }

    public RuleDefinitionNode getRuleDefinitionNode(String ruleGroupID,
                                                    String ruleDefinitionID) {
        RuleGroupNode ruleGroupNode = ruleGroups.get(ruleGroupID);
        HashMap<String, RuleDefinitionNode> definitionMap = ruleGroupNode.getRuleDefinitionMap();
        RuleDefinitionNode node = definitionMap.get(ruleDefinitionID);
        return node;
    }

    public Node parse(String input) {
        CharStream charStream = CharStreams.fromString(input);
        DslLexer lexer = new DslLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DslParser parser = new DslParser(tokens);
        ParseTree root = parser.dsl();
        AstParse dslVisitor = new AstParse();
        return dslVisitor.visit(root);
    }

}
