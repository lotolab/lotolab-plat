package com.lotolab.plat.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lotolab.plat.common.annotation.Excel;
import com.lotolab.plat.common.core.domain.BaseEntity;

/**
 * 前端用户对象 loto_user
 * 
 * @author lotolab
 * @date 2024-07-11
 */
public class CUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** C端用户ID */
    private Long cid;

    /** 用户Code(唯一) */
    @Excel(name = "用户编码")
    private String ucode;

    /** 密码 */
    // @Excel(name = "密码")
    private String password;

    /** salt */
    // @Excel(name = "salt")
    private String salt;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 是否实名[1已实名,0未实名] */
    @Excel(name = "是否实名")
    private Integer isReal;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 电话 */
    // @Excel(name = "电话")
    private String phone;

    /** 所属平台（数据字典loto_platform） */
    @Excel(name = "所属平台")
    private String platform;

    /** 用户角色（数据字典loto_user_type） */
    @Excel(name = "用户角色")
    private String type;

    /** 状态[0停用 1正常] */
    @Excel(name = "状态",readConverterExp = "0=停用,1=正常")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 三方登录信息 */
    private List<LotoUserOauth> lotoUserOauthList;

    public void setCid(Long cid) 
    {
        this.cid = cid;
    }

    public Long getCid() 
    {
        return cid;
    }
    public void setUcode(String ucode) 
    {
        this.ucode = ucode;
    }

    public String getUcode() 
    {
        return ucode;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setSalt(String salt) 
    {
        this.salt = salt;
    }

    public String getSalt() 
    {
        return salt;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIsReal(Integer isReal) 
    {
        this.isReal = isReal;
    }

    public Integer getIsReal() 
    {
        return isReal;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPlatform(String platform) 
    {
        this.platform = platform;
    }

    public String getPlatform() 
    {
        return platform;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public List<LotoUserOauth> getLotoUserOauthList()
    {
        return lotoUserOauthList;
    }

    public void setLotoUserOauthList(List<LotoUserOauth> lotoUserOauthList)
    {
        this.lotoUserOauthList = lotoUserOauthList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cid", getCid())
            .append("ucode", getUcode())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("nickname", getNickname())
            .append("name", getName())
            .append("isReal", getIsReal())
            .append("avatar", getAvatar())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("platform", getPlatform())
            .append("remark", getRemark())
            .append("type", getType())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("lotoUserOauthList", getLotoUserOauthList())
            .toString();
    }
}
