package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.index;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index.IndexDAYEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 首页日数据表JPA操作Dao
 *
 * @author b_xugang
 */
public interface IndexDayDao extends JpaRepository<IndexDAYEntity, String>, JpaSpecificationExecutor<IndexDAYEntity>
{
	/**
     * 根据日期和类型查询日数据集合
     * @param record 记录数
     * @param lastDate 特定日期
     * @param type 指标类型
     * @return 结果数据列表
     */
	@Query(value = "select * from (select * from BS_HOME_DAY e where e.type = ?3 "
			+ " and TO_DATE(TO_CHAR(e.data_time,'yyyy-mm-dd'),'yyyy-mm-dd')<=TO_DATE(?2,'yyyy-mm-dd')"
			+ " order by e.data_time desc) "
			+ " where rownum <= to_number(?1) * (select count(*) "
			+ " from (select distinct e.code From BS_HOME_DAY e where e.type = ?3 "
			+ " and TO_DATE(TO_CHAR(e.data_time, 'yyyy-mm-dd'),'yyyy-mm-dd')<=TO_DATE(?2,'yyyy-mm-dd'))) "
			+ " order by data_time",nativeQuery = true)
    List<IndexDAYEntity> findByDay(String record, String lastDate, String type);
   
}
