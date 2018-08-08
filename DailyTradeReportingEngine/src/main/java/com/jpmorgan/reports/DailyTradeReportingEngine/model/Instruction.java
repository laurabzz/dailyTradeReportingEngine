package com.jpmorgan.reports.DailyTradeReportingEngine.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 
 * @author Laura Zebrauskaite
 *
 */
public class Instruction {
	
	private String entity;
	private String buySell;
	private BigDecimal agreedFx;
	private String currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private Integer units;
	private BigDecimal pricePerUnit;
	private BigDecimal USDAmountOfTrade;
	
	public Instruction(String entity, String buySell, BigDecimal agreedFx, String currency, LocalDate instructionDate,
			LocalDate settlementDate, Integer units, BigDecimal pricePerUnit, BigDecimal USDAmountOfTrade) {
		super();
		this.entity = entity;
		this.buySell = buySell;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
		this.USDAmountOfTrade = USDAmountOfTrade;
	}
	
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getUSDAmountOfTrade() {
		return USDAmountOfTrade;
	}

	public void setUSDAmountOfTrade(BigDecimal USDAmountOfTrade) {
		this.USDAmountOfTrade = USDAmountOfTrade;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Instruction that = (Instruction) o;
		return Objects.equals(entity, that.entity) &&
				Objects.equals(buySell, that.buySell) &&
				Objects.equals(agreedFx, that.agreedFx) &&
				Objects.equals(currency, that.currency) &&
				Objects.equals(instructionDate, that.instructionDate) &&
				Objects.equals(settlementDate, that.settlementDate) &&
				Objects.equals(units, that.units) &&
				Objects.equals(pricePerUnit, that.pricePerUnit) &&
				Objects.equals(USDAmountOfTrade, that.USDAmountOfTrade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(entity, buySell, agreedFx, currency, instructionDate, settlementDate, units, pricePerUnit, USDAmountOfTrade);
	}

	@Override
	public String toString() {
		return "Instruction [entity=" + entity + ", buySell=" + buySell + ", agreedFx=" + agreedFx + ", currency="
				+ currency + ", instructionDate=" + instructionDate + ", settlementDate=" + settlementDate + ", units="
				+ units + ", pricePerUnit=" + pricePerUnit + ", USDAmountOfTrade=" + USDAmountOfTrade + "]";
	}
}
