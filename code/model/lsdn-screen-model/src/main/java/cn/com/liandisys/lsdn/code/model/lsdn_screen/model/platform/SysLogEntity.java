package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * 系统日志
 *
 * @author DYQ
 */
@Entity
@Table(name = "t_sys_log")
public class SysLogEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 时间
     **/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date sj;

    /**
     * 日志类型
     **/
    private String rzlx;

    /**
     * IP地址
     **/
    private String ip;

    /**
     * 用户名
     **/
    private String yhm;

    /**
     * 操作对象
     **/
    private String czdx;

    /**
     * 操作行为
     **/
    private String czxw;

    /**
     * 操作结果
     **/
    private String czjg;

    /**
     * 备注
     **/
    private String memo;

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "sj")
    public Date getSj() {

        return sj;
    }

    public void setSj(Date sj) {

        this.sj = sj;
    }

    @Column(name = "rzlx")
    public String getRzlx() {

        return rzlx;
    }

    public void setRzlx(String rzlx) {

        this.rzlx = rzlx;
    }

    @Column(name = "ip")
    public String getIp() {

        return ip;
    }

    public void setIp(String ip) {

        this.ip = ip;
    }

    @Column(name = "yhm")
    public String getYhm() {

        return yhm;
    }

    public void setYhm(String yhm) {

        this.yhm = yhm;
    }

    @Column(name = "czdx")
    public String getCzdx() {

        return czdx;
    }

    public void setCzdx(String czdx) {

        this.czdx = czdx;
    }

    @Column(name = "czxw")
    public String getCzxw() {

        return czxw;
    }

    public void setCzxw(String czxw) {

        this.czxw = czxw;
    }

    @Column(name = "czjg")
    public String getCzjg() {

        return czjg;
    }

    public void setCzjg(String czjg) {

        this.czjg = czjg;
    }

    @Column(name = "memo")
    public String getMemo() {

        return memo;
    }

    public void setMemo(String memo) {

        this.memo = memo;
    }

}
