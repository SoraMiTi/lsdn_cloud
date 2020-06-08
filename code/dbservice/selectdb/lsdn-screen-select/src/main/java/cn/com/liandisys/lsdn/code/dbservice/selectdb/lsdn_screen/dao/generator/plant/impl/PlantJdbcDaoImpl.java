package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.plant.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.plant.PlantJdbcDao;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator.BasePlantEntity;
import cn.com.liandisys.util.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * 电厂台账表
 * @author b_fangzheng
 *
 */
@Repository("plantJdbcDao")
public class PlantJdbcDaoImpl extends JdbcUtil implements PlantJdbcDao {
    
    /**
     * 抓取电厂下拉列表数据
     * @return
     */
    public List<BasePlantEntity> getPlantEntity(String[] plantType) {
        List<BasePlantEntity> list = new ArrayList<BasePlantEntity>();
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append(" SELECT ");
        sql.append("   * ");
        sql.append(" FROM "+ Const.LOCAL_LSDN_SCHEMA+".G_BASE_PLANT ");
        sql.append(" WHERE 1=1 ");
        sql.append("   AND TYZT = ? ");
        param.add(Const.COMM_CODE.TYZT_YES);
        if(plantType!=null){
        	sql.append(" AND TYPE IN (");
        	for (int i = 0; i < plantType.length; i++) {
				if(i<plantType.length-1){
					sql.append("?,");
				}else{
					sql.append("?)");
				}
				param.add(plantType[i]);
			}
        }
        sql.append(" ORDER BY SHORT_NAME ");
        try{
            list = jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<BasePlantEntity>(BasePlantEntity.class));
        } catch(Exception e) {
        }
        return list;
    }
}
