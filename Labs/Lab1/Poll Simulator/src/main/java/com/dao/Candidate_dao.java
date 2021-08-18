package com.dao;

import java.util.*;
import com.bean.Candidate_bean;

public class Candidate_dao {
	public static List<String> ls = new ArrayList<>();
	public static Map<String,Integer> mp=new HashMap<>();
	public static boolean save(Candidate_bean c)
	{
		boolean flag=false;
		try {
			try{
				ls.add(c.getCandidate_name());
				flag=true;
			}
			catch(Exception ex)
			{ex.printStackTrace();}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static List<String> getAllCandidateList(){
		return ls;
	}

}
