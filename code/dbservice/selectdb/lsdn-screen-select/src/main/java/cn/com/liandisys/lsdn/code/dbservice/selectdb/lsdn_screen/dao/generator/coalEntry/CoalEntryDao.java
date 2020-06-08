package cn.com.liandisys.lsdn.code.dbservice.selectdb.lsdn_screen.dao.generator.coalEntry;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryCoalEntity;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * O_B_ENTRY_COAL的Dao
 *
 * @author b_fangzheng
 */
@RepositoryRestResource(collectionResourceRel="coalEntryDao",path="coalEntryDao")
public interface CoalEntryDao extends JpaRepository<EntryCoalEntity,String>, JpaSpecificationExecutor<EntryCoalEntity> {
//public interface CoalEntryDao extends CrudRepository<EntryCoalEntity,String>{

    @Query("select e from EntryCoalEntity e where to_char(e.dataTime,'yyyy')=?1 ")
    List<EntryCoalEntity> getByYear(@Param("year")String year);

    List<EntryCoalEntity> getByPlantId(@Param("plantId")String plantId);

    @Modifying
    @Query("delete from EntryCoalEntity e where e.gdmh = ?1 ")
    @RestResource(exported=false)
    void deleteByGdmh(Double gdmh);

    @Modifying
    @Query("delete from EntryCoalEntity e where e.fdmh = ?1 ")
    @RestResource(exported=false)
    void deleteByFdmh(Double fdmh);
}
