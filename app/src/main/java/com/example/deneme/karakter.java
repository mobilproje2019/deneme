package com.example.deneme;

public class karakter {
    public static String isim="";
    public static int sinif =-1;
    public static int seviye=0;
    public static int cxp=0;
    public static int nxp=155;
    public static int point=0;

    public static int hp=100;

    public static int pasif=0;  // 0 warior 1 Assassin 2 Mage
    public static int[] stat={1,1,1}; // Str Agi Int


    public static int[][] skills={};

// çok karışık burası
    public static int[][] assassin={
            {0,50,0,0,3},               //seviye  , Hasar , İyileştirme , Etki , TUR
            {2,80,0,0,5},
            {4,50,60,2,4},
            {8,80,25,1,6},
            {12,100,65,0,10}
    };
    public static int[][] warrior={
            {0,100,0,1,3},               //seviye , Hasar , İyileştirme , Etki, TUR
            {2,120,0,0,4},
            {4,200,0,0,6},
            {8,250,0,1,8},
            {12,400,0,0,10}
    };
    public static int[][] mage={
            {0,0,50,0,2},               //seviye  , Hasar , İyileştirme , Etki , TUR
            {2,80,0,0,3},
            {4,0,100,2,6},
            {8,250,0,0,7},
            {12,600,0,0,8}
    };
}
