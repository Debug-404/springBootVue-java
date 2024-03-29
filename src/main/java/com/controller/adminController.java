package com.controller;

import com.annotation.RequestLog;
import com.model.Admin;
import com.model.User;
import com.service.AdminService;
import com.utils.Result;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Resource
    AdminService adminService;

    /**
     * 管理员登录
     */
    @RequestLog
    @RequestMapping(value = "/login")
    public Result login(@RequestBody User user, HttpSession session) {
        Admin admin = adminService.selectAdminById(user.getId());
        if (admin == null) return Result.unauthorized("账号或者密码错误，请重新登录");
        if (admin.getPassword().equals(user.getPassword())) {
            session.setAttribute("Identity", "admin");
            session.setAttribute("User", admin);
            return Result.success("登录成功", admin);
        } else return Result.unauthorized("账号或者密码错误，请重新登录");
    }


    /**
     * 管理员信息更新
     */
    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin) == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

}
