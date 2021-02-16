package argin.io.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable{

    private Boolean flag;
    private Integer code;
    private String message;
    private Long total;
    private Object data;

    private R() {
    }

    /**
     * 通用返回成功
     */
    public static R ok() {
        R r = new R();
        r.setFlag(true);
        r.setCode(200);
        return r;
    }

    /**
     * 通用返回失败
     */
    public static R error() {
        R r = new R();
        r.setFlag(false);
        r.setCode(444);
        return r;
    }

    /**
     * 自定义返回结果
     *
     */
    public R flag(Boolean flag) {
        this.setFlag(flag);
        return this;
    }

    /**
     * 自定义状态码
     *
     */
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 自定义状态信息
     *
     */
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

     /**
     * 自定义返回数据
     *
     */
    public R data(Object map) {
        this.setData(map);
        return this;
    }

    public R total(Long total) {
        this.setTotal(total);
        return this;
    }

}
