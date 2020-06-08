package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.base.BaseStandardEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "lsdn-screen-select/baseStandardDao",contextId = "baseStandardDaoClient")
public interface BaseStandardClient {

    @RequestMapping(value = "/findByFunctionId/{functionId}",method = RequestMethod.GET)
    public BaseStandardEntity findByFunctionId(@PathVariable("functionId") String functionId);

}
