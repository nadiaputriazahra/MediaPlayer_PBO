/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class Lagu extends Media {
    private String artis;
    private String album;
    
    public Lagu(String judul, int durasiDetik, String artis, String album){
        super(judul, durasiDetik);
        this.artis = artis;
        this.album = album;
    }
    
    public String getArtis() { return artis; }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Lagu] Judul: %-15s | Artis: %-12s | Album: %-12s | Durasi: %s%n",
                            judul, artis, album, formatDurasi());
    }
    
    @Override
    public void putar() {
        System.out.println("Memutar lagu \"" + judul + "\" oleh " + artis + " (hanya audio).");
    }   
}
