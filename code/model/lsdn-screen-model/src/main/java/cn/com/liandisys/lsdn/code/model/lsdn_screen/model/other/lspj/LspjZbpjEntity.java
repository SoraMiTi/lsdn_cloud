package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.lspj;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * T_06005_绿电指标评价数据表
 *
 * @author b_fangzheng
 */
@Entity
@Table(name = "O_L_LSPJ_ZBPJ")
public class LspjZbpjEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 电厂编号
     */
    private String plantId;

    /**
     * 机组编号
     */
    private String genId;

    /**
     * 装机容量（万千瓦）
     */
    private Double zjrl;

    /**
     * 发电量（万千瓦时）
     */
    private Double fdl;

    /**
     * 单位电量氮氧化物排放率（克/千瓦时）
     */
    private Double noxpfl;

    /**
     * 单位电量二氧化硫排放率（克/千瓦时）
     */
    private Double so2pfl;

    /**
     * 发电用水率（吨/万千瓦时）
     */
    private Double fdysl;

    /**
     * 单位电量烟尘排放率（克/千瓦时）
     */
    private Double yxpfl;

    /**
     * 厂用电率（%）
     */
    private Double cydl;

    /**
     * 供电煤耗（克标煤/千瓦时）
     */
    private Double gdmh;

    /**
     * AGC性能
     */
    private Double agcxn;

    /**
     * AVC性能
     */
    private Double avcxn;

    /**
     * 一次调频性能
     */
    private Double yctpxn;

    /**
     * 进相能力
     */
    private Double jxnl;

    /**
     * 滞相能力
     */
    private Double zxnl;

    /**
     * 强迫停运率
     */
    private Double qptyl;

    /**
     * 机组跳闸率
     */
    private Double jztzl;

    /**
     * 机组RB指数
     */
    private Double jzrbzs;

    /**
     * 黑启动能力
     */
    private Double hqdnl;

    /**
     * AGC响应
     */
    private Double agcxy;

    /**
     * AVC响应
     */
    private Double avcxy;

    /**
     * 一次调频响应
     */
    private Double yctpxy;

    /**
     * 电网热稳绝对贡献度
     */
    private Double rwdgxd;

    /**
     * 电网电压稳定绝对贡献度
     */
    private Double dywdgxd;

    /**
     * 技术管理水平
     */
    private Double jsglsp;

    /**
     * 有效值，0机组有效1电厂有效
     */
    private String flag;

    /**
     * 数据时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date dataTime;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @Column(name = "PLANT_ID")
    public String getPlantId() {

        return plantId;
    }

    public void setPlantId(String plantId) {

        this.plantId = plantId;
    }

    @Column(name = "GEN_ID")
    public String getGenId() {

        return genId;
    }

    public void setGenId(String genId) {

        this.genId = genId;
    }

    @Column(name = "ZJRL")
    public Double getZjrl() {

        return zjrl;
    }

    public void setZjrl(Double zjrl) {

        this.zjrl = zjrl;
    }

    @Column(name = "FDL")
    public Double getFdl() {

        return fdl;
    }

    public void setFdl(Double fdl) {

        this.fdl = fdl;
    }

    @Column(name = "NOXPFL")
    public Double getNoxpfl() {

        return noxpfl;
    }

    public void setNoxpfl(Double noxpfl) {

        this.noxpfl = noxpfl;
    }

    @Column(name = "SO2PFL")
    public Double getSo2pfl() {

        return so2pfl;
    }

    public void setSo2pfl(Double so2pfl) {

        this.so2pfl = so2pfl;
    }

    @Column(name = "FDYSL")
    public Double getFdysl() {

        return fdysl;
    }

    public void setFdysl(Double fdysl) {

        this.fdysl = fdysl;
    }

    @Column(name = "YXPFL")
    public Double getYxpfl() {

        return yxpfl;
    }

    public void setYxpfl(Double yxpfl) {

        this.yxpfl = yxpfl;
    }

    @Column(name = "CYDL")
    public Double getCydl() {

        return cydl;
    }

    public void setCydl(Double cydl) {

        this.cydl = cydl;
    }

    @Column(name = "GDMH")
    public Double getGdmh() {

        return gdmh;
    }

    public void setGdmh(Double gdmh) {

        this.gdmh = gdmh;
    }

    @Column(name = "AGCXN")
    public Double getAgcxn() {

        return agcxn;
    }

    public void setAgcxn(Double agcxn) {

        this.agcxn = agcxn;
    }

    @Column(name = "AVCXN")
    public Double getAvcxn() {

        return avcxn;
    }

    public void setAvcxn(Double avcxn) {

        this.avcxn = avcxn;
    }

    @Column(name = "YCTPXN")
    public Double getYctpxn() {

        return yctpxn;
    }

    public void setYctpxn(Double yctpxn) {

        this.yctpxn = yctpxn;
    }

    @Column(name = "JXNL")
    public Double getJxnl() {

        return jxnl;
    }

    public void setJxnl(Double jxnl) {

        this.jxnl = jxnl;
    }

    @Column(name = "ZXNL")
    public Double getZxnl() {

        return zxnl;
    }

    public void setZxnl(Double zxnl) {

        this.zxnl = zxnl;
    }

    @Column(name = "QPTYL")
    public Double getQptyl() {

        return qptyl;
    }

    public void setQptyl(Double qptyl) {

        this.qptyl = qptyl;
    }

    @Column(name = "JZTZL")
    public Double getJztzl() {

        return jztzl;
    }

    public void setJztzl(Double jztzl) {

        this.jztzl = jztzl;
    }

    @Column(name = "JZRBZS")
    public Double getJzrbzs() {

        return jzrbzs;
    }

    public void setJzrbzs(Double jzrbzs) {

        this.jzrbzs = jzrbzs;
    }

    @Column(name = "HQDNL")
    public Double getHqdnl() {

        return hqdnl;
    }

    public void setHqdnl(Double hqdnl) {

        this.hqdnl = hqdnl;
    }

    @Column(name = "AGCXY")
    public Double getAgcxy() {

        return agcxy;
    }

    public void setAgcxy(Double agcxy) {

        this.agcxy = agcxy;
    }

    @Column(name = "AVCXY")
    public Double getAvcxy() {

        return avcxy;
    }

    public void setAvcxy(Double avcxy) {

        this.avcxy = avcxy;
    }

    @Column(name = "YCTPXY")
    public Double getYctpxy() {

        return yctpxy;
    }

    public void setYctpxy(Double yctpxy) {

        this.yctpxy = yctpxy;
    }

    @Column(name = "RWDGXD")
    public Double getRwdgxd() {

        return rwdgxd;
    }

    public void setRwdgxd(Double rwdgxd) {

        this.rwdgxd = rwdgxd;
    }

    @Column(name = "DYWDGXD")
    public Double getDywdgxd() {

        return dywdgxd;
    }

    public void setDywdgxd(Double dywdgxd) {

        this.dywdgxd = dywdgxd;
    }

    @Column(name = "JSGLSP")
    public Double getJsglsp() {

        return jsglsp;
    }

    public void setJsglsp(Double jsglsp) {

        this.jsglsp = jsglsp;
    }

    @Column(name = "FLAG")
    public String getFlag() {

        return flag;
    }

    public void setFlag(String flag) {

        this.flag = flag;
    }

    @Column(name = "DATA_TIME")
    public Date getDataTime() {

        return dataTime;
    }

    public void setDataTime(Date dataTime) {

        this.dataTime = dataTime;
    }

}
