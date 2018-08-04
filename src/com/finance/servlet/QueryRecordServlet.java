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

	public int rowsPerPage; // ÿҳ��ʾ������
	public int curPage; // ��ǰҳҳ��
	public int maxPage; // �ܹ�ҳ��

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
			String curPage1 = request.getParameter("page"); // ��ȡ��ǰҳҳ��
			if (curPage1 == null) {
				curPage = 1;
				request.setAttribute("curPage", curPage); // ����curPage����
			} else {
				curPage = Integer.parseInt(curPage1);
				if (curPage < 1) {
					curPage = 1;
				}
				request.setAttribute("curPage", curPage);
			}

			List<TradeInfo> list = tdao.getData(curPage, rowsPerPage, account); // ��ȡ��ǰҳ������
			maxPage = tdao.getMaxPage(rowsPerPage, account); // ��ȡ��ҳ��
			request.setAttribute("list", list);
			request.setAttribute("maxPage", maxPage);
//          System.out.println(maxPage);
		
			RequestDispatcher rd = request.getRequestDispatcher("queryRecord.jsp"); // ������ת����queryRecord.jspҳ��
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
