package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청 정보와 응답 정보 설정
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 출력 객체
		PrintWriter out = resp.getWriter(); // <% out.print() %>
		
		// 세션 객체
		HttpSession session = req.getSession();
		
		// 파라메터
		String job = req.getParameter("job");
		
		if(job.contentEquals("login")) {
			String mid = req.getParameter("mid");
			String pwd = req.getParameter("pwd");
			
			session.setAttribute("mid", mid);
			
			out.print("<script>");
			out.print("   alert('반갑습니다. 좋은 하루 되세요~');  ");
			out.print("   location.href = 'index.jsp';     ");
			out.print("</script>");
			
		}else if(job.contentEquals("logout")) {
			
			session.removeAttribute("mid");
			
			out.print("<script>");
			out.print("   alert('다음에 다시 만나요~');  ");
			out.print("   location.href = 'index.jsp';     ");
			out.print("</script>");
		}
	}
	
}










