package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.other.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * O_B_NOTICE
 *
 * @author b_wuxl
 */
@Entity
@Table(name = "O_B_NOTICE")
public class NoticeEntity {

    /**
     * ID
     */
    private String id;

    /**
     * 公告内容
     */
    private String notice;

    /**
     * 公告类型 1:发布,2:未发布
     */
    private String noticetype;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 地址
     */
    private String path;

    /**
     * 附件列表
     */
//    private List<AttachmentEntity> attachList;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "GMT+8")
    private Date updateTime;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NOTICE")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Column(name = "NOTICETYPE")
    public String getNoticetype() {
        return noticetype;
    }

    public void setNoticetype(String noticetype) {
        this.noticetype = noticetype;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

//    @OneToMany(fetch = FetchType.EAGER, targetEntity = AttachmentEntity.class)
//    @JoinColumn(name = "entity_id")
//    public List<AttachmentEntity> getAttachList() {
//        return attachList;
//    }
//
//    public void setAttachList(List<AttachmentEntity> attachList) {
//        this.attachList = attachList;
//    }

}
