package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator;

import javax.persistence.*;

/**
 * T_01002_发电集团台账
 *
 * @author b_wuxl
 */
@Entity
@Table(name = "B_BASE_GROUP")
public class BaseGroupEntity {

    /**
     * 标识
     */
    private String id;

    /**
     * 发电集团名称
     */
    private String name;

    /**
     * 集团负责人
     */
    private String fzr;

    /**
     * 联系电话
     */
    private String lxfs;

    /**
     * 映射为T_SYS_ORG中的集团组织
     */
    private String orgId;

//    private OrgEntity org;

    /**
     * 地址
     */
    private String address;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Column(name = "FZR")
    public String getFzr() {

        return fzr;
    }

    public void setFzr(String fzr) {

        this.fzr = fzr;
    }

    @Column(name = "LXFS")
    public String getLxfs() {

        return lxfs;
    }

    public void setLxfs(String lxfs) {

        this.lxfs = lxfs;
    }

    @Column(name = "ORG_ID")
    public String getOrgId() {

        return orgId;
    }

    public void setOrgId(String orgId) {

        this.orgId = orgId;
    }

//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = OrgEntity.class)
//    @JoinColumn(name = "ORG_ID", insertable = false, updatable = false)
//    public OrgEntity getOrg() {
//
//        return org;
//    }
//
//    public void setOrg(OrgEntity org) {
//
//        this.org = org;
//    }

    @Column(name = "ADDRESS")
    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

}
