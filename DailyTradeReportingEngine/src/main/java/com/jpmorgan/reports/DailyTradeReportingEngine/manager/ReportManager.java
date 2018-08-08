package com.jpmorgan.reports.DailyTradeReportingEngine.manager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jpmorgan.reports.DailyTradeReportingEngine.model.Instruction;
import com.jpmorgan.reports.DailyTradeReportingEngine.util.Constants;

public class ReportManager {
	
	public ReportManager() {}

	/**
	 * Uses a helper method to calculate incoming and outgoing trade amount for the day
	 * @param instructions
	 * @param date
	 * @return formatted report
	 */
	public String buildReport(List<Instruction> instructions, LocalDate date) {
		
		StringBuilder report = new StringBuilder();
		Map<String,BigDecimal> results = calculateUSDTradeAmount(instructions);			
		report.append(String.format("Amount in USD settled incoming for %tF : %10.5f %n", date, results.get(Constants.INCOMING_AMOUNT)));
		report.append(String.format("Amount in USD settled outgoing for %tF : %10.5f %n", date, results.get(Constants.OUTGOING_AMOUNT)));
		
		return report.toString();
	}
	
	/**
	 * 
	 * @param instructions
	 * @return map with ingoing and outgoing payments
	 */
	private Map<String,BigDecimal> calculateUSDTradeAmount(List<Instruction> instructions) {		

		BigDecimal incomingAmount = BigDecimal.ZERO;
		BigDecimal outgoingAmount = BigDecimal.ZERO;
		
		for (Instruction instruction : instructions) {
			if (instruction.getBuySell().equals("B")) //put to constants
				incomingAmount = incomingAmount.add(instruction.getUSDAmountOfTrade());
			else
				outgoingAmount = outgoingAmount.add(instruction.getUSDAmountOfTrade());			
		}
		
		Map<String, BigDecimal> results = new HashMap<>();		
		results.put(Constants.INCOMING_AMOUNT, incomingAmount);
		results.put(Constants.OUTGOING_AMOUNT, outgoingAmount);
		
		return results;
		
	}
	
	public String generateRankingForDay(List<Instruction> instructions) {

		//sort list in descending order
		Comparator<Instruction> instructionComparator = Comparator.comparing(Instruction::getUSDAmountOfTrade, Comparator.reverseOrder());
		instructions.sort(instructionComparator);
		
		StringBuilder rankingString = new StringBuilder();
		rankingString.append("---------------------------------------------\n");

		rankingString.append("Ranking for ").append(instructions.get(0).getSettlementDate()).append(": \n");
		rankingString.append(String.format("%3s %23s %10s","Entity","Amount","Currency")).append("\n");
		
		int i = 1;
		for (Instruction instruction : instructions) {
			rankingString.append("|").append(i).append(". ").append(String.format("%5s",instruction.getEntity())).append("| ").append(String.format("%20.5f", instruction.getUSDAmountOfTrade()))
			.append(String.format("%10s", instruction.getCurrency())).append("\n");
			i++;
		}
		rankingString.append("---------------------------------------------\n\n");
		return rankingString.toString();
	}	
}
