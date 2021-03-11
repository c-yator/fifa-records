/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.companytobe.fifa.test;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yator
 */
public class My_Cnx {

    private static final String servername = "localhost";
    private static final String username = "root";
    private static final String dbname = "fifa";
    private static final Integer portnumber = 3306;
    private static final String password = "";

    public static Connection getConnection() {
        Connection cnx = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://" + servername + ":" + portnumber + "/" + dbname, "\"" + username + "\"", "\"" + password + "\"");
            System.out.println("connected successfully to mysql \n");
        } catch (SQLException ex) {
            System.out.print("failed to connect to database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }

    public void create(String query) {
        try {
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            int result = stmt.executeUpdate();
            System.out.println("created in database successfully \n");
        } catch (SQLException ex) {
            System.out.print("failed to create in database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(String table, String[] fields, Object[] values) {
        try {
            String[] preparedValues = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                preparedValues[i] = "?";
            }
            String joinedFields = String.join(",", fields);
            String joinedValues = String.join(",", preparedValues);

            String query = "INSERT INTO " + table + "(" + joinedFields + ") VALUES(" + joinedValues + ")";
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            for (int i = 0; i < fields.length; i++) {
                if (values[i] instanceof Integer) {
                    stmt.setInt(i + 1, (int) values[i]);
                }
                if (values[i] instanceof String) {
                    stmt.setString(i + 1, (String) values[i]);
                }
            }
            int result = stmt.executeUpdate();
            if (result == 0) {
                throw new SQLException("failed to insert in database");
            }
            stmt.close();
            System.out.println("inserted into database successfully \n");

        } catch (SQLException ex) {
            System.out.print("failed to insert in database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet readAndSort(String table, String field, boolean ascending) {
        ResultSet result = null;
        String sort = "asc";
        try {
            if (ascending == false) {
                sort = "desc";
            }
            String query = "SELECT * FROM " + table + " order by " + field + " " + sort;
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            result = stmt.executeQuery();
            System.out.println("read database successfully \n");
        } catch (SQLException ex) {
            System.out.println("failed to read from database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet read(String table) {
        ResultSet result = null;
        try {
            String query = "SELECT * FROM " + table;
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            result = stmt.executeQuery();
            System.out.println("read database successfully \n");
        } catch (SQLException ex) {
            System.out.println("failed to read from database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet read(String table, String field, Object value) {
        ResultSet result = null;
        try {
            String query = "SELECT * FROM " + table + " WHERE " + field + "=?";
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            if (value instanceof Integer) {
                stmt.setInt(1, (int) value);
            }
            if (value instanceof String) {
                stmt.setString(1, (String) value);
            }
            result = stmt.executeQuery();
            System.out.println("read database successfully \n");
        } catch (SQLException ex) {
            System.out.println("failed to read from database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet read(String[] columns, String table, String field, Object value) {
        ResultSet result = null;
        try {
            String joinedColumns = String.join(",", columns);
            String query = "SELECT " + joinedColumns + " FROM " + table + " WHERE " + field + "=?";
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            if (value instanceof Integer) {
                stmt.setInt(1, (int) value);
            }
            if (value instanceof String) {
                stmt.setString(1, (String) value);
            }
            result = stmt.executeQuery();
            System.out.println("read database successfully \n");
        } catch (SQLException ex) {
            System.out.println("failed to read from database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void update(String table, String updateField, Object updateValue, String field, Object value) {
        try {
            String query = "update " + table + " set " + updateField + "=? where " + field + "=?";
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            if (updateValue instanceof Integer) {
                stmt.setInt(1, (int) updateValue);
            }
            if (updateValue instanceof String) {
                stmt.setString(1, (String) updateValue);
            }
            if (value instanceof Integer) {
                stmt.setInt(2, (int) value);
            }
            if (value instanceof String) {
                stmt.setString(2, (String) value);
            }
            int result = stmt.executeUpdate();
            if (result == 0) {
                throw new SQLException("failed to update in database");
            }
            stmt.close();
            System.out.println("updated database successfully \n");

        } catch (SQLException ex) {
            System.out.println("failed updated database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String table, String[] updateFields, Object[] updateValues, String field, Object value) {
        try {
            String joinedFields = String.join("=?, ", updateFields);
            String query = "update " + table + " set " + joinedFields + "=? where " + field + "=?";

            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);

            for (int i = 0; i < updateFields.length; i++) {
                if (updateValues[i] instanceof Integer) {
                    stmt.setInt(i + 1, (int) updateValues[i]);
                }
                if (updateValues[i] instanceof String) {
                    stmt.setString(i + 1, (String) updateValues[i]);
                }
            }

            if (value instanceof Integer) {
                stmt.setInt(updateFields.length + 1, (int) value);
            }
            if (value instanceof String) {
                stmt.setString(updateFields.length + 1, (String) value);
            }
            int result = stmt.executeUpdate();
            if (result == 0) {
                throw new SQLException("failed to update in database");
            }
            System.out.println("updated database successfully \n");

        } catch (SQLException ex) {
            System.out.println("failed updated database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String query) {
        try {
            Connection cnx = My_Cnx.getConnection();
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("deleted from database successfully \n");
        } catch (SQLException ex) {
            System.out.println("failed to delete from database \n");
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isInDB(String table) {
        System.out.println("checking if is in DB \n");

        boolean isFound = false;
        try {
            DatabaseMetaData dbm = (DatabaseMetaData) My_Cnx.getConnection().getMetaData();
            ResultSet rs = dbm.getTables(null, null, table, null);
            if (rs.next()) {
                isFound = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(My_Cnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isFound;
    }
}
