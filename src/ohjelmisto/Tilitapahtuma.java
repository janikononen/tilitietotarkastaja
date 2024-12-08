package ohjelmisto;

import java.time.LocalDate;

public class Tilitapahtuma {
    LocalDate paivamaara = null;
    double summa = 0.0;
    String toimittajanNimi = "";

    @Override
    public String toString() {
        return "Tilitapahtuma [paivamaara=" + paivamaara + ", summa=" + (int)summa + ", toimittajanNimi=" + toimittajanNimi
                + "]";
    }
    
    public Tilitapahtuma() {
        this.paivamaara = null;
        this.summa = 0.00;
        this.toimittajanNimi = "";
    }

    public Tilitapahtuma(LocalDate paivamaara, double summa, String toimittajanNimi) {
        this.paivamaara = paivamaara;
        this.summa = summa;
        this.toimittajanNimi = toimittajanNimi;
    }

    public LocalDate getPaivamaara() {
        return paivamaara;
    }

    public void setPaivamaara(LocalDate paivamaara) {
        this.paivamaara = paivamaara;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public String getToimittajanNimi() {
        return toimittajanNimi;
    }

    public void setToimittajanNimi(String toimittajanNimi) {
        this.toimittajanNimi = toimittajanNimi;
    }
}
