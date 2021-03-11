/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.companytobe.fifa.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yator
 */
public class League {

    private String league;

    public League(String league) {
        this.league = league;
    }

    public void createLeagueTables(int numberOfTeams) {
        System.out.println("creating league table \n");
        try {
            //create league table
            String query = String.format("create table fifa.%s(pos int not null,team varchar(100) not null,GP int not null,W int not null,D int not null,L int not null,GF int not null,GA int not null,GD int not null,POINTS int not null)engine = innodb ", league);
            new My_Cnx().create(query);

            //insert into league table
            if (numberOfTeams < 3) {
                throw new Exception("minimum number of teams is 3");
            }
            String[] teams = new String[numberOfTeams];

            for (int i = 1; i <= numberOfTeams; i++) {
                String messo = String.format("enter team %s", i);
                if (messo.equals("") && league == null) {
                    throw new Exception("cannot leave team blank");
                }
                String teams_input = JOptionPane.showInputDialog(messo);
                if (teams_input.isEmpty()) {
                    throw new Exception("team name cannot be left blank");
                }
                teams[i - 1] = teams_input;

                String pos = String.format("%s", i);

                String table = league;
                String[] fields = {"pos", "team", "gp", "W", "D", "L", "GF", "GA", "GD", "POINTS"};
                Object[] values = {pos, teams[i - 1], 0, 0, 0, 0, 0, 0, 0, 0};

                System.out.println("inserting into league table");
                new My_Cnx().insert(table, fields, values);

            }
            //create match tables
            Match b = new Match(league);
            b.createMatchesTable(teams);
            b.createPlayedMatchesTable();
        } catch (Exception e) {
            Logger.getLogger(League.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    public DefaultTableModel displayLeagueTable(DefaultTableModel tbmodel) {
        System.out.println("displaying league table \n");
        try {
            ResultSet result = new My_Cnx().readAndSort(league, "points", false);
            int rowCount = tbmodel.getRowCount();
            if (rowCount != 0) {
                for (int i = rowCount - 1; i >= 0; i--) {
                    tbmodel.removeRow(i);
                }
            }
            while (result.next()) {
                //data added until finish
                String pos = result.getString("pos");
                String team = result.getString("team");
                String GP = result.getString("GP");
                String W = result.getString("W");
                String D = result.getString("D");
                String L = result.getString("L");
                String GF = result.getString("GF");
                String GA = result.getString("GA");
                String GD = result.getString("GD");
                String POINTS = result.getString("POINTS");
                //String array to store data in jtable
                String tbData[] = {pos, team, GP, W, D, L, GF, GA, GD, POINTS};
                tbmodel.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(League.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
        }
        return tbmodel;
    }

    public DefaultTableModel displayLeagueMatches(DefaultTableModel tbmodel) {
        System.out.println("displaying league matches \n");
        try {
            ResultSet result = new My_Cnx().read(league + "_matches");
            int rowCount = tbmodel.getRowCount();
            if (rowCount != 0) {
                for (int i = rowCount - 1; i >= 0; i--) {
                    tbmodel.removeRow(i);
                }
            }
            while (result.next()) {
                String match_id = String.valueOf(result.getInt("match_id"));
                String team1 = result.getString("team1");
                String team2 = result.getString("team2");
                //String array to store data in jtable
                String tbData[] = {team1, "vs", team2};
                tbmodel.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(League.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
        }
        return tbmodel;
    }

    public League_Results getTeamLeagueResult(String team) {
        System.out.println("getting team league result \n");
        League_Results r = new League_Results();
        try {

            String table = league;
            String field = "team";
            Object value = team;

            ResultSet result = new My_Cnx().read(table, field, value);
            while (result.next()) {
                r.setPos(result.getInt("pos"));
//                r.setMP(result.getInt("MP"));
                r.setW(result.getInt("W"));
                r.setD(result.getInt("D"));
                r.setL(result.getInt("L"));
                r.setGF(result.getInt("GF"));
                r.setGA(result.getInt("GA"));
                r.setGD(result.getInt("GD"));
                r.setPoints(result.getInt("POINTS"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(League.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void recordTeamLeagueResults(String team, League_Results r) {
        System.out.println("recording team league result \n");
        String table = league;
//        String[] updateFields = {"MP", "W", "D", "L", "GF", "GA", "GD", "POINTS"};
//        Object[] updateValues = {r.getMP(),r.getW(),r.getD(),r.getL(),r.getGF(),r.getGA(),r.getGD(),r.getPoints()};

        String[] updateFields = {"W", "D", "L", "GF", "GA", "GD", "POINTS"};
        Object[] updateValues = {r.getW(), r.getD(), r.getL(), r.getGF(), r.getGA(), r.getGD(), r.getPoints()};
        String field = "team";
        String value = team;

        new My_Cnx().update(table, updateFields, updateValues, field, team);
    }

}
