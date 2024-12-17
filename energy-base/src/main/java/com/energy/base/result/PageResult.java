package com.energy.base.result;

import com.energy.base.code.BaseCode;
import com.energy.base.code.ICode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author zhangwenlin
 * @since 2024-12-17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult<T> extends BaseResult implements IResult<List<T>>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分页页码（默认1）
     */
    private Integer pageIndex;

    /**
     * 分页大小（默认10）
     */
    private Integer pageSize;

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


    /**
     * 页码对应数据
     */
    private List<T> data;

    public PageResult() {
    }

    public PageResult(Boolean success) {
        super(success);
    }

    public PageResult(ICode code) {
        super(code);
    }

    public PageResult(Boolean success, String code, String message) {
        super(success, code, message);
    }

    public PageResult(Pager pager, List<T> list) {
        super(Optional.ofNullable(list).map(e -> BaseCode.SUCCESS).orElse(BaseCode.ERROR));
        this.pageIndex = pager.getPageIndex();
        this.pageSize = pager.getPageSize();
        this.total = pager.getTotal();
        this.next = pager.getNext();
        this.cnt = pager.getCnt();
        this.data = list;
    }


}