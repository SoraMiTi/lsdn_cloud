package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.index;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index.IndexMonthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 首页月数据表JPA操作Dao
 *
 * @author b_xugang
 */
public interface IndexMonthDao extends JpaRepository<IndexMonthEntity, String>, JpaSpecificationExecutor<IndexMonthEntity>
{

	/**
     * 根据年份和类型查询月数据集合
     * @param year 年份
     * @param type 指标类型
     * @return 结果数据列表
     */
	@Query("select e from IndexMonthEntity e where to_number(e.year) = ?1 and e.type=?2 order by to_number(e.month)")
    List<IndexMonthEntity> findByMonth(String year, String type);
   
}
