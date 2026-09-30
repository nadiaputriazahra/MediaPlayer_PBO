/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mediaplayer;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Mediaplayer {
    
    //Overloading: Cari berdasarkan judul
    public static void cariMedia(String judul, Media[] daftar, int jumlah){
        System.out.println("Mencari media dengan judul: " + judul);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++){
            if (daftar[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Media tidak ditemukan.");
    }
    
    //Overloading: Cari berdasarkan durasi maksimum (detik)
    public static void cariMedia(int durasiMaks, Media[] daftar, int jumlah){
        System.out.println("Mencari media dengan durasi <= " + durasiMaks + "detik");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++){
            if (daftar[i].getDurasiDetik() <= durasiMaks) {
                System.out.println("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Media tidak ditemukan.");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Media[] daftarMedia = new Media[10];
        int jumlah = 0;
        boolean isRunning = true;
        
        System.out.println("===============================");
        System.out.println(" Selamat Datang di MediaPlayer ");
        System.out.println("===============================");
        
        while(isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Media");
            System.out.println("2. Lihat Playlist");
            System.out.println("3. Putar Media");
            System.out.println("4. Cari Media");
            System.out.println("5. Keluar");
            System.out.println("Pilih menu (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1 -> {
                    if (jumlah >= daftarMedia.length) {
                        System.out.println("Maaf, playlist penuh!");
                        break;
                    }
                    System.out.println("\n--Tambah Media--");
                    System.out.println("1. Lagu");
                    System.out.println("2. Video");
                    System.out.println("3. Podcast");
                    System.out.println("Pilihan (1-3): ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (jenis < 1 || jenis > 3){
                        System.out.println("Jenis tidak valid.");
                        break;
                    }
                    
                    System.out.println("Masukkan judul: ");
                    String judul = scanner.nextLine();
                    System.out.println("Masukkan durasi (detik): ");
                    int durasi = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (jenis == 1){
                        System.out.println("Masukkan artis: ");
                        String artis = scanner.nextLine();
                        System.out.println("Masukkan album: ");
                        String album = scanner.nextLine();
                        daftarMedia[jumlah] = new Lagu(judul, durasi, artis, album);
                        
                    } else if (jenis == 2){
                        System.out.println("Masukkan resolusi (ex:1080p): ");
                        String resolusi = scanner.nextLine();
                        daftarMedia[jumlah] = new Video(judul, durasi, resolusi);
                        
                    } else {
                        System.out.println("Masukkan nama host: ");
                        String host = scanner.nextLine();
                        System.out.println("Masukkan nomor episode: ");
                        int eps = scanner.nextInt();
                        scanner.nextLine();
                        daftarMedia[jumlah] = new Podcast(judul, durasi, host, eps);   
                    }
                    jumlah++;
                    System.out.println("Sukses! Media berhasil ditambahkan.");
                }
                case 2 -> {
                    System.out.println("\n--- Playlist ---");
                    if (jumlah == 0){
                        System.out.println("Playlist masih kosong.");
                    } else {
                        for (int i = 0; i < jumlah; i++){
                            System.out.println((i + 1) + ". ");
                            daftarMedia[i].tampilkanInfo();
                        }
                        System.out.println("* Total Media dibuat: " + Media.totalMediaBerhasilDibuat);
                    }
                }
                case 3 -> {
                   if (jumlah == 0) {
                       System.out.println("Playlist masih kosong.");
                       break;
                   }
                    System.out.println("Nomor media yang diputar (1-" + jumlah +"): ");
                    int no = scanner.nextInt();
                    scanner.nextLine();
                    if (no >= 1 && no <= jumlah) {
                        daftarMedia[no - 1].putar();
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                }
                case 4 -> {
                    System.out.println("\n-- Cari Media --");
                    System.out.println("1. Berdasarkan judul");
                    System.out.println("2. Berdasarkan durasi maksimum");
                    System.out.println("Pilih (1/2): ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (mode == 1){
                        System.out.println("Masukkan judul: ");
                        cariMedia(scanner.nextLine(), daftarMedia, jumlah);
                    } else if (mode == 2) {
                        System.out.println("Masukkan durasi maksimum (detik): ");
                        
                        int maks = scanner.nextInt();
                        scanner.nextLine();
                        cariMedia(maks, daftarMedia, jumlah);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
                case 5 -> {
                    System.out.println("Terima kasih telah menggunakan MediaPlayer!");
                    isRunning = false;
                }
                default -> System.out.println("Pilihan tidak valid. Masukkan angka 1-5");
            }
        }
    }
}
