package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.statistics;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BaseGeneratorEntity;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BasePlantEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;


/**
 * 排放缺失统计表
 *
 * @author b_huyh
 */
@Entity
@Table(name = "O_S_EMISSIONS_LOST")
public class EmissionsLostEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 电厂
     */
    private BasePlantEntity plant;

    /**
     * 机组
     */
    private BaseGeneratorEntity gen;

    /**
     * 缺失开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 缺失结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 缺失数据数量
     */
    private Integer lostCount;

    /**
     * 记录创建时间
     */
    private Date createTime;

    @Id
    @GeneratedValue(generator = "system-uuid")
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

    public void setGen(BaseGeneratorEntity gen) {

        this.gen = gen;
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

    @Column(name = "LOST_COUNT")
    public Integer getLostCount() {

        return lostCount;
    }

    public void setLostCount(Integer lostCount) {

        this.lostCount = lostCount;
    }

    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

}
