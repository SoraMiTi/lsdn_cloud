package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 首页年统计表
 *
 * @author b_xugang
 */
@Entity
@Table(name = "BS_HOME_YEAR")
public class IndexYearEntity implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = -7236167805937162268L;

    /**
     * ID
     */
    private String id;

    /**
     * 指标编码
     */
    private String code;

    /**
     * 年份
     */
    private String year;

    /**
     * 指标数值
     */
    private Double value;

    /**
     * 指标类型
     */
    private String type;

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

    @Column(name = "YEAR")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "VALUE")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "IndexYearEntity [id=" + id + ", code=" + code + ", year="
                + year + ", value=" + value + ", type=" + type
                + ", updateTime=" + updateTime + "]";
    }

}
