package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.yctp;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * O_KH_YCTP
 *
 * @author b_wuxl
 */
@Entity
@Table(name = "O_KH_YCTP")
public class KhYctpEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 机组编号
     */
    private String genId;

    /**
     * 计算开始时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date startTime;

    /**
     * 计算结束时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date endTime;

    /**
     * 越频恢复时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date recoveryTime;

    /**
     * 实际积分容量
     */
    private Long qsy;

    /**
     * 理论积分容量
     */
    private Long qjy;

    /**
     * 积分容量比
     */
    private Long dx;

    /**
     * 评价结果
     */
    private String pj;

    /**
     * 合格率
     */
    private Long hgl;

    /**
     * 15秒响应占比
     */
    private Long xyzb15;

    /**
     * 30秒响应占比
     */
    private Long xyzb30;

    /**
     * 多长时间达到百分之50%
     */
    private Long xysc50;

    /**
     * 多长时间达到百分之75%
     */
    private Long xysc75;

    /**
     * 多长时间达到百分之90%
     */
    private Long xysc90;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "GEN_ID")
    public String getGenId() {
        return genId;
    }

    public void setGenId(String genId) {
        this.genId = genId;
    }

    @Column(name = "START_TIME")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "END_TIME")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Column(name = "RECOVERY_TIME")
    public Date getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(Date recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    @Column(name = "QSY")
    public Long getQsy() {
        return qsy;
    }

    public void setQsy(Long qsy) {
        this.qsy = qsy;
    }

    @Column(name = "QJY")
    public Long getQjy() {
        return qjy;
    }

    public void setQjy(Long qjy) {
        this.qjy = qjy;
    }

    @Column(name = "DX")
    public Long getDx() {
        return dx;
    }

    public void setDx(Long dx) {
        this.dx = dx;
    }

    @Column(name = "PJ")
    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    @Column(name = "HGL")
    public Long getHgl() {
        return hgl;
    }

    public void setHgl(Long hgl) {
        this.hgl = hgl;
    }

    @Column(name = "XYZB15")
    public Long getXyzb15() {
        return xyzb15;
    }

    public void setXyzb15(Long xyzb15) {
        this.xyzb15 = xyzb15;
    }

    @Column(name = "XYZB30")
    public Long getXyzb30() {
        return xyzb30;
    }

    public void setXyzb30(Long xyzb30) {
        this.xyzb30 = xyzb30;
    }

    @Column(name = "XYSC50")
    public Long getXysc50() {
        return xysc50;
    }

    public void setXysc50(Long xysc50) {
        this.xysc50 = xysc50;
    }

    @Column(name = "XYSC75")
    public Long getXysc75() {
        return xysc75;
    }

    public void setXysc75(Long xysc75) {
        this.xysc75 = xysc75;
    }

    @Column(name = "XYSC90")
    public Long getXysc90() {
        return xysc90;
    }

    public void setXysc90(Long xysc90) {
        this.xysc90 = xysc90;
    }

}
