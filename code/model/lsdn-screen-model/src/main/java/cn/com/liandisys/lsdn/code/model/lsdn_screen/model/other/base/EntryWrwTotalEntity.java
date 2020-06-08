package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * 全网月度数据表，单表维护，不做统计
 *
 * @author b_fangzheng
 */
@Entity
@Table(name = "O_B_ENTRY_WRW_TOTAL")
public class EntryWrwTotalEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 时间(年份)
     */
    @DateTimeFormat(pattern = "yyyy")
    @JsonFormat(pattern = "yyyy", timezone = "GMT+8")
    private Date dataTime;

    /**
     * 装机容量
     */
    private Double zjrl;

    /**
     * 累计发电量
     */
    private Double ljdl;

    /**
     * 燃煤量
     */
    private Double rml;

    /**
     * 供电煤耗
     */
    private Double gdmh;

    /**
     * 燃煤硫分
     */
    private Double rmlf;

    /**
     * 燃煤灰分
     */
    private Double rmhf;

    /**
     * 烟尘排放量
     */
    private Double pmEmissions;

    /**
     * SO2排放量
     */
    private Double so2Emissions;

    /**
     * NOx排放量
     */
    private Double noxEmissions;

    /**
     * SO2绩效排放率
     */
    private Double so2EmissionsRate;

    /**
     * NOx绩效排放率
     */
    private Double noxEmissionsRate;

    /**
     * 烟尘绩效排放率
     */
    private Double pmEmissionsRate;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @Column(name = "DATA_TIME")
    public Date getDataTime() {

        return dataTime;
    }

    public void setDataTime(Date dataTime) {

        this.dataTime = dataTime;
    }

    @Column(name = "ZJRL")
    public Double getZjrl() {

        return zjrl;
    }

    public void setZjrl(Double zjrl) {

        this.zjrl = zjrl;
    }

    @Column(name = "LJDL")
    public Double getLjdl() {

        return ljdl;
    }

    public void setLjdl(Double ljdl) {

        this.ljdl = ljdl;
    }

    @Column(name = "RML")
    public Double getRml() {

        return rml;
    }

    public void setRml(Double rml) {

        this.rml = rml;
    }

    @Column(name = "GDMH")
    public Double getGdmh() {

        return gdmh;
    }

    public void setGdmh(Double gdmh) {

        this.gdmh = gdmh;
    }

    @Column(name = "RMLF")
    public Double getRmlf() {

        return rmlf;
    }

    public void setRmlf(Double rmlf) {

        this.rmlf = rmlf;
    }

    @Column(name = "RMHF")
    public Double getRmhf() {

        return rmhf;
    }

    public void setRmhf(Double rmhf) {

        this.rmhf = rmhf;
    }

    @Column(name = "PM_EMISSIONS")
    public Double getPmEmissions() {

        return pmEmissions;
    }

    public void setPmEmissions(Double pmEmissions) {

        this.pmEmissions = pmEmissions;
    }

    @Column(name = "SO2_EMISSIONS")
    public Double getSo2Emissions() {

        return so2Emissions;
    }

    public void setSo2Emissions(Double so2Emissions) {

        this.so2Emissions = so2Emissions;
    }

    @Column(name = "NOX_EMISSIONS")
    public Double getNoxEmissions() {

        return noxEmissions;
    }

    public void setNoxEmissions(Double noxEmissions) {

        this.noxEmissions = noxEmissions;
    }

    @Column(name = "SO2_EMISSIONS_RATE")
    public Double getSo2EmissionsRate() {

        return so2EmissionsRate;
    }

    public void setSo2EmissionsRate(Double so2EmissionsRate) {

        this.so2EmissionsRate = so2EmissionsRate;
    }

    @Column(name = "NOX_EMISSIONS_RATE")
    public Double getNoxEmissionsRate() {

        return noxEmissionsRate;
    }

    public void setNoxEmissionsRate(Double noxEmissionsRate) {

        this.noxEmissionsRate = noxEmissionsRate;
    }

    @Column(name = "PM_EMISSIONS_RATE")
    public Double getPmEmissionsRate() {

        return pmEmissionsRate;
    }

    public void setPmEmissionsRate(Double pmEmissionsRate) {

        this.pmEmissionsRate = pmEmissionsRate;
    }

}
