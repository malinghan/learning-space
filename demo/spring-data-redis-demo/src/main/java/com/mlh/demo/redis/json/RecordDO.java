package com.mlh.demo.redis.json;


import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <记录>
 * <详细介绍>
 *
 * @author 甄春阳
 * @since 设计wiki | 需求wiki
 */
public class RecordDO extends HashMap<String, String> implements Serializable {
    private static final long serialVersionUID = -8234923092193606747L;

    private String employeeId = "";
    private String departmentId = "";

    // 临时先这样，后边规范所有报表必须用小写
    static Set<String> employeeKeys = new HashSet<String>() {{
        add("employeeId");
        add("employee_id");
        add("EMPLOYEE_ID");
    }};

    // 临时先这样，后边规范所有报表必须用小写
    static Set<String> departmentKeys = new HashSet<String>() {{
        add("departmentId");
        add("department_id");
        add("DEPARTMENT_ID");
    }};

    public RecordDO() {

    }

    /**
     * 构造函数需要cp一下map了
     *
     * @param mapData
     */
    public RecordDO(Map mapData) {
        if (mapData != null && !mapData.isEmpty()) {
            for (Object key : mapData.keySet()) {
                Object value = mapData.get(key);
                String strKey = key.toString();
                String strValue = value == null ? "" : value.toString();
                put(strKey, strValue);
            }
        }
    }

    /**
     * 重写这个方法就够了, putAll方法原理上也是分配空间后调用该方法
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public String put(String key, String value) {
        String val = super.put(key, value);
        setPropWhenPut(key, value);
        return val;
    }

    /**
     * 设置属性值
     * 如果需要自定义，则需要#重写该方法#
     *
     * @param key
     * @param value
     */
    protected void setPropWhenPut(String key, String value) {
        if (employeeKeys.contains(key)) {
            this.employeeId = value;
        }
        if (departmentKeys.contains(key)) {
            this.departmentId = value;
        }
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        /**
         * 由于该类没重写 toString 方法
         * 此处将数据放入 hashMap 集合，防止入库前序列化时丢失信息
         */
        super.put("employee_id", employeeId);
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        /**
         * 同employeeId
         */
        super.put("department_id", departmentId);
    }

    @Override
    public RecordDO clone() {
        return (RecordDO) super.clone();
    }
}
