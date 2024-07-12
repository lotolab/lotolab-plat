package com.lotolab.plat.mapper;

import java.util.List;
import com.lotolab.plat.domain.CUser;
import com.lotolab.plat.domain.LotoUserOauth;

/**
 * 前端用户Mapper接口
 * 
 * @author lotolab
 * @date 2024-07-11
 */
public interface CUserMapper 
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
     * 删除前端用户
     * 
     * @param cid 前端用户主键
     * @return 结果
     */
    public int deleteCUserByCid(Long cid);

    /**
     * 批量删除前端用户
     * 
     * @param cids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCUserByCids(Long[] cids);

    /**
     * 批量删除三方登录
     * 
     * @param cids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLotoUserOauthByCids(Long[] cids);
    
    /**
     * 批量新增三方登录
     * 
     * @param lotoUserOauthList 三方登录列表
     * @return 结果
     */
    public int batchLotoUserOauth(List<LotoUserOauth> lotoUserOauthList);
    

    /**
     * 通过前端用户主键删除三方登录信息
     * 
     * @param cid 前端用户ID
     * @return 结果
     */
    public int deleteLotoUserOauthByCid(Long cid);
}
