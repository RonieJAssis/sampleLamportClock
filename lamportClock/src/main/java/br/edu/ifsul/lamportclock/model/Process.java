/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.lamportclock.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronie
 */
public class Process {
    
    private Integer interval;
    
    private List<Integer> time;

    public Process(Integer interval) {
        this.interval = interval;
        time = new ArrayList<>();
        time.add(0);
        for(int i=1;i<10;i++){
            time.add(time.get(i-1)+this.interval);
        }
    }
    
    public void show(){
        for(int i=0;i<9;i++){
            System.out.print(time.get(i)+ " -> ");
        }
        System.out.println(time.get(9));
    }
    
    public Integer getTime(int i){
        return time.get(i-1);
    }
    
    public void setTime(int i,Integer value){
        if(value>this.getTime(i)){
            time.set(i-1, value+1);
            for(int j=i;i<=9;i++){
                time.set(i,time.get(i-1)+this.interval);
            }
        }
    }
    
}
