/*
 *Zadanie pierwsze kursu Systemy Operacyjne, 2014 PWr
 * Aleksander Kolbuszewski, Janek Szynal  
 */

package so3_ak_js;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Janek
 */
public class Generator {
    int iloscStron = 40; //liczba podzielna przez 8
    int liczbaOdwolan = 1500; //podzielna przez 20
    
    Odwolanie[] odwolania = new Odwolanie[liczbaOdwolan];
    
    

    /*generuje zadana ilosc procesow i dodaje do listy */
    void generujCiagOdwolan() {
        Random rand = new Random();
        for (int i=1; i<=liczbaOdwolan/20; i++){ //75 razy
           int starter = rand.nextInt(iloscStron*(3/4))+1+(iloscStron/8); //wylosuj punkt startowy z przedzialu 6-35
           for (int j=1; j<=liczbaOdwolan/75; i++){ // 20 razy
               int delta = rand.nextInt(11)-5;
               odwolania[j*i] = new Odwolanie(starter + delta);
           } 
        }
     
    }
    
}
