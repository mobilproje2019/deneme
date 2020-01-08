package com.example.deneme;

public class karakter {
    public static String isim="";
    public static int sinif =-1;
    public static int seviye=0;
    public static int cxp=0;
    public static int nxp=155;
    public static int point=0;
    public static boolean olusturdu=false;
    public static int hp=100;

    public static int pasif=-1;  // 0 warior 1 Assassin 2 Mage
    public static int[] stat={1,1,1}; // Str Agi Int


    public static int[][] skills={};

    public static int[][] resimler={
            {R.drawable.warriorpasif,R.drawable.warriors1,R.drawable.warriors2,R.drawable.warriors3,},
            {R.drawable.assasinpasif,R.drawable.assassins1,R.drawable.assassins2,R.drawable.assassins3},
            {R.drawable.magepasif,R.drawable.mages1,R.drawable.mages2,R.drawable.mages3}
    };
    public  static String[][] aciklama={

        {
                "\n\tİyileştirme"," Kendi canını bir miktar doldurursun.",
                "\n\tAteş Topu"," Rakibe bir ateş topu gönderirsin.",
                "\n\tBilgenin Öfkesi"," Rakibin yaşam gücünü emersin."}
    };

// çok karışık burası
    public static int[][] assassin={
            {0,50,0,0,3},               //seviye  , Hasar , İyileştirme , Etki , TUR
            {2,80,0,1,5},
            {4,50,60,2,4},
    };
    public static int[][] warrior={
            {0,100,0,1,3},               //seviye , Hasar , İyileştirme , Etki, TUR
            {2,120,0,0,4},
            {4,200,0,0,6},
    };
    public static int[][] mage={
            {0,0,50,0,2},               //seviye  , Hasar , İyileştirme , Etki , TUR
            {2,80,0,0,3},
            {4,100,100,0,6},
    };
}
