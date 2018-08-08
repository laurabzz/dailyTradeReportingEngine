package com.jpmorgan.reports.DailyTradeReportingEngine.manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jpmorgan.reports.DailyTradeReportingEngine.model.Instruction;

/**
 * Note: the class is not currently used but could be used as another way to sort the list of instructions
 * Manager to sort instructions into a hashmap by date
 * @author Laura Zebrauskaite
 *
 */
public class DataProcessingManager {
	
	public DataProcessingManager() {}
	
	public HashMap<LocalDate, List<Instruction>> sortInstructionsByDate(List<Instruction> allInstructions){
		
		HashMap<LocalDate, List<Instruction>> sortedInstructions = new HashMap<LocalDate, List<Instruction>>();
		
		for (Instruction instruction : allInstructions) {			
			if (!sortedInstructions.containsKey(instruction.getSettlementDate())) 
				sortedInstructions.put(instruction.getSettlementDate(), new ArrayList<Instruction>());
			
			sortedInstructions.get(instruction.getSettlementDate()).add(instruction);
		}
		
		return sortedInstructions;
	}
	
}
