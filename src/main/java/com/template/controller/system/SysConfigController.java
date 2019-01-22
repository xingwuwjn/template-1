package com.template.controller.system;

import com.template.bean.Menu;
import com.template.bean.User;
import com.template.bean.common.RespBean;
import com.template.controller.common.CommonController;
import com.template.enums.ResultEnum;
import com.template.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Api(description = "菜单接口")
@RestController
public class SysConfigController extends CommonController {
    @Autowired
    MenuService menuService;
    /**
     * 获取当前登录用户的菜单树
     * @param request
     * @return
     */
    @GetMapping("/sysmenu")
    public RespBean sysmenu(HttpServletRequest request) {
        User user =super.getCurrentUser(request);
        if (user ==null){
            return null;
        }
        List<Menu> menuList= menuService.getMenusByHrId(user.getId());
        return new RespBean(ResultEnum.SUCCESS,menuList);
    }
}
