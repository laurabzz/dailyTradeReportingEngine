package com.jpmorgan.reports.DailyTradeReportingEngine.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jpmorgan.reports.DailyTradeReportingEngine.model.Instruction;

public class TestData {

	public static List<Instruction> create(){
		Instruction i0 = new Instruction("foo", "B", new BigDecimal(0.50), "SGP", LocalDate.of(2018, Month.AUGUST, 1),
    			LocalDate.of(2018, Month.AUGUST, 2), 200, new BigDecimal(100.25), BigDecimal.ZERO) ;    	
    	Instruction i1 = new Instruction("bar", "S", new BigDecimal(0.22), "AED", LocalDate.of(2018, Month.AUGUST, 5), 
    			LocalDate.of(2018, Month.AUGUST, 7), 450, new BigDecimal(150.5), BigDecimal.ZERO) ;    	
    	Instruction i2 = new Instruction("i0", "B", new BigDecimal(0.50), "BYN", LocalDate.of(2018, Month.AUGUST, 15), 
    			LocalDate.of(2018, Month.AUGUST, 4), 750, new BigDecimal(90.75), BigDecimal.ZERO) ;
    	Instruction i3 = new Instruction("i1", "B", new BigDecimal(0.50), "BYN", LocalDate.of(2018, Month.AUGUST, 15), 
    			LocalDate.of(2018, Month.AUGUST, 4), 10000, new BigDecimal(90.75), BigDecimal.ZERO) ;
    	Instruction i4 = new Instruction("i2", "B", new BigDecimal(0.50), "AED", LocalDate.of(2018, Month.AUGUST, 10), 
    			LocalDate.of(2018, Month.AUGUST, 12), 10000, new BigDecimal(1000.75), BigDecimal.ZERO) ;
    	Instruction i5 = new Instruction("i3", "B", new BigDecimal(0.50), "GBP", LocalDate.of(2018, Month.AUGUST, 10), 
    			LocalDate.of(2018, Month.AUGUST, 12), 10000, new BigDecimal(0.75), BigDecimal.ZERO) ;
    	Instruction i6 = new Instruction("i4", "S", new BigDecimal(0.50), "BYN", LocalDate.of(2018, Month.AUGUST, 15), 
    			LocalDate.of(2018, Month.AUGUST, 4), 10000, new BigDecimal(9.75), BigDecimal.ZERO) ;
    	Instruction i7 = new Instruction("i5", "B", new BigDecimal(0.50), "AED", LocalDate.of(2018, Month.AUGUST, 15), 
    			LocalDate.of(2018, Month.AUGUST, 4), 10000, new BigDecimal(700), BigDecimal.ZERO) ;
    	Instruction i8 = new Instruction("i6", "B", new BigDecimal(0.50), "BYN", LocalDate.of(2018, Month.AUGUST, 15), 
    			LocalDate.of(2018, Month.AUGUST, 4), 10000, new BigDecimal(10), BigDecimal.ZERO) ;

		List<Instruction> list = new ArrayList<>(Arrays.asList(i0,i1,i2,i3,i4,i5,i6,i7,i8));
    	
    	return list;
	}
}
