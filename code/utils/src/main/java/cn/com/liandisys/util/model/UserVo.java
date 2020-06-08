package cn.com.liandisys.util.model;

import cn.com.liandisys.idev.modules.entity.Role;
import cn.com.liandisys.idev.modules.entity.impl.UserEntity;
import cn.com.liandisys.idev.modules.vo.BaseVo;
import cn.com.liandisys.idev.modules.vo.VoConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 用户视图
 * 
 * @author DYQ
 */
public class UserVo extends BaseVo implements VoConverter<UserEntity> {

    /** 登录名称 */
    private String loginName;

    /** 用户姓名 */
    private String name;

    /** 照片 */
    private byte[] photo;

    /** 角色信息 */
    private List<String> roles;

    /** 权限信息 */
    private Set<String> permissions;

    public String getLoginName() {

        return loginName;
    }

    public void setLoginName(String loginName) {

        this.loginName = loginName;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public byte[] getPhoto() {

        return photo;
    }

    public void setPhoto(byte[] photo) {

        this.photo = photo;
    }

    public List<String> getRoles() {

        return roles;
    }

    public void setRoles(List<String> roles) {

        this.roles = roles;
    }

    public Set<String> getPermissions() {

        return permissions;
    }

    public void setPermissions(Set<String> permissions) {

        this.permissions = permissions;
    }

    public void loaderFromEntity(UserEntity entity) {

        this.setLoginName(entity.getLoginName());
        this.setName(entity.getName());
        this.setPhoto(entity.getPhoto());
        if (entity.getRoles() != null) {
            this.roles = new ArrayList<String>();
            for (Role role : entity.getRoles()) {
                this.roles.add(role.getCode());
            }
        }
    }

    public void writeToEntity(UserEntity entity) {

        entity.setLoginName(this.loginName);
        entity.setName(this.name);
        entity.setPhoto(this.photo);
    }
}
