/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.companytobe.fifa.test;

/**
 *
 * @author lenovo
 */
public class League_update {

    private int score1;
    private int score2;
    League_Results r;

    public League_update(League_Results r, int score1, int score2) {
        this.r = r;
        this.score1 = score1;
        this.score2 = score2;

    }

    public void setWLD() {
        int gd = score1 - score2;
        if (gd > 0) {
            int W = r.getW();
            r.setW(W + 1);
        } else if (gd == 0) {
            int D = r.getD();
            r.setD(D + 1);
        } else {
            int L = r.getL();
            r.setL(L + 1);
        }
    }

    public void setGF() {
        //  return GF+lc.GF();
        int GF = r.getGF();
        r.setGF(GF + score1);
    }

    public void setGA() {
        //return GA+lc.GA();
        int GA = r.getGA();
        r.setGF(GA + score2);
    }

    public void setGD() {
        //return GD+lc.GD();
        int GD = r.getGD();
        int gd = score1 - score2;
        r.setGF(GD + gd);
    }

    public void setPoints() {
        // return points+lc.points();
        int points = r.getPoints();
        int gd = score1 - score2;

        if (gd > 0) {
            r.setPoints(points + 3);
        } else if (gd == 0) {
            r.setPoints(points + 1);
        } else {
            r.setPoints(points);
        }
    }

    public void setMP() {
        int MP = r.getMP();
        r.setMP(MP + 1);
    }

    public League_Results compute() {
        this.setWLD();
        this.setGA();
        this.setGD();
        this.setGF();
        this.setPoints();
//        this.getMP();
        return r;
    }
}
