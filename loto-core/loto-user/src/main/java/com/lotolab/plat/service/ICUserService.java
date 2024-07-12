package com.lotolab.plat.service;

import java.util.List;
import com.lotolab.plat.domain.CUser;

/**
 * 前端用户Service接口
 * 
 * @author lotolab
 * @date 2024-07-11
 */
public interface ICUserService 
{
    /**
     * 查询前端用户
     * 
     * @param cid 前端用户主键
     * @return 前端用户
     */
    public CUser selectCUserByCid(Long cid);

    /**
     * 查询前端用户列表
     * 
     * @param cUser 前端用户
     * @return 前端用户集合
     */
    public List<CUser> selectCUserList(CUser cUser);

    /**
     * 新增前端用户
     * 
     * @param cUser 前端用户
     * @return 结果
     */
    public int insertCUser(CUser cUser);

    /**
     * 修改前端用户
     * 
     * @param cUser 前端用户
     * @return 结果
     */
    public int updateCUser(CUser cUser);

    /**
     * 批量删除前端用户
     * 
     * @param cids 需要删除的前端用户主键集合
     * @return 结果
     */
    public int deleteCUserByCids(Long[] cids);

    /**
     * 删除前端用户信息
     * 
     * @param cid 前端用户主键
     * @return 结果
     */
    public int deleteCUserByCid(Long cid);
}
