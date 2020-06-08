package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.index;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index.IndexYearEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 首页年数据表JPA操作Dao
 *
 * @author b_xugang
 */
public interface IndexYearDao extends JpaRepository<IndexYearEntity, String>, JpaSpecificationExecutor<IndexYearEntity>
{

    /**
     * 根据年份和类型查询年数据集合
     * @param record 记录数
     * @param lastYear 结束年份
     * @param type 指标类型
     * @return 结果数据列表
     */
	@Query(value = "select * from (select * from BS_HOME_YEAR e where e.type=?1 and to_number(e.year) <= ?2 order by e.year desc) where rownum<=to_number(?3)*(select count(*) from (select distinct e.code From BS_HOME_YEAR e where  e.type=?1 and to_number(e.year) <= ?2)) order by year",nativeQuery = true)
    List<IndexYearEntity> findByYear(String type, String lastYear, String record);
   
}
