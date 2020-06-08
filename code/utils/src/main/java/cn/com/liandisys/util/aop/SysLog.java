package cn.com.liandisys.util.aop;

import cn.com.liandisys.idev.modules.common.Constants;

import java.lang.annotation.*;

/**
 * 自定义系统日志注解
 * 
 * @author DYQ
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 日志类型 一般操作日志/附件日志
     * 
     * @return
     */
    String logType() default Constants.LOG_TYPE_COMMON;

    /**
     * 业务类型（业务模块名称）
     * 
     * @return
     */
    String busiType() default "";

    /**
     * 操作类型 新增、修改、删除
     * 
     * @return
     */
    String methodType() default "";

    /**
     * 备注
     * 
     * @return
     */
    String memo() default "";
}
