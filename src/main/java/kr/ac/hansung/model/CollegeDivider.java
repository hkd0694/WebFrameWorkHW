package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CollegeDivider {
	
	private String c_division;
	private int c_credit;
	
	public CollegeDivider() {
		
	}
	
	public CollegeDivider(String c_division, int c_credit) {
		super();
		this.c_division = c_division;
		this.c_credit = c_credit;
	}
	
	public String getC_division() {
		return c_division;
	}
	public void setC_division(String c_division) {
		this.c_division = c_division;
	}
	public int getC_credit() {
		return c_credit;
	}
	public void setC_credit(int c_credit) {
		this.c_credit = c_credit;
	}
	
	@Override
	public String toString() {
		return "CollegeDivider [c_division=" + c_division + ", c_credit=" + c_credit + "]";
	}

}
