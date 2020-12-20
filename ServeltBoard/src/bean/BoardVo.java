package bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* 게시물 한건에 대한 세부 정보 저장 */
public class BoardVo {
	// 데이블과 관련된 필드
	private int    serial; //------게시물 고유 번호
	private String worker = ""; // 작성자
	private String pwd = ""; // ---암호
	private String subject = ""; //제목
	private String content = ""; //내용
	private String mDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // ------작성일
	private int hit; //------------조회수
	
	// 테이블에는 없는 필드항목
	private int attCnt; //---------첨부 파일 갯수
	List<AttVo> attList; //--------첨부 파일 정보
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getAttCnt() {
		return attCnt;
	}
	public void setAttCnt(int attCnt) {
		this.attCnt = attCnt;
	}
	public List<AttVo> getAttList() {
		return attList;
	}
	public void setAttList(List<AttVo> attList) {
		this.attList = attList;
	}
	
	
}
