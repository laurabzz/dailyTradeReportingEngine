package com.jpmorgan.reports.DailyTradeReportingEngine.manager;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.reports.DailyTradeReportingEngine.model.Instruction;
import com.jpmorgan.reports.DailyTradeReportingEngine.util.Constants;

/**
 * A manager to process instructions for a given day
 * @author Laura Zebrauskaite
 *
 */
public class InstructionProcessingManager {
	
	public InstructionProcessingManager() {}
	
	public List <Instruction> processInstructionsForADate(List<Instruction> instructions, LocalDate date){

		List<Instruction> instructionsForDate = new ArrayList<>(instructions.size()) ;
		
		for (Instruction instruction : instructions) {
			if (instruction.getSettlementDate().equals(date))
				if (isHoliday(instruction)) {
					LocalDate settDate = instruction.getSettlementDate();
					instruction.setSettlementDate(settDate.plusDays(1));
				}else {
					instructionsForDate.add(instruction);
				}
		}

		return processInstructions(instructionsForDate);
	}

	private List<Instruction> processInstructions(List<Instruction> instructions) {

		for (Instruction instruction : instructions) {
			BigDecimal USDAmountOfTrade = processInstruction(instruction);
			instruction.setUSDAmountOfTrade(USDAmountOfTrade);
		}
		return instructions;
		
	}

	/**
	 * Processes an instruction
	 * @param instruction
	 * @return USD amount of trade
	 */
	private BigDecimal processInstruction(Instruction instruction) {

		BigDecimal usdAmountOfTrade = BigDecimal.ZERO;
		usdAmountOfTrade = instruction.getPricePerUnit().multiply(new BigDecimal(instruction.getUnits()));
		usdAmountOfTrade = usdAmountOfTrade.multiply(instruction.getAgreedFx());		
		
		return usdAmountOfTrade;
		
	}

	public Boolean isHoliday(Instruction instruction) {
		
		if (Constants.FRISATWEEKENDCURRENCIES.contains(instruction.getCurrency())) {
			return instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.FRIDAY) ||
					instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SATURDAY);
		} else {
			return instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
					instruction.getSettlementDate().getDayOfWeek().equals(DayOfWeek.SUNDAY) ;			
		}

	}
}
