package com.ins.anping.utils.GetMenus;

import lombok.Data;

import java.util.List;

@Data
public class MenuItem {
    private String icontype;
    private Integer subIndex;
    private Integer level;
    private String icon;
    private Integer mainIndex;
    private Integer index;
    private String title;
    private String type;
    private Boolean isLeaf;
    private List<MenuItem> children; // 用于嵌套的children
    private List<String> nodeInfo;
    private String config;
    private String key;
    private Boolean selected;
    private String iconcolor;
}
