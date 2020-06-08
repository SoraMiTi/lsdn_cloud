package cn.com.liandisys.lsdn.code.model.lsdn_screen.model.base;


import lombok.*;

import javax.persistence.*;

/**
 * 排放限值台账数据
 *
 * @author b_huyh
 */
@Entity
@Table(name = "B_BASE_STANDARD")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@NamedQuery(name = "BaseStandardEntity.findAll", query = "SELECT a FROM BaseStandardEntity a")
public class BaseStandardEntity {

    /**
     * 标识
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "ID", length = 32)
    private String id;

    /**
     * 功能ID
     */
    @Column(name = "FUNCTION_ID")
    private String functionId;

    /**
     * 限值标准数值
     */
    @Column(name = "VALUE")
    private Double value;

    /**
     * 描述
     */
    @Column(name = "DESCRIBE")
    private String describe;

    /**
     * 单位
     */
    @Column(name = "UNIT")
    private String unit;

    /**
     * 备注
     */
    @Column(name = "BZ")
    private String bz;

}
