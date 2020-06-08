package cn.com.liandisys.util.util;

import cn.com.liandisys.idev.modules.entity.impl.RoleEntity;
import cn.com.liandisys.idev.modules.entity.impl.UserEntity;
import org.apache.shiro.SecurityUtils;

import java.util.List;
import java.util.UUID;

/**
 * web模块工具类
 * 
 * @author DYQ
 */
public class WebUtils {

    /**
     * 获取当前登录用户
     * 
     * @return
     */
    public static UserEntity getCurrentUser() {

        if (null != SecurityUtils.getSubject()) {
            return (UserEntity) SecurityUtils.getSubject().getPrincipal();
        }
        return null;
    }

    /**
     * 验证用户是否为某一角色
     * 
     * @param user
     * @param roleCode
     * @return
     */
    public static boolean hasRole(UserEntity user, String roleCode) {

        List<RoleEntity> roles = user.getRoles();
        for (RoleEntity role : roles) {
            if (roleCode.equals(role.getCode())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 生成随机ID
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replace("-", ""); 
        return str;
    }
}
