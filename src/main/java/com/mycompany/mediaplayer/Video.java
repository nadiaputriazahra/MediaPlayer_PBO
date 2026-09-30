/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class  Video extends Media {
    private String resolusi;
    
    public Video(String judul, int durasiDetik, String resolusi){
        super(judul, durasiDetik);
        this.resolusi = resolusi;
    }
     
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Video] Judul: %-15s | Resolusi: %-8s | Durasi: %s%n",
                            judul, resolusi, formatDurasi());
    }
    
    @Override
    public void putar() {
        System.out.println("Memutar video \"" + judul + "\" dalam resolusi " + resolusi + " (audio + gambar).");
    }
}