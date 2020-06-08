package cn.com.liandisys.util.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树型结构的VO
 * 
 * @author DYQ
 */
public class TreeNode {

    /** 节点ID */
    private String id;

    /** 节点显示名 */
    private String text;

    /** 节点图标 */
    private String iconCls;

    /** 是否选中 */
    private boolean checked = false;

    /** 是否为叶子节点 */
    private boolean leaf;

    /** 是否只读 */
    private boolean readOnly = false;

    /** 节点属性 */
    private Map<String, String> attributes = new HashMap<String, String>(4);

    /** 子节点的List */
    private List<TreeNode> children;

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

    public boolean isChecked() {

        return checked;
    }

    public void setChecked(boolean checked) {

        this.checked = checked;
    }

    public boolean isLeaf() {

        return leaf;
    }

    public void setLeaf(boolean leaf) {

        this.leaf = leaf;
    }

    public boolean isReadOnly() {

        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {

        this.readOnly = readOnly;
    }

    public Map<String, String> getAttributes() {

        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {

        this.attributes = attributes;
    }

    public List<TreeNode> getChildren() {

        return children;
    }

    public void setChildren(List<TreeNode> children) {

        this.children = children;
    }

    public void addAttribute(String name, String value) {

        attributes.put(name, value);
    }

    public void removeAttribute(String name) {

        attributes.remove(name);
    }

    public String getAttribute(String name) {

        return attributes.get(name);
    }

}
