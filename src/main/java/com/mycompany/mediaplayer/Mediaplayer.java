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
    public static void cariMedia(String judul, Media[] daftarMedia, int jumlahMedia){
        System.out.println("Mencari media dengan judul (teks): " + judul);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMedia; i++){
            if (daftarMedia[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.print("- Ditemukan: ");
                daftarMedia[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Media tidak ditemukan.");
    }
    
    //Overloading: Cari berdasarkan durasi maksimum (detik)
    public static void cariMedia(int durasiMaks, Media[] daftarMedia, int jumlahMedia){
        System.out.println("Mencari media dengan durasi maksimum (angka): " + durasiMaks + "detik");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMedia; i++){
            if (daftarMedia[i].getDurasiDetik() <= durasiMaks) {
                System.out.print("- Ditemukan: ");
                daftarMedia[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Media tidak ditemukan.");
    }
    
    public static void simulasiPutar(Media item){
        item.putar();
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        Media[] daftarMedia = new Media[10];
        int jumlahMedia = 0;
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
                    if (jumlahMedia >= daftarMedia.length) {
                        System.out.println("Maaf, playlist penuh!");
                        break;
                    }
                    System.out.println("\n--Tambah Media--");
                    System.out.println("1. Lagu");
                    System.out.println("2. Video");
                    System.out.println("3. Podcast");
                    System.out.println("4. Audiobook");
                    System.out.println("Pilihan (1-4): ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (jenis < 1 || jenis > 4){
                        System.out.println("Jenis tidak valid.");
                        break;
                    }
                    
                    System.out.print("Masukkan judul: ");
                    String judulBaru = scanner.nextLine();
                    
                    System.out.print("Masukkan durasi (detik): ");
                    int durasiBaru = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (jenis == 1){
                        System.out.print("Masukkan artis: ");
                        String artis = scanner.nextLine();
                        System.out.print("Masukkan album: ");
                        String album = scanner.nextLine();
                        daftarMedia[jumlahMedia] = new Lagu(judulBaru, durasiBaru, artis, album);
                        
                    } else if (jenis == 2){
                        System.out.print("Masukkan resolusi (ex:1080p): ");
                        String resolusi = scanner.nextLine();
                        daftarMedia[jumlahMedia] = new Video(judulBaru, durasiBaru, resolusi);
                    
                    } else if (jenis == 3){
                        System.out.print("Masukkan nama host: ");
                        String host = scanner.nextLine();
                        System.out.print("Masukkan nomor episode: ");
                        int episode = scanner.nextInt();
                        scanner.nextLine();
                        daftarMedia[jumlahMedia] = new Podcast(judulBaru, durasiBaru, host, episode);
                        
                    } else {
                        System.out.print("Masukkan nama narator: ");
                        String narator = scanner.nextLine();
                        System.out.print("Masukkan jumlah bab: ");
                        int bab = scanner.nextInt();
                        scanner.nextLine();
                        daftarMedia[jumlahMedia] = new AudioBook(judulBaru, durasiBaru, narator, bab);   
                    }
                    jumlahMedia++;
                    System.out.println("Sukses! Media berhasil ditambahkan.");
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Playlist ---");
                    if (jumlahMedia == 0){
                        System.out.println("Playlist masih kosong.");
                    } else {
                        for (int i = 0; i < jumlahMedia; i++){
                            System.out.print((i + 1) + ". ");
                            daftarMedia[i].tampilkanInfo();
                            
                            if (daftarMedia[i] instanceof Lagu) {
                                Lagu l = (Lagu) daftarMedia[i];
                                System.out.println("  Artis lagu ini: " + l.getArtis());
                            
                            } else if (daftarMedia[i] instanceof AudioBook) {
                                AudioBook a = (AudioBook) daftarMedia[i];
                                System.out.println("  Jumlah bab: " + a.getJumlahBab());
                            }
                        }
                        System.out.println("\nTotal Media yang pernah dibuat: " + Media.totalMediaBerhasilDibuat);
                    }
                    System.out.print("Tekan enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3 -> {
                   if (jumlahMedia == 0) {
                       System.out.println("Playlist masih kosong.");
                       break;
                   }
                    System.out.print("Nomor media yang diputar (1-" + jumlahMedia +"): ");
                    int no = scanner.nextInt();
                    scanner.nextLine();
                    if (no >= 1 && no <= jumlahMedia) {
                        simulasiPutar(daftarMedia[no - 1]);
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                    System.out.print("Tekan enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("\n-- Fitur Cari Media --");
                    System.out.println("1. Cari berdasarkan judul teks");
                    System.out.println("2. Cari berdasarkan durasi maksimum");
                    System.out.println("Pilih (1/2): ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (mode == 1){
                        System.out.println("Masukkan judul: ");
                        String kataKunci = scanner.nextLine();
                        cariMedia(kataKunci, daftarMedia, jumlahMedia);
                    } else if (mode == 2) {
                        System.out.println("Masukkan durasi maksimum (detik): ");
                        
                        int angkaKunci = scanner.nextInt();
                        scanner.nextLine();
                        cariMedia(angkaKunci, daftarMedia, jumlahMedia);
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
}

