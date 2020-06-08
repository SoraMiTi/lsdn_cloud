package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base.EntryWrwTotalEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "lsdn-screen-select/entryWrwTotalDao",contextId = "entryWrwTotalDaoClient")
public interface EntryWrwTotalClient {

    @RequestMapping(value = "/findByYear/{year}",method = RequestMethod.GET)
    public List<String> findByYear(@PathVariable("year") String year);

    @RequestMapping(value = "/findAllOrderByYear",method = RequestMethod.GET)
    public List<EntryWrwTotalEntity> findAllOrderByYear();

}
