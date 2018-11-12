package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/findOneID")
    public @ResponseBody Admin findOne(String id){
        //System.out.println(id);
        Admin admin = adminService.queryOne(id);
        return admin;
    }

    @RequestMapping("/update")
    public @ResponseBody
    Map<String,Object> update(String id, String password){
        HashMap<String, Object> results = new HashMap<>();
        try {
            adminService.update(id,password);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }


    @RequestMapping("/findOne")
    public  String queryone(String name, String  password, String enCode, Model model, HttpServletRequest request){
        Admin admin = adminService.findByNamePassword(name, password);
        /*System.out.println(admin);*/
        /*System.out.println("状态2");*/
        HttpSession session = request.getSession();
        session.setAttribute("flag",admin);
        session.setAttribute("admin",admin);

        /*System.out.println(session.getAttribute("flag"));*/
        model.addAttribute("name",admin.getName());
        String code= (String) session.getAttribute("validationCode");
        if(code.equals(enCode)){
            if(admin!=null&&name.equals(admin.getName())&&password.equals(admin.getPassword())){

                session.setAttribute("adminName",admin.getName());
                return "redirect:/back/main/main.jsp";
            }else {
                return "redirect:/back/admin/login.jsp";
            }
        }else{
            return "redirect:/back/admin/login.jsp";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
                 //清除session
                 session.invalidate();
                 //重定向到登录页面的跳转方法
                 return "redirect:/back/admin/login.jsp";

    }
}
