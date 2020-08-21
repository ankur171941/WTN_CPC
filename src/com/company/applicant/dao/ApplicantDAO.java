package com.company.applicant.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.applicant.bean.ApplicantBean;
import com.company.applicant.util.DBUtil;

public class ApplicantDAO {
	public String addApplicant(ApplicantBean studentBean)
	{
			String status="";
			try
            {
                Connection con = DBUtil.getConn();
                String query = "insert into applicant_tbl values(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,studentBean.getApplicant_Id());
                ps.setString(2,studentBean.getApplicant_Name());
                ps.setInt(3,studentBean.getMarks1());
                ps.setInt(4,studentBean.getMarks2());
                ps.setInt(5,studentBean.getMarks3());
                ps.setString(6,studentBean.getApplicant_Result());
                ps.setString(7,studentBean.getApplicant_Grade());
                if(ps.executeQuery()!=null)
                {
                    status = "SUCCESS";
                }
                else {
                    status = "FAIL";
                }
            }
			catch(Exception e) {
			    status = "FAIL";
            }


					return status;
	}
	
	public ArrayList<ApplicantBean> getByResult(String criteria)
	{
		ArrayList<ApplicantBean> ar=new ArrayList<ApplicantBean>();
        ResultSet r =null;
        PreparedStatement ps = null;
        try {
            Connection con = DBUtil.getConn();
            String query = "select * from applicant_tbl where applicant_result=? or applicant_result=?";
            ps = con.prepareStatement(query);
            if(criteria == "PASS") {
                ps.setString(1, "PASS");
                ps.setString(2, "pass");
                r = ps.executeQuery();
            }
            else if(criteria == "FAIL") {
                ps.setString(1, "FAIL");
                ps.setString(2, "fail");
                r = ps.executeQuery();

            }
            else if(criteria == "ALL")
            {
                ps = con.prepareStatement("select * from applicant_tbl");
            }
            else {
                return null;
            }
            while(r.next()) {
                ApplicantBean ab = new ApplicantBean();
                ab.setApplicant_Id(r.getString(1));
                ab.setApplicant_Name(r.getString(2));
                ab.setMarks1(r.getInt(3));
                ab.setMarks2(r.getInt(4));
                ab.setMarks3(r.getInt(5));
                ab.setApplicant_Result(r.getString(6));
                ab.setApplicant_Grade(r.getString(7));

            }
        }
        catch(Exception e) {
            return null;
        }
		return ar;
	}
	public String generateApplicantId (String applicant_name)
	{
	    String id = applicant_name.substring(0, 2);
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int num =0;
	    try {
	        Connection con = DBUtil.getConn();
	        String query = "select APPLICANT_SEQ.nextval from dual";
	        ps = con.prepareStatement(query);
	        rs = ps.executeQuery();
	        if(rs.next())
            {
                num = rs.getInt(1);

            }
        }
	    catch (Exception e)
        {

        }
	    id = id + String.valueOf(num);
		return null;
	}
}
