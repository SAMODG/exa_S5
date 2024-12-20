package com.monsite.ja_l3.config;

public class Configuration{
    public enum ModeStockage { LISTE, BASE_DE_DONNEES }

    private static ModeStockage modeStockage = ModeStockage.BASE_DE_DONNEES; // Par défaut

    public static ModeStockage getModeStockage() {
        return modeStockage;
    }

    public static void setModeStockage(ModeStockage mode) {
        modeStockage = mode;
    }
}
