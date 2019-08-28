package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.SelectService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class SelectController {

    @Autowired
    private SelectService selectService;

    @ResponseBody
    @RequestMapping("/selectUser")
    public User selectUser(HttpServletRequest request) {
        StringBuffer str = new StringBuffer();
        try {
            BufferedInputStream in = new BufferedInputStream(request.getInputStream());
            int i;
            char c;
            while ((i=in.read())!=-1) {
                c=(char)i;
                str.append(c);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        JSONObject obj= JSONObject.fromObject(str.toString());
        User user= selectService.selectUser(obj.get("name").toString());
        System.out.println("服务端=="+user.toString());
        return user;
    }
}
