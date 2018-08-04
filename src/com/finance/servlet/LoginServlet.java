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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String psd = request.getParameter("psd");
		
		HttpSession session = request.getSession();
		String svc = (String) session.getAttribute("sessionVerifyCode");
		String veriCode=request.getParameter("vericode");//ȡֵ
		System.out.println(svc);
//		System.out.println(veriCode);
		
		UserDao dao = new UserDao();
		UserInfo ui = dao.findByUname(uname);
        
		if (ui == null) { //  �û���������
			request.setAttribute("msg", "�û���������");
		} else { // �û�������
			
			if (psd.equals(ui.getPsd())) {
				if(!veriCode.equalsIgnoreCase(svc)){
					request.setAttribute("msg", "��֤�����");
					request.getRequestDispatcher("index.jsp").forward(request, response);
					return;
			        }else{
			        	request.getSession().setAttribute("uname", uname);
			        	response.sendRedirect("homepage.jsp");
			        	return;
			        }
			} else {
				request.setAttribute("msg", "�û����������벻��ȷ");
			}
		 }
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
