package com.org.bank.model;

public class ResponseWithdrawAmount {
	private Integer NumberOfHundredNotes;
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

	public ResponseWithdrawAmount(Integer numberOfHundredNotes, Integer numberOfTWOThousandNotes) {
		super();
		NumberOfHundredNotes = numberOfHundredNotes;
		NumberOfTWOThousandNotes = numberOfTWOThousandNotes;
	}

}
