package org.example;

import java.util.*;

public class Bekeres {
    private static Scanner src = new Scanner(System.in); // Standard input olvasó
    private String szoveg; // A bekért szöveget tárolja
    public static char[] tomb; // Statikus karaktertömb a szöveg karaktereinek tárolására
    public List<Character> lista; // Lista, amely a karaktereket tárolja

    // Alapértelmezett konstruktor
    public Bekeres() {
        this.lista = new ArrayList<>();  // A lista inicializálása
    }

    // Másik konstruktor, amely egyetlen karakterből álló szöveget fogad el
    public Bekeres(char szoveg) {
        this.szoveg = String.valueOf(szoveg); // A karakter szöveggé alakítása
        this.lista = new ArrayList<>();  // A lista inicializálása
    }

    // Getter a szoveg változóhoz
    public String getSzoveg() {
        return szoveg;
    }

    // Szöveg bekérése a felhasználótól
    public String beker() {
        while (true) { // Végtelen ciklus, amíg a megfelelő bemenetet nem kapjuk
            this.szoveg = this.src.nextLine(); // Szöveg beolvasása
            if (szoveg.length() >= 15) { // Ellenőrzés: legalább 15 karakter hosszú legyen
                this.tomb = szoveg.toCharArray(); // A szöveget karaktertömbbé alakítjuk
                // A karaktertömb elemeit hozzáadjuk a listához
                for (char c : tomb) {
                    this.lista.add(c);
                }
                break; // Kilépés a ciklusból, ha a feltétel teljesült
            } else {
                kiir("A szöveg túl rövid."); // Hibaüzenet, ha nem elég hosszú a szöveg
            }
        }
        return szoveg; // Visszatérünk a bekért szöveggel
    }

    // Karakterek megjelenítése vesszővel elválasztva
    public static void veszovelMegjelenit() {
        for (int i = 0; i < tomb.length; i++) {
            if (i > 0) { // Nem az első karakter előtt rakjuk ki a vesszőt
                kiir(",");
            }
            kiir("" + tomb[i]); // Az aktuális karakter kiírása
        }
    }

    // Karakterek megjelenítése kötőjellel elválasztva
    public void kotoJelelMegjelenit() {
        for (int i = 0; i < lista.size(); i++) {
            if (i > 0) { // Nem az első karakter előtt rakjuk ki a kötőjelet
                kiir("-");
            }
            kiir("" + lista.get(i)); // Az aktuális karakter kiírása a listából
        }
    }

    // Egyedi betűk kiolvasása (nem rendezve)
    public Set<Character> betukKiOlvasasa() {
        Set<Character> egyediBetuk = new HashSet<>(); // HashSet az egyedi karakterekhez
        for (char c : tomb) {
            if (Character.isLetter(c)) // Csak betűk hozzáadása
                egyediBetuk.add(c);
        }
        return egyediBetuk; // Visszatérés az egyedi betűk halmazával
    }

    // Egyedi betűk kiolvasása ABC sorrendben
    public Set<Character> betukAbc() {
        Set<Character> egyediBetuk = new TreeSet<>(); // TreeSet az automatikus ABC rendezéshez
        for (char c : tomb) {
            if (Character.isLetter(c)) { // Csak betűk hozzáadása
                egyediBetuk.add(c);
            }
        }
        return egyediBetuk; // Visszatérés a rendezett betűkkel
    }

    // Betűk darabszámának kiszámítása és ABC sorrendben való rendezése
    public Map<Character, Integer> mennyiVan() {
        Map<Character, Integer> betukDarab = new TreeMap<>(); // TreeMap az automatikus rendezéshez
        for (char c : tomb) {
            if (Character.isLetter(c)) { // Csak betűket számolunk
                // Ha a betű már szerepel, növeljük az értékét; ha nem, 1-gyel inicializáljuk
                betukDarab.put(c, betukDarab.getOrDefault(c, 0) + 1);
            }
        }
        return betukDarab; // Visszatérés a betűk darabszámával
    }

    // Karakterlánc kiírása a konzolra
    public static void kiir(String szoveg) {
        System.out.print(szoveg); // Szöveg kiírása
    }
}
