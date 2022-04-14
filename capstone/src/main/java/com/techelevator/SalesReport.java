package com.techelevator;
import com.techelevator.TextBasedVendingMachine;

//Provide a "Hidden" menu option on the main menu ("4") that writes to a sales report that shows the total sales
// since the machine was started. The name of the file must include the date and time so each sales report is uniquely named.
//An example of the output format is provided below.

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;


public class SalesReport {


    Date date = new Date() ;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    File reportFile = new File("salesReports/" + dateFormat.format(date) + ".txt");

    public SalesReport() {

    }


    //report generator
    public void generateReport(Map<String, Integer> salesReportMap) {

        try (PrintWriter salesReport = new PrintWriter(new FileOutputStream(reportFile, true))){
            //iterate through the map and get all of the values

            for(Map.Entry<String, Integer> i : salesReportMap.entrySet()){
                salesReport.println(i.getKey() + " | " + i.getValue());
            }



        } catch (FileNotFoundException e){
            System.err.println("Cannot open logFile for writing");
        }

    }

    //report reader
    public void readReport(){

        File folder = new File("salesReports/"); //path to the folder
        String[] filesPresent = folder.list(); //makes an array of the files in that folder

        //make sure there are files in that folder
        if(filesPresent.length==0){
            System.out.println("Nothing to see here");

        }else{
            for(String fileName : filesPresent){  // loop through files in the directory

                File fileToRead = new File("salesReports/" + fileName);
                Scanner fileReader;
                try{
                    fileReader = new Scanner(fileToRead);
                    System.out.println("\n" + fileName); //print name of the file

                    while(fileReader.hasNextLine()){
                        String lineOfText = fileReader.nextLine();
                        System.out.println(lineOfText); //print what's inside the file line by line
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Inventory file not found");
                }
            }
        }

        salesReportNavigation();

    }

    public void salesReportNavigation(){
        //navigation
        TextBasedVendingMachine vendingMachine = new TextBasedVendingMachine();

        System.out.println("\nPress 1 to go back to the main menu");
        System.out.println("Press 2 to exit");

        Scanner navigationInput = new Scanner(System.in);
        String navigationSelection = navigationInput.nextLine();

        if(navigationSelection.equals("1")){
            vendingMachine.mainMenu();
        } else if(navigationSelection.equals("2")){
            System.out.println("*** Thank you for using the Vending Machine ***");
            System.exit(0);
        } else {
            System.out.println("Please enter 1 or 2");
            salesReportNavigation();
        }

    }


}
