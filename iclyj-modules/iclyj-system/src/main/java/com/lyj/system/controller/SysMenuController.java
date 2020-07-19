package com.lyj.system.controller;

import com.lyj.common.core.web.domain.AjaxResult;
import com.lyj.system.service.impl.SysMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2020/7/19 16:48
 *
 * 菜单控制层
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    private SysMenuServiceImpl sysMenuService;

    /**
     * 查询所有菜单
     *
     * @return
     */
    @GetMapping("list")
    public AjaxResult list(){
        return AjaxResult.success(sysMenuService.selectMenuList());
    }

}
