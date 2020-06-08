package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj.impl;

import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.common.Const;
import cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj.LspjZbpjJdbcDao;
import cn.com.liandisys.util.util.JdbcUtil;
import cn.com.liandisys.util.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * LspjPjGenJdbcDaoImpl 操作表O_L_LSPJ_ZBPJ
 * 
 * @author luwl
 *
 */
@Repository("lspjZbpjJdbcDao")
public class LspjZbpjJdbcDaoImpl extends JdbcUtil implements LspjZbpjJdbcDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	/**
     * 查询火力电厂历史绿色指标排名
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return List<Map<String, Object>>存放数据的列表
     */
	public List<Map<String, Object>> queryLszsHistory(String startDate,
			String endDate,String year) {
		if(StringUtil.isNullOrBlank(year)){
			year= Const.STATIC_DATA.LSPJ_DCPSPM_YEAR;
		}
		StringBuffer sql = new StringBuffer();
		List<Object> param = new ArrayList<Object>();
		sql.append(" WITH ZBBASE AS ");
		sql.append("   ( ");
		sql.append("     SELECT ZB.PLANT_ID, ");
		sql.append("     ROUND(SUM(ZB.RWDGXD), 3)  AS RWDGXD, ");
		sql.append("     ROUND(SUM(ZB.DYWDGXD), 3) AS DYWDGXD, ");
		sql.append("     ROUND(SUM(ZB.YCTPXY), 3)  AS YCTPXY, ");
		sql.append("     ROUND(SUM(ZB.AGCXY), 3)   AS AGCXY, ");
		sql.append("     ROUND(SUM(ZB.AVCXY), 3)   AS AVCXY, ");
		sql.append("     ROUND(SUM(ZB.JXNL), 3)    AS JXNL, ");
		sql.append("     ROUND(SUM(ZB.ZXNL), 3)    AS ZXNL, ");
		sql.append("     ROUND(SUM(ZB.AGCXN), 3)   AS AGCXN, ");
		sql.append("     ROUND(SUM(ZB.AVCXN), 3)   AS AVCXN, ");
		sql.append("     ROUND(SUM(ZB.YCTPXN), 3)  AS YCTPXN, ");
		sql.append("     ROUND(SUM(ZB.QPTYL), 3)   AS QPTYL, ");
		sql.append("     ROUND(SUM(ZB.JZTZL), 3)   AS JZTZL, ");
		sql.append("     ROUND(SUM(ZB.JZRBZS), 3)  AS JZRBZS, ");
		sql.append("     ROUND(SUM(ZB.HQDNL), 3)   AS HQDNL, ");
		sql.append("     ROUND(SUM(ZB.JSGLSP), 3)  AS JSGLSP ");
		sql.append("   FROM O_L_LSPJ_ZBPJ ZB ");
		sql.append("   WHERE 1                           =1 ");
		sql.append("   AND ZB.FLAG                       = '1' ");
		sql.append("   AND TO_CHAR(ZB.DATA_TIME, 'YYYY') = ? ");
		param.add(year);
		sql.append("   GROUP BY ZB.PLANT_ID ");
		sql.append("   ), ");
		sql.append("   BASEDATA AS ");
		sql.append("   (SELECT PLANT.ID PLANT_ID, ");
		sql.append("     PLANT.SHORT_NAME, ");
		sql.append("     ROUND(SUM(HDATA.SUP_POWER), 3)          AS DATAVAL, ");
		sql.append("     ROUND(AVG(HDATA.GDMH), 3)               AS COAL, ");
		sql.append("     ROUND(AVG(HDATA.SO2_EMISSIONS_RATE), 3) AS SO2RATE, ");
		sql.append("     ROUND(AVG(HDATA.NOX_EMISSIONS_RATE), 3) AS NOXRATE, ");
		sql.append("     ROUND(AVG(HDATA.PM_EMISSIONS_RATE), 3)  AS PMRATE ");
		sql.append("   FROM S_GEN_HOUR HDATA ");
		sql.append("   JOIN G_BASE_PLANT PLANT ");
		sql.append("   ON HDATA.PLANT_ID                          = PLANT.ID ");
		sql.append("   WHERE 1                                    =1 ");
		sql.append("   AND HDATA.SUP_POWER                        > 2 ");
		sql.append("   AND TO_CHAR(HDATA.DATA_TIME,'yyyy-MM-dd') >=? ");
		sql.append("   AND TO_CHAR(HDATA.DATA_TIME,'yyyy-MM-dd') <=? ");
		param.add(startDate);
		param.add(endDate);
		//投运状态为 已投运
		sql.append(" AND PLANT.TYZT = ? ");
		param.add(Const.COMM_CODE.TYZT_YES);
		sql.append("   GROUP BY PLANT.ID, ");
		sql.append("     PLANT.SHORT_NAME ");
		sql.append("   ) ");
		sql.append(" SELECT * FROM BASEDATA JOIN ZBBASE ON ZBBASE.PLANT_ID = BASEDATA.PLANT_ID ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}

	/**
     * 根据电厂id和年份 查询电厂绿色评价数据
     * @param plantId
     * @param year
     * @return
     */
	public List<Map<String, Object>> findByPlantIdAndYear(String plantId,
			String year) {
		StringBuffer sql =new StringBuffer("");
		List<Object> param=new ArrayList<Object>();
		sql.append(" SELECT * ");
		sql.append(" FROM " + Const.LOCAL_LSDN_SCHEMA + ".O_L_LSPJ_ZBPJ ");
		sql.append(" WHERE PLANT_ID =? ");
		param.add(plantId);
		sql.append(" AND TO_CHAR(DATA_TIME,'YYYY')=? ");
		param.add(year);
		sql.append(" AND FLAG                     ='1' ");
		return jdbcTemplate.queryForList(sql.toString(),param.toArray());
	}
	
    /**
     * 根据年份统计当年指标评价数据
     * @param year
     * @return
     * @author b_fangzheng
     */
    public Map<String, Object> getZbpjStaByYear(String year) {
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append(" WITH TOTALFDL AS ");
        sql.append("   (SELECT SUM(FDL) AS TOTAL ");
        sql.append("   FROM O_L_LSPJ_ZBPJ ");
        sql.append("   WHERE 1 =1 ");
        sql.append("   AND TO_CHAR(DATA_TIME,'yyyy') = ? ");
        param.add(year);
        sql.append("   AND FLAG = ? ");
        param.add(Const.STATIC_DATA.ZBPJ_FLAG_PLANT);
        sql.append("   ) ");
        sql.append(" SELECT ");
        sql.append("   NVL(SUM(YCTPXN * FDL / T.TOTAL), 0) YCTPXN, ");
        sql.append("   NVL(SUM(AGCXN * FDL / T.TOTAL), 0) AGCXN, ");
        sql.append("   NVL(SUM(AVCXN * FDL / T.TOTAL), 0) AVCXN, ");
        sql.append("   NVL(SUM(JXNL * FDL / T.TOTAL), 0) JXNL, ");
        sql.append("   NVL(SUM(ZXNL * FDL / T.TOTAL), 0) ZXNL, ");
        sql.append("   NVL(SUM(JZTZL * FDL / T.TOTAL), 0) JZTZL, ");
        sql.append("   NVL(SUM(JSGLSP * FDL / T.TOTAL), 0) JSGLSP, ");
        sql.append("   NVL(SUM(QPTYL * FDL / T.TOTAL), 0) QPTYL, ");
        sql.append("   NVL(SUM(JZRBZS * FDL / T.TOTAL), 0) JZRBZS, ");
        sql.append("   NVL(SUM(HQDNL * FDL / T.TOTAL), 0) HQDNL, ");
        sql.append("   NVL(SUM(RWDGXD * FDL / T.TOTAL), 0) RWDGXD, ");
        sql.append("   NVL(SUM(DYWDGXD * FDL / T.TOTAL), 0) DYWDGXD, ");
        sql.append("   NVL(SUM(AGCXY * FDL / T.TOTAL), 0) AGCXY, ");
        sql.append("   NVL(SUM(AVCXY * FDL / T.TOTAL), 0) AVCXY, ");
        sql.append("   NVL(SUM(YCTPXY * FDL / T.TOTAL), 0) YCTPXY, ");
        sql.append("   NVL(SUM(NOXPFL * FDL / T.TOTAL), 0) NOXPFL, ");
        sql.append("   NVL(SUM(YXPFL * FDL / T.TOTAL), 0) YXPFL, ");
        sql.append("   NVL(SUM(SO2PFL * FDL / T.TOTAL), 0) SO2PFL, ");
        sql.append("   NVL(SUM(NOXPFL * FDL / T.TOTAL), 0) NOXPFL, ");
        sql.append("   NVL(SUM(CYDL * FDL / T.TOTAL), 0) CYDL, ");
        sql.append("   NVL(SUM(FDYSL* FDL / T.TOTAL), 0) FDYSL ");
        
        sql.append(" FROM O_L_LSPJ_ZBPJ ZB, ");
        sql.append("   TOTALFDL T ");
        sql.append(" WHERE 1 =1 ");
        sql.append("   AND TO_CHAR(ZB.DATA_TIME,'yyyy') = ? ");
        param.add(year);
        sql.append("   AND ZB.FLAG = ? ");
        param.add(Const.STATIC_DATA.ZBPJ_FLAG_PLANT);
        
        return jdbcTemplate.queryForMap(sql.toString(),param.toArray());
    }
    
    
    /**
     * 根据年份统计当年电厂指标评价数据
     * @param year
     * @return
     * @author b_fangzheng
     */
    public Map<String, Object> getZbpjStaByYearAndPlantType(String year, String plantType) {
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append("  WITH TOTALFDL AS ");
        sql.append("    (SELECT SUM(ZB.FDL) AS TOTAL ");
        sql.append("    FROM O_L_LSPJ_ZBPJ ZB ");
        sql.append("    JOIN G_BASE_PLANT PLANT ");
        sql.append("       ON PLANT.ID = ZB.PLANT_ID ");
        sql.append("    WHERE 1 =1 ");
        sql.append("    AND TO_CHAR(DATA_TIME,'yyyy') = ? ");
        param.add(year);
        sql.append("    AND FLAG = ? ");
        param.add(Const.STATIC_DATA.ZBPJ_FLAG_PLANT);
        if(StringUtil.isNotNullOrBlank(plantType)) {
            sql.append("    AND PLANT.TYPE = ? ");
            param.add(plantType);
        }
        sql.append("  ) ");
        sql.append("  SELECT ");
        sql.append("    NVL(SUM(GDMH * FDL / T.TOTAL), 0) GDMH, ");
//        sql.append("    NVL(SUM(AGCXN * FDL / T.TOTAL), 0) AGCXN, ");
        sql.append("    NVL(SUM(YXPFL * FDL / T.TOTAL), 0) YXPFL ");
        sql.append("  FROM O_L_LSPJ_ZBPJ ZB, ");
        sql.append("   TOTALFDL T, ");
        sql.append("   G_BASE_PLANT PLANT ");
        sql.append("  WHERE 1=1 ");
        sql.append("   AND ZB.PLANT_ID = PLANT.ID ");
        sql.append("    AND TO_CHAR(ZB.DATA_TIME,'yyyy') = ? ");
        param.add(year);
        sql.append("    AND ZB.FLAG = ? ");
        param.add(Const.STATIC_DATA.ZBPJ_FLAG_PLANT);
        if(StringUtil.isNotNullOrBlank(plantType)) {
            sql.append("    AND PLANT.TYPE = ? ");
            param.add(plantType);
        }
        
        return jdbcTemplate.queryForMap(sql.toString(),param.toArray());
    }

    /**
     * 根据年份获取当年电厂指标评价数据（接入容量）
     * @param year
     * @return
     */
    public List<Map<String, Object>> getZbpjByYear(String year) {
        StringBuffer sql = new StringBuffer();
        List<Object> param = new ArrayList<Object>();
        
        sql.append(" SELECT ");
        sql.append("   PLANT_ID, ");
        sql.append("   ZJRL ");
        sql.append(" FROM O_L_LSPJ_ZBPJ ZB ");
        sql.append(" WHERE 1=1 ");
        sql.append("   AND ZB.FLAG = ? ");
        param.add(Const.STATIC_DATA.ZBPJ_FLAG_PLANT);
        sql.append("   AND TO_CHAR(ZB.DATA_TIME,'yyyy') = ? ");
        param.add(year);
        
        return jdbcTemplate.queryForList(sql.toString(), param.toArray());
    }
    
}
