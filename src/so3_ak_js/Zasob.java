/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so3_ak_js;

import java.util.Random;

/**
 *
 * @author Janek
 */
public class Zasob {
    int iloscStron = 40; //(uwaga:i tak wpisane na sztywno!)
    int liczbaOdwolan = 1500; //podzielna przez 20
    int liczbaBledow=0;
    Odwolanie[] ramki;
    Odwolanie[] odwolania = new Odwolanie[liczbaOdwolan];

    
    void generujCiagOdwolan() {
        Random rand = new Random();
        for (int i=0; i<75; i++){ //75 razy
           int starter = rand.nextInt(30)+1+5; //wylosuj punkt startowy z przedzialu 6-35
           for (int j=1; j<=20; j++){ // 20 razy
               int delta = rand.nextInt(11)-5;
              // System.out.println((i*20)+j-1); //TESTY
               odwolania[(i*20)+j-1] = new Odwolanie(starter + delta);
           } 
        }
       System.out.println("Wygenerowano ciag "+liczbaOdwolan+" odwolan do "+iloscStron+" stron.");
    }
    
    void wypiszOdwolania(){
       for (int i=0; i<1500; i++){
           System.out.println(odwolania[i].wartosc+" ");
       }
    }
    
    public void wykonajDlaIlosciRamek(int n){
        ramki = new Odwolanie[n];
        System.out.println("Bledy dla "+n+" ramek przy uzyciu algorytmu:");
        System.out.println(" - FIFO : "+FIFO());
        System.out.println(" - RAND : "+RAND()); 
        System.out.println(" - OPT : "+OPT()); 
        System.out.println(" - LRU : "+LRU()); 
        System.out.println(" - aLRU : "+aLRU());   
    }
        
    public void wypelnijPusteRamki(){
        for (int i=0; i<ramki.length; i++){
            ramki[i]=odwolania[i];
        }
    }
     
    public boolean czyJestWRamkach(Odwolanie o){
        boolean jestWRamkach=false;
        for (Odwolanie ramka : ramki) {
            if (ramka.wartosc == o.wartosc) {
                jestWRamkach=true;
            }
        }
        return jestWRamkach;
    }
    
    public int wKtorejJestRamce(Odwolanie o){
        int ramka = -1;
        for (int i=0; i<ramki.length; i++) {
            if (ramki[i].wartosc == o.wartosc) {
                ramka = i;
            }
        }
        return ramka;
    }
    
    public int FIFO(){
        liczbaBledow=0;
        wypelnijPusteRamki(); //wypelnij puste ramki pierwszymi odwolaniami        
        int indeksOstatnioUzytejRamki = ramki.length-1; //ustawiamy na ostatni
        for (int i=ramki.length; i<liczbaOdwolan; i++){    //dla kaĹĽdego odwolania
            if(!czyJestWRamkach(odwolania[i])){ //jeĹ›li odwolania nie ma w ramce
                liczbaBledow++;                 //policz bĹ‚Ä…d
                indeksOstatnioUzytejRamki++;
                indeksOstatnioUzytejRamki=indeksOstatnioUzytejRamki % ramki.length; 
                ramki[indeksOstatnioUzytejRamki]=odwolania[i];
            }
        }
        return liczbaBledow;
    }
    public int RAND(){
        liczbaBledow=0;
        wypelnijPusteRamki();
        for (int i=ramki.length; i<liczbaOdwolan; i++){    //dla kaĹĽdego odwolania
            if(!czyJestWRamkach(odwolania[i])){ //jeĹ›li odwolania nie ma w ramce
                liczbaBledow++;                 //policz bĹ‚Ä…d
                Random rand = new Random();
                ramki[rand.nextInt(ramki.length)]=odwolania[i];
                
            }
        }
        return liczbaBledow;
    }
    
    public int OPT(){
        liczbaBledow=0;
        wypelnijPusteRamki();
        for(int i=0; i<liczbaOdwolan; i++) {
            if(!czyJestWRamkach(odwolania[i])) {
                liczbaBledow++;
                ramki[najdluzejNieBedzieUzywana(i+1)] = odwolania[i];	//w miejsce tego, ktory wystapi najpozniej (szukamy przy pomocy dodatkowej metody) wstawimy nowa strone 
            }
        }

        
        return liczbaBledow;
    }
    public int najdluzejNieBedzieUzywana(int poczatek) { 
        //System.out.println("wywolano nnu");
        int indeksNNU = 0;                         //init indeks najdluzej nieuzywanej
        int wartoscNNU = 1;                         // init odleglosc (wartosc nnu)
        for (int i=0; i<ramki.length; i++){         //dla kazdej ramki
            int indOdwolania = poczatek;            //zaczynajac od poczatku
            int count = 0;                          // counter
            while (indOdwolania<liczbaOdwolan-1 && ramki[i].wartosc != odwolania[indOdwolania].wartosc) { //dopĂłki nie dojdziesz do wartoĹ›ci takiej, jak w ramce
                count++; //nabijaj licznik
                indOdwolania++; //idz dalej w odwolaniach
            } //a kiedy dojdziesz
            if (count > wartoscNNU){ //jesli ta ramka jest dluzej nieuzywana niz dotychczasone nnu
               // System.out.println("yo"+count);
                wartoscNNU = count;
                indeksNNU = i;
            }
        }
        return indeksNNU;
    }

    
    public int LRU(){
        liczbaBledow=0;
        wypelnijPusteRamki();
        for(int i=0; i<liczbaOdwolan; i++) {
            if(!czyJestWRamkach(odwolania[i])) {
                liczbaBledow++;
                ramki[najdluzejNieBylaUzywana(i)] = odwolania[i];	//w miejsce tego, ktory wystapi najpozniej (szukamy przy pomocy dodatkowej metody) wstawimy nowa strone 
            }
        }
        return liczbaBledow;
    }
         public int najdluzejNieBylaUzywana(int poczatek) { 
        //System.out.println("wywolano nnu");
        int indeksNNU = 0;                         //init indeks najdluzej nieuzywanej
        int wartoscNNU = 1;                         // init odleglosc (wartosc nnu)
        for (int i=0; i<ramki.length; i++){         //dla kazdej ramki
            int indOdwolania = poczatek;            //zaczynajac od poczatku
            int count = 0;                          // counter
            while (indOdwolania>=0 && ramki[i].wartosc != odwolania[indOdwolania].wartosc) { //dopĂłki nie dojdziesz do wartoĹ›ci takiej, jak w ramce
                count++; //nabijaj licznik
                indOdwolania--; //idz dalej w odwolaniach
            } //a kiedy dojdziesz
            if (count > wartoscNNU){ //jesli ta ramka  byla dluzej nieuzywana niz dotychczasone nnu
               // System.out.println("yo"+count);
                wartoscNNU = count;
                indeksNNU = i;
            }
        }
        return indeksNNU;
    }

        
    
    
   public int aLRU(){
        liczbaBledow=0;
                wypelnijPusteRamki();
        boolean znalezionoZerowa;
        //bit odniesienia jest 0 w kazdej stronie
        for (int i=ramki.length; i<liczbaOdwolan; i++){          //dla kaĹĽdego odwolania
            if (czyJestWRamkach(odwolania[i])){                   //jesli biezace odwolanie jest do strony, ktora juz jest w ramce
                ramki[wKtorejJestRamce(odwolania[i])].bitOdniesienia = 1; //nadaj tej stronie 1, zeby zaznaczyc, ze byla uzywana
            } else if(!czyJestWRamkach(odwolania[i])){            //jeĹ›li w ramkach nie ma takiej strony
                liczbaBledow++;       
                znalezionoZerowa = false; 
                for (int j=ramki.length; j<ramki.length; j++){    //przejdz przez bramki
                    if(ramki[j].bitOdniesienia == 0){             //jesli znajdziesz z zerem
                        znalezionoZerowa = true;                  //zaznacz to
                         ramki[j] = odwolania[i];                 //wrzuc tam odwolanie
                    }
                }
                if (znalezionoZerowa == false){
                    Random rand = new Random();
                   ramki[rand.nextInt(ramki.length)]=odwolania[i]; 
                 }

                
            }
        }
        return liczbaBledow;
    }

    
}
