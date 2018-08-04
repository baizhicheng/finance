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
 * Servlet implementation class UpdateInfoServlet
 */
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
//		System.out.println(">>>>>>>>>>>1:"+uname);
		UserDao dao = new UserDao();
        UserInfo ui = dao.getUserInfoByName(uname);
        request.setAttribute("ui", ui);
        request.getRequestDispatcher("updateInfo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String idStr = request.getParameter("id");
		
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
//		System.out.println(">>>>>>>>>>>address:"+address);
//		System.out.println(">>>>>>>>>>>phone:"+phone);
//		System.out.println(">>>>>>>>>>>id:"+idStr);
		
		UserDao dao = new UserDao();
		       
		UserInfo ui = new UserInfo();
		ui.setAddress(address);
		ui.setPhone(phone);
		ui.setId(Integer.valueOf(idStr));
		
		boolean result = false ;
		result = dao.updateUserInfo(ui);
//		System.out.println(">>>>>>>>>>>result:"+result);
		if(result){
			request.setAttribute("msg", "修改成功！");
		}else{
			request.setAttribute("msg", "修改失败！");
		}
		request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
		
	}

}
