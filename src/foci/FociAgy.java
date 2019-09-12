/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foci;

/**
 *
 * @author gergely.vajda
 */
public class FociAgy {

    private Integer fordulo;
    private Integer hazaiVege;
    private Integer vendegVege;
    private Integer hazaiFel;
    private Integer vendegFel;
    private String hazai;
    private String vendeg;

    public Integer getFordulo() {
        return fordulo;
    }

    public Integer getHazaiVege() {
        return hazaiVege;
    }

    public Integer getVendegVege() {
        return vendegVege;
    }

    public Integer getHazaiFel() {
        return hazaiFel;
    }

    public Integer getVendegFel() {
        return vendegFel;
    }

    public String getHazai() {
        return hazai;
    }

    public String getVendeg() {
        return vendeg;
    }

    public FociAgy(Integer fordulo, Integer hazaiVege, Integer vendegVege, Integer hazaiFel, Integer vendegFel, String hazai, String vendeg) {
        this.fordulo = fordulo;
        this.hazaiVege = hazaiVege;
        this.vendegVege = vendegVege;
        this.hazaiFel = hazaiFel;
        this.vendegFel = vendegFel;
        this.hazai = hazai;
        this.vendeg = vendeg;
    }

    @Override
    public String toString() {
        return fordulo + " " + hazaiVege + " " + vendegVege + " " + hazaiFel + " " + vendegFel + " " + hazai + " " + vendeg;
    }
    
    
    
    
            
    
    
}
