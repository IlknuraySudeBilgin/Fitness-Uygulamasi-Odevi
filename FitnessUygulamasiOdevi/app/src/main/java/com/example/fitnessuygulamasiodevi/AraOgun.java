package com.example.fitnessuygulamasiodevi;

public class AraOgun {

    String yemek_ad,yemek_kalori,yemek_key;

    public AraOgun() {
    }

    public AraOgun(String yemek_ad, String yemek_kalori, String yemek_key) {
        this.yemek_ad = yemek_ad;
        this.yemek_kalori = yemek_kalori;
        this.yemek_key = yemek_key;
    }

    public String getYemek_ad() {
        return yemek_ad;
    }

    public void setYemek_ad(String yemek_ad) {
        this.yemek_ad = yemek_ad;
    }

    public String getYemek_kalori() {
        return yemek_kalori;
    }

    public void setYemek_kalori(String yemek_kalori) {
        this.yemek_kalori = yemek_kalori;
    }

    public String getYemek_key() {
        return yemek_key;
    }

    public void setYemek_key(String yemek_key) {
        this.yemek_key = yemek_key;
    }
}
