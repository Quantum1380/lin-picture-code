package com.linyu.linpicturebackend.common;

import lombok.Data;

/**
 * 通用的分页请求类
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    protected int current = 1;

    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = "descend";
}