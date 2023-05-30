package com.example.fitnessuygulamasiodevi;

public class Kullanici {

    String email,sifre;

    public Kullanici() {
    }

    public Kullanici(String email, String sifre) {
        this.email = email;
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
