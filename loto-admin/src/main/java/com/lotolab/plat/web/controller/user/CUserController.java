package com.lotolab.plat.web.controller.user;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lotolab.plat.common.annotation.Log;
import com.lotolab.plat.common.core.controller.BaseController;
import com.lotolab.plat.common.core.domain.AjaxResult;
import com.lotolab.plat.common.enums.BusinessType;
import com.lotolab.plat.domain.CUser;
import com.lotolab.plat.service.ICUserService;
import com.lotolab.plat.common.utils.poi.ExcelUtil;
import com.lotolab.plat.common.core.page.TableDataInfo;

/**
 * 前端用户Controller
 * 
 * @author lotolab
 * @date 2024-07-11
 */
@RestController
@RequestMapping("/cuser/user")
public class CUserController extends BaseController
{
    @Autowired
    private ICUserService cUserService;

    /**
     * 查询前端用户列表
     */
    @PreAuthorize("@ss.hasPermi('cuser:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(CUser cUser)
    {
        startPage();
        List<CUser> list = cUserService.selectCUserList(cUser);
        return getDataTable(list);
    }

    /**
     * 导出前端用户列表
     */
    @PreAuthorize("@ss.hasPermi('cuser:user:export')")
    @Log(title = "终端用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CUser cUser)
    {
        List<CUser> list = cUserService.selectCUserList(cUser);
        ExcelUtil<CUser> util = new ExcelUtil<CUser>(CUser.class);
        util.exportExcel(response, list, "终端用户数据");
    }

    /**
     * 获取前端用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('cuser:user:query')")
    @GetMapping(value = "/{cid}")
    public AjaxResult getInfo(@PathVariable("cid") Long cid)
    {
        return success(cUserService.selectCUserByCid(cid));
    }

    /**
     * 新增前端用户
     */
    @PreAuthorize("@ss.hasPermi('cuser:user:add')")
    @Log(title = "前端用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CUser cUser)
    {
        return toAjax(cUserService.insertCUser(cUser));
    }

    /**
     * 修改前端用户
     */
    @PreAuthorize("@ss.hasPermi('cuser:user:edit')")
    @Log(title = "前端用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CUser cUser)
    {
        return toAjax(cUserService.updateCUser(cUser));
    }

    /**
     * 删除前端用户
     */
    @PreAuthorize("@ss.hasPermi('cuser:user:remove')")
    @Log(title = "前端用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cids}")
    public AjaxResult remove(@PathVariable Long[] cids)
    {
        return toAjax(cUserService.deleteCUserByCids(cids));
    }
}
