package com.tour.dao;

import com.tour.bean.Friend;
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
public class FriendDao {
    //发布朋友圈
    public int insertFriend(int userId,String friendTitle,String friendPage){
        String sql = "insert into friend (userId,friendTitle,friendPage) values("+userId+",'"+friendTitle+"','"+friendPage+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查看所有朋友圈
    public List<Friend> selectFriend(){
        String sql = "select * from friend f,user u WHERE f.userId = u.userId ORDER BY friendId DESC ";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        List<Friend> list = new ArrayList<>();
        con = DbHelper.getconnection();
        try {
            st = con.createStatement();
            rs=st.executeQuery(sql);
            if (rs!=null){
                while(rs.next()){
                    Friend friend = new Friend();
                    friend.setFriendId(rs.getInt("friendId"));
                    friend.setUserName(rs.getString("userName"));
                    friend.setFriendTitle(rs.getString("friendTitle"));
                    friend.setFriendPage(rs.getString("friendPage"));
                    list.add(friend);
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //删除朋友圈
    public int deleteFriend(int friendId){
        String sql = "delete from friend where friendId = "+friendId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }
}
