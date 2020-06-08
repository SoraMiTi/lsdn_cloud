package cn.com.liandisys.util.result;


import cn.com.liandisys.idev.modules.common.Constants;

/**
 * WebService请求返回数据
 * 
 * @author DYQ
 */
public class ResponseInfo {

    /** 状态 success/error */
    private String status;

    /** 返回信息 */
    private String msg;

    /** 返回结果 */
    private Object result;

    /**
     * 基础构造函数
     * 
     * @param status
     * @param msg
     * @param result
     */
    public ResponseInfo(String status, String msg, Object result) {

        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    /**
     * 返回信息
     * 
     * @param status
     * @param msg
     */
    public ResponseInfo(String status, String msg) {

        this.status = status;
        this.msg = msg;
    }

    /**
     * 成功返回
     * 
     * @param result
     */
    public ResponseInfo(Object result) {

        this.status = Constants.SUCCESS;
        this.result = result;
    }

    /**
     * 错误返回
     * 
     * @param msg
     */
    public ResponseInfo(String msg) {

        this.status = Constants.ERROR;
        this.msg = msg;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }

    public Object getResult() {

        return result;
    }

    public void setResult(Object result) {

        this.result = result;
    }

}
