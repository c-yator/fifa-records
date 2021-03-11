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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yator
 */
public class Match {

    private String league;

    public Match(String league) {
        this.league = league;

    }

    public void createMatchesTable(String[] teams) {
        System.out.println("creating matches table \n");

        int status = 0;
        //create matches table
        String query = String.format("create table fifa.%s_matches(match_id int not null auto_increment,status int not null,team1 varchar(100) not null,team2 varchar(100) not null, primary key(match_id))engine = innodb", league);
        new My_Cnx().create(query);

        //insert teams into matches table
        int c = teams.length;

        for (int p = 0; p <= teams.length - 1; p++) {
            for (int w = 0; w <= teams.length - 1; w++) {
                if (p != w) {
                    String table = league + "_matches";
                    String[] fields = {"status", "team1", "team2"};
                    Object[] values = {status, teams[p], teams[w]};
                    new My_Cnx().insert(table, fields, values);
                }
            }
        }

    }

    public void createPlayedMatchesTable() {
        System.out.println("creating played matches table \n");

        //create played matches table
        String query = String.format("create table fifa.%s_matchesplayed(match_id int not null auto_increment,team1 varchar(100) not null,team2 varchar(100) not null,score1 int not null,score2 int not null, primary key(match_id))engine = innodb", league);
        new My_Cnx().create(query);
    }

    public void updateMatchStatus(int match_id) {
        System.out.println("updating match status \n");

        int status = 1;

        String table = league + "_matches";
        String updateField = "status";
        int updateValue = status;
        String field = "status";
        int value = match_id;

        new My_Cnx().update(table, updateField, updateValue, field, value);
    }

    public void recordMatchResults(String team1, String team2, int score1, int score2) {
        System.out.println("recording match results \n");

        String table = league + "_matchesplayed";
        String[] fields = {"team1", "team2", "score1", "score2"};
        Object[] values = {team1, team2, score1, score2};
        new My_Cnx().insert(table, fields, values);
    }

    public DefaultTableModel updateTableModel(String table, DefaultTableModel tbmodel) {
        System.out.println("updating table model \n");

        try {
            ResultSet result = new My_Cnx().read(league + table);
            int rowCount = tbmodel.getRowCount();
            if (rowCount != 0) {
                for (int i = rowCount - 1; i >= 0; i--) {
                    tbmodel.removeRow(i);
                }
            }
            while (result.next()) {
                String team_1 = result.getString("team1");
                String team_2 = result.getString("team2");
                String score_1 = String.valueOf(result.getInt("score1"));
                String score_2 = String.valueOf(result.getInt("score2"));
                String tbData[] = {team_1, "vs", team_2, score_1, score_2};
                tbmodel.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, e);
        }
        return tbmodel;
    }

}
