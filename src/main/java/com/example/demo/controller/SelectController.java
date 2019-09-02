package com.example.demo.controller;

import com.example.demo.entity.UserVo;
import com.example.demo.service.SelectService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class SelectController {

    @Autowired
    private SelectService selectService;

    @ResponseBody
    @RequestMapping("/selectUser")
    public List<UserVo> selectUser(HttpServletRequest request) {
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
        Map<String, Object> params = new HashMap<>();
        params.put("usercode",obj.get("usercode").toString());
        params.put("starttime",obj.get("starttime").toString());
        params.put("endtime",obj.get("endtime").toString());
        List<UserVo> list= selectService.selectUser(params);
        if (list == null || list.size() == 0){
            System.out.println("数据库查询为空");
        }else{
            System.out.println("数据库查询=="+list.get(0).getDname());
        }
        return list;
    }

    @RequestMapping("/userAll")
    public List<UserVo> viewUserAll() {
        List<UserVo> list= selectService.selectUserAll();
        return list;
    }
}
