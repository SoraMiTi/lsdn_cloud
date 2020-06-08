package cn.com.liandisys.lsdn.code.logicservice.lsdn_screen.service;

import cn.com.liandisys.lsdn.code.model.lsdn_screen.model.base.BaseStandardEntity;

public interface BaseStandardService {

    BaseStandardEntity findByFunctionId(String functionId);

}
