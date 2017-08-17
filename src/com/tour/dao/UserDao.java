package com.tour.dao;

import com.tour.bean.User;
import com.tour.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 17-3-23.
 */
public class UserDao {
    //查询用户名重复
    public boolean selectUserName(String userName){
        String sql = "select * from user where userName = '"+userName+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        boolean b = false;
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    b = true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return b;
    }

    //用户登录
    public User loginUser(String userName, String userPassword){
        String sql = "select * from user where userName = '"+userName+"' and userPassword = '"+userPassword+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        User user =new User();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    user.setUserId(rs.getInt("userId"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserType(rs.getInt("userType"));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return user;
    }

    //用户注册
    public int registUser(String userName, String userPassword){
        String sql = "insert into user set userName = '"+userName+"',userPassword = '"+userPassword+"'";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //删除用户
    public int deleteUser(int userId){
        String sql = "delete from user where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查看所有用户
    public List<User> selectAllUser(){
        String sql = "select * from user";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<User> list = new ArrayList<>();
        con = DbHelper.getconnection();
        try {
            st = con.createStatement();
            rs=st.executeQuery(sql);
            if (rs!=null){
                while(rs.next()){
                    User user = new User();
                    user.setUserId(rs.getInt("userId"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserType(rs.getInt("userType"));
                    list.add(user);
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //修改用户权限
    public int updateType(int userType,int userId){
        String sql = "update user set userType = "+userType+" where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //修改密码
    public int updateUserPassword(int userId,String userPassword){
        String sql = "update user set userPassword = '"+userPassword+"' where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
