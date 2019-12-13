package com.example.deneme;

public class Yetenekler {
    String passive;
    String passiveName;
    String Skill_1Name;
    String Skill_2Name;
    String Skill_3Name;
    String Skill_1;
    String Skill_2;
    String Skill_3;
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
    public  void initcharacter(int pasif)
    {
        if(pasif==0)
        {
            setPassiveName(karakter.aciklama[0][0]);
            setPassive(karakter.aciklama[0][1]);
            setSkill_1Name(karakter.aciklama[0][2]);
            setSkill_1(karakter.aciklama[0][3]);
            setSkill_2Name(karakter.aciklama[0][4]);
            setSkill_2(karakter.aciklama[0][5]);
            setSkill_3Name(karakter.aciklama[0][6]);
            setSkill_3(karakter.aciklama[0][7]);
        }
        else if(pasif==1)
        {
            setPassiveName(karakter.aciklama[1][0]);
            setPassive(karakter.aciklama[1][1]);
            setSkill_1Name(karakter.aciklama[1][2]);
            setSkill_1(karakter.aciklama[1][3]);
            setSkill_2Name(karakter.aciklama[1][4]);
            setSkill_2(karakter.aciklama[1][5]);
            setSkill_3Name(karakter.aciklama[1][6]);
            setSkill_3(karakter.aciklama[1][7]);
        }
        else
        {
            setPassiveName(karakter.aciklama[2][0]);
            setPassive(karakter.aciklama[2][1]);
            setSkill_1Name(karakter.aciklama[2][2]);
            setSkill_1(karakter.aciklama[2][3]);
            setSkill_2Name(karakter.aciklama[2][4]);
            setSkill_2(karakter.aciklama[2][5]);
            setSkill_3Name(karakter.aciklama[2][6]);
            setSkill_3(karakter.aciklama[2][7]);
        }
    }

}
