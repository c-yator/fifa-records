/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.companytobe.fifa.test;

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
public class Verify {

    public static boolean isEmpty(String fieldName, String fieldValue) {
        boolean isEmpty = false;

        if (fieldValue.trim().equals("") || fieldValue.trim().toLowerCase().equals(fieldName)) {
            isEmpty = true;
        }
        return isEmpty;
    }

    //create a function to check if the entered username already exists in the database
    public static boolean checkUsernameExists(String username) {
        boolean exists = false;
        try {

            String table = "user";
            String field = "username";
            String value = username;

            ResultSet result = new My_Cnx().read(table, "username", username);
            if (result.next()) {
                exists = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Verify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }

    public static String player(String player) {

        try {
            if (player.isEmpty()) {
                throw new Exception("player cannot be empty");
            }
            String table = "users";
            String field = "username";
            String value = player;

            ResultSet result = new My_Cnx().read(table, field, value);
            if (!result.next()) {
                throw new SQLException(player + " does not exist would you like to create a new player?");
            }

        } catch (SQLException ex) {
            String message = ex.getMessage();
            if (message.equals(player + " does not exist would you like to create a new player?")) {
                String[] options = {"yes", "no"};
                int x = JOptionPane.showOptionDialog(null, player + " does not exist would you like to create a new player?", "new player", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (x == 0) {
                    Register_Form form = new Register_Form();
                    form.setVisible(true);
                    form.pack();
                    form.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "enter a valid username for player");
                }
            }
            Logger.getLogger(Player_vs_player.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Player_vs_player.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;
    }

}
