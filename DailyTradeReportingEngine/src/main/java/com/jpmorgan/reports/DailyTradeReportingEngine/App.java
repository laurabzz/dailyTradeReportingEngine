package com.jpmorgan.reports.DailyTradeReportingEngine;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.jpmorgan.reports.DailyTradeReportingEngine.manager.InstructionProcessingManager;
import com.jpmorgan.reports.DailyTradeReportingEngine.manager.ReportManager;
import com.jpmorgan.reports.DailyTradeReportingEngine.model.Instruction;
import com.jpmorgan.reports.DailyTradeReportingEngine.util.TestData;

/**
 * A simple trade reporting app.
 * 
 */
public class App {
    public static void main( String[] args ) {

    	//setting up managers and generating the test data
		InstructionProcessingManager instructionProcessingManager = new InstructionProcessingManager();
        ReportManager reportManager = new ReportManager();        
        
        List<Instruction> list = TestData.create();
        List<Instruction> processedInstructions;
    	
        /**
         * The loop here is for the display purposes.
         * It is assumed that the report will need to be generated for a specific day which will negate the need for a loop. 
         * If the list will always contain multiple dates, the HashMap would be a better option for data retrieval
         * (see DataProcessingManager.java for example)
         * 
         * Iterating through a list every day is not ideal for optimisation - a solution that would fit 
         * more defined requirements would need to be revised.
         */
    	for (LocalDate date = LocalDate.of(2018, Month.AUGUST, 1); date.isBefore(LocalDate.of(2018, Month.AUGUST, 31)); date = date.plusDays(1)) {
    		processedInstructions = instructionProcessingManager.processInstructionsForADate(list, date);
    		
    		if (!processedInstructions.isEmpty()) {
    			System.out.println(reportManager.buildReport(processedInstructions, date)); 
    			System.out.println(reportManager.generateRankingForDay(processedInstructions));
    		}
        
    	}
        
        
    }
}
