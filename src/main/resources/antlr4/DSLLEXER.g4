lexer grammar DSLLEXER;

fragment INT_FRAGMENT                   : [0-9];
fragment CHAR_CN_FRAGMENT               : [\u4e00-\u9fff];
fragment CHAR_EN_FRAGMENT               : [a-zA-Z];
fragment PUNCTUATION_FRAGMENT           : [_/-];
fragment SPACE_FRAGMENT                 : [ \t];
fragment NONE_EMPTY_DELIMITER_FRAGMENT  : '、'|'.'|':'|'：'|'。'|','|'，';
fragment INT_EN_PUNCTUATION             : INT_FRAGMENT
                                        | CHAR_EN_FRAGMENT
                                        | PUNCTUATION_FRAGMENT
                                        ;

// 通用分隔符, 具体的限制逻辑在业务代码中处理
SEPARATOR: SPACE_FRAGMENT+
          |SPACE_FRAGMENT* NONE_EMPTY_DELIMITER_FRAGMENT SPACE_FRAGMENT*
          ;

// 在 ALPHANUM 的基础之上要求必须包含一个中文
ALLCHAR : ALPHANUM* CHAR_CN_FRAGMENT+ ALPHANUM*;

// 分隔符/数字/英文字母的任意组合 但是不能只包含分隔符
ALPHANUM : INT_EN_PUNCTUATION* (INT_FRAGMENT | CHAR_EN_FRAGMENT)+ INT_EN_PUNCTUATION*;

// 任意数字字符串
INT: INT_FRAGMENT+;

EXPR:   [a-zA-Z0-9/_+()-]+ ;
STRING: '"' .*? '"';

COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WS  :    [ \t\r\n]+ -> skip ; // toss out whitespace