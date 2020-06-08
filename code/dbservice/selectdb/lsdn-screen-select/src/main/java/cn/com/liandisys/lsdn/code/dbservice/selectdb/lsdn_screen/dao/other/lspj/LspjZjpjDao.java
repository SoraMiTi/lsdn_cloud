package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.lspj.LspjPjzjEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


/**
 * O_L_LSPJ_ZJPJ 的Dao
 *
 * @author b_fangzheng
 */
public interface LspjZjpjDao extends JpaRepository<LspjPjzjEntity, String>, JpaSpecificationExecutor<LspjPjzjEntity> {

    /**
     * 根据年查询当年综合评价数据
     * @param year 年份
     * @return 
     */
    @Query("select entity from LspjPjzjEntity entity where to_char(entity.dataTime,'yyyy') = ?1 ")
    LspjPjzjEntity findByYear(String year);
    
}
