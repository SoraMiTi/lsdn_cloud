package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * T_02002_机组台账数据
 *
 * @author b_fangzheng
 */
@Entity
@Table(name = "G_BASE_GENERATOR")
public class BaseGeneratorEntity {

    /**
     * 机组编号
     */
    private String id;

    /**
     * 机组名称
     */
    private String name;

    /**
     * 所属电厂编号
     */
    private BasePlantEntity plant;

    private String plantId;

    /**
     * 额定容量
     */
    private Double ratedCapacity;

    /**
     * 最大容量
     */
    private Double maxCapacity;

    /**
     * 最小容量
     */
    private Double minCapacity;

    /**
     * 额定功率
     */
    private Double ratedPower;

    /**
     * 机组燃料类型 1：燃煤 2：燃气 3：燃油
     */
    private String type;

    /**
     * 机组主汽等级
     */
    private String zqdj;

    /**
     * 是否是低煤耗机组 0：否 1：是
     */
    private String ifDmh;

    /**
     * 是否是调峰机组 0：否 1：是
     */
    private String ifTfjz;

    /**
     * 投运时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tysj;

    /**
     * 投运状态 0：未投运 1：投运中
     */
    private String tyzt;

    /**
     * 并网点
     */
    private String node;

    /**
     * 运行状态 0：未运行 1：运行中
     */
    private String runStatus;

    /**
     * 机组绿能标识（对方库中编号）
     */
    private String lsnyId;

    @Id
    @GeneratedValue(generator = "system-uuid")
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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BasePlantEntity.class)
    @JoinColumn(name = "PLANT_ID", insertable = false, updatable = false)
    public BasePlantEntity getPlant() {

        return plant;
    }

    public void setPlant(BasePlantEntity plant) {

        this.plant = plant;
    }

    @Column(name = "RATED_CAPACITY")
    public Double getRatedCapacity() {

        return ratedCapacity;
    }

    public void setRatedCapacity(Double ratedCapacity) {

        this.ratedCapacity = ratedCapacity;
    }

    @Column(name = "MAX_CAPACITY")
    public Double getMaxCapacity() {

        return maxCapacity;
    }

    public void setMaxCapacity(Double maxCapacity) {

        this.maxCapacity = maxCapacity;
    }

    @Column(name = "MIN_CAPACITY")
    public Double getMinCapacity() {

        return minCapacity;
    }

    public void setMinCapacity(Double minCapacity) {

        this.minCapacity = minCapacity;
    }

    @Column(name = "RATED_POWER")
    public Double getRatedPower() {

        return ratedPower;
    }

    public void setRatedPower(Double ratedPower) {

        this.ratedPower = ratedPower;
    }

    @Column(name = "TYPE")
    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    @Column(name = "ZQDJ")
    public String getZqdj() {

        return zqdj;
    }

    public void setZqdj(String zqdj) {

        this.zqdj = zqdj;
    }

    @Column(name = "IF_DMH")
    public String getIfDmh() {

        return ifDmh;
    }

    public void setIfDmh(String ifDmh) {

        this.ifDmh = ifDmh;
    }

    @Column(name = "IF_TFJZ")
    public String getIfTfjz() {

        return ifTfjz;
    }

    public void setIfTfjz(String ifTfjz) {

        this.ifTfjz = ifTfjz;
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

    @Column(name = "NODE")
    public String getNode() {

        return node;
    }

    public void setNode(String node) {

        this.node = node;
    }

    @Column(name = "RUN_STATUS")
    public String getRunStatus() {

        return runStatus;
    }

    public void setRunStatus(String runStatus) {

        this.runStatus = runStatus;
    }

    @Column(name = "LSNY_ID")
    public String getLsnyId() {

        return lsnyId;
    }

    public void setLsnyId(String lsnyId) {

        this.lsnyId = lsnyId;
    }

    @Column(name = "PLANT_ID")
    public String getPlantId() {

        return plantId;
    }

    public void setPlantId(String plantId) {

        this.plantId = plantId;
    }

}
