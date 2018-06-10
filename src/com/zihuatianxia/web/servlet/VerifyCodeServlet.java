package com.zihuatianxia.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zihuatianxia.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");

		VerifyCode vc = new VerifyCode();// 创建验证码类
		BufferedImage image = vc.getImage();// 创建验证码图片
		HttpSession session = request.getSession();
		session.setAttribute(name, vc.getText());// 获取验证码文本
		// System.out.println(vc.getText());
		OutputStream output = response.getOutputStream();
		VerifyCode.output(image, output);// 输出图片到页面
		
//		String usercode=request.getParameter("user_code");  //获取用户输入的验证码
//		String sessioncode=(String) session.getAttribute(name);  //获取保存在session里面的验证码
//        String result="";
//        if( usercode != null && usercode.equalsIgnoreCase(sessioncode)){   //对比两个code是否正确
//            result = "1";
//        }else{
//            result = "0";
//        }
//
//        output.write(result.getBytes());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}