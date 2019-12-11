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

    public static int[][] resimler={
            {R.drawable.warriorpasif,R.drawable.warriors1,R.drawable.warriors2,R.drawable.warriors3,},
            {R.drawable.assassinpasif,R.drawable.assassins1,R.drawable.assassins2,R.drawable.assassins3},
            {R.drawable.magepasif,R.drawable.mages1,R.drawable.mages2,R.drawable.mages3}
    };
    public  static String[][] aciklama={

        {"\n\tSavaşçının Azmi","Eğer canın %15'in altına düşerse eksik canınızın %20 i kadar Saldırı Gücü kazanırsın.",
                "\n\tAğır Darbe","Rakibe ağır bir darbe indirerek 1 tur boyunca sana saldıramaz hale getirirsin.\n\tMin Damage:100\tEtki:Stun\tTur:3",
                "\n\tSaf Güç","Rakibe atılarak fiziksel bir darbe indirirsin.\n\tMin Damage:120\tTur:4",
                "\n\tKafa Kıran","Rakibin kafasına ağır bir darbe indirirsin.\n\tMin Damage:200\tTur:6"
            },

        {"\n\tÖlümün Çevikliği","Rakibin saldırılarından %30 oranla kaçıp Kritik Karşı Saldırıda bulunursun.",
                    "\n\tHançer Fırlat"," Rakibe bir hançer fırlatırsın.\n\tMin Damage:50\tTur:3",
                    "\n\tZayıf Nokta"," Rakibin zayıf bir noktasına vurarak 1 tur boyunca saldıramaz hale getirirsin.\n\tMin Damage:80\tEtki:Stun\tTur:5",
                    "\n\tGölgenin Hançeri"," Rakibe tılsımlı hançerinle saldırarak ağır yara açarsın ve biraz can çalarsın.\n\tMin Damage:50 Min İyileştirme:60" +
                            "\tEtki:Ağır Yara\tTur:4"
            },

        {"\n\tBilgeliğin Gücü"," Rakip yeteneklerinden daha az hasar alırsın.Ayrıca aldığın hasarın %20'si kadar sonraki yeteneğin için Yetenek Gücü kazanırsın",
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
            {4,0,100,1,6},
    };
}
