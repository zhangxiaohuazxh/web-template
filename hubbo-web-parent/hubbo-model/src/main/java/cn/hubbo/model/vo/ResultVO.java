/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/16 18:53
 * 限定类名: cn.hubbo.model.vo.ResultVO
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.model.vo;

import static cn.hubbo.commons.ex.BusinessStatusCode.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;

import cn.hubbo.commons.ex.BusinessException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ResultVO<T> {

    /**
     * 成功的编码从0开始,不一定用的到 错误状态码从10000开始编码
     */
    private final Short code;

    /**
     * 错误的描述信息
     */
    private final String msg;

    /**
     * 响应给客户端的数据或错误的具体信息
     */
    private final T data;

    /**
     * 调用此函数无意思,编译器强制要求提供一个无参构造
     */
    public ResultVO() {
        this.code = DEFAULT_ERROR_CODE;
        this.msg = DEFAULT_ERROR_MSG;
        this.data = null;
    }

    private ResultVO(Short code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultVO<T> success() {
        return new ResultVO<>(DEFAULT_SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(DEFAULT_SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> ResultVO<T> error() {
        return new ResultVO<>(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG, null);
    }

    public static <T> ResultVO<T> error(T data) {
        return new ResultVO<>(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MSG, data);
    }

    public static <T> ResultVO<T> error(Short code, String msg, T data) {
        return new ResultVO<>(code, msg, data);
    }

    @SuppressWarnings({"unchecked"})
    public ResultVO<?> append(ImmutablePair<String, Object>... pairs) {
        if (this.code == null) {
            throw new BusinessException(UNKNOWN_ERROR_CODE, "构造的数据不合法 code = null");
        }
        if (this.data == null) {
            var data = new HashMap<String, Object>(pairs.length >= 12 ? 32 : 16);
            for (var pair : pairs) {
                data.put(pair.getKey(), pair.getValue());
            }
            return new ResultVO<>(this.code, this.msg, data);
        }
        if (this.data instanceof Map) {
            var data = (Map<String, Object>)this.data;
            for (var pair : pairs) {
                data.put(pair.getKey(), pair.getValue());
            }
        } else {
            return new ResultVO<>(this.code, this.msg, pairs);
        }
        return this;
    }

}
