package com.energy.base.result;

import lombok.Data;

import java.beans.Transient;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@Data
public class Pager implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分页页码（默认1）
     */
    private Integer pageIndex = 1;

    /**
     * 分页大小（默认10）
     */
    private Integer pageSize = 10;

    /**
     * 分数数据总量
     */
    private Integer total;

    /**
     * 是否存在下一页
     */
    private Boolean next;

    /**
     * 分页返回数量
     */
    private Integer cnt;

    private Integer start;

    private Integer end;

    public Pager() {

    }

    public Pager(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    @Transient
    public Integer getStart() {
        return start;
    }

    @Transient
    public Integer getEnd() {
        return end;
    }

    /**
     * 计算分页limit开始结束参数
     */
    public void setPage() {
        //第一页从0开始，第二页从从pageSize开始
        this.start = pageIndex - 1 == 0 ? 0 : (pageIndex - 1) * pageSize;
        this.end = pageSize;
    }


    /**
     * 计算分页返回赋值
     *
     * @param total 数据总量
     * @param cnt   分页返回数量
     */
    public void setPage(Integer total, Integer cnt) {
        this.total = total;
        this.cnt = cnt;
        //第一页:总数 > 分页返回数量存在下一页，第二页:总数 > pageSize+cnt 存在下一页
        this.next = pageIndex - 1 == 0 ? total > cnt : total > (pageIndex - 1) * pageSize + cnt;
    }
}