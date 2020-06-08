package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.impl;

import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen.CoalEntryClient;
import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen.CoalEntryDaoClient;
import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.CoalEntryService;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryCoalEntity;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("coalEntryService")
@Transactional
public class CoalEntryServiceImpl implements CoalEntryService {

    @Autowired
    private CoalEntryDaoClient coalEntryDaoClient;

    @Autowired
    private CoalEntryClient coalEntryClient ;

    public List<EntryCoalEntity> getByYear(String year) {
        Collection<EntryCoalEntity> coals = coalEntryDaoClient.getByYear(year).getContent();
        List<EntryCoalEntity> coalList = new ArrayList<>(coals);
        return coalList;
    }

    public EntryCoalEntity findById(String id) {
        EntryCoalEntity ec = coalEntryDaoClient.findById(id).getContent();
        return ec;
    }

    public List<EntryCoalEntity> getByPlantId(String plantId){
        Collection<EntryCoalEntity> coals = coalEntryDaoClient.getByPlantId(plantId).getContent();
        List<EntryCoalEntity> coalList = new ArrayList<>(coals);
        return coalList;
    }

    @LcnTransaction
    @Transactional(readOnly = false)
    public void delete(Double gdmh,Double fdmh){
        coalEntryClient.deleteByGdmh(gdmh);
        coalEntryClient.deleteByFdmh(fdmh);
    }
}
