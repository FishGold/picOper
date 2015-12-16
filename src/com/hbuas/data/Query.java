package com.hbuas.data;

import com.hbuas.picUpLoad.WeiXinPic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bgm on 2015/12/15.
 */
public class Query {
    private static PreparedStatement ps;
    private static ResultSet rs;
    public Query(){}
    public List<WeiXinPic> Query(String sql , Connection connection){
        List<WeiXinPic> list = new ArrayList<WeiXinPic>();
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                WeiXinPic weiXinPic = new WeiXinPic();
                weiXinPic.setID(rs.getInt(1));
                weiXinPic.setPicName(rs.getString(2));
                weiXinPic.setPicDescription(rs.getString(3));
                weiXinPic.setPicUrl(rs.getString(4));
                weiXinPic.setDate(rs.getDate(5));
                list.add(weiXinPic);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
