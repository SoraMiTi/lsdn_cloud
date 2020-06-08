package cn.com.liandisys.lsdn.code.model.lsdn_screen.vo.source;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * S_TOTAL_REAL  Vo
 *
 * @author b_fangzheng
 */
public class STotalRealVo {

    /**
     * 标识
     */
    private String id;

    /**
     * 全网频率
     */
    private Double pl;

    /**
     * 全网负荷
     */
    private Double fh;

    /**
     * 外来清洁电力
     */
    private Double qjdl;

    /**
     * 电网旋转备电量
     */
    private Double bdl;

    /**
     * 燃煤负荷/供电功率
     */
    private Double rmPower;

    /**
     * 燃机负荷/供电功率
     */
    private Double rjPower;

    /**
     * 光电负荷/供电功率
     */
    private Double gdPower;

    /**
     * 风电负荷/供电功率
     */
    private Double fdPower;

    /**
     * 水电负荷/供电功率
     */
    private Double sdPower;

    /**
     * 火电负荷/供电功率（燃煤负荷+燃机负荷）
     */
    private Double hdPower;

    /**
     * 分布式光伏负荷/供电功率
     */
    private Double dePower;
    /**
     * SO2排放
     */
    private Double so2Emissions;

    /**
     * NOx排放
     */
    private Double noxEmissions;

    /**
     * PM排放
     */
    private Double pmEmissions;

    /**
     * SO2排放
     */
    private Double so2EmissionsRate;

    /**
     * NOx排放
     */
    private Double noxEmissionsRate;

    /**
     * PM排放
     */
    private Double pmEmissionsRate;

    /**
     * 供电煤耗
     */
    private Double gdmh;

    /**
     * 发电煤耗
     */
    private Double fdmh;

    /**
     * SO？绩效排放率最优电厂
     */
    private String so2Plant;

    /**
     * NOx绩效排放率最优电厂
     */
    private String noxPlant;

    /**
     * PM绩效排放率最优电厂
     */
    private String pmPlant;

    /**
     * 发电煤耗最优电厂
     */
    private String fdmhPlant;

    /**
     * 供电煤耗最优电厂
     */
    private String gdmhPlant;

    /**
     * 绿电评价最优电厂
     */
    private String ldpjPlant;

    /**
     * 调峰深度范围1机组数  pe<=0.3
     */
    private long peakType1Count;

    /**
     * 调峰深度范围2机组数  0.3<=pe<=0.35
     */
    private long peakType2Count;

    /**
     * 调峰深度范围3机组数  0.35<=pe<=0.4
     */
    private long peakType3Count;

    /**
     * 调峰深度范围4机组数  其他范围
     */
    private long peakType4Count;

    /**
     * 数据统计时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dataTime;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public Double getPl() {

        return pl;
    }

    public void setPl(Double pl) {

        this.pl = pl;
    }

    public Double getFh() {

        return fh;
    }

    public void setFh(Double fh) {

        this.fh = fh;
    }

    public Double getQjdl() {

        return qjdl;
    }

    public void setQjdl(Double qjdl) {

        this.qjdl = qjdl;
    }

    public Double getBdl() {

        return bdl;
    }

    public void setBdl(Double bdl) {

        this.bdl = bdl;
    }

    public Double getRmPower() {

        return rmPower;
    }

    public void setRmPower(Double rmPower) {

        this.rmPower = rmPower;
    }

    public Double getRjPower() {

        return rjPower;
    }

    public void setRjPower(Double rjPower) {

        this.rjPower = rjPower;
    }

    public Double getGdPower() {

        return gdPower;
    }

    public void setGdPower(Double gdPower) {

        this.gdPower = gdPower;
    }

    public Double getFdPower() {

        return fdPower;
    }

    public void setFdPower(Double fdPower) {

        this.fdPower = fdPower;
    }

    public Double getSdPower() {

        return sdPower;
    }

    public void setSdPower(Double sdPower) {

        this.sdPower = sdPower;
    }

    public Double getHdPower() {
        return hdPower;
    }

    public void setHdPower(Double hdPower) {
        this.hdPower = hdPower;
    }

    public Double getDePower() {
        return dePower;
    }

    public void setDePower(Double dePower) {
        this.dePower = dePower;
    }

    public Double getSo2Emissions() {

        return so2Emissions;
    }

    public void setSo2Emissions(Double so2Emissions) {

        this.so2Emissions = so2Emissions;
    }

    public Double getNoxEmissions() {

        return noxEmissions;
    }

    public void setNoxEmissions(Double noxEmissions) {

        this.noxEmissions = noxEmissions;
    }

    public Double getPmEmissions() {

        return pmEmissions;
    }

    public void setPmEmissions(Double pmEmissions) {

        this.pmEmissions = pmEmissions;
    }

    public String getSo2Plant() {

        return so2Plant;
    }

    public void setSo2Plant(String so2Plant) {

        this.so2Plant = so2Plant;
    }

    public String getNoxPlant() {

        return noxPlant;
    }

    public void setNoxPlant(String noxPlant) {

        this.noxPlant = noxPlant;
    }

    public String getPmPlant() {

        return pmPlant;
    }

    public void setPmPlant(String pmPlant) {

        this.pmPlant = pmPlant;
    }

    public String getFdmhPlant() {

        return fdmhPlant;
    }

    public void setFdmhPlant(String fdmhPlant) {

        this.fdmhPlant = fdmhPlant;
    }

    public String getGdmhPlant() {

        return gdmhPlant;
    }

    public void setGdmhPlant(String gdmhPlant) {

        this.gdmhPlant = gdmhPlant;
    }

    public Date getDataTime() {

        return dataTime;
    }

    public void setDataTime(Date dataTime) {

        this.dataTime = dataTime;
    }


    public String getLdpjPlant() {

        return ldpjPlant;
    }


    public void setLdpjPlant(String ldpjPlant) {

        this.ldpjPlant = ldpjPlant;
    }


    public Double getGdmh() {

        return gdmh;
    }


    public void setGdmh(Double gdmh) {

        this.gdmh = gdmh;
    }


    public Double getFdmh() {

        return fdmh;
    }


    public void setFdmh(Double fdmh) {

        this.fdmh = fdmh;
    }

    public long getPeakType1Count() {
        return peakType1Count;
    }

    public void setPeakType1Count(long peakType1Count) {
        this.peakType1Count = peakType1Count;
    }

    public long getPeakType2Count() {
        return peakType2Count;
    }

    public void setPeakType2Count(long peakType2Count) {
        this.peakType2Count = peakType2Count;
    }

    public long getPeakType3Count() {
        return peakType3Count;
    }

    public void setPeakType3Count(long peakType3Count) {
        this.peakType3Count = peakType3Count;
    }

    public long getPeakType4Count() {
        return peakType4Count;
    }

    public void setPeakType4Count(long peakType4Count) {
        this.peakType4Count = peakType4Count;
    }


    public Double getSo2EmissionsRate() {

        return so2EmissionsRate;
    }


    public void setSo2EmissionsRate(Double so2EmissionsRate) {

        this.so2EmissionsRate = so2EmissionsRate;
    }


    public Double getNoxEmissionsRate() {

        return noxEmissionsRate;
    }


    public void setNoxEmissionsRate(Double noxEmissionsRate) {

        this.noxEmissionsRate = noxEmissionsRate;
    }


    public Double getPmEmissionsRate() {

        return pmEmissionsRate;
    }


    public void setPmEmissionsRate(Double pmEmissionsRate) {

        this.pmEmissionsRate = pmEmissionsRate;
    }

}
