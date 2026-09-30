/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class Media {
    protected String judul;
    protected int durasiDetik;
    
    public static int totalMediaBerhasilDibuat = 0;
    
    public Media(String judul, int durasiDetik){
        this.judul = judul;
        setDurasiDetik(durasiDetik);
        totalMediaBerhasilDibuat++;
    }
    
    public String getJudul() { return this.judul; }
    public int getDurasiDetik() { return this.durasiDetik; }
    
    public void setDurasiDetik(int durasiDetik) {
        if (durasiDetik > 0) {
            this.durasiDetik = durasiDetik;
        } else {
            System.out.println("Durasi tidak valid, diset ke 1 detik.");
            this.durasiDetik = 1;
        }
    }
    
    protected String formatDurasi() {
        return String.format("%02d%n", durasiDetik / 60, durasiDetik % 60);
    }
    
    public void tampilkanInfo() {
        System.out.printf("[Media] Judul: %-20s | Durasi: %s%n", judul, formatDurasi());
    }
    
    public void putar() {
        System.out.println("Memutar media: " + judul);
    }
}
