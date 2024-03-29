/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gergely.vajda
 */
public class FociEljaras {

    private List<FociAgy> jegyzokonyv;

    public List<FociAgy> getJegyzokonyv() {
        return jegyzokonyv;
    }

    public FociEljaras() {
        this.jegyzokonyv = new ArrayList<>();
    }

    public void betoltes() {
        try {
            FileReader buta = new FileReader("meccs.txt");
            BufferedReader okos = new BufferedReader(buta);
            Integer meret = Integer.parseInt(okos.readLine());
            String egysor;
            String[] nyers = new String[7];
            for (int i = 0; i < meret; i++) {
                egysor = okos.readLine();
                nyers = egysor.split(" ");
                FociAgy fa = new FociAgy(Integer.parseInt(nyers[0]), Integer.parseInt(nyers[1]), Integer.parseInt(nyers[2]), Integer.parseInt(nyers[3]), Integer.parseInt(nyers[4]), nyers[5], nyers[6]);
                jegyzokonyv.add(fa);
            }
            buta.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Nem található a file!");
        } catch (IOException ex) {
            System.out.println("Nem olvasható a file!");
        }
    }

    public void masodikFeladat() {
        System.out.println("-Második feladat-");
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem a forduló számát!");
        Integer forduloszam = sc.nextInt();
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            if (jegyzokonyv.get(i).getFordulo() == forduloszam) {
                System.out.println(jegyzokonyv.get(i).getHazai() + "-" + jegyzokonyv.get(i).getVendeg() + ": " + jegyzokonyv.get(i).getHazaiVege() + ":" + jegyzokonyv.get(i).getVendegVege() + " (" + jegyzokonyv.get(i).getHazaiFel() + ":" + jegyzokonyv.get(i).getVendegFel() + ")");
            }
        }
    }

    public void harmadikFeladat() {
        System.out.println("-Harmadik feladat-");
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            if (jegyzokonyv.get(i).getHazaiFel() < jegyzokonyv.get(i).getVendegFel() && jegyzokonyv.get(i).getHazaiVege() > jegyzokonyv.get(i).getVendegVege()) {
                System.out.println(jegyzokonyv.get(i).getFordulo() + " " + jegyzokonyv.get(i).getHazai());
            }
        }
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            if (jegyzokonyv.get(i).getHazaiFel() > jegyzokonyv.get(i).getVendegFel() && jegyzokonyv.get(i).getHazaiVege() < jegyzokonyv.get(i).getVendegVege()) {
                System.out.println(jegyzokonyv.get(i).getFordulo() + " " + jegyzokonyv.get(i).getVendeg());
            }
        }
    }

    public void negyOtHatFeladatok() {
        System.out.println("-Negyedik feladat-");
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem a csapat nevét!");
        String csapatnev = sc.nextLine();
        System.out.println("-Ötödik feladat-");
        Integer lott = 0;
        Integer kapott = 0;
        //hazaiként játszott meccsek gólstatisztikája
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            if (csapatnev.equals(jegyzokonyv.get(i).getHazai())) {
                lott = lott + jegyzokonyv.get(i).getHazaiVege();
                kapott = kapott + jegyzokonyv.get(i).getVendegVege();
            } else {
                lott = lott + jegyzokonyv.get(i).getVendegVege();
                kapott = kapott + jegyzokonyv.get(i).getHazaiVege();
            }
        }

        System.out.println("Lőtt: " + lott + " Kapott: " + kapott);
        System.out.println("-Hatodik feladat-");
        Integer legelsoFordulo = Integer.MAX_VALUE;
        String veroCsapat = "";
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            if (csapatnev.equals(jegyzokonyv.get(i).getHazai()) && jegyzokonyv.get(i).getHazaiVege() < jegyzokonyv.get(i).getVendegVege()) {
                if (jegyzokonyv.get(i).getFordulo() < legelsoFordulo) {
                    legelsoFordulo = jegyzokonyv.get(i).getFordulo();
                    veroCsapat = jegyzokonyv.get(i).getVendeg();
                }
            }
        }
        if (legelsoFordulo == Integer.MAX_VALUE) {
            System.out.println("A csapat otthon veretlen maradt.");
        } else {
            System.out.println("A(z) " + csapatnev + " csapatot a(z) " + legelsoFordulo + ". fordulóban a(z) " + veroCsapat + " verte meg először.");
        }

    }

    public void hetedikFeladat() {
        Integer[] stat = new Integer[100];
        Integer ideiglenes;
        for (int i = 0; i < 100; i++) {
            stat[i]=0;
        }
        //statisztika számolás
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            
            if (jegyzokonyv.get(i).getHazaiVege()>jegyzokonyv.get(i).getVendegVege()) {
                ideiglenes=(jegyzokonyv.get(i).getHazaiVege())*10+(jegyzokonyv.get(i).getVendegVege());
            }else{
            ideiglenes=(jegyzokonyv.get(i).getVendegVege())*10+(jegyzokonyv.get(i).getHazaiVege());
            }
            
            if (stat[ideiglenes]!=0) {
                stat[ideiglenes]++;
            }else {
                stat[ideiglenes]=1;
            }
        }
        
        try {
            FileWriter buta = new FileWriter("stat.txt");
            PrintWriter okos = new PrintWriter(buta);
            for (int i = 0; i < 100; i++) {
                if (stat[i]!=0) {
                    okos.println(i%10+"-"+i/10+" (vagy "+i/10+"-"+i%10+"): "+stat[i]+". darab");
                }
            }
            buta.close();

        } catch (IOException ex) {
            System.out.println("A file nem készíthető el!");
        }
    }

}
