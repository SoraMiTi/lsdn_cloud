package cn.com.liandisys.util.model;

import java.util.List;

/**
 * 导航菜单
 * 
 * @author DYQ
 */
public class Menu {

    /** ID */
    private String id;

    /** 名称 */
    private String text;

    /** 图标 */
    private String iconCls;

    /** 业务编码 */
    private String busiCode;

    /** 是否为叶子节点 */
    private boolean leaf;

    /** 是否为外部链接 */
    private boolean outer;

    /** 访问地址 */
    private String url;

    /** 子菜单 */
    private List<Menu> children;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public String getIconCls() {

        return iconCls;
    }

    public void setIconCls(String iconCls) {

        this.iconCls = iconCls;
    }

    public String getBusiCode() {

        return busiCode;
    }

    public void setBusiCode(String busiCode) {

        this.busiCode = busiCode;
    }

    public boolean isLeaf() {

        return leaf;
    }

    public void setLeaf(boolean leaf) {

        this.leaf = leaf;
    }

    public boolean isOuter() {

        return outer;
    }

    public void setOuter(boolean outer) {

        this.outer = outer;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public List<Menu> getChildren() {

        return children;
    }

    public void setChildren(List<Menu> children) {

        this.children = children;
    }

}
