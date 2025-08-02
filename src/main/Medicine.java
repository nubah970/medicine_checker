/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.medicine_check.main;

/**
 *
 * @author nubah
 */
public class Medicine {
   private  String name;
    private String dose;
    private String time;
    public Medicine(String name, String dose, String time) {
        this.name = name;
        this.dose = dose;
        this.time = time;
    }
    public String getName() { return name; }
    public String getDose() { return dose; }
    public String getTime() { return time; }
} 
}
