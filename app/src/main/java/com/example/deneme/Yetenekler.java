package com.example.deneme;
public class Yetenekler {
    public static String passive;
    public static String passiveName;
    public static  int Skill_1CD;
    public static  int Skill_2CD;
    public static int Skill_3CD;
    public static String Skill_1Name;
    public static String Skill_2Name;
    public static String Skill_3Name;
    public static String Skill_1;
    public static String Skill_2;
    public static String Skill_3;

    public static int[] k=new int[3];


    //region GET SET
    public String getPassiveName() {
        return passiveName;
    }
    public void setPassiveName(String passiveName) {
        this.passiveName = passiveName;
    }
    public String getSkill_1() {
        return Skill_1;
    }
    public void setSkill_1(String skill_1) {
        Skill_1 = skill_1;
    }
    public String getSkill_2() {
        return Skill_2;
    }
    public void setSkill_2(String skill_2) {
        Skill_2 = skill_2;
    }
    public String getSkill_3() {
        return Skill_3;
    }
    public void setSkill_3(String skill_3) {
        Skill_3 = skill_3;
    }
    public String getPassive() {
        return passive;
    }
    public void setPassive(String passive) {
        this.passive = passive;
    }
    public String getSkill_1Name() {
        return Skill_1Name;
    }
    public void setSkill_1Name(String skill_1Name) {
        Skill_1Name = skill_1Name;
    }
    public String getSkill_2Name() {
        return Skill_2Name;
    }
    public void setSkill_2Name(String skill_2Name) {
        Skill_2Name = skill_2Name;
    }
    public String getSkill_3Name() {
        return Skill_3Name;
    }
    public void setSkill_3Name(String skill_3Name) {
        Skill_3Name = skill_3Name;
    }
    public int getSkill_1CD() {
        return Skill_1CD;
    }
    public void setSkill_1CD(int skill_1CD) {
        Skill_1CD = skill_1CD;
}
    public int getSkill_2CD() {
        return Skill_2CD;
    }
    public void setSkill_2CD(int skill_2CD) {
        Skill_2CD = skill_2CD;
    }
    public int getSkill_3CD() {
        return Skill_3CD;
    }
    public void setSkill_3CD(int skill_3CD) {
        Skill_3CD = skill_3CD;
    }
    //endregion
    public  void initcharacter(int pasif)
    {
        if(pasif==0)
        {
            setPassiveName(karakter.aciklama[0][0]);
            setPassive(karakter.aciklama[0][1]);
            setSkill_1Name(karakter.aciklama[0][2]);
            setSkill_1(karakter.aciklama[0][3]);
            setSkill_1CD(3);
            setSkill_2Name(karakter.aciklama[0][4]);
            setSkill_2(karakter.aciklama[0][5]);
            setSkill_2CD(4);
            setSkill_3Name(karakter.aciklama[0][6]);
            setSkill_3(karakter.aciklama[0][7]);
            setSkill_3CD(6);
          //  k[0]=3;
          //  k[1]=4;
          //  k[2]=6;
        }
        else if(pasif==1)
        {
            setPassiveName(karakter.aciklama[1][0]);
            setPassive(karakter.aciklama[1][1]);
            setSkill_1Name(karakter.aciklama[1][2]);
            setSkill_1(karakter.aciklama[1][3]);
            setSkill_1CD(3);
            setSkill_2Name(karakter.aciklama[1][4]);
            setSkill_2(karakter.aciklama[1][5]);
            setSkill_2CD(5);
            setSkill_3Name(karakter.aciklama[1][6]);
            setSkill_3(karakter.aciklama[1][7]);
            setSkill_3CD(4);
         //   k[0]=3;
          //  k[1]=5;
         //   k[2]=4;
        }
        else
        {
            setPassiveName(karakter.aciklama[2][0]);
            setPassive(karakter.aciklama[2][1]);
            setSkill_1Name(karakter.aciklama[2][2]);
            setSkill_1(karakter.aciklama[2][3]);
            setSkill_1CD(2);
            setSkill_2Name(karakter.aciklama[2][4]);
            setSkill_2(karakter.aciklama[2][5]);
            setSkill_2CD(3);
            setSkill_3Name(karakter.aciklama[2][6]);
            setSkill_3(karakter.aciklama[2][7]);
            setSkill_3CD(6);
          //  k[0]=2;
         //   k[1]=3;
         //   k[2]=6;
        }
    }

}
