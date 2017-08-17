package com.tour.dao;

import com.tour.bean.Messeng;
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
public class MessengDao {
    //插入信息
    public int insertMesseng(int messengType,String messengName,String messengTitle,String messengPage,String messengAddress,int messengRoom){
        String sql = "insert into messeng " +
                "(messengType,messengName,messengTitle,messengPage,messengAddress,messengRoom)" +
                " values("+messengType+",'"+messengName+"','"+messengTitle+"','"+messengPage+"','"+messengAddress+"',"+messengRoom+")";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //删除信息
    public int deleteMesseng(int messengId){
        String sql = "delete from messeng where messengId = "+messengId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查询信息
    public List<Messeng> selectMesseng(int messengType){
        String sql = "select * from messeng where messengType = "+messengType;
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Messeng> list = new ArrayList<>();
        con = DbHelper.getconnection();
        try {
            st = con.createStatement();
            rs=st.executeQuery(sql);
            if (rs!=null){
                while(rs.next()){
                    Messeng messeng = new Messeng();
                    messeng.setMessengId(rs.getInt("messengId"));
                    messeng.setMessengType(messengType);
                    messeng.setMessengName(rs.getString("messengName"));
                    messeng.setMessengTitle(rs.getString("messengTitle"));
                    messeng.setMessengPage(rs.getString("messengPage"));
                    messeng.setMessengAddress(rs.getString("messengAddress"));
                    messeng.setMessengRoom(rs.getInt("messengRoom"));
                    list.add(messeng);
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //修改信息
    public int updateMesseng(int messengId,String messengName,String messengTitle,String messengPage,String messengAddress,int messengRoom){
        String sql = "update messeng set " +
                "messengName = '"+messengName+"',messengTitle = '"+messengTitle+"',messengPage = '"+messengPage+"',messengAddress = '"+messengAddress+"',messengRoom = "+messengRoom +
                " where messengId = "+messengId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //根据搜索内容查询
    public List<Messeng> selectMessengByName(String messengName){
        String sql = "select * from messeng where messengName like '%"+messengName+"%' or messengTitle LIKE '%"+messengName+"%'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Messeng> list = new ArrayList<>();
        con = DbHelper.getconnection();
        try {
            st = con.createStatement();
            rs=st.executeQuery(sql);
            if (rs!=null){
                while(rs.next()){
                    Messeng messeng = new Messeng();
                    messeng.setMessengId(rs.getInt("messengId"));
                    messeng.setMessengName(rs.getString("messengName"));
                    messeng.setMessengTitle(rs.getString("messengTitle"));
                    messeng.setMessengPage(rs.getString("messengPage"));
                    messeng.setMessengAddress(rs.getString("messengAddress"));
                    list.add(messeng);
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //酒店预定
    public int updateHotel(int messengId){
        String sql = "update messeng set messengRoom = messengRoom-1 where messengId = "+messengId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //取消预定
    public int cancelHotel(int messengId){
        String sql = "update messeng set messengRoom = messengRoom+1 where messengId = "+messengId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
