package JavaFiles;


import java.io.Serializable;

public class Sujeto implements Serializable {

    private static final long serialVersionUID = 035L;
    private String Sex, Freq, Age, Ref, Pros, Seguro, DerHab, PProg, klave, Cobertura;

    public Sujeto() {
    }

    public Sujeto(String S, String F, String A, String R, String P, String SEG, String DH, String PPROG, String Cover, String K) {
        Sex = S;
        Freq = F;
        Age = A;
        Ref = R;
        Pros = P;
        Seguro = SEG;
        DerHab = DH;
        PProg = PPROG;
        Cobertura = Cover;
        klave = K;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getFreq() {
        return Freq;
    }

    public void setFreq(String Freq) {
        this.Freq = Freq;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getPros() {
        return Pros;
    }

    public void setPros(String Prospera) {
        this.Pros = Prospera;
    }

    public String getSeguro() {
        return Seguro;
    }

    public void setSeguro(String Seguro) {
        this.Seguro = Seguro;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String Ref) {
        this.Ref = Ref;
    }

    public String getPProg() {
        return PProg;
    }

    public void setPProg(String PProg) {
        this.PProg = PProg;
    }

    public String getDerHab() {
        return DerHab;
    }

    public void setDerHab(String DerHab) {
        this.DerHab = DerHab;
    }
    
    public String getCover() {
        return Cobertura;
    }

    public void setCover(String cover) {
         Cobertura = cover;
    }

    public String getKlave() {
        return klave;
    }

    public void setKlave(String klave) {
        this.klave = klave;
    }
}
