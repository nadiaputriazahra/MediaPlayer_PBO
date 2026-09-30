/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class Podcast extends Media {
    private String host;
    private int episode;
    
    public Podcast(String judul, int durasiDetik, String host, int episode){
        super(judul, durasiDetik);
        this.host = host;
        this.episode = episode;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Podcast] Judul: %-15s | Host: %-10s | Eps: %-3d | Durasi: %s%n",
                            judul, host, episode, formatDurasi());
    }
    
    @Override
    public void putar() {
        System.out.println("Memutar podcast \"" + judul + "\" episode " + episode + " bersama " + host + ".");
    }
}
