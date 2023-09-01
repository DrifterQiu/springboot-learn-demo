package com.example.myBatis.untils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiuyu
 * @date 2023年09月01日 09:12
 */
public class PageUtil implements Serializable {

    private static final long serialVersionUID = 4134597479338628931L;

    private int pageSize = 20;

    private int pageNum = 1;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


    @Override
    public String toString() {
        return "PageUtil{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }
}
