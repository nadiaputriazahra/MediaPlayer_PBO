/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class  Video extends Media implements Dapatdiunduh, Dapatdinilai {
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
    
    @Override
    public void hitungEstimasiKuota() {
        double mb = durasiDetik / 60.0 * 15.0;
        System.out.printf("-> Estimasi Kuota: %1f MB (video, sekitar 15 MB / menit).%n", mb);
    }
    
    @Override
    public void prosesUnduh() {
        System.out.println("-> [PROSES UNDUH] File video resolusi " + resolusi + " diunduh, pastikan ruang penyimpanan cukup.");
    }
    
    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [ULASAN VIDEO] Video ini mendapat rating " + bintang + "/5 bintang.");
    }
}