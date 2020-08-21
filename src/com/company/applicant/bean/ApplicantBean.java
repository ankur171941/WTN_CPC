package com.company.applicant.bean;

public class ApplicantBean {
	private String applicant_id;
	private String applicant_name;
	private  int marks1;
	private  int marks2;
	private  int marks3;
	private String applicant_result;
	private String applicant_grade;
	public ApplicantBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getApplicant_Id() {
		return applicant_id;
	}
	public void setApplicant_Id(String Applicant_Id) {
		this.applicant_id = Applicant_Id;
	}
	public String getApplicant_Name() {
		return applicant_name;
	}
	public void setApplicant_Name(String name) {
		this.applicant_name = name;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int m1) {
		this.marks1 = m1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public String getApplicant_Result() {
		return applicant_result;
	}
	public void setApplicant_Result(String applicant_result) {
		this.applicant_result = applicant_result;
	}
	public String getApplicant_Grade() {
		return applicant_grade;
	}
	public void setApplicant_Grade(String applicant_grade) {
		this.applicant_grade = applicant_grade;
	}
	
}
