package com.example.demo.controller;


import com.example.demo.entity.User;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class ClientController {
    @RequestMapping("/client")
    @ResponseBody
    public User HttpPostData(String usercode) throws IOException {

            HttpClient httpclient = new DefaultHttpClient();//创建HttpClient对象
            String URL = "http://localhost:8080/user/selectUser";
            HttpPost httppost = new HttpPost(URL);//创建HttpPost对象
            JSONObject obj = new JSONObject();
            obj.put("name", usercode);
            httppost.setEntity(new StringEntity(obj.toString()));//设置请求参数
            HttpResponse response = httpclient.execute(httppost);//发送请求会返回一个HttpResponse
            String rev = EntityUtils.toString(response.getEntity());//该方法可获取HttpEntity对象，该对象包装了服务器的响应内容
            obj= JSONObject.fromObject(rev);
            User user = (User)JSONObject.toBean(obj,User.class);
            System.out.println("客户端=="+user.toString());
            return user;
    }
}
