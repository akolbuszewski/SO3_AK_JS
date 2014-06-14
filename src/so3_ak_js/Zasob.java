/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so3_ak_js;

import java.io.FileNotFoundException;
import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Janek
 */
public class Zasob {
    int iloscStron = 40; //(uwaga:i tak wpisane na sztywno!)
    int liczbaOdwolan = 1500; //podzielna przez 20
    
    Odwolanie[] odwolania = new Odwolanie[liczbaOdwolan];
    
   
    /*generuje zadana ilosc procesow i dodaje do listy */
    void generujCiagOdwolan() {
        Random rand = new Random();
        for (int i=0; i<75; i++){ //75 razy
           int starter = rand.nextInt(30)+1+5; //wylosuj punkt startowy z przedzialu 6-35
           for (int j=1; j<=20; j++){ // 20 razy
               int delta = rand.nextInt(11)-5;
               System.out.println((i*20)+j-1);
               odwolania[(i*20)+j-1] = new Odwolanie(starter + delta);
           } 
        }
     
    }
    
    void wypiszOdwolania(){
       for (int i=0; i<1500; i++){
           System.out.println(odwolania[i].wartosc+" ");
       }
    }
    
    
    public void FCFS (ArrayList<Odwolanie> procesy){
//        ArrayList<Odwolanie> backupProcesy = procesy;
//        procesy.get(0).momentWejscia=procesy.get(0).momentZgloszenia;  //ponieważ  w pętli odnosimy się do poprzedniego elementu dla każdego elementu,
//        procesy.get(0).czasOczekiwania = 0;                           //musimy najpierw ustawić ręcznie wartosc dla zerowego    
//        for (int i=1; i<procesy.size(); i++){                          //i zacząć pętlę dla pierwszego
//            procesy.get(i).momentWejscia=Math.max(((procesy.get(i-1).momentWejscia)+(procesy.get(i-1).dlugoscFazy)),procesy.get(i).momentZgloszenia);
//            procesy.get(i).czasOczekiwania=procesy.get(i).momentWejscia-procesy.get(i).momentZgloszenia;
//        }
//        //zsumowanie wyników
//        System.out.println("Dla algorytmu FIFO: "+wyliczSredniCzas(procesy)); 
//        procesy = backupProcesy;
//        for (Odwolanie pro : procesy){
//            pro.odswiez();
//        }
    }

    
}
