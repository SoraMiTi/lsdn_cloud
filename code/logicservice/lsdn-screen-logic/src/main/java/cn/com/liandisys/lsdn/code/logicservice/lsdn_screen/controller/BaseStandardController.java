package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.controller;

import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.BaseStandardService;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.base.BaseStandardEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseStandard")
public class BaseStandardController {

    private static final Logger logger = LoggerFactory.getLogger(BaseStandardController.class);

    @Autowired
    private BaseStandardService baseStandardService;

    /**
     * 根据功能id查询
     *
     * @param functionId
     * @return
     */
    @GetMapping("/findByFunctionId/{functionId}")
    public BaseStandardEntity findByFunctionId(@PathVariable("functionId") String functionId){
        BaseStandardEntity baseStandard = baseStandardService.findByFunctionId(functionId);
        return  baseStandard;
    }

}
