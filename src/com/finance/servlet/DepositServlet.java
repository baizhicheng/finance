package com.finance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finance.dao.TradeDao;
import com.finance.model.TradeInfo;


/**
 * Servlet implementation class DepositServlet
 */
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		System.out.println(">>>>>>>>>>>111:"+uname);
		UserDao dao = new UserDao();
        UserInfo ui = dao.findAccount(uname);
        request.setAttribute("ui", ui);
        request.getRequestDispatcher("deposit.jsp").forward(request, response);*/
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
/*		String account = request.getParameter("account");*/
		double money = Double.parseDouble(request.getParameter("money"));
		
		TradeInfo tr =new TradeInfo();
/*		tr.setAccount(account);*/
		tr.setMoney(money);
		
		TradeDao tdao = new TradeDao();
		boolean result = false ;
		result = tdao.deposit(tr,uname);
//		System.out.println(">>>>>>>>>>>result:"+result);
		if(result){
			request.setAttribute("msg", "存款成功！");
		}else{
			request.setAttribute("msg", "存款失败！");
		}
		request.getRequestDispatcher("deposit.jsp").forward(request, response);
		
        
	}

}
