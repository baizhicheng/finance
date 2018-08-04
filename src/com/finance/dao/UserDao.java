package com.finance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.finance.model.UserInfo;
import com.finance.utils.DBUtils;

public class UserDao {
	public UserInfo findByUname(String uname) {
		UserInfo ui = null;
		Connection conn = null;
		
		try {
			conn=DBUtils.getConnection();
			Statement st = conn.createStatement();
		
		String sql = "select id,uname,psd from userinfo1 where uname = '" + uname +"'";
/*		System.out.println(sql);*/
		
		ResultSet rs = st.executeQuery(sql);	
		while (rs.next()) {
			ui = new UserInfo();
			ui.setId(rs.getInt("id"));
			ui.setUname(rs.getString(2));
			ui.setPsd(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return ui;
	}
	
	public UserInfo findByAccount(String account) {
		UserInfo ui = null;
		Connection conn = null;
		
		try {
			conn=DBUtils.getConnection();
			Statement st = conn.createStatement();
		
		String sql = "select account,balance from userinfo1 where account = '" + account +"'";
/*		System.out.println(sql);*/
		
		ResultSet rs = st.executeQuery(sql);	
		while (rs.next()) {
			ui = new UserInfo();
			ui.setAccount(rs.getString("account"));
			ui.setBalance(rs.getDouble("balance"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return ui;
	}
	
	public UserInfo getUserInfoByName(String uname){
		UserInfo ui = null;
		Connection conn = null;
		
		try {
			conn=DBUtils.getConnection();
			Statement st = conn.createStatement();
		
		String sql = "select id,account,uname,birth,sex,address,phone,idcard,balance from userinfo1 where uname = '" + uname +"'";
/*		System.out.println(sql);*/
		
		ResultSet rs = st.executeQuery(sql);	
		while (rs.next()) {
			ui = new UserInfo();
			ui.setId(rs.getInt("id"));
			ui.setAccount(rs.getString(2));
			ui.setUname(rs.getString(3));
			ui.setBirth(rs.getDate(4));
			ui.setSex(rs.getString(5));
			ui.setAddress(rs.getString(6));
			ui.setPhone(rs.getString(7));
			ui.setIdcard(rs.getString(8));
			ui.setBalance(rs.getDouble(9));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return ui;
	}
	
/*	public UserInfo getUserInfoByAccount(String account){
		UserInfo ui = null;
		Connection conn = null;
		
		try {
			conn=DBUtils.getConnection();
			Statement st = conn.createStatement();
		
		String sql = "select id,account,uname,balance from userinfo1 where account = '" + account +"'";
		System.out.println(sql);
		
		ResultSet rs = st.executeQuery(sql);	
		while (rs.next()) {
			ui = new UserInfo();
			ui.setId(rs.getInt("id"));
			ui.setAccount(rs.getString(2));
			ui.setUname(rs.getString(3));
			ui.setBalance(rs.getDouble(4));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return ui;
	}*/
	
	public boolean updateUserInfo(UserInfo ui){
		boolean flag = false ;
		Connection conn = null;
		try {
			
		   conn=DBUtils.getConnection();
		   
		   String sql = "update userinfo1 set address=?,phone=? where id = ? ";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   System.out.println(sql);
		   
		   ps.setString(1, ui.getAddress());   
		   ps.setString(2, ui.getPhone());
		   ps.setInt(3, ui.getId());
		   System.out.println(ui.getAddress());
		   System.out.println(ui.getPhone());
		   System.out.println(ui.getId());
		   
		   int i = ps.executeUpdate();
		   System.out.println(i);
		   if(i>0){
		   flag = true;
		   }
		   System.out.println("更新结果:"+flag); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return flag;
	}
	
	public boolean updatePsd(UserInfo ui){
		boolean flag = false ;
		Connection conn = null;
		try {
			
		   conn=DBUtils.getConnection();
		   
		   String sql = "update userinfo1 set psd=? where uname = ? ";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   System.out.println(sql);
		   
		   ps.setString(1, ui.getPsd());   
		   ps.setString(2,ui.getUname());
		   System.out.println(ui.getPsd());
		   System.out.println(ui.getUname());
		   
		   int i = ps.executeUpdate();
		   System.out.println(i);
		   if(i>0){
		   flag = true;
		   }
		   System.out.println("更新结果:"+flag); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return flag;
	}
	
	public boolean deposite(UserInfo ui){
		boolean flag = false ;
		Connection conn = null;
		try {
			
		   conn=DBUtils.getConnection();
		   
		   String sql = "update userinfo1 set balance=? where id = ? ";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   System.out.println(sql);
		   
		   ps.setString(1, ui.getPsd());   
		   ps.setString(2,ui.getUname());
		   System.out.println(ui.getPsd());
		   System.out.println(ui.getUname());
		   
		   int i = ps.executeUpdate();
		   System.out.println(i);
		   if(i>0){
		   flag = true;
		   }
		   System.out.println("更新结果:"+flag); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResources(conn, null, null);
			
		}
		return flag;
	}
	


}
