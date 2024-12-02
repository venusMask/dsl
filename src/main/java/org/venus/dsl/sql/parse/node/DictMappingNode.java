package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DictMappingNode extends Node {

    private String dictName;

}
