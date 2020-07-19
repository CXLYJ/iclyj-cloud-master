package com.lyj.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.lyj.common.core.web.domain.AjaxResult;
import com.lyj.system.domain.SysMenu;
import com.lyj.system.service.impl.SysMenuServiceImpl;
import org.apache.commons.codec.Charsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

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


    /**
     * 导出全部菜单
     *
     * @return
     */
    @GetMapping("exportExcel")
    public AjaxResult exportExcel(HttpServletResponse response) throws Exception{
        List<SysMenu> menuList = sysMenuService.selectMenuList();
        ExcelWriter excelWriter = null;
        try {
            String fileName = URLEncoder.encode("菜单数据导出", Charsets.UTF_8.name());
            excelWriter = EasyExcel.write(fileName, SysMenu.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(menuList, writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
        return AjaxResult.success();
    }


}
