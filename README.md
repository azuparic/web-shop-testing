<br />
<div align="center">
  <h2 align="center">Testiranje web stranice <a href="https://www.futura-it.hr/">futura-it.hr</a></h2>
</div>

## O projektu
Projekt je napravljen za kolegij Metode i tehnike testiranja programske podrške.
Web stranica <a href="https://www.futura-it.hr/"> Futura IT</a> testirana je s devet različitih testnih slučajeva
podijeljenih u tri klase. Osim te tri klase, koristi se Setup.java klasa kako bi se lakše postavili početni podaci.
Koristi se tri web drivera za korištenje različitih preglednika. Korišten je priority kako bi se odredio redoslijed 
testiranja, te Thread.sleep kako bi se sačekalo da se stranica učita. Elementima se pristupa pomoću xpath-a, name-a
i id-a, a za korištenje skrivenog elementa koristi se JavascriptExecutor objekt.


## Setup.java
U Setup klasi se određuje stranica koja se testira, te bira driver koji se koristi.


## LoginTest.java
LoginTest klasa testira tri načina logiranja:
  1. LoginOnlyMail - pokušaj prijave samo pomoću mail-a
  2. LoginOnlyPassword - pokušaj prijave samo pomoću lozinke
  3. LoginIncorrectCredentials - pokušaj prijave s krivim podacima


## SearchTest.java
SearchTest klasa testira tri različita pretraživanja:
  1. EmptySearch - pokušaj pretraživanja bez unosa
  2. RandomTextSearch - pretraživanje s besmislenim tekstom
  3. ItemSearch - pretraživanje određenog proizvoda


## ItemTest.java
ItemTest klasa testira interakciju s proizvodom:
  1. FavoriteItem - dodavanje proizvoda u favorite
  2. CompareItem - dodavanje proizvoda na usporedbu
  3. AddItemToCart - dodavanje proizvoda u košaricu


## Report
<img src="/images/report.png" alt="report" width="1242" height="565">


## Autor
Adrian Župarić
