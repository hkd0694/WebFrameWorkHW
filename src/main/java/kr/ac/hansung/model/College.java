package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class College {
	
	private int num;
	private int c_year;
	private int c_term;
	private String c_code;
	private String c_subject;
	private String c_division;
	private int c_credit;
	
	public College() {
		
	}

	public College(int num,int c_year, int c_term, String c_code, String c_subject, String c_division, int c_credit) {
		super();
		this.num = num;
		this.c_year = c_year;
		this.c_term = c_term;
		this.c_code = c_code;
		this.c_subject = c_subject;
		this.c_division = c_division;
		this.c_credit = c_credit;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_subject() {
		return c_subject;
	}

	public void setC_subject(String c_subject) {
		this.c_subject = c_subject;
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
		return "College [num=" + num + ", c_year=" + c_year + ", c_term=" + c_term + ", c_code=" + c_code
				+ ", c_subject=" + c_subject + ", c_division=" + c_division + ", c_credit=" + c_credit + "]";
	}
	
	
}
