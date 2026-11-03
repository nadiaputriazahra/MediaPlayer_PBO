/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class Speaker {
    private String namaSpeaker;
    private int volumeMaks;
    
    public Speaker(String namaSpeaker, int volumeMaks){
        this.namaSpeaker = namaSpeaker;
        this.volumeMaks = volumeMaks;
    }
    
    public void nyalakan(){
        System.out.println("-> [" + namaSpeaker + "] dinyalakan. Volume maksimum: " + volumeMaks + "%");
    }
}
