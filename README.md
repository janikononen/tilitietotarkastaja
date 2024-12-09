# 🛠️ Käytetyt teknologiat ja menetelmät

Ohjelmisto on toteutettu **Java-kielellä** ja hyödynnetty seuraavia teknologioita ja menetelmiä:

- **Kokoelmat ja tietorakenteet**: ArrayList, HashMap
- **Java Stream API**: Tietojen suodattamiseen ja käsittelyyn
- **DateTime API**: Päivämäärien käsittely (LocalDate, DateTimeFormatter)
- **Tiedostonkäsittely**: InputStream ja Scanner luokkien avulla
- **Olio-ohjelmointi**: Modularisointi luokkien ja metodien avulla

# 💻 Ohjelmiston toiminnallisuus

Ohjelmisto käsittelee tilitapahtumatiedostoja ja tarjoaa seuraavat ominaisuudet:

1. **Kuukausittaisten tilitapahtumien käsittely**:
   - Lukee tilitiedot tekstitiedostosta.
   - Jakaa tapahtumat kuukausittaisiin kokonaisuuksiin.

2. **Tuloraportointi**:
   - Laskee tuloja kuukausittain ja palauttaa tulot yhteenvedossa.

3. **Kulujen analysointi**:
   - Erottaa kulut tiettyjen toimittajien (esim. ravintolat tai bensa-asemat) perusteella.

4. **Vuokratulojen etsiminen**:
   - Suodattaa ja esittää vuokratulot.

5. **Tulosteet**:
   - Tulostaa valittujen kategorioiden kulut ja kuukausittaiset tulot.

# 🎓 Mitä opin ohjelmistoa tehdessä?

Ohjelmistoa tehdessä sain kokemusta seuraavista asioista:

- **Java-ohjelmointi**:
  - Syvällisempi ymmärrys Stream API:sta ja sen käytöstä.
  - Olio-ohjelmoinnin suunnittelu ja toteutus.

- **Tiedon käsittely**:
  - Tiedostojen lukeminen ja tietojen pilkkominen ohjelmallisesti.
  - Päivämäärien ja numeerisen datan hallinta.

- **Modularisointi**:
  - Eri osien eristäminen ja uudelleenkäytettävyys.

- **Debuggaus ja virheiden käsittely**:
  - Tietorakenteiden ja tiedostomuotojen aiheuttamien virheiden korjaus.

# 🔄 Jatkosovellus ja kehitysmahdollisuudet

Ohjelmistoa voidaan kehittää ja laajentaa seuraavasti:

- **Käyttöliittymä**:
  - Graafinen käyttöliittymä (GUI) raporttien visualisointia varten.

- **Tietojen visualisointi**:
  - Kaavioiden ja graafien luominen kuukausittaisista tuloista ja menoista.

- **Lisäominaisuudet**:
  - Ennusteiden luominen tilitapahtumien perusteella.
  - Kulujen budjetointi ja hälytykset ylitetyistä rajoista.

- **Integraatiot**:
  - Tuki useille tiedostoformaatille, kuten CSV tai JSON.
  - tietokanta
