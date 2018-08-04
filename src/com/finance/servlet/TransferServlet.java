package com.finance.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finance.dao.TradeDao;
import com.finance.dao.UserDao;
import com.finance.model.TradeInfo;
import com.finance.model.UserInfo;

/**
 * Servlet implementation class TransferServlet
 */
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		String account = request.getParameter("account");
		double money = Double.parseDouble(request.getParameter("money"));
		
		TradeInfo tr =new TradeInfo();
		tr.setAccount(account);
		tr.setMoney(money);
		
		TradeDao tdao = new TradeDao();
		
		
		
		
	    int result = tdao.transfer(tr,uname,account);
//		System.out.println(">>>>>>>>>>>result:"+result);
	    if(result==0){
		request.setAttribute("msg", "转账失败！");
		}else if(result==1){
			request.setAttribute("msg", "转账成功！");
			}else if(result==2){
				request.setAttribute("msg", "余额不足！");
				}else{
					request.setAttribute("msg", "对方账户不存在！");
				}
	    request.getRequestDispatcher("transfer.jsp").forward(request, response);	
        
	}

}
