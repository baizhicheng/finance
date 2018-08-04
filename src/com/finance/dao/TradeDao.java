package com.finance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.finance.model.TradeInfo;
import com.finance.model.UserInfo;
import com.finance.utils.DBUtils;

public class TradeDao {
	
	public boolean deposit(TradeInfo tr, String uname){
		boolean flag = false ;
		Connection conn = null;
		UserDao dao = new UserDao();
		UserInfo ui =dao.getUserInfoByName(uname);
		try{
			conn=DBUtils.getConnection();
			
			
			double sum = tr.getMoney() + ui.getBalance();
			tr.setTradetype("存款");
			String updatesql =  "update userinfo1 set balance = '" + sum
					+ "' where account = '" + ui.getAccount() + "'";
			PreparedStatement ps1 = conn.prepareStatement(updatesql);
			int i= ps1.executeUpdate();
			
			Date date = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(date);
			
			String insertsql = "insert into traderecord1(account,money,tradetype,tradetime) values(?,?,?,?)";
			PreparedStatement ps2 = conn.prepareStatement(insertsql);
			ps2.setString(1, ui.getAccount());   
			ps2.setDouble(2, tr.getMoney());
			ps2.setString(3, tr.getTradetype());
			ps2.setString(4, dateString);
			int j= ps2.executeUpdate();
	        if(i>0){
	        	if(j>0){
	        		flag=true;
	        	}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return flag;
	}
	
	public int withdraw(TradeInfo tr, String uname){
		int flag = 0 ;
		Connection conn = null;
		UserDao dao = new UserDao();
		UserInfo ui =dao.getUserInfoByName(uname);
		try{
			conn=DBUtils.getConnection();
			
			if(tr.getMoney()>ui.getBalance()){
				flag=2;
			}else{
			double sub = ui.getBalance()-tr.getMoney() ;
			tr.setTradetype("取款");
			String updatesql =  "update userinfo1 set balance = '" + sub
					+ "' where account = '" + ui.getAccount() + "'";
			PreparedStatement ps1 = conn.prepareStatement(updatesql);
			int i= ps1.executeUpdate();
			
			Date date = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(date);
			
			String insertsql = "insert into traderecord1(account,money,tradetype,tradetime) values(?,?,?,?)";
			PreparedStatement ps2 = conn.prepareStatement(insertsql);
			ps2.setString(1, ui.getAccount());   
			ps2.setDouble(2, tr.getMoney());
			ps2.setString(3, tr.getTradetype());
			ps2.setString(4, dateString);
			int j= ps2.executeUpdate();
	        if(i>0){
	        	if(j>0){
	        		flag=1;
	        	}
	        }
		 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return flag;
	}
	
	public int transfer(TradeInfo tr, String uname,String account){
		int flag = 0 ;
		Connection conn = null;
		UserDao dao = new UserDao();
		UserInfo ui1 =dao.getUserInfoByName(uname);
		UserInfo ui2 =dao.findByAccount(account);
		try{
			conn=DBUtils.getConnection();
			if(ui2==null){
				flag=3;
			}else{
				if(tr.getMoney()>ui1.getBalance()){
					flag=2;
				}else{
					double sub = ui1.getBalance()-tr.getMoney() ;
					String updatesql1 =  "update userinfo1 set balance = '" + sub
							+ "' where account = '" + ui1.getAccount() + "'";
					PreparedStatement ps1 = conn.prepareStatement(updatesql1);
					int i= ps1.executeUpdate();
					
					double sum = ui2.getBalance()+tr.getMoney() ;
					String updatesql2 =  "update userinfo1 set balance = '" + sum
							+ "' where account = '" + ui2.getAccount() + "'";
					PreparedStatement ps2 = conn.prepareStatement(updatesql2);
					int j= ps2.executeUpdate();
					
					Date date = Calendar.getInstance().getTime();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateString = formatter.format(date);
					tr.setTradetype("转入");
					
					String insertsql1 = "insert into traderecord1(account,money,tradetype,tradetime) values(?,?,?,?)";
					PreparedStatement ps3 = conn.prepareStatement(insertsql1);
					ps3.setString(1, ui2.getAccount());   
					ps3.setDouble(2, tr.getMoney());
					ps3.setString(3, tr.getTradetype());
					ps3.setString(4, dateString);
					int k= ps3.executeUpdate();
					
		
					tr.setTradetype("转出");
					String insertsql2 = "insert into traderecord1(account,money,tradetype,tradetime) values(?,?,?,?)";
					PreparedStatement ps4 = conn.prepareStatement(insertsql2);
					ps4.setString(1, ui1.getAccount());   
					ps4.setDouble(2, tr.getMoney());
					ps4.setString(3, tr.getTradetype());
					ps4.setString(4, dateString);
					int h = ps4.executeUpdate();
			        if(i>0&&j>0&&k>0&&h>0){
			        	flag=1;
			        }
			  }
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return flag;
	}
	/*public List<TradeInfo> findAllTradeInfo(){
		List<TradeInfo> list = new ArrayList<TradeInfo>(); 
		TradeInfo tr = null;
		Connection conn = null;
		try{
			conn=DBUtils.getConnection();
			Statement st = conn.createStatement();
			
			String sql = "select id, account, money, tradetype, tradetime from traderecord1";
            ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				tr = new TradeInfo();
				tr.setId(rs.getInt(1));
				tr.setAccount(rs.getString(2));
				tr.setMoney(rs.getDouble(3));
				tr.setTradetype(rs.getString(4));
				tr.setTradetime(rs.getString(5));
				list.add(tr);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return list;
		
	}*/
	 /**
     * 获取当前页的数据
     * @param curPage
     * @param rowsPerPage
     * @return
     */
	public List<TradeInfo> getData(int curPage, int rowsPerPage,String account) {
		List<TradeInfo> list = new ArrayList<TradeInfo>();
		Connection conn = null;
		int pagenum = (curPage-1)*rowsPerPage;
		try{
			conn=DBUtils.getConnection();
			String sql = "select * from traderecord1 where account = ? and account limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,account);
	        ps.setInt(2,pagenum);
	        ps.setInt(3,rowsPerPage);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()){
	        	TradeInfo tr = new TradeInfo();
				tr.setId(rs.getInt(1));
				tr.setAccount(rs.getString(2));
				tr.setMoney(rs.getDouble(3));
				tr.setTradetype(rs.getString(4));
				tr.setTradetime(rs.getString(5));
				list.add(tr);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return list;
	}
	
	/**
     * 返回总页数
     * @return
     */
	
	public int getMaxPage(int rowsPerPage,String account) {
		int maxPage;
        int maxRowCount = 0;
        Connection conn = null;
		try{
			conn=DBUtils.getConnection();
			Statement st = conn.createStatement();
			String sql = "select count(*) from traderecord1 where account = '" + account +"'";			
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()){
				maxRowCount = rs.getInt(1); //总行数
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		maxPage = (maxRowCount + rowsPerPage - 1) / rowsPerPage;  //总页数
		return maxPage;
	}
}
