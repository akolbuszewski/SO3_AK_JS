/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so3_ak_js;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Janek
 */
public class SO3_AK_JS {

   
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Zasob zas = new Zasob();
        startMenu(zas.zPliku());
       
    }
    
    private static void startMenu(ArrayList<Odwolanie> procesy) throws FileNotFoundException{
            System.out.println("* * *");
            System.out.println("Wybierz naciskajac klawisz cyfry, a nastepnie potwierdź enterem:");
            System.out.println("1 - Wyświetl listę procesów");
            System.out.println("2 - Wczytaj nową listę procesów");
            System.out.println("3 - Przedstaw statystyki");
            System.out.println("4 - Zakończ");

            //MENU
            Scanner scn = new Scanner(System.in);

            switch (scn.nextInt()) {
            case 1: 
                    int momentZgloszenia=0;
                    for (Odwolanie p : procesy){
                        p.wypisz();                      
                    }
                    System.out.println("ilosc procesow = "+procesy.size());
                    startMenu(procesy);
                    break;
            case 2:
                    Zasob zas = new Zasob();
                    startMenu(zas.zPliku());
                    break;

            case 3:
                    Zasob zas2 = new Zasob();   

                    System.out.println("Podaj kwant czasu dla algorytmu rotacyjnego: ");
                    //zas2.runAlgs(procesy, scn.nextInt());
               
                    zas2.RR(procesy, scn.nextInt());
                    zas2.SJFW(procesy);
                    zas2.SJF(procesy);
                    zas2.FCFS(procesy);

                    startMenu(procesy);
                    break;
            
            case 4:
    
                    break;
            }

        }

    
}
