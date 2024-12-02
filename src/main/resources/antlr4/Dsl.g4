grammar Dsl;

@header {
package org.venus.dsl.sql.ast;
}

// 不能使用rule作为名称,否则生成的RuleContext会跟内置的RuleContext冲突导致报错
dsl             : ruleGroup+                                    #singleRule
                | ruleDeclare ruleGroup+ '{' assertion '}'      #multipleRule
                ;

ruleGroup       : ruleDeclare   ruleDefinition+ assertion;

ruleDeclare     : ruleCode = ID ruleName = STRING;

ruleDefinition  : ruleCode = ID ruleLogic (SEMICOLON ruleLogic)*;

ruleLogic
                :  lhs = valueTake  dictMapping* op = EQ  rhs = value                # eqExpr
                |  lhs = valueTake  dictMapping* op = NE  rhs = value                # neExpr
                |  lhs = valueTake  dictMapping* op = IN  rhs = value                # inExpr
                ;

dictMapping     : '->' STRING_SQUARE_BRACKETS;

assertion       : match+ ('其他输出' outputExpr)*;

match           : '满足'  logicExpr '输出'  outputExpr;

value           : DIGIT
                | STRING
                | '{' STRING (',' STRING)* '}'
                ;

inValue         : '{' value (',' value)* '}'
                ;

logicExpr
                : op = NOT rhs = logicExpr                                # NotExpr
                | lhs = logicExpr op = AND rhs = logicExpr                # AndExpr
                | lhs = logicExpr op = OR  rhs = logicExpr                # OrExpr
                | LP logicExpr RP                                         # ParenLogicExpr
                | ruleCode = ID                                           # RuleItemExpr
                ;

outputExpr
                : functionName = ID  '(' outputExpr* ')'                # FunctionCallSymbol
                | lhs = outputExpr op = '*' rhs = outputExpr            # MulExpr
                | lhs = outputExpr op = '/' rhs = outputExpr            # DivExpr
                | lhs = outputExpr op = '+' rhs = outputExpr            # AddExpr
                | lhs = outputExpr op = '-' rhs = outputExpr            # SubExpr
                | DIGIT                                                 # NumberVarExpr
                | STRING                                                # StringVarExpr
                | FIELD_TAKE                                            # FieldVarExpr
                | '(' outputExpr ')'                                    # ParenPolyExpr
                ;

valueTake
                :'(' ID ')'       # RuleTake
                | '（' ID '）'     # RuleTake
                | FIELD_TAKE      # FieldTake
                ;

/* 词法部分只设计通用词, 并不考虑词的具体含义, 具体词的含义在上面语法部分定义 */
FIELD_TAKE              : '${' .*? '}';

LP                      : '(';
RP                      : ')';
EQ                      : '=' | '==' | '等于';
NE                      : '≠' | '!=' | '不等于';
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