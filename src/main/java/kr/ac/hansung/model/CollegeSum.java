package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CollegeSum {
	

	private int c_year;
	private int c_term;
	private int c_credit;
	
	public CollegeSum() {
		
	}
	
	public CollegeSum(int c_year, int c_term, int c_credit) {
		super();
		this.c_year = c_year;
		this.c_term = c_term;
		this.c_credit = c_credit;
	}
	

	@Override
	public String toString() {
		return "CollegeSum [c_year=" + c_year + ", c_term=" + c_term + ", c_credit=" + c_credit + "]";
	}
	public int getC_year() {
		return c_year;
	}
	public void setC_year(int c_year) {
		this.c_year = c_year;
	}
	public int getC_term() {
		return c_term;
	}
	public void setC_term(int c_term) {
		this.c_term = c_term;
	}
	public int getC_credit() {
		return c_credit;
	}
	public void setC_credit(int c_credit) {
		this.c_credit = c_credit;
	}
}
