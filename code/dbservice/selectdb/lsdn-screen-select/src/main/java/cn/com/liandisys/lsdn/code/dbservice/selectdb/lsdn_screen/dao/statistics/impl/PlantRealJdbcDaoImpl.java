package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.statistics.PlantRealJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 各电厂实时统计数据
 * 
 * @author b_fangzheng
 */
@Repository("plantRealJdbcDao")
public class PlantRealJdbcDaoImpl extends JdbcUtil implements PlantRealJdbcDao {

    /**
     * 获取电厂最新一条实时统计数据(plantId为空时抓取所有电厂)
     * @return
     */
    public List<Map<String, Object>> getPlantRealSta(String pantId) {
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        sql.append(" WITH MAXDATA AS ( ");
        sql.append(" SELECT ");
        sql.append("   MAX(DATA_TIME) DATA_TIME, PLANT_ID ");
        sql.append(" FROM S_PLANT_REAL ");
        sql.append(" GROUP BY PLANT_ID), ");
        sql.append(" REALDATA AS ( ");
        sql.append(" SELECT ");
        sql.append("   PR.PLANT_ID, ");
        sql.append("   PR.DATA_TIME, ");
        sql.append("   PR.SUP_POWER, ");
        sql.append("   PR.SO2_EMISSIONS_RATE, ");
        sql.append("   PR.NOX_EMISSIONS_RATE, ");
        sql.append("   PR.PM_EMISSIONS_RATE, ");
        sql.append("   PR.GDMH ");
        sql.append(" FROM S_PLANT_REAL PR ");
        sql.append(" JOIN MAXDATA ");
        sql.append("   ON MAXDATA.PLANT_ID = PR.PLANT_ID ");
        sql.append("   AND MAXDATA.DATA_TIME = PR.DATA_TIME) ");
        sql.append(" SELECT ");
        sql.append("   BP.ID, ");
        sql.append("   BP.SHORT_NAME, ");
        sql.append("   REALDATA.DATA_TIME, ");
        sql.append("   NVL(REALDATA.SUP_POWER, 0) SUP_POWER, ");
        sql.append("   NVL(REALDATA.SO2_EMISSIONS_RATE, 0) SO2_EMISSIONS_RATE, ");
        sql.append("   NVL(REALDATA.NOX_EMISSIONS_RATE, 0) NOX_EMISSIONS_RATE, ");
        sql.append("   NVL(REALDATA.PM_EMISSIONS_RATE, 0) PM_EMISSIONS_RATE, ");
        sql.append("   NVL(REALDATA.GDMH, 0) GDMH ");
        sql.append(" FROM G_BASE_PLANT BP ");
        sql.append(" JOIN REALDATA ");
        sql.append("   ON REALDATA.PLANT_ID = BP.ID ");
        sql.append(" WHERE 1=1 ");
        if(StringUtil.isNotNullOrBlank(pantId)) {
            sql.append("   AND BP.ID = ? ");
            param.add(pantId);
        }
        System.out.println(new Date());
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }

    /**
     * 查询该月份风电电厂产生的电量
     * @param date 'yyyy-mm'格式
     */
	public List<Map<String, Object>> getWindDlByMonth(String date) {
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" WITH WIND_BASE AS ");
		sql.append("   (SELECT BASE_WIND.PLANT_ID, ");
		sql.append("     REPLACE(TO_CHAR(WM_CONCAT(BASE_WIND.TYPE)),',','、') AS TYPE, ");
		sql.append("     REPLACE(TO_CHAR(WM_CONCAT(BASE_WIND.DYDJ)),',','/') AS DYDJ, ");
		sql.append("     REPLACE(TO_CHAR(WM_CONCAT(BASE_WIND.FJZH)),',','+') AS FJZH ");
		sql.append("   FROM G_BASE_WIND_POWER BASE_WIND ");
		sql.append("   GROUP BY BASE_WIND.PLANT_ID ");
		sql.append("   ), ");
		sql.append("   REAL_BASE AS ");
		sql.append("   (SELECT BASE_WIND.PLANT_ID, ");
		sql.append("     NVL(SUM(REAL_WIND.REAL_DL),0)   AS REAL_DL, ");
		sql.append("     NVL(SUM(REAL_WIND.ONLINE_DL),0) AS ONLINE_DL ");
		sql.append("   FROM G_BASE_WIND_POWER BASE_WIND ");
		sql.append("   JOIN G_REAL_WIND_POWER REAL_WIND ");
		sql.append("   ON BASE_WIND.ID = REAL_WIND.SB_ID ");
		sql.append("  WHERE 1=1 ");
		if(StringUtil.isNotNullOrBlank(date)){
			sql.append(" AND TO_CHAR(REAL_WIND.DATA_TIME,'YYYY-MM')= ? ");
			param.add(date);
		}
		sql.append("   GROUP BY BASE_WIND.PLANT_ID ");
		sql.append("   ) ");
		sql.append(" SELECT PLANT.SHORT_NAME AS PLANT_NAME, ");
		sql.append("   PLANT.CAPACITY, ");
		sql.append("   WIND.FJZH, ");
		sql.append("   WIND.TYPE, ");
		sql.append("   WIND.DYDJ, ");
		sql.append("   ROUND(NVL(REAL.REAL_DL/10000,0),2)     AS REAL_DL, ");
		sql.append("   ROUND( NVL( REAL.ONLINE_DL/10000,0),2) AS ONLINE_DL ");
		sql.append(" FROM G_BASE_PLANT PLANT ");
		sql.append(" LEFT JOIN WIND_BASE WIND ");
		sql.append(" ON PLANT.ID = WIND.PLANT_ID ");
		sql.append(" LEFT JOIN REAL_BASE REAL ");
		sql.append(" ON PLANT.ID    =REAL.PLANT_ID ");
		sql.append(" WHERE 1        =1 ");
		sql.append(" AND PLANT.TYPE = ? ");
		param.add(Const.COMM_CODE.DYLX_FD);
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}
}
