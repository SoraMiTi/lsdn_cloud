package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.platform;

import javax.persistence.*;
/**
 * 系统参数
 *
 * @author DYQ
 */
@Entity
@Table(name = "t_sys_parameter")
public class SysParamEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 数值
     */
    private String value;

    /**
     * 备注
     */
    private String memo;

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false)
    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    @Column(name = "name", nullable = false)
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Column(name = "value", nullable = false)
    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    @Column(name = "memo")
    public String getMemo() {

        return memo;
    }

    public void setMemo(String memo) {

        this.memo = memo;
    }
}
