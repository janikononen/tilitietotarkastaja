package ohjelmisto;
import java.util.ArrayList;
import java.util.List;

public class TilioteKuukausi {
    String kuukaudenNimi = "";
    int kuukaudenVuosi = 0;
    List<Tilitapahtuma> tilitapahtumat = new ArrayList<>();
    
    @Override
    public String toString() {
        return "TilioteKuukausi [kuukaudenNimi=" + kuukaudenNimi + ", kuukaudenVuosi=" + kuukaudenVuosi
                + ", tilitapahtumat=" + tilitapahtumat + "]";
    }
    public TilioteKuukausi() {
        this.kuukaudenNimi = "";
        this.kuukaudenVuosi = 0;
        this.tilitapahtumat = new ArrayList<>();
    }
    public TilioteKuukausi(String kuukaudenNimi, int kuukaudenVuosi, List<Tilitapahtuma> tilitapahtumat) {
        this.kuukaudenNimi = kuukaudenNimi;
        this.kuukaudenVuosi = kuukaudenVuosi;
        this.tilitapahtumat = tilitapahtumat;
    }
    public String getKuukaudenNimi() {
        return kuukaudenNimi;
    }
    public void setKuukaudenNimi(String kuukaudenNimi) {
        this.kuukaudenNimi = kuukaudenNimi;
    }
    public int getKuukaudenVuosi() {
        return kuukaudenVuosi;
    }
    public void setKuukaudenVuosi(int kuukaudenVuosi) {
        this.kuukaudenVuosi = kuukaudenVuosi;
    }
    public List<Tilitapahtuma> getTilitapahtumat() {
        return tilitapahtumat;
    }
    public void setTilitapahtumat(List<Tilitapahtuma> tilitapahtumat) {
        this.tilitapahtumat = tilitapahtumat;
    }
}
