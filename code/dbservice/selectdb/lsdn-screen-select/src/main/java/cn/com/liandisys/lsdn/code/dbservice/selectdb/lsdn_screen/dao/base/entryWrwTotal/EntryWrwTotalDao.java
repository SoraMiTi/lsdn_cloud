package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.base.entryWrwTotal;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryWrwTotalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 全网月度数据表，单表维护，不做统计的Dao
 *
 * @author b_fangzheng
 */
public interface EntryWrwTotalDao extends JpaRepository<EntryWrwTotalEntity, String>, JpaSpecificationExecutor<EntryWrwTotalEntity> {

    /**
     * 根据时间查询当前数据是否已经存在
     * @param dataTime
     * @return
     */
    @Query("select a.id from EntryWrwTotalEntity a where to_char(a.dataTime,'yyyy') = ?1")
//    @Query(value="select * from O_B_ENTRY_WRW_TOTAL e where to_char(e.DATA_TIME,'yyyy') =?1 ",nativeQuery=true)
    List<String> findByYear(String year);
    
    /**
     * 根据时间查询当前数据是否已经存在
     * @param dataTime
     * @return
     */
    @Query("select e from EntryWrwTotalEntity e order by to_char(e.dataTime,'yyyy')")
    List<EntryWrwTotalEntity> findAllOrderByYear();
    
}
