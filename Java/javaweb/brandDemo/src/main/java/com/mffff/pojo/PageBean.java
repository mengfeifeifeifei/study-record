package com.mffff.pojo;

import java.util.List;

public class PageBean<T> {

    private List<T> data;

    private Integer totalCount;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", totalCount=" + totalCount +
                '}';
    }
}
