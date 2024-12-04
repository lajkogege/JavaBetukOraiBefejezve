package org.example;


public class Main {
    public static void main(String[] args) {
        Bekeres bekeres = new Bekeres();
        bekeres.kiir("Adj meg legalább 15 hósszuságu szöveget:\n");
        bekeres.beker();
        bekeres.veszovelMegjelenit();
        bekeres.kiir("\n");
        bekeres.kotoJelelMegjelenit();
        //egyedi betük kioplvasasa
        bekeres.kiir("\n");
        bekeres.kiir(""+bekeres.betukKiOlvasasa());
        bekeres.kiir("\n");
        bekeres.kiir(""+bekeres.betukAbc());
        bekeres.kiir("\n");
        bekeres.kiir(""+bekeres.mennyiVan());


    }




}