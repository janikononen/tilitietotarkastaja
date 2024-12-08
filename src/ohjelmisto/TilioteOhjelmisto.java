package ohjelmisto;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TilioteOhjelmisto {

    public List<Tilitapahtuma> etsiVuokratulot(List<Tilitapahtuma> tilitapahtumat){
        //käydään läpi tilitapahtumat ja poimitaan tapahtumat jotka ovat tuloja
        List<Tilitapahtuma> vuokratulot = tilitapahtumat.stream().filter(t -> t.getSumma() > 0).collect(Collectors.toList());
        return vuokratulot;
    }
    public static HashMap<Integer, Double> etsiTulotKuukausittain(List<Tilitapahtuma> tilitapahtumat){
        //mappi kuukausille ja tuloille
        HashMap<Integer, Double> tulotkuukausittain = new HashMap<>();

        for(int i = 1; i <= 12; i++){           
            double kuukaudentulot = 0.0;
            //käydään kaikkien tapahtumat läpi ja jos summa > 0 niin lisätään kuukauden (i) tuloksi tilitapahtuman summa
            for (Tilitapahtuma t : tilitapahtumat) {
                if (t.getPaivamaara().getMonthValue() == i && t.getSumma() > 0) {
                    kuukaudentulot += t.getSumma();
                }
            }
            tulotkuukausittain.put(i, kuukaudentulot);
        }
        return tulotkuukausittain;
    }
    //luodaan ruokapaikan/menon nimi jota voi halutessaan vaihtaa
    public class Ruokapaikka {
        private final String nimi;

        public Ruokapaikka(String paikka){
            this.nimi = paikka;
        } 
        public String getNimi() {
            return nimi;
        }
    }
    //Käsitellään tilitapahtumien kuluja    
    public class kulunKäsittely {
        //halutun ruokapaikan menot
        public int ruokamenot (List<Tilitapahtuma> tilitapahtumat, Ruokapaikka ruokapaikka){
            double summa =tilitapahtumat.stream().filter(t -> t.toimittajanNimi.contains(ruokapaikka.getNimi())).collect(Collectors.summingDouble(Tilitapahtuma::getSumma));
            return (int)summa;
        }
        //haluttujen bensa-asemien menot, voidaan vaihtaa miksi tahansa menoiksi luomalla objektit Teboil ja Neste -tilalle ja käyttämällä niitä tiedonhaussa.
        public int bensamenot (List<Tilitapahtuma> tilitapahtumat){
            Set<String> halututBensikset = Set.of("Teboil","Neste");
            double summa = tilitapahtumat.stream().filter(t -> halututBensikset.stream().anyMatch(b -> t.getToimittajanNimi().contains(b))).collect(Collectors.summingDouble(Tilitapahtuma::getSumma));
            return (int)summa;
        }
    }

    public static void main(String[] args) {
        //alla "tarvittavat" listat

        //lista tilitapahtumille per kuukausi
        List<TilioteKuukausi> tilitapahtumatKuukausittain = new ArrayList<>();
        //lista kaikille tilitapahtumillle
        List<Tilitapahtuma> kaikkitilitapahtumat = new ArrayList<>();
        //lista kuukausista tilitapahtumatKuukausittain, varten. Lisäsin tyhjän kuukauden ensimmäiseksi jotta 1 = tammikuu ja 12 = joulukuu        
        List<String> kuukaudetListassa = List.of("", "Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu",
        "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu");
        
        //muutetaan päivämäärän formaatti kun antoi virheilmoituksen aiheeseen liittyen
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //määritellään tekstitiedoston nimi jota käytetään tilitietojen datalähteenä
        InputStream inputStream = TilioteOhjelmisto.class.getClassLoader().getResourceAsStream("tilitiedot.txt");
        Scanner tiedostonlukija = new Scanner(inputStream);
            String rivi = tiedostonlukija.nextLine(); // tämä jotta ei oteta ensimmäistä riviä
            while (tiedostonlukija.hasNextLine()) {
                rivi = tiedostonlukija.nextLine(); // käy läpi tiedoston rivi riviltä

                //väliaikainen lista tietorivin eri tietotyypeille
                String[] palat = rivi.split(";", -1);
    
                // palat[0] = päivämäärä "2023/12/29"
                // palat[1] = summa "55,66"
                // palat[5] = toimittajanNimi esim. "JANI KÖNÖNEN"
                
                //luodaan uusi Tilitapahtuma-olio
                Tilitapahtuma tilitapahtuma = new Tilitapahtuma(
                    LocalDate.parse(palat[0], formatter),
                    Double.parseDouble(palat[1].replace(",", ".")),
                    palat[5]
                );
                //lisätään tilitapahtumat-listaan tilitapahtuma-olio
                kaikkitilitapahtumat.add(tilitapahtuma);
            }

            for(int i = 1; i < 13; i++){   
                List<Tilitapahtuma> tapahtumatKuukausittain = new ArrayList<>();        
                //käydään kaikkien tapahtumat läpi ja luodaan tiliotekuukausi-oliot
                for (Tilitapahtuma t : kaikkitilitapahtumat) {
                    if (t.getPaivamaara().getMonthValue() == i) {
                        tapahtumatKuukausittain.add(t);
                    }

                }
                //luodaan tilioteKuukausi-olio
                TilioteKuukausi tilioteKuukausi = new TilioteKuukausi(kuukaudetListassa.get(i),2023 ,tapahtumatKuukausittain);
                //lisätään tilioteKuukausi-olio tilitapahtumatKuukausittain-listaan
                tilitapahtumatKuukausittain.add(tilioteKuukausi);
            }
        //luodaan TilioteOhjelmisto -olio, jonka avulla päästään käyttämään luokkia ja methodieita
        TilioteOhjelmisto o = new TilioteOhjelmisto();
        TilioteOhjelmisto.Ruokapaikka paikkaNimi = o.new Ruokapaikka("Hesburger");
        TilioteOhjelmisto.kulunKäsittely kulut = o.new kulunKäsittely();
        //ruokamenot
        int ruokamenot = kulut.ruokamenot(kaikkitilitapahtumat, paikkaNimi);
        //polttoainekulut
        int polttoainekulut = kulut.bensamenot(kaikkitilitapahtumat);
        
        //kovakoodattu tuloste jotta sain palautettua työn viopeen
        System.out.println("Tulostetaan Hesburgerin ruokailukulut tiedoston aikajanteelta:\n" +
                            "HESBURGER RUOKAMENOT TALLA JAKSOLLA: " + ruokamenot + " euroa");
        System.out.println("Tulostetaan autoilun polttoainekuluja tiedoston aikajanteella:\n" +
                            "POLTTOAINEKULUT TALLA JAKSOLLA: " + polttoainekulut + " euroa");

        //käytetään etsitulotKuukausittain -methodia kaikkitilitapahtumat-listan avulla, joka sisältää listan Tilitapahtuma-olioista
        HashMap<Integer, Double> tulot = etsiTulotKuukausittain(kaikkitilitapahtumat);
        // Marraskuu on 11. kuukausi
        int kknumero = 11;
        int marraskuunTulot = tulot.get(kknumero).intValue();
        String kuukaudenNimi = kuukaudetListassa.get(kknumero);

        System.out.println(kuukaudenNimi + "n tulot\n" + kknumero + ": " + marraskuunTulot);
    
        tiedostonlukija.close();    
    }
    
}
