package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.generator;

//import cn.com.liandisys.idev.modules.entity.impl.OrgEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * T_02001_电厂台账数据表（燃煤、燃机）
 *
 * @author b_fangzheng
 */
@Entity
@Table(name = "G_BASE_PLANT")
public class BasePlantEntity {

    /**
     * 电厂编号 与厂站台账数据中厂站编号关联
     */
    private String id;

    /**
     * 电厂名称
     */
    private String name;

    /**
     * 电厂简称
     */
    private String shortName;

    /**
     * 所属分区 所属500kV供电分区——13个供电区域（可能存在两个）
     */
    private String ssfq;

    /**
     * 所属供电公司 所属供电公司——11家供电公司
     */
    private String compId;

    /**
     * 所属发电集团
     */
    private BaseGroupEntity jt;

    private String ssjt;

    /**
     * 电厂类型/电源类型 1.燃煤电厂 2.燃机电厂 3.光伏电厂 4.风电电厂 5.虚拟电厂 6.其他
     */
    private String type;

    /**
     * 装机容量
     */
    private Double capacity;

    // /** 装机负荷 */
    // private Double load;

    /**
     * X轴偏差
     */
    private String x;

    /**
     * Y轴偏差
     */
    private String y;

    /**
     * 负责人
     */
    private String fzr;

    /**
     * 联系方式
     */
    private String lxfs;

    /**
     * 备注
     */
    private String bz;

    /**
     * 运行状态 0：未运行 1：运行中
     */
    private String runStatus;

    /**
     * 投运状态 0：未投运 1：投运中
     */
    private String tyzt;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 电厂绿能标识（对方库中唯一编号）
     */
    private String lsnyId;

    /**
     * 电厂排序编号
     */
    private Integer plantOrder;

    /**
     * 地址
     */
    private String address;

    /**
     * 所属公司
     */
    private String orgId;

//    private OrgEntity org;

    /**
     * 装机时间/投运时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date tysj;

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

    @Column(name = "SHORT_NAME")
    public String getShortName() {

        return shortName;
    }

    public void setShortName(String shortName) {

        this.shortName = shortName;
    }

    @Column(name = "SSFQ")
    public String getSsfq() {

        return ssfq;
    }

    public void setSsfq(String ssfq) {

        this.ssfq = ssfq;
    }

    @Column(name = "COMP_ID")
    public String getCompId() {

        return compId;
    }

    public void setCompId(String compId) {

        this.compId = compId;
    }

    @Column(name = "TYPE")
    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    @Column(name = "CAPACITY")
    public Double getCapacity() {

        return capacity;
    }

    public void setCapacity(Double capacity) {

        this.capacity = capacity;
    }

    // @Column(name = "LOAD")
    // public Double getLoad() {
    //
    // return load;
    // }
    //
    // public void setLoad(Double load) {
    //
    // this.load = load;
    // }

    @Column(name = "X")
    public String getX() {

        return x;
    }

    public void setX(String x) {

        this.x = x;
    }

    @Column(name = "Y")
    public String getY() {

        return y;
    }

    public void setY(String y) {

        this.y = y;
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

    @Column(name = "BZ")
    public String getBz() {

        return bz;
    }

    public void setBz(String bz) {

        this.bz = bz;
    }

    @Column(name = "RUN_STATUS")
    public String getRunStatus() {

        return runStatus;
    }

    public void setRunStatus(String runStatus) {

        this.runStatus = runStatus;
    }

    @Column(name = "TYZT")
    public String getTyzt() {

        return tyzt;
    }

    public void setTyzt(String tyzt) {

        this.tyzt = tyzt;
    }

    @Column(name = "LNG")
    public String getLng() {

        return lng;
    }

    public void setLng(String lng) {

        this.lng = lng;
    }

    @Column(name = "LAT")
    public String getLat() {

        return lat;
    }

    public void setLat(String lat) {

        this.lat = lat;
    }

    @Column(name = "LSNY_ID")
    public String getLsnyId() {

        return lsnyId;
    }

    public void setLsnyId(String lsnyId) {

        this.lsnyId = lsnyId;
    }

    @Column(name = "PLANT_ORDER")
    public Integer getPlantOrder() {

        return plantOrder;
    }

    public void setPlantOrder(Integer plantOrder) {

        this.plantOrder = plantOrder;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
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

    @Column(name = "SSJT")
    public String getSsjt() {

        return ssjt;
    }

    public void setSsjt(String ssjt) {

        this.ssjt = ssjt;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BaseGroupEntity.class)
    @JoinColumn(name = "SSJT", insertable = false, updatable = false)
    public BaseGroupEntity getJt() {

        return jt;
    }

    public void setJt(BaseGroupEntity jt) {

        this.jt = jt;
    }

    @Column(name = "TYSJ")
    public Date getTysj() {

        return tysj;
    }

    public void setTysj(Date tysj) {

        this.tysj = tysj;
    }
}
