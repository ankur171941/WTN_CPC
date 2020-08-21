package com.company.applicant.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ListIterator;

import com.company.applicant.dao.ApplicantDAO;
import com.company.applicant.util.DBUtil;
import com.company.applicant.util.WrongDataException;
import com.company.applicant.bean.ApplicantBean;


public class ApplicantMain {

	/**
	 * @param
	 */
	public String addApplicant(ApplicantBean studBean)
	{
		ApplicantDAO applicantDAO = new ApplicantDAO();
		String applicant_result="";
		String applicant_grade = "";
		int marks1=studBean.getMarks1();
		int marks2 = studBean.getMarks2();
		int marks3 = studBean.getMarks3();
		try {
            if (studBean == null || studBean.getApplicant_Name() == "" || studBean.getApplicant_Name().length() < 2 || studBean.getMarks1() < 0 || studBean.getMarks1() > 100 || studBean.getMarks2() < 0 || studBean.getMarks2() > 100 || studBean.getMarks3() < 0 || studBean.getMarks3() > 100) {
                throw new WrongDataException();
            }


        }
		catch(WrongDataException w){
		    w.toString();
        }

            studBean.setApplicant_Id(applicantDAO.generateApplicantId(studBean.getApplicant_Name()));
            int total=0;
            total =  marks1 + marks2 + marks3;
            if(total >=240) {
				studBean.setApplicant_Result("PASS");
				studBean.setApplicant_Grade("Distinction");
            }
            else if(total >=180 && total <240) {
				studBean.setApplicant_Result("PASS");
				studBean.setApplicant_Grade("First Class");
            }
            else if(total >=150 && total <180) {
				studBean.setApplicant_Result("PASS");
				studBean.setApplicant_Grade("Second Class");
            }
            else if(total >=105 && total <150) {

				studBean.setApplicant_Result("PASS");
				studBean.setApplicant_Grade("Third Class");
            }
            else if(total <105){
				studBean.setApplicant_Result("FAIL");
				studBean.setApplicant_Grade("No_Applicant_Grade");
            }
//            studBean.setApplicant_Result(applicant_result);
//            studBean.setApplicant_Grade(applicant_grade);
            String s = applicantDAO.addApplicant(studBean);
			if(s.equals("SUCCESS")) {
//				return studBean.getApplicant_Id() + ":" + applicant_result;
				applicant_result = applicant_result + studBean.getApplicant_Id() + ":" + studBean.getApplicant_Result();
			}
			else {
				applicant_result = "error";
			}
			return applicant_result;
	}
	public ArrayList<ApplicantBean> displayAll(String criteria)  {
		ApplicantDAO applicantDAO = new ApplicantDAO();
		ArrayList<ApplicantBean> applicantBeans;

			if (criteria.equals("PASS") || criteria.equals("FAIL") || criteria.equals("ALL")) {
				applicantBeans = applicantDAO.getByResult(criteria);
				return  applicantBeans;
			}

		else
		{
			try {
				throw new WrongDataException();
			}
			catch (WrongDataException w)
			{
				return null;
			}
		}

	}
	public static void main(String[] args) {
		ApplicantMain applicantMain = new ApplicantMain();
		ApplicantBean applicantBean = new ApplicantBean();
		ApplicantDAO applicantDAO = new ApplicantDAO();
		//Test case 1
		applicantMain.addApplicant(applicantBean);

		//Test Case 2
		applicantBean.setApplicant_Name("");
		applicantBean.setApplicant_Id("101");
		applicantBean.setMarks1(59);
		applicantBean.setMarks2(66);
		applicantBean.setMarks3(55);
		applicantMain.addApplicant(applicantBean);

		//Test Case 3
		applicantBean.setApplicant_Name("a");
		applicantBean.setApplicant_Id("102");
		applicantBean.setMarks1(59);
		applicantBean.setMarks2(66);
		applicantBean.setMarks3(55);
		applicantMain.addApplicant(applicantBean);

		//Test Case 4
		applicantBean.setApplicant_Name("ankutr");
		applicantBean.setApplicant_Id("103");
		applicantBean.setMarks1(140);
		applicantBean.setMarks2(30);
		applicantBean.setMarks3(-10);
		applicantMain.addApplicant(applicantBean);

		//Test Case 5
		applicantBean.setApplicant_Id(applicantDAO.generateApplicantId("ankur"));
		System.out.println(applicantBean.getApplicant_Id());

		//Test Case 6
		//PASS
		applicantBean.setApplicant_Name("anku");
		applicantBean.setApplicant_Id("106");
		applicantBean.setMarks1(59);
		applicantBean.setMarks2(66);
		applicantBean.setMarks3(55);
		applicantMain.addApplicant(applicantBean);
		System.out.println(applicantBean.getApplicant_Result() + ":" + applicantBean.getApplicant_Grade());
		//FAIL
		applicantBean.setApplicant_Name("anku");
		applicantBean.setApplicant_Id("106");
		applicantBean.setMarks1(10);
		applicantBean.setMarks2(20);
		applicantBean.setMarks3(4);
		applicantMain.addApplicant(applicantBean);
		System.out.println(applicantBean.getApplicant_Result() + ":" + applicantBean.getApplicant_Grade());
		//PASS
		applicantBean.setApplicant_Name("anku");
		applicantBean.setApplicant_Id("106");
		applicantBean.setMarks1(59);
		applicantBean.setMarks2(66);
		applicantBean.setMarks3(55);
		applicantMain.addApplicant(applicantBean);
		System.out.println(applicantBean.getApplicant_Result() + ":" + applicantBean.getApplicant_Grade());

		//Test Case 7
		ArrayList<ApplicantBean> all = new ArrayList<ApplicantBean>();
		System.out.println(all);

		//Test Case 8
		//PASS
		ArrayList<ApplicantBean> al1 = applicantMain.displayAll("PASS");
		System.out.println(al1.size());
		//FAIL
		ArrayList<ApplicantBean> al2 = applicantMain.displayAll("FAIL");
		System.out.println(al1.size());
		//ALL
		ArrayList<ApplicantBean> al3 = applicantMain.displayAll("ALL");
		System.out.println(al1.size());


	}

}
