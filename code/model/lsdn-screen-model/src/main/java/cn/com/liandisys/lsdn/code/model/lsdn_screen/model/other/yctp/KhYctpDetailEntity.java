package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.yctp;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * 考核-一次调频-相关机组数据
 *
 * @author b_wuxl
 */
@Entity
@Table(name = "O_KH_YCTP_DETAIL")
public class KhYctpDetailEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 一次调频编号
     */
    private String yctpId;

    /**
     * 数据时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:ss:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:ss:mm", timezone = "GMT+8")
    private Date dataTime;

    /**
     * 电网频率
     */
    private Double hz;

    /**
     * 有功功率
     */
    private Double yg;

    /**
     * 实际积分容量
     */
    private Double qsy;

    /**
     * 理论积分容量
     */
    private Double qjy;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "YCTP_ID")
    public String getYctpId() {
        return yctpId;
    }

    public void setYctpId(String yctpId) {
        this.yctpId = yctpId;
    }

    @Column(name = "DATA_TIME")
    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    @Column(name = "HZ")
    public Double getHz() {
        return hz;
    }

    public void setHz(Double hz) {
        this.hz = hz;
    }

    @Column(name = "YG")
    public Double getYg() {
        return yg;
    }

    public void setYg(Double yg) {
        this.yg = yg;
    }

    @Column(name = "QSY")
    public Double getQsy() {
        return qsy;
    }

    public void setQsy(Double qsy) {
        this.qsy = qsy;
    }

    @Column(name = "QJY")
    public Double getQjy() {
        return qjy;
    }

    public void setQjy(Double qjy) {
        this.qjy = qjy;
    }

}
