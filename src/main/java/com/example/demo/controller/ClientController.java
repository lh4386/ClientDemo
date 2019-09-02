package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.entity.UserVo;
import com.example.demo.service.SelectService;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    private SelectService selectService;

    @RequestMapping("/client")
    @ResponseBody
    public List<UserVo> HttpPostData(String usercode,String starttime,String endtime) throws IOException {

            HttpClient httpclient = new DefaultHttpClient();//创建HttpClient对象
            String URL = "http://localhost:8080/user/selectUser";
            HttpPost httppost = new HttpPost(URL);//创建HttpPost对象
            JSONObject obj = new JSONObject();
            obj.put("usercode", usercode);
            obj.put("starttime", starttime);
            obj.put("endtime", endtime);
            System.out.println("数据传入==员工姓名"+usercode+"；开始时间"+starttime+"；结束时间"+endtime);
            httppost.setEntity(new StringEntity(obj.toString()));//设置请求参数
            HttpResponse response = httpclient.execute(httppost);//发送请求会返回一个HttpResponse
            String rev = EntityUtils.toString(response.getEntity());//该方法可获取HttpEntity对象，该对象包装了服务器的响应内容
            List<UserVo> list = JSON.parseArray(rev, UserVo.class);
            return list;

    }

    @RequestMapping("/clientAll")
    @ResponseBody
    public List<UserVo> HttpPostDataAll() throws IOException {

        HttpClient httpclient = new DefaultHttpClient();//创建HttpClient对象
        String URL = "http://localhost:8080/user/userAll";
        HttpPost httppost = new HttpPost(URL);//创建HttpPost对象
        JSONObject obj = new JSONObject();
        httppost.setEntity(new StringEntity(obj.toString()));//设置请求参数
        HttpResponse response = null;//发送请求会返回一个HttpResponse
        response = httpclient.execute(httppost);
        String rev = null;//该方法可获取HttpEntity对象，该对象包装了服务器的响应内容
        rev = EntityUtils.toString(response.getEntity());
        List<UserVo> list = JSON.parseArray(rev, UserVo.class);
        for (UserVo userVo:list) {
            Map<String, Object> params = new HashMap<>();
            params.put("usercode",userVo.getUsercode());
            List<UserVo> userVoList=selectService.selectUser(params);
            if(userVoList == null || userVoList.size() == 0){
               selectService.insert(userVo);
            }
        }
        return list;
    }
}
