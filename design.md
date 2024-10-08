# 规则设计
规则设计同时支持单个规则组和多个规则组
## 单个规则组
eg:
```text
rule_group_id_1 第一个规则组的中文名称 rule_group_english_name comment: "对当前规则组的注释"
1、标本部位 属于 {肺, 气管};
2、病灶部位 = 肺 且 病灶存在状态 属于 {确定, 疑似, 拟};
满足: "1 and 2" 值域: "是";
```
1. rule_group_id_1 是必须的且不能包含中文. 分隔符支持 `/` `_` `-`, 如果包含空格使用双引号包裹. "rule group id 1".
2. 中文名称不是必须的.
3. 英文名称不是必须的(不能包含中文).
4. comment: "". 关键字不能去掉.
5. 如果字段部分属于多个值中的一个则使用 `{}` 进行包裹, 使用 `,` 分隔.
6. 满足和值域的值使用双引号包含, 满足部分的组合条件使用 `and or`.  


## 多个规则组
```text
rule_id 规则中文名称 ruleenglish_name comment: "对当前规则的注释"
rule_group_id_1 第一个规则组的中文名称 rule_group_english_name comment: "对当前规则组的注释"
1、标本部位 属于 {肺, 气管};
2、病灶部位 = 肺 且 病灶存在状态 属于 {确定, 疑似, 拟};
满足: "1 and 2" 值域: "是";
rule_group_id_2 第一个规则组的中文名称 rule_group_english_name comment: "对当前规则组的注释"
1、标本部位 属于 {肺, 气管};
2、病灶部位 = 肺 且 病灶存在状态 属于 {确定, 疑似, 拟};
满足: "1 and 2" 值域: "是";
总结:
满足: "1 and 2" 值域: "是";
```
1. 相对于单个的规则组, 全部规则的判断条件是以 `总结:` 开始.