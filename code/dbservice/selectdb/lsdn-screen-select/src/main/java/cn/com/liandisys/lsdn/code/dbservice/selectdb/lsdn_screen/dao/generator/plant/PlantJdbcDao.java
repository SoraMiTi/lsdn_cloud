package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.plant;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BasePlantEntity;

import java.util.List;


/**
 * 电厂台账表
 * @author b_fangzheng
 *
 */
public interface PlantJdbcDao {

    /**
     * 抓取电厂下拉列表数据
     * @return
     */
    List<BasePlantEntity> getPlantEntity(String[] plantType);

}
