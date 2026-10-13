/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class AudioBook extends Media implements Dapatdiunduh {
    private String narator;
    private int jumlahBab;
    
    public AudioBook(String judul, int durasiDetik, String narator, int jumlahBab) {
        super(judul, durasiDetik);
        this.narator = narator;
        this.jumlahBab = jumlahBab;
    }
    
    public int getJumlahBab() { return jumlahBab; }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("[AudioBook] Judul: %-15s | Narator: %-10s | Bab: %-3d | Durasi: %s%n",
                            judul, narator, jumlahBab, formatDurasi());
    }
    
    @Override
    public void putar() {
        System.out.println("Memutar AudioBook \"" + judul + "\" dibacakan oleh " + narator + " mulai dari bab 1 dari " + jumlahBab + " bab.");
    }
    
    @Override
    public void hitungEstimasiKuota() {
        double mb = durasiDetik / 60.0 * 1.0;
        System.out.printf("-> Estimasi Kuota: %1f MB (audio berkomppresi tinggi, sekitar 0.5 MB / menit).%n", mb);
    }
    
    @Override
    public void prosesUnduh() {
        System.out.println("-> [PROSES UNDUH] " + jumlahBab + " bab audiobook diunduh satu per satu.");
    }
}
