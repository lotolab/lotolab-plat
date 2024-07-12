package com.lotolab.plat.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lotolab.plat.common.annotation.Excel;
import com.lotolab.plat.common.core.domain.BaseEntity;

/**
 * 三方登录对象 loto_user_oauth
 * 
 * @author lotolab
 * @date 2024-07-11
 */
public class LotoUserOauth extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** OAuth ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long cid;

    /** OAuth UUID */
    @Excel(name = "OAuth UUID")
    private String vendorId;

    /** 微信,开放平台唯一ID */
    @Excel(name = "微信,开放平台唯一ID")
    private String openid;

    /** 微信,开放平台 unionid */
    @Excel(name = "微信,开放平台 unionid")
    private String unionid;

    /** 集成商代码(数据字典oauth_vendor) */
    @Excel(name = "集成商代码(数据字典oauth_vendor)")
    private String vendor;

    /** 集成商 */
    @Excel(name = "集成商")
    private String vendorName;

    /** 状态[0停用 1正常] */
    @Excel(name = "状态[0停用 1正常]")
    private String status;

    /** 同步时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "同步时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date syncTime;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCid(Long cid) 
    {
        this.cid = cid;
    }

    public Long getCid() 
    {
        return cid;
    }
    public void setVendorId(String vendorId) 
    {
        this.vendorId = vendorId;
    }

    public String getVendorId() 
    {
        return vendorId;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setUnionid(String unionid) 
    {
        this.unionid = unionid;
    }

    public String getUnionid() 
    {
        return unionid;
    }
    public void setVendor(String vendor) 
    {
        this.vendor = vendor;
    }

    public String getVendor() 
    {
        return vendor;
    }
    public void setVendorName(String vendorName) 
    {
        this.vendorName = vendorName;
    }

    public String getVendorName() 
    {
        return vendorName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSyncTime(Date syncTime) 
    {
        this.syncTime = syncTime;
    }

    public Date getSyncTime() 
    {
        return syncTime;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cid", getCid())
            .append("vendorId", getVendorId())
            .append("openid", getOpenid())
            .append("unionid", getUnionid())
            .append("vendor", getVendor())
            .append("vendorName", getVendorName())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("syncTime", getSyncTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
