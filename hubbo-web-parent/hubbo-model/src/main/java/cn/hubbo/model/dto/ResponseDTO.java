/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/16 18:54
 * 限定类名: cn.hubbo.model.dto.ResponseDTO
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.model.dto;

import cn.hubbo.model.vo.ResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseDTO<T> extends ResultVO<T> {

    private final Short code;

    private final String msg;

    private final T data;

    private final Long timestamp;

    private ResponseDTO() {
        this.code = null;
        this.msg = null;
        this.data = null;
        this.timestamp = null;
    }

    public ResponseDTO(ResultVO<T> result) {
        this.code = result.getCode();
        this.msg = result.getMsg();
        this.data = result.getData();
        this.timestamp = System.currentTimeMillis();
    }
}
