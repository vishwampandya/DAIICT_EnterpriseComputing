package com.servlets;

import java.io.*;
import java.util.*;

import javax.servlet.*;

import com.bean.*;
import com.dao.*;

@WebServlet("/Voting_Servlet")
public class Voting_Servlet extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int vote_no=Integer.parseInt(request.getParameter("vote_id"));
		String name=request.getParameter("vote");
		System.out.println(name);
		
		Voter_bean vb= new Voter_bean();
		vb.setVoter_Number(vote_no);
		Voter_dao vd= new Voter_dao();
			if(vd.Voter_Id(vb))
			{
				Voter_dao.Vote_Count(name);
				Voter_dao.High_Vote_Candidate();
				out.print("<p>Thanks for vote!</p>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else
			{
				out.println("already voted!!");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			
			
		}

}
