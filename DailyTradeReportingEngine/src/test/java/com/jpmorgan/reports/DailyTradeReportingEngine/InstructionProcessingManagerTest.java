package com.jpmorgan.reports.DailyTradeReportingEngine;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.reports.DailyTradeReportingEngine.manager.InstructionProcessingManager;
import com.jpmorgan.reports.DailyTradeReportingEngine.model.Instruction;

public class InstructionProcessingManagerTest {

	private InstructionProcessingManager instructionProcessingManager;
	private List<Instruction> list = new ArrayList<>();
	
	@Before 
	public void setup() {
		instructionProcessingManager = new InstructionProcessingManager();
		
		Instruction i0 = new Instruction("foo", "B", new BigDecimal(0.50), "SGP", LocalDate.of(2018, Month.AUGUST, 1),
    			LocalDate.of(2018, Month.AUGUST, 4), 200, new BigDecimal(100.25), BigDecimal.ZERO) ;    	
    	Instruction i1 = new Instruction("bar", "S", new BigDecimal(0.22), "AED", LocalDate.of(2018, Month.AUGUST, 5), 
    			LocalDate.of(2018, Month.AUGUST, 7), 450, new BigDecimal(150.5), BigDecimal.ZERO) ;    	
    	Instruction i2 = new Instruction("i0", "B", new BigDecimal(0.50), "BYN", LocalDate.of(2018, Month.AUGUST, 9), 
    			LocalDate.of(2018, Month.AUGUST, 10), 750, new BigDecimal(90.75), BigDecimal.ZERO) ;
    	Instruction i3 = new Instruction("i1", "B", new BigDecimal(0.50), "SAR", LocalDate.of(2018, Month.AUGUST, 9), 
    			LocalDate.of(2018, Month.AUGUST, 10), 10000, new BigDecimal(90.75), BigDecimal.ZERO) ;
    	Instruction i4 = new Instruction("i1", "B", new BigDecimal(0.50), "AED", LocalDate.of(2018, Month.AUGUST, 10), 
    			LocalDate.of(2018, Month.AUGUST, 12), 10000, new BigDecimal(90.75), BigDecimal.ZERO) ;
    	Instruction i5 = new Instruction("i1", "B", new BigDecimal(0.50), "GBP", LocalDate.of(2018, Month.AUGUST, 10), 
    			LocalDate.of(2018, Month.AUGUST, 12), 10000, new BigDecimal(90.75), BigDecimal.ZERO) ;
		
    	list.add(i0);
    	list.add(i1);
    	list.add(i2);
    	list.add(i3);
		list.add(i4);
		list.add(i5);
	}
	
	@Test
	public void checkHoliday() {
		Assert.assertEquals(instructionProcessingManager.isHoliday(list.get(0)), true);		
	}
	
	@Test
	public void checkFriSatHoliday() {
		Assert.assertTrue(instructionProcessingManager.isHoliday(list.get(3)));
	}
	
	@Test
	public void checkFriSatNotHoliday() {
		Assert.assertFalse(instructionProcessingManager.isHoliday(list.get(2)));
	}
	
	@Test
	public void checkSundayHoliday() {
		Assert.assertTrue(instructionProcessingManager.isHoliday(list.get(5)));
	}
	
	@Test
	public void checkSundayNotHoliday() {
		Assert.assertFalse(instructionProcessingManager.isHoliday(list.get(4)));
	}
	
	@Test
	public void checkInstructionsForSundayDate() {
		List<Instruction>processedList = instructionProcessingManager.processInstructionsForADate(list, LocalDate.of(2018, Month.AUGUST, 12));
		Assert.assertEquals(1, processedList.size());
	}
	
	@Test
	public void checkInstructionsForEmptyDate() {
		List<Instruction>processedList = instructionProcessingManager.processInstructionsForADate(list, LocalDate.of(2018, Month.AUGUST, 13));
		Assert.assertEquals(0, processedList.size());
	}
	
	@Test
	public void checkInstructionsForFridayDate() {
		List<Instruction>processedList = instructionProcessingManager.processInstructionsForADate(list, LocalDate.of(2018, Month.AUGUST, 10));
		Assert.assertEquals(1, processedList.size());
	}
	
}
