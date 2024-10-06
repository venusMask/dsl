grammar DSL;

import DSLLEXER;

@header {
package org.venus.dsl.gen;
}

dsl: rule;

rule                    :  ruleGroup                           # singleRule
                        |  ruleDeclare ruleGroup+ judge        # multipleRule
                        ;

ruleDeclare             : ruleID (SEPARATOR ruleNameCn)? (SEPARATOR ruleNameEn)? ;
ruleID                  : ALPHANUM ;
ruleNameCn              : ALLCHAR ;
ruleNameEn              : ALPHANUM ;

ruleGroup               :  ruleDeclare ruleDefinition+ judge;
ruleDefinition          :  ruleID SEPARATOR ruleItem ';' ;
ruleItem                :  expression (SEPARATOR '且' SEPARATOR expression)*;
expression              :  field SEPARATOR* function* SEPARATOR*  '='   SEPARATOR*  value       # eq
                        |  field SEPARATOR* function* SEPARATOR*  '属于' SEPARATOR*  value       # in
                        |  field SEPARATOR* function* SEPARATOR*  '包含' SEPARATOR*  value       # contains
                        ;

value                   :  ALLCHAR;
field                   :  ALLCHAR;
function                :  '->' '[' ALLCHAR ']';

judge                   : match* allMatch? noneMatch? anyMatch? other;
match                   : '满足' SEPARATOR EXPR SEPARATOR '值域' SEPARATOR result ';';
allMatch                : '均满足值域' SEPARATOR result  ;
noneMatch               : '均不满足值域' SEPARATOR result  ;
anyMatch                : '任一满足值域' SEPARATOR result  ;
other                   : '其他值域' SEPARATOR result  ;
result                  : STRING ;