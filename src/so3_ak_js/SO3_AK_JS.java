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
        zas.generujCiagOdwolan();
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Dla ilu różnych ilosci ramek chcesz przetestować algorytmy?");
        int[] tab = new int[scn.nextInt()];
        
        System.out.println("Podaj kolejne wartosci ilosci ramek, potwierdzajac enterem");
        for (int i=0; i<tab.length; i++){
            tab[i]=scn.nextInt();
        }
        //pętla 123 456 789
        for (int i=0; i<tab.length; i++){
            zas.wykonajDlaIlosciRamek(tab[i]);
        }
        
    }
    
    

    
}
