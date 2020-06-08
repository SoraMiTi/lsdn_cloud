package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryWrwTotalEntity;

import java.util.List;

public interface EntryWrwTotalService {

     List<String> findByYear(String year);

     List<EntryWrwTotalEntity> findAllOrderByYear();

}
