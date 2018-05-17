package Business;

import Acquaintance.ICPR;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goope
 */
public class CPR implements ICPR {
    private String CPRNumber;
    
    CPR (String CPRNumber) {
        this.CPRNumber = CPRNumber;
    }

    @Override
    public String getCprNumber() {
        return CPRNumber;
    }
   
    
//    /**
//     * For testing the valitate function
//     * @param args 
//     */
//    public static void main(String[] args) {
//        CPR c1 = new CPR("123456-4789");
//        CPR c2 = new CPR("123456-478");
//        CPR c3 = new CPR("12346-4789");
//        CPR c4 = new CPR("1k3456-4789");
//        CPR c5 = new CPR("123456-47i9");
//        CPR c6 = new CPR("123456.4789");
//        CPR c7 = new CPR("1234564789");
//        System.out.println(c1.getCprNumber() + "\t" +c1.validateCPR());
//        System.out.println(c2.getCprNumber() + "\t" +c2.validateCPR());
//        System.out.println(c3.getCprNumber() + "\t" +c3.validateCPR());
//        System.out.println(c4.getCprNumber() + "\t" +c4.validateCPR());
//        System.out.println(c5.getCprNumber() + "\t" +c5.validateCPR());
//        System.out.println(c6.getCprNumber() + "\t" +c6.validateCPR());
//        System.out.println(c7.getCprNumber() + "\t" +c7.validateCPR());
//    }
//    
//    
}
