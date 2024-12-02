package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DictMappingNode extends Node {

    private String dictName;

}
