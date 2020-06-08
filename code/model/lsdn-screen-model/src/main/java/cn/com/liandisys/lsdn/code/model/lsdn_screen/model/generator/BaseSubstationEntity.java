package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * T_O1003_厂站台账数据
 *
 * @author b_wuxl
 */
@Entity
@Table(name = "B_BASE_SUBSTATION")
public class BaseSubstationEntity {

    /**
     * 厂站标识
     */
    private String id;

    /**
     * 厂站名称
     */
    private String name;

    /**
     * 所属分区  所属500kV供电分区——14个供电区域（可能存在两个）
     */
    private String ssfq;

    /**
     * 所属供电公司  所属供电公司——11家供电公司
     */
    private String compId;

    /**
     * 厂站类型 1.变电站  2.火电站  3.风电站  4.光电站  5.虚拟站  6.换流站  7.其他
     */
    private String type;

    /**
     * X轴偏差
     */
    private String x;

    /**
     * Y轴偏差
     */
    private String y;

    /**
     * 电压等级
     */
    private String vlty;

    /**
     * 投运时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date tysj;

    /**
     * 投运状态  0：未投运  1：投运中
     */
    private String tyzt;

    /**
     * 上次故障修复时间  用于计算累计安全运行时长
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date xfsj;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    @Id
    @Column(name = "ID", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SSFQ")
    public String getSsfq() {
        return ssfq;
    }

    public void setSsfq(String ssfq) {
        this.ssfq = ssfq;
    }

    @Column(name = "COMP_ID")
    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "X")
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    @Column(name = "Y")
    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Column(name = "VLTY")
    public String getVlty() {
        return vlty;
    }

    public void setVlty(String vlty) {
        this.vlty = vlty;
    }

    @Column(name = "TYSJ")
    public Date getTysj() {
        return tysj;
    }

    public void setTysj(Date tysj) {
        this.tysj = tysj;
    }

    @Column(name = "TYZT")
    public String getTyzt() {
        return tyzt;
    }

    public void setTyzt(String tyzt) {
        this.tyzt = tyzt;
    }

    @Column(name = "XFSJ")
    public Date getXfsj() {
        return xfsj;
    }

    public void setXfsj(Date xfsj) {
        this.xfsj = xfsj;
    }

    @Column(name = "LNG")
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Column(name = "LAT")
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

}
