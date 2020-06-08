package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BasePlantEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * 电厂月度数据表，单表维护，不做统计
 *
 * @author b_fangzheng
 */
@Entity
@Table(name = "O_B_ENTRY_WRW_PLANT")
public class EntryWrwPlantEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 电厂ID
     */
    private String plantId;

    private BasePlantEntity plant;

    /**
     * 燃煤硫分
     */
    private Double rmlf;

    /**
     * 燃煤灰分
     */
    private Double rmhf;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy")
    @JsonFormat(pattern = "yyyy", timezone = "GMT+8")
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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BasePlantEntity.class)
    @JoinColumn(name = "PLANT_ID", insertable = false, updatable = false)
    public BasePlantEntity getPlant() {

        return plant;
    }

    public void setPlant(BasePlantEntity plant) {

        this.plant = plant;
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

    @Column(name = "DATA_TIME")
    public Date getDataTime() {

        return dataTime;
    }

    public void setDataTime(Date dataTime) {

        this.dataTime = dataTime;
    }
}
