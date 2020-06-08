package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.platform;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.platform.SysParamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


/**
 * 系统参数的Dao
 * 
 * @author DYQ
 */
public interface SysParamDao
        extends JpaRepository<SysParamEntity, String>, JpaSpecificationExecutor<SysParamEntity> {

    /**
     * 根据参数编号查询参数值
     * 
     * @param code
     * @return
     */
    @Query("select A.value from SysParamEntity A where A.code = ?1")
    String findValueByCode(String code);

    /**
     * 根据系统参数名字规则查询系统参数
     * 
     * @param name 系统参数名字
     * @param pageable
     * @return 返回系统参数列表
     */
    @Query(value = "select A from SysParamEntity A where A.name like ?1")
    Page<SysParamEntity> findByNameLike(String name, Pageable pageable);
}
