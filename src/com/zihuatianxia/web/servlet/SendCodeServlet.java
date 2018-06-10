package com.zihuatianxia.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zihuatianxia.utils.RandomNum;
import com.zihuatianxia.utils.SendCode;

public class SendCodeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2442878560559362211L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String phone = request.getParameter("phone");
		
		RandomNum randomNum = new RandomNum();
		RandomNum.num = randomNum.getRandom();
		
		try {
			SendCode.sendSms(phone, RandomNum.num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "验证码发送成功！");
		request.setAttribute("phone", phone);
		request.getSession().setAttribute("code", RandomNum.num);
		request.getRequestDispatcher("/register.jsp?phone=" + phone).forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
