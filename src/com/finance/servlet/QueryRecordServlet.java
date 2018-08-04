package com.finance.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class QueryRecordServlet
 */
public class QueryRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public int rowsPerPage; // 每页显示的行数
	public int curPage; // 当前页页码
	public int maxPage; // 总共页数

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryRecordServlet() {
		super();
		rowsPerPage = 5;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		/*
		 * TradeDao tdao = new TradeDao(); List<TradeInfo> list =
		 * tdao.findAllTradeInfo(); request.setAttribute("tradeinfo", list);
		 * request.getRequestDispatcher("/queryRecord.jsp").forward(request,
		 * response);
		 */
		TradeDao tdao = new TradeDao();
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
//        System.out.println(">>>>>>account:"+account);
		if(uname==null){
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}else{
			UserDao dao = new UserDao();
			UserInfo ui = dao.getUserInfoByName(uname);
			String account = ui.getAccount();
			String curPage1 = request.getParameter("page"); // 获取当前页页码
			if (curPage1 == null) {
				curPage = 1;
				request.setAttribute("curPage", curPage); // 设置curPage对象
			} else {
				curPage = Integer.parseInt(curPage1);
				if (curPage < 1) {
					curPage = 1;
				}
				request.setAttribute("curPage", curPage);
			}

			List<TradeInfo> list = tdao.getData(curPage, rowsPerPage, account); // 获取当前页的数据
			maxPage = tdao.getMaxPage(rowsPerPage, account); // 获取总页数
			request.setAttribute("list", list);
			request.setAttribute("maxPage", maxPage);
//          System.out.println(maxPage);
		
			RequestDispatcher rd = request.getRequestDispatcher("queryRecord.jsp"); // 将请求转发到queryRecord.jsp页面
			rd.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
