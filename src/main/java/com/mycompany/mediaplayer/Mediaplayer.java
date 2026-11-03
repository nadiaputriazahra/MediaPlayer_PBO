/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mediaplayer;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author ASUS
 */
public class Mediaplayer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        Pusatmedia pusatmedia = new Pusatmedia("Media Center Unila");
        pusatmedia.bukaPusatMedia();

        try {
            pusatmedia.tambahMedia(new Lagu("Hati-Hati di Jalan", 210, "Tulus", "Manusia"));
            pusatmedia.tambahMedia(new Video("Belajar Java OOP", 900, "1080p"));
            pusatmedia.tambahMedia(new Podcast("Ngobrol Teknologi", 1800, "Rina", 12));
            pusatmedia.tambahMedia(new AudioBook("Laskar Pelangi", 3600, "Andi", 8));
        } catch (Exception e) {
            System.out.println("[ERROR DATA AWAL] " + e.getMessage());
        }
        pusatmedia.tambahPengguna(new Pengguna("USR001", "Budi Santoso"));
        pusatmedia.tambahPengguna(new Pengguna("USR002", "Siti Aminah"));
        pusatmedia.tambahPengguna(new Pengguna("USR003", "Rudi Hartono"));
 
        boolean isRunning = true;
 
        System.out.println("=========================================");
        System.out.println("    SELAMAT DATANG DI MEDIA PLAYER!     ");
        System.out.println("=========================================");
 
        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Media");
            System.out.println("2. Lihat Playlist");
            System.out.println("3. Cari Media");
            System.out.println("4. Manajemen Pengguna");
            System.out.println("5. Pemutaran (Demo Association)");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu: 1-6: ");
 
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
 
                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n-- Pilih Jenis Media --");
                        System.out.println("1. Lagu");
                        System.out.println("2. Video");
                        System.out.println("3. Podcast");
                        System.out.println("4. Audiobook");
                        System.out.print("Pilihan (1/2/3/4): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();
 
                        System.out.print("Masukkan Judul: ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan Durasi (detik): ");
                        int durasi = scanner.nextInt();
                        scanner.nextLine();
 
                        if (jenis == 1) {
                            System.out.print("Masukkan Artis: ");
                            String artis = scanner.nextLine();
                            System.out.print("Masukkan Album: ");
                            pusatmedia.tambahMedia(new Lagu(judul, durasi, artis, scanner.nextLine()));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Resolusi: ");
                            pusatmedia.tambahMedia(new Video(judul, durasi, scanner.nextLine()));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Host: ");
                            String host = scanner.nextLine();
                            System.out.print("Masukkan Episode: ");
                            pusatmedia.tambahMedia(new Podcast(judul, durasi, host, scanner.nextInt()));
                        } else if (jenis == 4) {
                            System.out.print("Masukkan Narator: ");
                            String narator = scanner.nextLine();
                            System.out.print("Masukkan Jml Bab: ");
                            pusatmedia.tambahMedia(new AudioBook(judul, durasi, narator, scanner.nextInt()));
                        } else {
                            System.out.println("Jenis media tidak valid.");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Playlist ---");
                        pusatmedia.lihatSemuaMedia();
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Media --");
                        System.out.print("Masukkan Judul: ");
                        String kataKunci = scanner.nextLine();
 
                        try {
                            pusatmedia.cariMedia(kataKunci);
                        } catch (MediaTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        System.out.println("\n-- Kelola Pengguna --");
                        System.out.println("1. Tambah Pengguna");
                        System.out.println("2. Cari Pengguna");
                        System.out.println("3. Lihat Semua");
                        System.out.print("Pilih: ");
                        int menuP = scanner.nextInt();
                        scanner.nextLine();
 
                        if (menuP == 1) {
                            System.out.print("Masukkan ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama: ");
                            String nama = scanner.nextLine();
 
                            pusatmedia.tambahPengguna(new Pengguna(id, nama));
                        } else if (menuP == 2) {
                            System.out.print("ID yg dicari: ");
                            pusatmedia.cariPengguna(scanner.nextLine());
                        } else if (menuP == 3) {
                            pusatmedia.lihatSemuaPengguna();
                        }
                    }
                    case 5 -> {
                        System.out.println("\n-- Sistem Pemutaran (Asosiasi) --");
                        System.out.print("Masukkan ID Pendengar: ");
                        String inputId = scanner.nextLine();
 
                        Pengguna pendengar = pusatmedia.getPengguna(inputId);
 
                        if (pendengar == null) {
                            System.out.println("Gagal: Pengguna belum terdaftar!");
                        } else if (pusatmedia.getJumlahMedia() == 0) {
                            System.out.println("Gagal: Belum ada media yang bisa diputar.");
                        } else {
                            pusatmedia.lihatSemuaMedia();
                            System.out.print("Pilih Nomor Media yg ingin diputar: ");
                            int noMedia = scanner.nextInt() - 1;
                            scanner.nextLine();
 
                            if (noMedia >= 0 && noMedia < pusatmedia.getJumlahMedia()) {
                                Media itemPutar = pusatmedia.getMediaByIndex(noMedia);
 
                                Transaksipemutaran.prosesPutar(pendengar, itemPutar);
                            } else {
                                System.out.println("Nomor media tidak valid!");
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan Media Player!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
 
            } catch (InputMismatchException e) {
                System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
            }
        }
 
        scanner.close();
    }
} 
