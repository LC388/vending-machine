package com.techelevator;

import com.techelevator.caught.SelectionException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MachineAuditTest extends TestCase {
    MachineAudit testMachine = new MachineAudit();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    //format the date and time
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    LocalDateTime now = LocalDateTime.now();

    //test all of these

    @Test
    public void testLogFeedMoney(){

        //can't make it throw an exception becuase this class always creates a new file
        //we'd just be testing whether the built in exception works
        //test for ?

    }

    public void testLogValidItemSelected() {
    }

    public void testLogChangeGiven() {
    }
}