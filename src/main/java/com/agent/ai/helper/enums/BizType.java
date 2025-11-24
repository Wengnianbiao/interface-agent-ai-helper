package com.agent.ai.helper.enums;

/**
 * 业务类型枚举,会通过前端下拉框约束业务类型
 */
public enum BizType {

    /**
     * 建档
     */
    CREATE_ARCHIVE,

    /**
     * 同步申请单
     */
    SYNC_APPLY,

    /**
     * 删除申请单
     */
    DELETE_APPLY,

    /**
     * 同步账单
     */
    SYNC_CHAG;



    /**
     * 根据字符串获取业务类型枚举
     * @param bizTypeStr 业务类型字符串
     * @return 对应的BizType枚举值，如果未找到则返回null
     */
    public static BizType fromString(String bizTypeStr) {
        if (bizTypeStr == null || bizTypeStr.isEmpty()) {
            return null;
        }

        try {
            return BizType.valueOf(bizTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
