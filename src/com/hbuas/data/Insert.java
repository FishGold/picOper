package com.hbuas.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by bgm on 2015/12/15.
 */
public class Insert {
    private static PreparedStatement ps;
    public Insert(){}
    public boolean Insert(String sql, Connection connection){
        try{
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
