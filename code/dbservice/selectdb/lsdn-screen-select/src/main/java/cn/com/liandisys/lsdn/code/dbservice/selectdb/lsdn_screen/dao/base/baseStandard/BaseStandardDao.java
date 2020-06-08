package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.base.baseStandard;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.base.BaseStandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 排放限值台账数据 Dao
 * 
 * @author b_huyh
 */
public interface BaseStandardDao extends JpaRepository<BaseStandardEntity, String>, JpaSpecificationExecutor<BaseStandardEntity> {

    /**
     * 根据功能id查询
     * 
     * @param functionId
     * @return
     */
    BaseStandardEntity findByFunctionId(String functionId);
    
    /**
     * 根据功能id集合查询
     * 
     * @param functionIdList
     * @return
     */
    @Query("select e from BaseStandardEntity e where e.functionId in ?1")
    List<BaseStandardEntity> findByFunctionIds(List<String> functionIdList);
}
