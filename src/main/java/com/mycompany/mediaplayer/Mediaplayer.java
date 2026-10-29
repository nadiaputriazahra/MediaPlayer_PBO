/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mediaplayer;

import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Mediaplayer {

    public static void cariMedia(String judul, ArrayList<Media> daftarMedia) throws MediaTidakDitemukanException {
        System.out.println("Mencari Media dengan Judul: " + judul);
        boolean ditemukan = false;

        for (int i = 0; i < daftarMedia.size(); i++) {
            if (daftarMedia.get(i).getJudul().equalsIgnoreCase(judul)) {
                daftarMedia.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new MediaTidakDitemukanException("Gagal: Media dengan judul '" + judul + "' tidak terdaftar di sistem.");
        }
    }

    public static void simulasiPutar(Media item) {
        item.putar();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Media> daftarMedia = new ArrayList<>();

        HashMap<String, String> dataPengguna = new HashMap<>();
        try {
            daftarMedia.add(new Lagu("Hati-Hati di Jalan", 210, "Tulus", "Manusia"));
            daftarMedia.add(new Video("Belajar Java OOP", 900, "1080p"));
            daftarMedia.add(new Podcast("Ngobrol Teknologi", 1800, "Rina", 12));
            daftarMedia.add(new AudioBook("Laskar Pelangi", 3600, "Andi", 8));
        } catch (Exception e) {
            System.out.println("[ERROR DATA AWAL] " + e.getMessage());
        }
        dataPengguna.put("USR001", "Budi Santoso");
        dataPengguna.put("USR002", "Siti Aminah");
        dataPengguna.put("USR003", "Rudi Hartono");

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
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: 1-5: ");

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
                        String judulBaru = scanner.nextLine();

                        System.out.print("Masukkan Durasi (detik): ");
                        int durasiBaru = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Artis: ");
                            String artis = scanner.nextLine();
                            System.out.print("Masukkan Album: ");
                            String album = scanner.nextLine();
                            daftarMedia.add(new Lagu(judulBaru, durasiBaru, artis, album));
                            
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Resolusi (mis. 1080p): ");
                            String resolusi = scanner.nextLine();
                            daftarMedia.add(new Video(judulBaru, durasiBaru, resolusi));
                            
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Nama Host: ");
                            String host = scanner.nextLine();
                            System.out.print("Masukkan Nomor Episode: ");
                            int episode = scanner.nextInt();
                            scanner.nextLine();
                            daftarMedia.add(new Podcast(judulBaru, durasiBaru, host, episode));
                            
                        } else if (jenis == 4) {
                            System.out.print("Masukkan Nama Narator: ");
                            String narator = scanner.nextLine();
                            System.out.print("Masukkan Jumlah Bab: ");
                            int bab = scanner.nextInt();
                            scanner.nextLine();
                            daftarMedia.add(new AudioBook(judulBaru, durasiBaru, narator, bab));
                        }

                        System.out.println("Sukses! Media berhasil ditambahkan. (Total Media: " + daftarMedia.size() + ")");
                    }
                    case 2 -> {
                        System.out.println("\n--- Daftar Playlist ---");
                        if (daftarMedia.isEmpty()) {
                            System.out.println("Belum ada media yang tersimpan.");
                        } else {
                            for (int i = 0; i < daftarMedia.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarMedia.get(i).tampilkanInfo();
                                simulasiPutar(daftarMedia.get(i));

                                daftarMedia.get(i).hitungEstimasiKuota();
                                if (daftarMedia.get(i) instanceof Dapatdiunduh) {
                                    Dapatdiunduh itemUnduh = (Dapatdiunduh) daftarMedia.get(i);
                                    itemUnduh.prosesUnduh();
                                }
                                if (daftarMedia.get(i) instanceof Dapatdinilai) {
                                    Dapatdinilai itemBisaDinilai = (Dapatdinilai) daftarMedia.get(i);
                                    itemBisaDinilai.beriRating(5);
                                }
                                System.out.println();
                            }
                            System.out.println("* Total Media di Playlist: " + daftarMedia.size());
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Media --");
                        System.out.print("Masukkan Judul: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            cariMedia(kataKunci, daftarMedia);
                        } catch (MediaTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                    }
                    
                    case 4 -> {
                        System.out.println("\n-- Kelola Pengguna (HashMap) --");
                        System.out.println("1. Tambah Pengguna Baru");
                        System.out.println("2. Cari Pengguna via ID");
                        System.out.println("3. Tampilkan Semua Pengguna");
                        System.out.print("Pilih: ");
                        int menuPengguna = scanner.nextInt();
                        scanner.nextLine();

                        if (menuPengguna == 1) {
                            System.out.print("Masukkan ID (sebagai Key): ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String nama = scanner.nextLine();

                            dataPengguna.put(id, nama);
                            System.out.println("Berhasil menambahkan pengguna!");
                            
                        } else if (menuPengguna == 2) {
                            System.out.print("Masukkan ID yang dicari: ");
                            String searchId = scanner.nextLine();

                            if (dataPengguna.containsKey(searchId)) {
                                System.out.println("Ditemukan! Nama: " + dataPengguna.get(searchId));
                            } else {
                                System.out.println("Pengguna dengan ID tersebut tidak terdaftar.");
                            }
                            
                        } else if (menuPengguna == 3) {
                            System.out.println("Total Pengguna Terdaftar: " + dataPengguna.size());
                            for (String keyId : dataPengguna.keySet()) {
                                System.out.println("- ID: " + keyId + " | Nama: " + dataPengguna.get(keyId));
                            }
                        }
                    }
                    
                    case 5 -> {
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
