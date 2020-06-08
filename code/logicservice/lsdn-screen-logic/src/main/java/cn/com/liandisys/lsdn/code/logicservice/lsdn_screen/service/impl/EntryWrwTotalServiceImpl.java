package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.impl;

import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen.EntryWrwTotalClient;
import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.EntryWrwTotalService;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryWrwTotalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entryWrwTotalService")
public class EntryWrwTotalServiceImpl implements EntryWrwTotalService {

    @Autowired
    private EntryWrwTotalClient entryWrwTotalClient;

    public List<String> findByYear(String year){
        return entryWrwTotalClient.findByYear(year);
    }

    public List<EntryWrwTotalEntity> findAllOrderByYear(){
        return entryWrwTotalClient.findAllOrderByYear();
    }

}
