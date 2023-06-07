package sec02.ex01;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
	

	public void init(ServletConfig config) throws ServletException {
		memberDAO=new MemberDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage=null;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getPathInfo();
		if(action==null||action.equals("/listMembers.do")) {
			List<MemberVO> memberList=memberDAO.listMembers();
			request.setAttribute("membersList", memberList);
			nextPage="/test02/listMembers.jsp";
		}else if(action.equals("/addMember.do")) {
			
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		MemberVO memberVO=new MemberVO(id,pwd,name,email);
		memberDAO.addMember(memberVO);
		nextPage="/member/listMembers.do";
		
		}else if(action.equals("/memberForm.do")) {
			nextPage="/test02/MemberForm.jsp";
		}else {
			List<MemberVO> memberList=memberDAO.listMembers();
			request.setAttribute("membersList", memberList);
			nextPage="/test02/listMembers.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		}

}
