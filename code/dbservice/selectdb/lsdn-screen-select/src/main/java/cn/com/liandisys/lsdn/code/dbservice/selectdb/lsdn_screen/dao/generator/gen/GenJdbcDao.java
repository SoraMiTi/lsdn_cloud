package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.gen;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BaseGeneratorEntity;

import java.util.List;

/**
 * 机组台账表
 * @author b_fangzheng
 *
 */
public interface GenJdbcDao {

    /**
     * 抓取机组下拉列表数据
     * @param plantId
     * @return
     */
    List<BaseGeneratorEntity> getGenByPlant(String plantId);

}
