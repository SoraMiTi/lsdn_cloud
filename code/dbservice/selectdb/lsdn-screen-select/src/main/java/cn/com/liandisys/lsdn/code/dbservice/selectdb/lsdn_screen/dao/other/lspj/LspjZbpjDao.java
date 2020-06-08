package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.other.lspj;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.lspj.LspjZbpjEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * T_06005_绿电指标评价数据表的Dao
 *
 * @author b_fangzheng
 */
public interface LspjZbpjDao extends JpaRepository<LspjZbpjEntity, String>, JpaSpecificationExecutor<LspjZbpjEntity> {
}
