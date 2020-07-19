package com.lyj.system.mapper;


import com.lyj.system.domain.SysMenu;

import java.util.List;

/**
 * 菜单表 数据层
 * 
 * @author ruoyi
 */
public interface SysMenuMapper
{

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectMenuPermsByUserId(Long userId);

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<SysMenu> selectMenuList();
}
