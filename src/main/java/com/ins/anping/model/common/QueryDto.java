package com.ins.anping.model.common;

import lombok.Data;

@Data
public class QueryDto {
    private String field;
    private Object value;
    private Integer isLike;
}
