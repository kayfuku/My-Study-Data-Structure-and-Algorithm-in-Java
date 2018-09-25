// Collections.sort
// (By myself)


package com.google.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinionInterrogation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
//      int[][] minions = { { 5, 1, 5 }, { 10, 1, 2 } };
        int[][] minions = { { 390, 185, 624 }, 
                            { 686, 351, 947 }, 
                            { 276, 1023, 1024 }, 
                            { 199, 148, 250 } };
        
        int[] result = answer(minions);
        for (int i = 0; i < minions.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
    
    
    public static int[] answer(int[][] minions) {
        
        // Initialization.
        ArrayList<Minion> list = new ArrayList<Minion>();
        
        for (int i = 0; i < minions.length; i++) {
            Minion minion = 
                    new Minion(minions[i][0], minions[i][1], minions[i][2]);
            minion.setNumMinion(i);
            list.add(minion);
        }
        
        // Sort.
        Collections.sort(list, new Comparator<Minion>() {
            @Override
            public int compare(Minion m1, Minion m2) {
                double result;
                
                result = m1.getT() * (m2.getPN() / m2.getPD()) 
                        - m2.getT() * (m1.getPN() / m1.getPD());
                
                if (result > 0) {
                    return 1;
                } else if (result == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        
        // Return the order.  
        int[] orderMinions = new int[minions.length];
        for (int i = 0; i < orderMinions.length; i++) {
            orderMinions[i] = list.get(i).numMinion;
        }
        
        return orderMinions;
    }
    
    
    // ************ class Minion ************************************
    public static class Minion {
        private double t, pN, pD;
        private int numMinion;
        
        public Minion(int time, int numerator, int denominator) {
            this.t = time;
            this.pN = numerator;
            this.pD = denominator;
        }
                
        public double getT() {
            return this.t;
        }
        
        public double getPN() {
            return this.pN;
        }
        
        public double getPD() {
            return this.pD;
        }
        
        public void setNumMinion(int n) {
            this.numMinion = n;
        }
        
    }
    
    
    
    

}
