package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.index;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.index.IndexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 首页公共数据表JPA操作Dao
 *
 * @author b_xugang
 */
public interface IndexDao extends JpaRepository<IndexEntity, String>, JpaSpecificationExecutor<IndexEntity>
{

    /**
     * 根据指标类型查询指标数据集合
     * @param type 指标类型
     * @return 结果数据列表
     */
    @Query("select z from IndexEntity z where z.type = ?1")
    List<IndexEntity> findByType(String type);
   
}
