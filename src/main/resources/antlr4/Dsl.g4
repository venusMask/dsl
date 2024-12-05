grammar Dsl;

@header {
package org.venus.dsl.ast;
}

dsl             : ruleGroup                                     #singleRule
                | ruleDeclare ruleGroup+ '{' assertion '}'      #multipleRule
                ;

ruleGroup       : ruleDeclare   ruleDefinition+ assertion;

ruleDeclare     : ruleCode = ID ruleName = STRING;

ruleDefinition  : ruleCode = ID ruleLogic (SEMICOLON ruleLogic)*;

ruleLogic
                :  lhs = valueTake  dictMapping* op = EQ         rhs = valueTake     #EqRuleExpr
                |  lhs = valueTake  dictMapping* op = NE         rhs = valueTake     #NeRuleExpr
                |  lhs = valueTake  dictMapping* op = IN         rhs = valueTake     #InRuleExpr
                |  lhs = valueTake  dictMapping* op = '+'        rhs = valueTake     #AddRuleExpr
                |  lhs = valueTake  dictMapping* op = '-'        rhs = valueTake     #SubRuleExpr
                |  lhs = valueTake  dictMapping* op = '*'        rhs = valueTake     #MulRuleExpr
                |  lhs = valueTake  dictMapping* op = '/'        rhs = valueTake     #DivRuleExpr
                |  lhs = valueTake  dictMapping* op = '>'        rhs = valueTake     #GtRuleExpr
                |  lhs = valueTake  dictMapping* op = '>='       rhs = valueTake     #GeRuleExpr
                |  lhs = valueTake  dictMapping* op = '<'       rhs = valueTake      #LtRuleExpr
                |  lhs = valueTake  dictMapping* op = '<='       rhs = valueTake     #LeRuleExpr
                |  lhs = valueTake  dictMapping* op = CONTAINS   rhs = valueTake     #ContainsRuleExpr
                |  lhs = valueTake  dictMapping* op = NOTCONTAINS   rhs = valueTake  #NotContainsRuleExpr
                ;

dictMapping     : '->' STRING_SQUARE_BRACKETS;

assertion       : match+ ('其他输出' outputExpr)*;

match           : '满足'  logicExpr '输出'  outputExpr;

valueTake
                :'(' ID ')'       #RuleTake
                | '（' ID '）'     #RuleTake
                | FIELD_TAKE      #FieldTake
                | DIGIT           #NumberTake
                | STRING          #StringTake
                | '{' STRING (',' STRING)* '}' #ListTake
                ;

logicExpr
                : op = NOT rhs = logicExpr                                #NotLogicExpr
                | lhs = logicExpr op = AND rhs = logicExpr                #AndLogicExpr
                | lhs = logicExpr op = OR  rhs = logicExpr                #OrLogicExpr
                | LP logicExpr RP                                         #NestLogicExpr
                | ruleCode = ID                                           #RuleCodeLogicExpr
                ;

outputExpr
                : functionName = ID  '(' outputExpr* ')'                #FunctionOutputExpr
                | lhs = outputExpr op = '*' rhs = outputExpr            #MulOutputExpr
                | lhs = outputExpr op = '/' rhs = outputExpr            #DivOutputExpr
                | lhs = outputExpr op = '+' rhs = outputExpr            #AddOutputExpr
                | lhs = outputExpr op = '-' rhs = outputExpr            #SubOutputExpr
                | DIGIT                                                 #NumberOutputExpr
                | STRING                                                #StringOutputExpr
                | FIELD_TAKE                                            #FieldOutputExpr
                | '(' outputExpr ')'                                    #NestOutputExpr
                ;

/* 词法部分只设计通用词, 并不考虑词的具体含义, 具体词的含义在上面语法部分定义 */
FIELD_TAKE              : '${' .*? '}';

LP                      : '(';
RP                      : ')';
EQ                      : '=' | '==' | '等于';
NE                      : '≠' | '!=' | '不等于';
CONTAINS                : 'contains';
NOTCONTAINS             : 'not_contains';
IN                      : 'in' | '->' | '属于';
NOT                     : '!' | 'not' | 'NOT';
AND                     : '&' | 'and' | 'AND';
OR                      : '|' | 'or' | 'OR';

SEMICOLON               : ';' |'；';

STRING_PARENS_CN        : '（' ( '\\（' |'\\）'| . )*? '）' ;

ID                      : LETTER (LETTER | DIGIT)*;
LETTER                  : [a-zA-Z_-];
DIGIT                   : [0-9]+ ;

STRING                  : STRING_SINGLE_QUOTES | STRING_DOUBLE_QUOTES | STRING_DOUBLE_QUOTES_CN;
STRING_SQUARE_BRACKETS  : '[' ( '\\[' |'\\]'|. )*? ']' ;

fragment
STRING_SINGLE_QUOTES    : '\'' ( '\'' | . )*? '\'' ;

fragment
STRING_DOUBLE_QUOTES    : '"' ( '\\"' | . )*? '"' ;

fragment
STRING_DOUBLE_QUOTES_CN : '“' ( '\\“' |'\\”'|. )*? '”' ;

WS                      : [ \t\r\n]+    -> skip ;
COMMENT                 : '/*' .*? '*/' -> skip;
LINE_COMMENT            : '//' ~[\r\n]* -> skip;