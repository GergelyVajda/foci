/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        Integer lott1=0;
        Integer kapott1=0;
        Integer lott2=0;
        Integer kapott2=0;
        Integer osszlott=lott1+lott2;
        Integer osszkapott=kapott1+kapott2;
        //hazaként játszott meccsek gólstatisztikája
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            if (csapatnev==jegyzokonyv.get(i).getHazai()) {
                if (jegyzokonyv.get(i).getHazaiVege()>jegyzokonyv.get(i).getVendegVege()) {
                    lott1++;
                }
                if (jegyzokonyv.get(i).getHazaiVege()<jegyzokonyv.get(i).getVendegVege()) {
                    kapott1++;
                }
            }
        }
        //vendégként játszott meccsek gólstatisztikája
        for (int i = 0; i < jegyzokonyv.size(); i++) {
            if (csapatnev==jegyzokonyv.get(i).getVendeg()) {
                if (jegyzokonyv.get(i).getHazaiVege()>jegyzokonyv.get(i).getVendegVege()) {
                    lott2++;
                }
                if (jegyzokonyv.get(i).getHazaiVege()<jegyzokonyv.get(i).getVendegVege()) {
                    kapott2++;
                }
            }
        }
        System.out.println("Lőtt: "+osszlott+" Kapott: "+osszkapott);  
    }
}
