package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.lspj;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * O_L_LSPJ_ZJPJ
 *
 * @author b_fangzheng
 */
@Entity
@Table(name = "O_L_LSPJ_ZJPJ")
public class LspjPjzjEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 能源消耗总量(万吨标煤)
     */
    private Double nyxhzl;

    /**
     * 全社会用电量(亿千瓦时)
     */
    private Double qshydl;

    /**
     * 万元产值电耗下降率(%)
     */
    private Double wyczdhxjl;

    /**
     * 售电量(亿千瓦时)
     */
    private Double sdl;

    /**
     * 综合线损率(%)
     */
    private Double zhxsl;

    /**
     * 跨区实际购电量(亿千瓦时)
     */
    private Double kqsjgdl;

    /**
     * 跨省实际调入电量(亿千瓦时)
     */
    private Double kqsjdrl;

    /**
     * 跨省实际直流购电量(万千瓦时)
     */
    private Double kssjzlgdl;

    /**
     * 电力消费弹性指数
     */
    private Double dlxftxzs;

    /**
     * 年日均用电量(万千瓦时)
     */
    private Double nrjydl;

    /**
     * 供电煤耗(克标煤/千瓦时)
     */
    private Double gdmh;

    /**
     * 居民用电平均电价(元/千千瓦时)
     */
    private Double jmydpjdj;

    /**
     * 本地发电结构--煤（万千瓦）
     */
    private Double bdfdjgmei;

    /**
     * 本地发电结构--油（万千瓦）
     */
    private Double bdfdjgyou;

    /**
     * 本地发电结构--天然气（万千瓦）
     */
    private Double bdfdjgtrq;

    /**
     * 本地发电结构--风电（万千瓦）
     */
    private Double bdfdjgfd;

    /**
     * 本地发电结构--太阳能（万千瓦）
     */
    private Double bdfdjgtyn;

    /**
     * 本地发电结构--生物质（万千瓦）
     */
    private Double bdfdjgswz;

    /**
     * 本地发电结构--其他（万千瓦）
     */
    private Double bdfdjgqt;

    /**
     * 清洁能源装机
     */
    private Double qjnyzj;

    /**
     * 清洁能源总装机
     */
    private Double qjnyzzj;

    /**
     * 清洁能源装机提升占比
     */
    private Double qjnyzjtszb;

    /**
     * 新能源发电量(亿千瓦时)
     */
    private Double xnyfdl;

    /**
     * 厂用电率(%)
     */
    private Double cydl;

    /**
     * 分时电价行业电量（居民）(万千瓦时)
     */
    private Double fsdjhydljm;

    /**
     * 并网分布式电源装机容量(万千瓦)
     */
    private Double bwfbsdyzjrl;

    /**
     * 用户参与调峰调频容量(万千瓦)
     */
    private Double yhcydctprl;

    /**
     * 总调峰调频容量(万千瓦)
     */
    private Double ztftprl;

    /**
     * 公司经营区域发电量(亿千瓦时)
     */
    private Double gsjyqyfdl;

    /**
     * 公司经营区域可再生能源弃电量(万千瓦时)
     */
    private Double gsjyqyzsnyqdl;

    /**
     * 发电权交易电量(亿千瓦时)
     */
    private Double fdqjydl;

    /**
     * 年最大负荷(万千瓦)
     */
    private Double nzdfh;

    /**
     * 考核点电压合格率(%)
     */
    private Double ckddyhgl;

    /**
     * 电热水器替代燃气热水器新增电量(万千瓦时)
     */
    private Double drsqtdrqrsqxzdl;

    /**
     * 电网技术监督质量评价
     */
    private Double dwjsjdzlpj;

    /**
     * 新能源汽车保有量(辆)
     */
    private Double xnyqcbyl;

    /**
     * 年度电力科技创新投入(万元)
     */
    private Double nddlkjxtr;

    /**
     * 供电可靠率(%)
     */
    private Double gdkkl;

    /**
     * 峰谷差率(%)
     */
    private Double gfcl;

    /**
     * 以电代煤因子（万kW）
     */
    private Double yddmyz;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    @Column(name = "NYXHZL")
    public Double getNyxhzl() {

        return nyxhzl;
    }

    public void setNyxhzl(Double nyxhzl) {

        this.nyxhzl = nyxhzl;
    }

    @Column(name = "QSHYDL")
    public Double getQshydl() {

        return qshydl;
    }

    public void setQshydl(Double qshydl) {

        this.qshydl = qshydl;
    }

    @Column(name = "WYCZDHXJL")
    public Double getWyczdhxjl() {

        return wyczdhxjl;
    }

    public void setWyczdhxjl(Double wyczdhxjl) {

        this.wyczdhxjl = wyczdhxjl;
    }

    @Column(name = "SDL")
    public Double getSdl() {

        return sdl;
    }

    public void setSdl(Double sdl) {

        this.sdl = sdl;
    }

    @Column(name = "ZHXSL")
    public Double getZhxsl() {

        return zhxsl;
    }

    public void setZhxsl(Double zhxsl) {

        this.zhxsl = zhxsl;
    }

    @Column(name = "KQSJGDL")
    public Double getKqsjgdl() {

        return kqsjgdl;
    }

    public void setKqsjgdl(Double kqsjgdl) {

        this.kqsjgdl = kqsjgdl;
    }

    @Column(name = "KQSJDRL")
    public Double getKqsjdrl() {

        return kqsjdrl;
    }

    public void setKqsjdrl(Double kqsjdrl) {

        this.kqsjdrl = kqsjdrl;
    }

    @Column(name = "KSSJZLGDL")
    public Double getKssjzlgdl() {

        return kssjzlgdl;
    }

    public void setKssjzlgdl(Double kssjzlgdl) {

        this.kssjzlgdl = kssjzlgdl;
    }

    @Column(name = "DLXFTXZS")
    public Double getDlxftxzs() {

        return dlxftxzs;
    }

    public void setDlxftxzs(Double dlxftxzs) {

        this.dlxftxzs = dlxftxzs;
    }

    @Column(name = "NRJYDL")
    public Double getNrjydl() {

        return nrjydl;
    }

    public void setNrjydl(Double nrjydl) {

        this.nrjydl = nrjydl;
    }

    @Column(name = "GDMH")
    public Double getGdmh() {

        return gdmh;
    }

    public void setGdmh(Double gdmh) {

        this.gdmh = gdmh;
    }

    @Column(name = "JMYDPJDJ")
    public Double getJmydpjdj() {

        return jmydpjdj;
    }

    public void setJmydpjdj(Double jmydpjdj) {

        this.jmydpjdj = jmydpjdj;
    }

    @Column(name = "BDFDJGMEI")
    public Double getBdfdjgmei() {

        return bdfdjgmei;
    }

    public void setBdfdjgmei(Double bdfdjgmei) {

        this.bdfdjgmei = bdfdjgmei;
    }

    @Column(name = "BDFDJGYOU")
    public Double getBdfdjgyou() {

        return bdfdjgyou;
    }

    public void setBdfdjgyou(Double bdfdjgyou) {

        this.bdfdjgyou = bdfdjgyou;
    }

    @Column(name = "BDFDJGTRQ")
    public Double getBdfdjgtrq() {

        return bdfdjgtrq;
    }

    public void setBdfdjgtrq(Double bdfdjgtrq) {

        this.bdfdjgtrq = bdfdjgtrq;
    }

    @Column(name = "BDFDJGFD")
    public Double getBdfdjgfd() {

        return bdfdjgfd;
    }

    public void setBdfdjgfd(Double bdfdjgfd) {

        this.bdfdjgfd = bdfdjgfd;
    }

    @Column(name = "BDFDJGTYN")
    public Double getBdfdjgtyn() {

        return bdfdjgtyn;
    }

    public void setBdfdjgtyn(Double bdfdjgtyn) {

        this.bdfdjgtyn = bdfdjgtyn;
    }

    @Column(name = "BDFDJGSWZ")
    public Double getBdfdjgswz() {

        return bdfdjgswz;
    }

    public void setBdfdjgswz(Double bdfdjgswz) {

        this.bdfdjgswz = bdfdjgswz;
    }

    @Column(name = "BDFDJGQT")
    public Double getBdfdjgqt() {

        return bdfdjgqt;
    }

    public void setBdfdjgqt(Double bdfdjgqt) {

        this.bdfdjgqt = bdfdjgqt;
    }

    @Column(name = "QJNYZJ")
    public Double getQjnyzj() {

        return qjnyzj;
    }

    public void setQjnyzj(Double qjnyzj) {

        this.qjnyzj = qjnyzj;
    }

    @Column(name = "QJNYZZJ")
    public Double getQjnyzzj() {

        return qjnyzzj;
    }

    public void setQjnyzzj(Double qjnyzzj) {

        this.qjnyzzj = qjnyzzj;
    }

    @Column(name = "QJNYZJTSZB")
    public Double getQjnyzjtszb() {

        return qjnyzjtszb;
    }

    public void setQjnyzjtszb(Double qjnyzjtszb) {

        this.qjnyzjtszb = qjnyzjtszb;
    }

    @Column(name = "XNYFDL")
    public Double getXnyfdl() {

        return xnyfdl;
    }

    public void setXnyfdl(Double xnyfdl) {

        this.xnyfdl = xnyfdl;
    }

    @Column(name = "CYDL")
    public Double getCydl() {

        return cydl;
    }

    public void setCydl(Double cydl) {

        this.cydl = cydl;
    }

    @Column(name = "FSDJHYDLJM")
    public Double getFsdjhydljm() {

        return fsdjhydljm;
    }

    public void setFsdjhydljm(Double fsdjhydljm) {

        this.fsdjhydljm = fsdjhydljm;
    }

    @Column(name = "BWFBSDYZJRL")
    public Double getBwfbsdyzjrl() {

        return bwfbsdyzjrl;
    }

    public void setBwfbsdyzjrl(Double bwfbsdyzjrl) {

        this.bwfbsdyzjrl = bwfbsdyzjrl;
    }

    @Column(name = "YHCYDCTPRL")
    public Double getYhcydctprl() {

        return yhcydctprl;
    }

    public void setYhcydctprl(Double yhcydctprl) {

        this.yhcydctprl = yhcydctprl;
    }

    @Column(name = "ZTFTPRL")
    public Double getZtftprl() {

        return ztftprl;
    }

    public void setZtftprl(Double ztftprl) {

        this.ztftprl = ztftprl;
    }

    @Column(name = "GSJYQYFDL")
    public Double getGsjyqyfdl() {

        return gsjyqyfdl;
    }

    public void setGsjyqyfdl(Double gsjyqyfdl) {

        this.gsjyqyfdl = gsjyqyfdl;
    }

    @Column(name = "GSJYQYZSNYQDL")
    public Double getGsjyqyzsnyqdl() {

        return gsjyqyzsnyqdl;
    }

    public void setGsjyqyzsnyqdl(Double gsjyqyzsnyqdl) {

        this.gsjyqyzsnyqdl = gsjyqyzsnyqdl;
    }

    @Column(name = "FDQJYDL")
    public Double getFdqjydl() {

        return fdqjydl;
    }

    public void setFdqjydl(Double fdqjydl) {

        this.fdqjydl = fdqjydl;
    }

    @Column(name = "NZDFH")
    public Double getNzdfh() {

        return nzdfh;
    }

    public void setNzdfh(Double nzdfh) {

        this.nzdfh = nzdfh;
    }

    @Column(name = "CKDDYHGL")
    public Double getCkddyhgl() {

        return ckddyhgl;
    }

    public void setCkddyhgl(Double ckddyhgl) {

        this.ckddyhgl = ckddyhgl;
    }

    @Column(name = "DRSQTDRQRSQXZDL")
    public Double getDrsqtdrqrsqxzdl() {

        return drsqtdrqrsqxzdl;
    }

    public void setDrsqtdrqrsqxzdl(Double drsqtdrqrsqxzdl) {

        this.drsqtdrqrsqxzdl = drsqtdrqrsqxzdl;
    }

    @Column(name = "DWJSJDZLPJ")
    public Double getDwjsjdzlpj() {

        return dwjsjdzlpj;
    }

    public void setDwjsjdzlpj(Double dwjsjdzlpj) {

        this.dwjsjdzlpj = dwjsjdzlpj;
    }

    @Column(name = "XNYQCBYL")
    public Double getXnyqcbyl() {

        return xnyqcbyl;
    }

    public void setXnyqcbyl(Double xnyqcbyl) {

        this.xnyqcbyl = xnyqcbyl;
    }

    @Column(name = "NDDLKJXTR")
    public Double getNddlkjxtr() {

        return nddlkjxtr;
    }

    public void setNddlkjxtr(Double nddlkjxtr) {

        this.nddlkjxtr = nddlkjxtr;
    }

    @Column(name = "GDKKL")
    public Double getGdkkl() {

        return gdkkl;
    }

    public void setGdkkl(Double gdkkl) {

        this.gdkkl = gdkkl;
    }

    @Column(name = "GFCL")
    public Double getGfcl() {

        return gfcl;
    }

    public void setGfcl(Double gfcl) {

        this.gfcl = gfcl;
    }

    @Column(name = "YDDMYZ")
    public Double getYddmyz() {

        return yddmyz;
    }

    public void setYddmyz(Double yddmyz) {

        this.yddmyz = yddmyz;
    }

    @Column(name = "DATA_TIME")
    public Date getDataTime() {

        return dataTime;
    }

    public void setDataTime(Date dataTime) {

        this.dataTime = dataTime;
    }

}
