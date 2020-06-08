package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.impl;

import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.client.lsdnScreen.BaseStandardClient;
import cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service.BaseStandardService;
import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.base.BaseStandardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("baseStandardService")
public class BaseStandardServiceImpl implements BaseStandardService {

    @Autowired
    private BaseStandardClient baseStandardClient;

    public BaseStandardEntity findByFunctionId(String functionId) {
        return baseStandardClient.findByFunctionId(functionId);
    }
}
