/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author ASUS
 */
public class Pusatmedia {
    private String namaPusat;
    private Speaker speakerUtama;
    
    private ArrayList<Media> daftarMedia;
    private HashMap<String, Pengguna> dataPengguna;
    
    public Pusatmedia(String namaPusat){
        this.namaPusat = namaPusat;
        this.speakerUtama = new Speaker("Speaker Utama", 100);
        this.daftarMedia = new ArrayList<>();
        this.dataPengguna = new HashMap<>();
    }
    
    public void bukaPusatMedia(){
        System.out.println("\n*** Menginisialisasi sistem " + this.namaPusat + " ***");
        speakerUtama.nyalakan();
    }
    
    public void tambahMedia(Media m){
        daftarMedia.add(m);
        System.out.println("Sukses! Media ditambahkan. (Total Media: " + daftarMedia.size() + ")");
    }
    
    public void tambahPengguna(Pengguna p){
        dataPengguna.put(p.getId(), p);
        System.out.println("Berhasil menambahkan pengguna!");
    }
    
    public void lihatSemuaMedia(){
        if (daftarMedia.isEmpty()){
            System.out.println("Belum ada media yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarMedia.size(); i++){
            System.out.print((i + 1) + ". ");
            daftarMedia.get(i).tampilkanInfo();
        }
    }
    
    public void cariMedia(String judul) throws MediaTidakDitemukanException {
        System.out.println("Mencari Media dengan Judul: " + judul);
        boolean ditemukan = false;
        for (Media m : daftarMedia) {
            if (m.getJudul().equalsIgnoreCase(judul)) {
                m.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new MediaTidakDitemukanException("Gagal: Media dengan judul '" + judul + "' tidak terdaftar.");
        }
    }
    
    public void cariPengguna(String id) {
        if (dataPengguna.containsKey(id)) {
            System.out.println("Ditemukan! Nama: " + dataPengguna.get(id).getNama());
        } else {
            System.out.println("Pengguna dengan ID tersebut tidak terdaftar.");
        }
    }
    
    public void lihatSemuaPengguna() {
        System.out.println("Total Pengguna Terdaftar: " + dataPengguna.size());
        for (Pengguna p : dataPengguna.values()) {
            System.out.println("- ID: " + p.getId() + " | Nama: " + p.getNama());
        }
    }
    
    public Pengguna getPengguna(String id) { return dataPengguna.get(id); }
    public Media getMediaByIndex(int index) { return daftarMedia.get(index); }
    public int getJumlahMedia() { return daftarMedia.size(); }   
}
