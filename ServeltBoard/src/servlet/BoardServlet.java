package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BoardDao;
import bean.BoardVo;
import bean.Page;

@WebServlet(urlPatterns = "/board.do")
public class BoardServlet extends HttpServlet{
	//사용자의 요청 처리를 응답할 페이지
	String url = "index.jsp?inc=./board/board_";
	
	// 응답정ㅂ와 응답대상을 저장하여 전송할 객체
	RequestDispatcher dispatcher;
	
	// 요청처리를 실제로 처리하여 결과를 반환하는 객체
	BoardDao dao;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청정보에 한글이 있는 경우 한글 인코딩
		req.setCharacterEncoding("utf-8");
		
		// 응답정보에 한글이 있는 경우 한글 처리
		resp.setContentType("text/html;charset=utf-8");
		
		String job = req.getParameter("job");
		if(job==null) job = "list"; //default
		
		//servlet에서 html 문서를 출력하고자 할 때
		PrintWriter out = resp.getWriter();
		
		BoardVo vo = null; 
		Map<String, Object> map = null;
		String msg = ""; // 처리 결과 메시지 저장
		int serial = 0; 
		
		Page page = new Page();
		
		if(req.getParameter("findStr") != null) {
			page.setFindStr(req.getParameter("findStr"));
		}
		
		if(req.getParameter("nowPage") != null) {
			page.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		//페이징 정보를 공통으로 사용하기 위해 req에 저장
		req.setAttribute("page", page);
		
		dao = new BoardDao(); // 요청된 정보를 처리하기 위해 객체 생성
		
		// 파라메터 job을 구분하여 요청처리
		switch(job) {
		case "":
		case "list" :
			map = dao.select(page);
			
			req.setAttribute("list", (List<BoardVo>)map.get("list"));
			req.setAttribute("page", (Page)map.get("page"));
			
			
			//String url = "index.jsp?inc=./board/board_";
			dispatcher = req.getRequestDispatcher(url + "list.jsp");
			dispatcher.forward(req, resp);
			
			
			break;
		
		}
		
		
		
	}

}






















