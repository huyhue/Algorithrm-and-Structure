/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

public class sum {
    int recurSum(int n){
        if(n<=1){
            return n;
        }else{
            return n+recurSum(n-1);
        }
    }
    public static void main(String[] args) {
        
    }
}
