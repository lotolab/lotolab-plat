package com.lotolab.plat.service.impl;

import java.util.List;
import com.lotolab.plat.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.lotolab.plat.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.lotolab.plat.domain.LotoUserOauth;
import com.lotolab.plat.mapper.CUserMapper;
import com.lotolab.plat.domain.CUser;
import com.lotolab.plat.service.ICUserService;

/**
 * 前端用户Service业务层处理
 * 
 * @author lotolab
 * @date 2024-07-11
 */
@Service
public class CUserServiceImpl implements ICUserService 
{
    @Autowired
    private CUserMapper cUserMapper;

    /**
     * 查询前端用户
     * 
     * @param cid 前端用户主键
     * @return 前端用户
     */
    @Override
    public CUser selectCUserByCid(Long cid)
    {
        return cUserMapper.selectCUserByCid(cid);
    }

    /**
     * 查询前端用户列表
     * 
     * @param cUser 前端用户
     * @return 前端用户
     */
    @Override
    public List<CUser> selectCUserList(CUser cUser)
    {
        return cUserMapper.selectCUserList(cUser);
    }

    /**
     * 新增前端用户
     * 
     * @param cUser 前端用户
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCUser(CUser cUser)
    {
        cUser.setCreateTime(DateUtils.getNowDate());
        int rows = cUserMapper.insertCUser(cUser);
        insertLotoUserOauth(cUser);
        return rows;
    }

    /**
     * 修改前端用户
     * 
     * @param cUser 前端用户
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCUser(CUser cUser)
    {
        cUser.setUpdateTime(DateUtils.getNowDate());
        cUserMapper.deleteLotoUserOauthByCid(cUser.getCid());
        insertLotoUserOauth(cUser);
        return cUserMapper.updateCUser(cUser);
    }

    /**
     * 批量删除前端用户
     * 
     * @param cids 需要删除的前端用户主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCUserByCids(Long[] cids)
    {
        cUserMapper.deleteLotoUserOauthByCids(cids);
        return cUserMapper.deleteCUserByCids(cids);
    }

    /**
     * 删除前端用户信息
     * 
     * @param cid 前端用户主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCUserByCid(Long cid)
    {
        cUserMapper.deleteLotoUserOauthByCid(cid);
        return cUserMapper.deleteCUserByCid(cid);
    }

    /**
     * 新增三方登录信息
     * 
     * @param cUser 前端用户对象
     */
    public void insertLotoUserOauth(CUser cUser)
    {
        List<LotoUserOauth> lotoUserOauthList = cUser.getLotoUserOauthList();
        Long cid = cUser.getCid();
        if (StringUtils.isNotNull(lotoUserOauthList))
        {
            List<LotoUserOauth> list = new ArrayList<LotoUserOauth>();
            for (LotoUserOauth lotoUserOauth : lotoUserOauthList)
            {
                lotoUserOauth.setCid(cid);
                list.add(lotoUserOauth);
            }
            if (list.size() > 0)
            {
                cUserMapper.batchLotoUserOauth(list);
            }
        }
    }
}
