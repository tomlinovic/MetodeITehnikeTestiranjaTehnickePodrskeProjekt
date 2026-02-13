# Okvir za automatsko testiranje programske podrške

Ovaj projekt sadrži okvir (framework) za automatsko testiranje web aplikacija korištenjem Selenium WebDrivera i TestNG-a. Testirao sam vlastiti završni rad koji je laravel projekt koji je stranica koja pruza usluge starijim ljudima...

Koristeni alati:
Apache Maven 3.9.12
Java openjdk 17.0.17 2025-10-21
Selenium	3.12.0
TestNG	6.14.3
Maven Surefire Plugin
IntelliJ IDEA / Eclipse
Github + Git bash

### Ovisnosti (pom.xml) 
Koristio sam ovisnosti koje smo koristili na LV2.

1. Koristimo TestBase.java kako bi svaki puta pozvali istu stranicu i pripremili webdriver

2. LoginTest provjerava moze li se korisnik uspjesno prijaviti i odjaviti

3. CheckoutAccessTest provjerava moze li korisnik staviti proizvod u kosaricu ako nije prijavljen. Ne bi trebalo biti moguće napraviti košaricu prije nego što se korisnik ne prijavi.

4. TestNegativeQuantity provjerava moze li korisnik upisati negativan broj za kolicinu proizvoda nekog u kosarici.

5. TestContactPage provjerava radi li stranica za kontakt i provjerava je li email ispisan u podacima za kontakt.

6. TestProfilePage provjerava moze li korisnik pristupiti svojemu profilu kada se prijavi na stranicu