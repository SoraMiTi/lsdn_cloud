package cn.com.liandisys.util.model;

import cn.com.liandisys.idev.modules.entity.impl.SysCodeEntity;

import java.util.List;

/**
 * 多级公用代码条目
 * 
 * @author DYQ
 */
public class MultCommCode {

    private String id;

    private String value;

    private String label;

    private boolean selected;
    
    private String orgId;

    private Boolean leaf;

    private List<MultCommCode> children;

    public MultCommCode() {
        super();
    }

    public MultCommCode(SysCodeEntity entity) {
        super();
        this.id = entity.getId();
        this.value = entity.getCode();
        this.label = entity.getName();
        this.leaf = entity.getLeaf();
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }


    public boolean isSelected() {

        return selected;
    }

    public void setSelected(boolean selected) {

        this.selected = selected;
    }

    public Boolean getLeaf() {

        return leaf;
    }

    public void setLeaf(Boolean leaf) {

        this.leaf = leaf;
    }

    public List<MultCommCode> getChildren() {

        return children;
    }

    public void setChildren(List<MultCommCode> children) {

        this.children = children;
    }

    public String getOrgId() {

        return orgId;
    }

    public void setOrgId(String orgId) {

        this.orgId = orgId;
    }

    
    public String getLabel() {
    
        return label;
    }

    
    public void setLabel(String label) {
    
        this.label = label;
    }

}
