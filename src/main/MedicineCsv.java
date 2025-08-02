/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.medicine_check.main;



/**
 *
 * @author nubah
 */
public class MedicineCsv {
import java.io.*;
import java.util.ArrayList;
import java.util.List;

   private List<Medicine> medicineList;
   public MedicineCsv(){
       medicineList = new ArrayList<>();
    }
   public void addMedicine(Medicine medicine) {
        medicineList.add(medicine);
        System.out.println("Medication added: " + medicine.getName());
    }
   public String generateCSV() {
        StringBuilder csv = new StringBuilder("Medicine,Dosage,Time\n"); // CSV header
        
        for (Medicine med : medicineList) {
            csv.append(med.getName()).append(",");
            csv.append(med.getDose()).append(",");
            csv.append(med.getTime()).append("\n");
        }
        return csv.toString();
    }public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(generateCSV());
            System.out.println("Saved to: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    medicineList.add(new Medicine(
                        data[0], 
                        data[1], 
                        data[2]));
                }
            }
            System.out.println("Loaded from the file: " + filename);
        } catch (IOException e) {
            System.out.println("Error loading the file: " + e.getMessage());
        }
    }
}
    
}
