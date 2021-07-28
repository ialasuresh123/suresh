package com.org.bank.model;

public class ResponseWithdrawAmount {
	private Integer NumberOfHundredNotes;
	private Integer NumberOfFiveHundredNotes;
	private Integer NumberOfThousandNotes;

	private Integer NumberOfTWOThousandNotes;

	public Integer getNumberOfHundredNotes() {
		return NumberOfHundredNotes;
	}

	public void setNumberOfHundredNotes(Integer numberOfHundredNotes) {
		NumberOfHundredNotes = numberOfHundredNotes;
	}

	public Integer getNumberOfTWOThousandNotes() {
		return NumberOfTWOThousandNotes;
	}

	public void setNumberOfTWOThousandNotes(Integer numberOfTWOThousandNotes) {
		NumberOfTWOThousandNotes = numberOfTWOThousandNotes;
	}

	public Integer getNumberOfFiveHundredNotes() {
		return NumberOfFiveHundredNotes;
	}

	public void setNumberOfFiveHundredNotes(Integer numberOfFiveHundredNotes) {
		NumberOfFiveHundredNotes = numberOfFiveHundredNotes;
	}

	public Integer getNumberOfThousandNotes() {
		return NumberOfThousandNotes;
	}

	public void setNumberOfThousandNotes(Integer numberOfThousandNotes) {
		NumberOfThousandNotes = numberOfThousandNotes;
	}

	public ResponseWithdrawAmount(Integer numberOfHundredNotes, Integer numberOfFiveHundredNotes,
			Integer numberOfThousandNotes, Integer numberOfTWOThousandNotes) {
		super();
		NumberOfHundredNotes = numberOfHundredNotes;
		NumberOfFiveHundredNotes = numberOfFiveHundredNotes;
		NumberOfThousandNotes = numberOfThousandNotes;
		NumberOfTWOThousandNotes = numberOfTWOThousandNotes;
	}

	

}
