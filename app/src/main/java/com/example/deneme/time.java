package com.example.deneme;

public class time {
    // Bir Gün totalde 7 parça ama biz 21 yapıcaz büyük aksiyonlar 3 ufak aksiyonlar 1 parça götürecek
  int zaman;

    public int getZaman() {
        return zaman;
    }

    public boolean setZaman(int zaman) {
        if (this.zaman + zaman <= 21) {
            this.zaman += zaman;
            return  true;
        }
        else
            return  false;
    }


}
