package com.example.deneme;

public class Yetenekler {
    public static  int Skill_1CD;
    public static  int Skill_2CD;
    public static int Skill_3CD;
    int sP;
    int s1,s2,s3;

    public static int[] k=new int[3];

    public Yetenekler()
    {
        initcharacter(karakter.pasif);
    }
    //region GET SET


    public int getsP() {
        return sP;
    }

    public void setsP(int sP) {
        this.sP = sP;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getS3() {
        return s3;
    }

    public void setS3(int s3) {
        this.s3 = s3;
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
    public  void initcharacter(int pasif){
        if(pasif==0)
        {

          setsP(R.drawable.warriorpasif);
          setS1(R.drawable.warriors1);
          setS2(R.drawable.warriors2);
          setS3(R.drawable.warriors3);

            setSkill_1CD(3);

            setSkill_2CD(4);
            setSkill_3CD(6);
        }
        else if(pasif==1)
        {
            setsP(R.drawable.assasinpasif);
            setS1(R.drawable.assassins1);
            setS2(R.drawable.assassins2);
            setS3(R.drawable.assassins3);
            setSkill_1CD(3);
            setSkill_2CD(5);
            setSkill_3CD(4);
        }
        else
        {
            setsP(R.drawable.magepasif);
            setS1(R.drawable.mages1);
            setS2(R.drawable.mages2);
            setS3(R.drawable.mages3);
            setSkill_1CD(2);
            setSkill_2CD(3);
            setSkill_3CD(6);
        }
    }

}
