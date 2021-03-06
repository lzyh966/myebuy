package com.mage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.mage.po.User;
import com.mage.util.DBUtil;

public class UserDao {

	public static User queryUserByName(String uname) {
		//连接数据库
		Connection conn=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		User user=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t_user where userName = ?";
			sta=conn.prepareStatement(sql);
			//设置参数
			sta.setString(1, uname);
			//执行编译，获取结果集
			res=sta.executeQuery();
			while(res.next()) {
				user=new User();
				user.setId(res.getInt("id"));
				user.setUserName(res.getString("userName"));
				user.setPassword(res.getString("password"));
				user.setTrueName(res.getString("trueName"));
				user.setSex(res.getString("sex"));
				user.setDentityCode(res.getString("dentityCode"));
				user.setEmail(res.getString("email"));
				user.setMobile(res.getString("mobile"));
				user.setAddress(res.getString("address"));
				user.setBirthday(res.getDate("birthday"));
				user.setStatus(res.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(res, sta, conn);
		}
		return user;

	}

	public int register(User adduser) {
		//连接数据库
		Connection conn=null;
		PreparedStatement sta=null;
		int row=0;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into t_user (address,birthday,dentityCode,email,mobile,password,sex,userName,status,trueName)"
					+ " values (?,?,?,?,?,?,?,?,?,?)";
			sta=conn.prepareStatement(sql);
			//设置参数
			sta.setString(1, adduser.getAddress());
			sta.setObject(2, adduser.getBirthday());
			sta.setString(3, adduser.getDentityCode());
			sta.setString(4, adduser.getEmail());
			sta.setString(5, adduser.getMobile());
			sta.setString(6, adduser.getPassword());
			sta.setString(7, adduser.getSex());
			sta.setString(8, adduser.getUserName());
			sta.setInt(9, adduser.getStatus());
			sta.setString(10, adduser.getTrueName());
			row=sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, sta, conn);
		}
		return row;
	}

	public int updateuser(User upuser) {
		
		// 连接数据库
		Connection conn = null;
		PreparedStatement sta = null;
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "update t_user set address = ?,birthday = ?,dentityCode = ?,"
					+ " email = ?,mobile = ?,password = ?,sex = ?,userName = ?,status = ?,trueName = ? where id = ?";
			sta = conn.prepareStatement(sql);
			// 设置参数
			sta.setString(1, upuser.getAddress());
			sta.setObject(2, upuser.getBirthday());
			sta.setString(3, upuser.getDentityCode());
			sta.setString(4, upuser.getEmail());
			sta.setString(5, upuser.getMobile());
			sta.setString(6, upuser.getPassword());
			sta.setString(7, upuser.getSex());
			sta.setString(8, upuser.getUserName());
			sta.setInt(9, upuser.getStatus());
			sta.setString(10, upuser.getTrueName());
			sta.setInt(11, upuser.getId());
			row = sta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, sta, conn);
		}
		return row;
	}

	

}
