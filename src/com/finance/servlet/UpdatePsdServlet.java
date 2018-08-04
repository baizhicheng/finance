package com.finance.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finance.dao.UserDao;
import com.finance.model.UserInfo;

/**
 * Servlet implementation class UpdatePsdServlet
 */
public class UpdatePsdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePsdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String oldpsd = request.getParameter("oldpsd");// 旧密码
		String newpsd = request.getParameter("newpsd");// 新密码
		
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");

		// System.out.println(">>>>>>>>>>>psd:"+newpsd);
		// System.out.println(">>>>>>>>>>>uname:"+uname);

		UserDao dao = new UserDao();
		
		UserInfo ui = dao.findByUname(uname);
		request.setAttribute("ui", ui);
		
		UserInfo ui2 = new UserInfo();
		ui2.setPsd(newpsd);
		ui2.setUname(uname);
	
		if (oldpsd.equals(ui.getPsd())) {
			boolean result = false;
			result = dao.updatePsd(ui2);
			if (result) {
				request.setAttribute("msg", "修改成功！");
			} else {
				request.setAttribute("msg", "修改失败！");
			}
		} else {
			request.setAttribute("msg", "当前密码不正确");
		}
		request.getRequestDispatcher("updatePsd.jsp").forward(request, response);

	}

}
