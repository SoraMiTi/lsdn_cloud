package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BaseGeneratorEntity;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BasePlantEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * O_B_ENTRY_COAL
 *
 * @author b_fangzheng
 */
@Entity
@Table(name = "O_B_ENTRY_COAL")
public class EntryCoalEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 电厂实体类型
     */
    private BasePlantEntity plant;

    /**
     * 机组实体类型
     */
    private BaseGeneratorEntity gen;

    /**
     * 电厂编号
     */
    private String plantId;

    /**
     * 机组编号
     */
    private String genId;

    /**
     * 供电煤耗
     */
    private Double fdmh;

    /**
     * 发电煤耗
     */
    private Double gdmh;

    /**
     * 煤热值
     */
    private Double coalCalorificVal;

    /**
     * 燃气热值
     */
    private Double gasCalorificVal;

    /**
     * 可燃气体未完全燃烧热损失
     */
    private Double gasLost;

    /**
     * 固体未完全燃烧热损失
     */
    private Double solidLost;

    /**
     * 锅炉散热热损失
     */
    private Double boilerheatLost;

    /**
     * 灰渣物理显热热损失
     */
    private Double ashheatLost;

    /**
     * 状态
     */
    private String state;

    /**
     * 燃料收到基水分含量
     */
    private Double coalWaterContent;

    /**
     * 录入人
     */
    private String inputer;

    /**
     * 数据时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dataTime;

    /**
     * 录入时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Id
    @Column(name = "ID", length = 32)
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BasePlantEntity.class)
    @JoinColumn(name = "PLANT_ID", insertable = false, updatable = false)
    public BasePlantEntity getPlant() {

        return plant;
    }

    public void setPlant(BasePlantEntity plant) {

        this.plant = plant;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BaseGeneratorEntity.class)
    @JoinColumn(name = "GEN_ID", insertable = false, updatable = false)
    public BaseGeneratorEntity getGen() {

        return gen;
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

    public void setGen(BaseGeneratorEntity gen) {

        this.gen = gen;
    }

    @Column(name = "FDMH")
    public Double getFdmh() {

        return fdmh;
    }

    public void setFdmh(Double fdmh) {

        this.fdmh = fdmh;
    }

    @Column(name = "GDMH")
    public Double getGdmh() {

        return gdmh;
    }

    public void setGdmh(Double gdmh) {

        this.gdmh = gdmh;
    }

    @Column(name = "COAL_CALORIFIC_VAL")
    public Double getCoalCalorificVal() {

        return coalCalorificVal;
    }

    public void setCoalCalorificVal(Double coalCalorificVal) {

        this.coalCalorificVal = coalCalorificVal;
    }

    @Column(name = "GAS_CALORIFIC_VAL")
    public Double getGasCalorificVal() {

        return gasCalorificVal;
    }

    public void setGasCalorificVal(Double gasCalorificVal) {

        this.gasCalorificVal = gasCalorificVal;
    }

    @Column(name = "GAS_LOST")
    public Double getGasLost() {

        return gasLost;
    }

    public void setGasLost(Double gasLost) {

        this.gasLost = gasLost;
    }

    @Column(name = "SOLID_LOST")
    public Double getSolidLost() {

        return solidLost;
    }

    public void setSolidLost(Double solidLost) {

        this.solidLost = solidLost;
    }

    @Column(name = "BOILERHEAT_LOST")
    public Double getBoilerheatLost() {

        return boilerheatLost;
    }

    public void setBoilerheatLost(Double boilerheatLost) {

        this.boilerheatLost = boilerheatLost;
    }

    @Column(name = "ASHHEAT_LOST")
    public Double getAshheatLost() {

        return ashheatLost;
    }

    public void setAshheatLost(Double ashheatLost) {

        this.ashheatLost = ashheatLost;
    }

    @Column(name = "STATE")
    public String getState() {

        return state;
    }

    public void setState(String state) {

        this.state = state;
    }

    @Column(name = "COAL_WATER_CONTENT")
    public Double getCoalWaterContent() {

        return coalWaterContent;
    }

    public void setCoalWaterContent(Double coalWaterContent) {

        this.coalWaterContent = coalWaterContent;
    }

    @Column(name = "INPUTER")
    public String getInputer() {

        return inputer;
    }

    public void setInputer(String inputer) {

        this.inputer = inputer;
    }

    @Column(name = "DATA_TIME")
    public Date getDataTime() {

        return dataTime;
    }

    public void setDataTime(Date dataTime) {

        this.dataTime = dataTime;
    }

    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

}
