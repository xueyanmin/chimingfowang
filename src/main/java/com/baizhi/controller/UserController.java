package com.baizhi.controller;
import com.baizhi.entity.User;

import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public @ResponseBody void add(User user){

        userService.add(user);
        System.out.println("---------用户添加成功-------------");
    }


    @RequestMapping("/findUsernamePassword")
    public @ResponseBody void  findbyUsernamePassword(HttpSession session, String username, String password){
            User user = userService.findByUsernamePassword(username, password);

        if(username.equals(user.getUsername())&&password.equals(user.getPassword())){

            session.setAttribute("adminName",user.getUsername());
            System.out.println(username+":"+password);
            System.out.println("-------------01--------------");

        }

    }


    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findbyPage(Integer page,Integer rows){
        Map<String,Object> results = new HashMap<>();
        List<User> users = userService.findByPage(page, rows);
        Long totals = userService.findTotals();
        results.put("total",totals);
        results.put("rows",users);
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody String  findone(String id){
        userService.findOne(id);
        return "index";
    }

    @RequestMapping("/delete")
    public @ResponseBody void delect(String id){
        userService.remove(id);
    }

    @RequestMapping("/delRows")
    public @ResponseBody void delRows(String[] ids){
        for (String  id : ids) {
            userService.remove(id);
        }
    }

    @RequestMapping("/update")
    public @ResponseBody void update(User user){
        /*Map<String,Object> results = new HashMap<String,Object>();
        try {
            userService.motify(user);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;*/
        userService.motify(user);
        System.out.println("---------修改成功！！----------");
    }

    @RequestMapping("/updateStatus")
    public @ResponseBody Map<String,Object> updateStatus(String id,Integer status){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            userService.updateStatus(id,status);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
