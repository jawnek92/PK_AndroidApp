package com.example.jan.jbapp;

/**
 * Created by jan on 21.05.2018.
 */

public class websiteCollection {


    private String mainCategory;
    private String subCategory;
    private String serchByUserKey;

    public websiteCollection(String mainCategory, String subCategory, String serchByUserKey) {
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.serchByUserKey = serchByUserKey;
    }

    private String Olx = "https://www.olx.pl/";
    private String Allegro = "https://allegro.pl/";
    private String Sprzedajemy = "https://sprzedajemy.pl/";
    private String eBay = "https://www.ebay.pl/";
    private String martplaats = "https://www.marktplaats.nl/";
    private String mobileDe = "https://www.mobile.de/";

    public String getOlx() {
        return Olx;
    }

    public String getAllegro() {
        return Allegro;
    }

    public String getSprzedajemy() {
        return Sprzedajemy;
    }

    public String geteBay() {
        return eBay;
    }

    public String getMartplaats() {
        return martplaats;
    }

    public String getMobileDe() {
        return mobileDe;
    }
}
