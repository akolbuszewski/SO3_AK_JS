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
    
    Odwolanie[] odwolania = new Odwolanie[liczbaOdwolan];
    
   
    /*generuje zadana ilosc procesow i dodaje do listy */
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
        System.out.println("Błędy dla "+n+" ramek przy uzyciu algorytmu:");
        System.out.println(" - FIFO : "+FIFO(n));
        System.out.println(" - RAND : "+RAND(n)); 
        System.out.println(" - OPT : "+OPT(n)); 
        System.out.println(" - LRU : "+LRU(n)); 
        System.out.println(" - aLRU : "+aLRU(n));   
    }
    
    public int FIFO(int liczbaRamek){
        liczbaBledow=0;
        
        return liczbaBledow;
    }
    
    public int RAND(int liczbaRamek){
        liczbaBledow=0;
        
        return liczbaBledow;
    }
    
    public int OPT(int liczbaRamek){
        liczbaBledow=0;
        
        return liczbaBledow;
    }
    
    public int LRU(int liczbaRamek){
        liczbaBledow=0;
        
        return liczbaBledow;
    }
    
    
   public int aLRU(int liczbaRamek){
        liczbaBledow=0;
        return liczbaBledow;
    }

    
}
