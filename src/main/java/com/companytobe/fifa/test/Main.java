/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.companytobe.fifa.test;

/**
 *
 * @author Yator
 */
public class Main {

    public static void main(String[] args) {
        String table = "luigi";
        String team = "a";
        League_Results r = new League_Results();
        String field = "team";
        String[] updateFields = {"W", "D", "L", "GF", "GA", "GD", "POINTS"};
        Object[] updateValues = {r.getW(), r.getD(), r.getL(), r.getGF(), r.getGA(), r.getGD(), r.getPoints()};
        String joinedFields = String.join("=?, ", updateFields);
        String query = "update " + table + " set " + joinedFields + "=? where " + field + "=?";
        System.out.println(query);
    }
}
