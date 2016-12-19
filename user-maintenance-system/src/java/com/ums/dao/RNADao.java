/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ums.dao;

import com.ums.beans.RNABean;
import com.ums.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RNADao {
     private Connection connection;
    
    public RNADao() {
        connection = DBConnection.createConnection();
    }
    
     public void addRNA(RNABean rna) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into RNA(typeName,description,image) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, rna.getTypeName());
              preparedStatement.setString(2, rna.getDescription());
                preparedStatement.setString(3, rna.getRnaImage());
            preparedStatement.executeUpdate();
             preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRNA(int rnaId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from RNA where rnaId=?");
            // Parameters start with 1
            preparedStatement.setInt(1, rnaId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRNA(RNABean rna) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update RNA set typeName=?, Description=?, image=? " +
                            "where rnaId=?");
            preparedStatement.setString(1, rna.getTypeName());
            preparedStatement.setString(2, rna.getDescription());
            preparedStatement.setString(3, rna.getRnaImage());
             preparedStatement.setInt(4, rna.getRnaId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RNABean> getAllRNas() {
        List<RNABean> rnaList = new ArrayList<RNABean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from RNA");
            while (rs.next()) {
                RNABean rna = new RNABean();
                rna.setRnaId(rs.getInt("rnaId"));
                rna.setTypeName(rs.getString("typeName"));
                rna.setRnaImage(rs.getString("image"));
                rna.setDescription(rs.getString("description"));
                rnaList.add(rna);
            }
             rs.close();
             statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rnaList;
    }

    public RNABean getRNAById(int rnaId) {
        RNABean rna = new RNABean();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from RNA where rnaId=?");
            preparedStatement.setInt(1, rnaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                rna.setRnaId(rs.getInt("rnaId"));
                rna.setTypeName(rs.getString("typeName"));
                rna.setRnaImage(rs.getString("image"));
                rna.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rna;
    }
}
