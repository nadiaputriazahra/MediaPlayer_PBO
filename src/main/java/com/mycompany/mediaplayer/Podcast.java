/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class Podcast extends Media implements Dapatdinilai {
    private String host;
    private int episode;
    
    public Podcast(String judul, int durasiDetik, String host, int episode) throws Exception {
        super(judul, durasiDetik);
        if (episode <= 0) throw new Exception("Nomor Episode harus lebih dari 0!");
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
    
    @Override
    public void hitungEstimasiKuota() {
        double mb = durasiDetik / 60.0 * 1.0;
        System.out.printf("-> Estimasi Kuota: %.1f MB (streaming saja, sekitar 0.5 MB / menit).%n", mb);
    }
    
    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [ULASAN PODCAST] Episode ini mendapat rating " + bintang + "/5 bintang.");
    }
}
