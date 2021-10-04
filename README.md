<img src="https://github.com/kubabar1/CarRental/blob/master/CarRental/src/main/webapp/static/img/car_rental_logo_name.png" width="400"/>

# 1. Opis ogólny

> A more detailed description of UML diagrams can be found in the Wiki tab, located at the link below.
> https://github.com/kubabar1/CarRental/wiki


## 1.1 Program name
*Car Rental*

## 1.2 Cel aplikacji

The main purpose of creating this application was to put into practice the knowledge I have accumulated on the subject of development
database rest applications using Spring.
</br></br>
The purpose of the * CarRental * program is to support the car rental company. The main task of the application is to allow you to view the list of cars
and their details by customers, and then booking the selected car. The application also has a client panel that allows
viewing orders and changing account settings, and an administrator panel enabling, among others administration of orders and
users, adding and editing cars, editing car equipment. The application also has a logging system and new registration
customers.

## 1.3 Krótkie wstępne podsumowanie aplikacji

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/home.png" width="800"/>

### Backend:
REST API written in Spring using the following technologies:

<ul>
  <li>Spring MVC</li>
  <li>Spring Security</li>
  <li>Spring Data JPA</li>
  <li>Hibernate</li>
</ul>
W sumie projekt składa się z 8 pakietów, 83 klas które łącznie mają ok. 5000  linii kodu.

### Frontend:
Frontend was mainly written using React. I used the Thymeleaf technology to create a login panel,
registration and as the basis for the main page of the project and the user panel. In total, I used to create the frontend
the following technologies:

<ul>
  <li>React, React Router</li>
  <li>Thymeleaf</li>
  <li>Bootstrap</li>
  <li>HTML, CSS</li>
  <li>npm, webpack</li>
</ul>




W sumie frontend składa się ze 101 plików, które w sumie liczą ok. 8000 linii kodu. 

## 1.4 Docelowi użytkownicy

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/actors_diagram.png" width="600"/>

<ul>
  <li><b>Admin</b> - osoba zarządzająca stroną posiadająca najwięcej uprawnień</li>
  <li><b>Customer</b> - klient, osoba korzystająca z naszej strony w celu rezerwacji auta, każdy użytkownik który zakłada konto posiada
    początkowo rolę klienta, pozostałe role są przypisywane przez admina
  </li>
  <li><b>Renting employee</b> - osoba wypożyczająca auta, ma m.in uprawnienia do zarządzania wszystkimi zamówieniami</li>
  <li><b>Office employee</b> - osoba pracująca na stanowisku biurowym</li>
</ul>

# 2. Opis funkcjonalności

## 2.1 Uruchomienie

### Do uruchomienia potrzebne będą:
<ul>
  <li>serwer MySQL (można go pobrać poleceniem <i>sudo apt-get install mysql-server</i>),</li>
  <li>Maven (można go pobrać poleceniem <i>sudo apt-get install maven</i>),</li>
  <li>Tomcat (należy później skonfigurować użytkowników i nadać im odpowiednie prawa)</li>
</ul>

</br>

### W celu uruchomienia projektu należy wykonać następujące kroki:
1.	Clone the repository: https://github.com/kubabar1/CarRental.git
```
  git clone https://github.com/kubabar1/CarRental.git
```

2.	
Using a database script called carrental.sql located <a href="https://github.com/kubabar1/CarRental/blob/master/carrental.sql"> here </a>
create a database on the MySQL server. To install the database, enter the following command:
```
   sudo mysql –u root < carrental.sql
```


This command will delete the existing database named carrental (if any) and create a new one with the tables and the values ​​entered into them.
!!! it is very important that there is a root user in our database, without a password, but if a password is set, enter it in the * persistence-mysql.properties * file <a href="https://github.com/kubabar1/CarRental/blob/master/CarRental/src/main/java/persistence-mysql.properties">link</a>.

3.	
Go to the directory in the project where the pom.xml file is located and execute the following command:
 ```
   sudo mvn clean install
```
 
* sudo * is necessary due to the fact that Maven creates a folder in the root directory of the system in which it extracts some photos
used in the application and in which they are stored, among others photos of cars added by us.

4.	After Maven is finished, go to the * CarRental / target * folder and copy the CarRental.war file into the folder
* webapps * of our * Tomcat * server (e.g. for Tomcat 8 it will be * / var / lib / tomcat8 / webapps *).

5.	
We edit the configuration in the * / etc / tomcat8 / server.xml * file:

a)	For Windows
```
  <Host name="localhost">
    
  
    <Context docBase="C:\carrental\img\vehicles_img" path="/CarRental/vehicles-img"/>
    <Context docBase="C:\carrental\img\etc_img" path="/CarRental/etc-img"/>
  </Host>
```
    
b)	
For Linux:
```
  <Host name="localhost">
    
  
    <Context docBase="/carrental/img/vehicles_img" path="/CarRental/vehicles-img"/>
    <Context docBase="/carrental/img/etc_img" path="/CarRental/etc-img"/>
  </Host>
```
    
Dzięki temu nasza aplikacja będzie mogła mieć dostęp do zdjęć przechowywanych na dysku.

6.	Uruchamiamy serwer poleceniem (dla wersji serwera Tomcat 8): 
```
  sudo service tomcat8 start 
```

7.	Wpisujemy w przegladarce adres *http://localhost:8080/CarRental*

## 2.2 Możliwości programu i główne funkcjonalności

#### 2.2.1 Wyświetlenie ekranu głównego

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/home.gif" width="600"/>

Ekran główny wyświetla się po kliknięciu przycisku *Home* w menu lub kliknięciu w logo firmy. Przeglądanie listy pojazdów
Listę pojazdów możemy wyświetlić po kliknięciu przycisku *Car list* w menu.

#### 2.2.2 Wyszukiwanie pojazdów według podanych kryteriów

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/carsearch.gif" width="600"/>

Aby wyszukać pojazdy według kryteriów należy przejść do listy pojazdów przez kliknięcie przycisku *Car list* w menu, a następnie wprowadzić pożądane kryteria w panelu filtrów i kliknąć przycisk *Search*. Spowoduje to wyświetlenie na ekranie pojazdów spełniających pożądane kryteria.

#### 2.2.3 Przejrzenie szczegółów pojazdu

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/carprops.gif" width="600"/>

Aby przejrzeć informacje szczegółowe na temat pojazdów należy przejść do listy pojazdów (po kliknięciu *Car rental*), a następnie przy wybranym pojeździe z listy kliknąć przycisk *Properties*.

#### 2.2.4	Rezerwacja pojazdu

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/reserve1.gif" width="600"/>
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/reserve2.gif" width="600"/>

Zarezerwować pojazd może tylko zalogowany użytkownik. Aby zarezerwować pojazd należy wypełnić formularz znajdujący się na podstronie *Home* i kliknąć przycisk *Reserve*. Następnie należy wypełnić poszczególne podstrony formularza i na ostatniej wybrać *Reserve*. Pojazd można również zarezerwować poprzez kliknięcie przycisku *Reserve*, znajdującego się na podsterownie detali wybranego auta (użytkownik musi być zalogowany aby zobaczyć owy przycisk).

#### 2.2.5 Dodanie komentarza na temat pojazdu.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/comment.gif" width="600"/>

Aby dodać komentarz należy być zalogowanym. Komentarz wraz z liczbą gwiazdek można dodać na podstronie szczegółów danego pojazdu.

#### 2.2.6 Przejrzenie listy najlepszych ofert

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/bestoffers.gif" width="600"/>

Listę najlepszych ofert możemy wyświetlić po kliknięciu przycisku *Best offers* w menu.

#### 2.2.7 Przeczytanie informacji na temat firmy.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/aboutus.gif" width="600"/>

Informacje na temat firmy możemy przeczytać po kliknięciu przycisku *About us*.

#### 2.2.8 Uzyskanie danych kontaktowych firmy.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/contact.gif" width="600"/>

Dane kontaktowe firmy możemy wyświetlić po kliknięciu przycisku *Contact* w menu.

#### 2.2.9 Wysłanie e-maila do pracowników firmy.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/contactemail.gif" width="600"/>

Klient ma możliwość wysłania emaila do pracowników firmy poprzez formularz znajdujący się na podstronie *Contacts*.

#### 2.2.10 Utworzenie nowego konta.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/signup.gif" width="600"/>

Nowe konto możemy utworzyć poprzez kliknięcie przycisku *Sign up* i prawidłowe wypełnienie formularza.

#### 2.2.11 Zalogowanie się na istniejące konto.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/login.gif" width="600"/>

Aby zalogować się na istniejące konto należy kliknąć przycisk *Log in*, wpisać login i hasło, a następnie kliknąć przycisk *Sign in*.

#### 2.2.12 Wylogowanie się z konta użytkownika.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/logout1.gif" width="600"/>
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/logout2.gif" width="600"/>

Aby wylogować się z konta użytkownika należy kliknąć przycisk *Log out*, znajdujący się zarówno na głównej stronie internetowej jak i w panelu klienta.

## PANEL ADMINA - BOOKING
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/bookings_admin.gif" width="600"/>

#### 2.2.13 Przejrzenie listy wszystkich zamówień.

Listę wszystkich zamówień może przeglądać tylko użytkownik posiadający rolę Aby przejrzeć listę wszystkich zamówień należy przejść do panelu klienta i kliknąć przycisk *All bookings*.

#### 2.2.14 Pobranie pliku w formacie Excel zawierającego wszystkie zamówienia.
Aby pobrać plik Excel zawierający wszystkie zamówienia przechowywane w bazie należy przejść do panelu klienta, wybrać zakładkę „All bookings” , a następnie kliknąć niebieski przycisk *Download file*.

#### 2.2.15 Wyświetlenie listy wszystkich aktualnych rezerwacji.
Aby wyświetlić listę wszystkich aktualnych rezerwacji dokonanych przez użytkowników należy przejść do panelu klienta i kliknąc zakładkę *All reserved bookings*.

#### 2.2.16 Zmiana statusu rezerwacji na „Rented”
Użytkownik posiadający odpowiednie uprawnienia może zmienić status rezerwacji auta na *Rented*. Dzieje się to w momencie, gdy klient po zarezerwowaniu auta przychodzi po jego odbiór.

#### 2.2.17 Anulowanie rezerwacji przez pracownika.
Użytkownik posiadający odpowiednie uprawnienia może anulować dowolną rezerwację. Musi w tym celu przejść do panelu klienta i wybrać zakładkę *All reserved bookings*, a następnie kliknąć czerwony przycisk *Cancel*.

#### 2.2.18 Wyświetlenie listy wszystkich aktualnie wynajętych aut.
Aby wyświetlić listę wszystkich aktualnych wynajęć aut dokonanych przez użytkowników należy przejść do panelu klienta i kliknąc zakładkę *All rented bookings*.

#### 2.2.19 Zmiana stanu rezerwacji przez pracownika na „Returned” po zwróceniu auta przez klienta.
Użytkownik posiadający odpowiednie uprawnienia może zmienić status rezerwacji auta na „Returned”. Dzieje się to w momencie, gdy klient zwraca zarezerwowane auto.

## PANEL UŻYTKOWNIKA - BOOKING
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/bookings_client.gif" width="600"/>

#### 2.2.20 Wyświetlenie listy wszystkich dokonanych zamówień użytkownika.
Funkcjonalność ta jest udostępniona dla każdego zalogowanego użytkownika. Aby użytkownik mógł wyświetlić listę wszystkich dokonanych przez siebie zamówień musi przejść do panelu klienta i kliknąć zakładkę *My all bookings*.

#### 2.2.21 Wyświetlenie listy wszystkich rezerwacji użytkownika.
Funkcjonalność ta jest udostępniona dla każdego zalogowanego użytkownika. Aby użytkownik mógł wyświetlić listę wszystkich dokonanych przez siebie zamówień posiadających status *Reserved* musi przejść do panelu klienta i kliknąć zakładkę *My all rented bookings*.

#### 2.2.22 Odwołanie rezerwacji przez użytkownika.
Funkcjonalność ta jest udostępniona dla każdego zalogowanego użytkownika. Aby użytkownik mógł anulować dokonaną przez siebie rezerwację musi przejść do panelu klienta, kliknąć zakładkę *My all reserved bookings* i kliknąć czerwony przycisk *Cancel* przy rezerwacji którą chcemy anulować.

#### 2.2.23 Wyświetlenie listy wszystkich wynajętych rezerwacji przez użytkownika
Funkcjonalność ta jest udostępniona dla każdego zalogowanego użytkownika. Aby użytkownik mógł wyświetlić listę wszystkich swoich rezerwacji posiadających status "Rented" (wynajętych pojazdów) musi kliknąć w przycisk *My all rented bookings* znajdujący się w zakładce *Bookings*.

## PANEL ADMINA - USERS
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/users.gif" width="600"/>

#### 2.2.24 Wyświetlenie listy wszystkich użytkowników.
Aby wyświetlić listę wszystkich użytkowników należy kliknąć przycisk *Show* wewnątrz zakładki *Users* znajdującej się w panelu admina.

#### 2.2.25 Edycja użytkownika.
Aby edytować użytkownika, należy kliknąć przycisk *Edit* znajdujący się obok użytkownika, na liście użytkowników.

## PANEL ADMINA - CARS
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/cars.gif" width="600"/>

#### 2.2.26 Wyświetlenie listy wszystkich aut.
Aby wyświetlić listę wszystkich aut należy kliknąć zakładkę *Cars* a następnie zakładkę *Show cars*.

#### 2.2.27 Edycja danych pojazdu.
Aby edytować auto należy kliknąć przycisk *Edit* znajdujący się obok każdego pojazdu na liście pojazdów.

#### 2.2.28 Dodanie nowego pojazdu.
Aby dodać nowe auto należy kliknąć zakładkę *Cars*, a następnie zakładkę *Add car*.

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/addcar.gif" width="600"/>

## PANEL ADMINA - CARS EQUIPMENT
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/careqp.gif" width="600"/>

#### 2.2.29 Wyświetlenie listy wszystkich elementów wyposażenia pojazdu o danym ID.
Aby wyświetlić listę wszystkich elementów wyposażenia danego pojazdu, należy kliknąć przycisk *Car equipment list*, a następnie wpisać ID danego pojazdu.

#### 2.2.30 Dodanie nowego elementu wyposażenia do auta o danym ID.
Aby dodać nowy element wyposażenia do auta, należy wyświetlić listę jego wyposażenia, a następnie z selektora znajdującego się na dole podstrony wybrać pożądany element i kliknąć przycisk ADD.


#### 2.2.31 Usunięcie istniejącego elementu wyposażenia z auta o podanym ID.
Aby usunąć element wyposażenia z auta, należy wyświetlić listę jego wyposażenia, a następnie kliknąć przycisk *Delete*.

## PANEL ADMINA - EQUIPMENT
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/equipmentlist.gif" width="600"/>

#### 2.2.32 Wyświetlenie listy wszystkich istniejących elementów wyposażenia.
Aby wyświetlić listę wszystkich istniejących elementów wyposażenia należy kliknąć zakładkę *Cars*, a następnie *Equipment list*.

#### 2.2.33 Dodanie elementu wyposażenia do listy istniejących elementów.
Aby dodać element wyposażenia do listy wszystkich elementów wyposażenia, należy wyświetlić listę el. wyposażenia, podać nazwę i kod elementu i kliknąć przycisk *Add*.

#### 2.2.34 Usunięcie elementu wyposażenia z listy istniejących elementów.
Aby usunąć element wyposażenia z listy wszystkich elementów wyposażenia, należy wyświetlić listę el. wyposażenia, a następnie kliknąć przycisk *Delete* przy pożądanym elemencie z listy.

## PANEL ADMINA - USER ROLES
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/userrole.gif" width="600"/>

#### 2.2.35 Wyświetlenie listy użytkowników wraz z przypisanymi im rolami.
Aby wyświetlić listę użytkowników wraz z przypisanymi im rolami należy w panelu admina kliknąć zakładkę "User roles", a następnie *Show*.

#### 2.2.36 Dodanie dla danego użytkownika nowej roli.
Aby dodać dla danego użytkownika nową rolę, należy wyświetlić listę użytkowników wraz z przypisanymi im rolami, a następnie przy wybranym użytkowniku z listy kliknąć przycisk *Add role*. 

## PANEL UŻYTKOWNIKA - LOCATIONS

#### 2.2.37 Wyświetlenie listy lokalizacji wypożyczalni aut.
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/locations.gif" width="600"/>

Aby wyświetlić listę lokalizacji wypożyczalni aut należy kliknąć zakładkę *Locations*, a następnie zakładkę *Show*.

## PANEL ADMINA - EMAILS

#### 2.2.38 Wysłanie emaila do danego użytkownika.
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/emails.gif" width="600"/>

Aby wysłać email do danego użytkownika, należy w panelu admina kliknąć zakładkę *Send e-mail*, a następnie wybrać użytkownika z listy i kliknąć znajdujący się obok niego przycisk *Send*.

## PANEL UŻYTKOWNIKA - SETTINGS

#### 2.2.39 Zmiana ustawień konta.
<img src="https://github.com/kubabar1/readme_images_repository/blob/master/car_rental_images/settings.gif" width="600"/>

Aby zmienić ustawienia naszego konta, należy w panelu użytkownika kliknąć zakładkę *Settings*, a następnie wprowadzić zmiany i kliknąć przycisk *Edit*.





