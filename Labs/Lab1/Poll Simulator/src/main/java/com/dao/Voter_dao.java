package com.dao;
import java.util.*;
import java.util.stream.Collectors;

import com.bean.Voter_bean;

public class Voter_dao {
	static Set<Integer> si = new HashSet<>();
	static Map<String,Integer> setH;
	static Map<String,Integer> tm;
	public static boolean Voter_Id(Voter_bean v)
	{
		boolean flag=false;
		try {
			try{
				if(si.contains(v.getVoter_Number()))
				{
					return false;
				}
				else
				{
					si.add(v.getVoter_Number());
					flag=true;
				}
				
			}
			catch(Exception ex)
			{ex.printStackTrace();}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	 public static<K> void increment(Map<K, Integer> map, K key)
	    {
		 	
		   Integer count = map.get(key);
	        if (count == null) {
	            map.put(key, 1);
	        }
	        else {
	            map.put(key, count + 1);
	        } 
	    }
	 
	public static void Vote_Count(String name)
	{
        increment(Candidate_dao.mp, name);
	}
	
	
	public static <K, V> K getKeyFromValue(Map<K, V> map, Object value) 
    {
    
    Set<K> keys = map.keySet();
    
    for(K key : keys){
        
        if( map.get(key).equals(value) ){
            return key;
        }            
    }
    
    return null;        
}
	
	public static Map<String,Integer> High_Vote_Candidate()
	{
		setH = new HashMap<>();
		int value_ans=(Collections.max(Candidate_dao.mp.values()));
		String key_ans=getKeyFromValue(Candidate_dao.mp,value_ans);
		
		int maxValueInMap=(Collections.max(Candidate_dao.mp.values()));  
        int max2=0;
        for (Map.Entry<String, Integer> entry : Candidate_dao.mp.entrySet())
        {  
            if (entry.getValue()<maxValueInMap) {
                if(max2<entry.getValue())
                {
                    max2=entry.getValue();
                }     
            }
        }
        String ans=getKeyFromValue(Candidate_dao.mp,max2);
        setH.put(ans,Candidate_dao.mp.get(ans));
        setH.put(key_ans,value_ans);
        	
		return tm;
	}
}
