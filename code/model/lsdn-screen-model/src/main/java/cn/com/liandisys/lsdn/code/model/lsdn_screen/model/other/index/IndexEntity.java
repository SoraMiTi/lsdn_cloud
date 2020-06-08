package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 首页公共数据表
 *
 * @author b_xugang
 */
@Entity
@Table(name = "BS_HOME_INDEX")
public class IndexEntity implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -2816368358572453140L;

    /**
     * ID
     */
    private String id;

    /**
     * 指标编码
     */
    private String code;

    /**
     * 指标名称
     */
    private String name;

    /**
     * 指标单位
     */
    private String unit;

    /**
     * 指标数值
     */
    private String value;

    /**
     * 指标类型
     */
    private String type;

    /**
     * 备注
     */
    private String comments;

    /**
     * 更改日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "UNIT")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "COMMENTS")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "IndexEntity [id=" + id + ", code=" + code + ", name=" + name
                + ", unit=" + unit + ", value=" + value + ", type=" + type
                + ", comments=" + comments + ", updateTime=" + updateTime + "]";
    }

}
