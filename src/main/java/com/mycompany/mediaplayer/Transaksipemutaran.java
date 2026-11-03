/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediaplayer;

/**
 *
 * @author ASUS
 */
public class Transaksipemutaran {
    public static void prosesPutar(Pengguna pengguna, Media media){
        System.out.println("\n=== STRUK PEMUTARAN ===");
        System.out.println("Pendengar: " + pengguna.getNama() + " (" + pengguna.getId() + ")");
        System.out.println("Media   : " + media.getJudul());
        System.out.println("Status  : Berhasil dicatat di sistem");
        
        media.putar();
        media.hitungEstimasiKuota();
        
        if (media instanceof Dapatdiunduh) {
            ((Dapatdiunduh) media).prosesUnduh();
        }
        System.out.println("=========================");
    }
}
