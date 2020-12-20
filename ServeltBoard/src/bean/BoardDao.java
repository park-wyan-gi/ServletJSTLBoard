package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDao {
	Connection conn;
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// 파일이 업로드되는 경로
	static String uploadPath = "C:\\Users\\pwg\\workspace-202006\\ServeltBoard\\WebContent\\upload\\";
	
	public BoardDao() {
		conn = new DBConn("it_travel", "1111").getConn();
	}
	
	// nowPage와 findStr 정보를 사용하여 Page 클래스의 필드값 계산
	public Page reSetPage(Page p) {
		try {
			sql = "select count(serial) totList from board where subject like ? or content like ? ";
			ps = conn.prepareStatement(sql);
			ps.setNString(1, "%" + p.getFindStr() + "%");
			ps.setNString(2, "%" + p.getFindStr() + "%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int totList = rs.getInt("totList");
				p.setTotListSize(totList);
				p.pageCompute();
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return p;
		}
		
	}
	public Map<String, Object> select(Page page){
		Map<String, Object> map = new HashMap<String, Object>();
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		page = reSetPage(page);
		char mode = 's';
		
		try {
			sql =   " select * from ("
			    +   "    select rownum rno, a.* from ( "
				+   "      select serial, mdate, worker, "
				+   "           lpad(' ', (level-1)*12+1, '&nbsp;&nbsp;') || subject  subject, "
				+	"           (select count(serial) from boardAtt att where att.pserial = b.serial) attCnt, "
				+	"            hit, pserial from board b "
				+	"     where subject like ? or content like ? "
				+	"     connect by prior serial = pserial "
				+	"     start with pserial is null "
				+	"     order siblings by serial desc "
				+	"    )a "
				+	" ) where rno between ? and ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + page.getFindStr() + "%");
			ps.setString(2, "%" + page.getFindStr() + "%");
			ps.setInt(3,  page.getStartNo());
			ps.setInt(4,  page.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVo vo = setVo(rs, mode);
				list.add(vo);
			}
			
			map.put("page", page);
			map.put("list", list);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConn();
			return map;
		}
		
		
	}
	
	public BoardVo setVo(ResultSet rs, char mode) throws Exception{
		BoardVo vo = new BoardVo();
		vo.setSerial(rs.getInt("serial"));
		vo.setSubject(rs.getNString("subject"));
		vo.setWorker(rs.getNString("worker"));
		vo.setHit(rs.getInt("hit"));
		vo.setmDate(sdf.format(rs.getDate("mdate")));
		
		if(mode == 's') { // 검색이라면
			vo.setAttCnt(rs.getInt("attCnt"));
		}
		
		
		return vo;
	}
	
	public void disConn() {
		try {
			if(conn != null) conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
			
}
