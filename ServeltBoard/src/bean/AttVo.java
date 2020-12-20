package bean;

/* 첨부파일 하나의 정보 */
public class AttVo {
	int 	serial; //자신의 순번
	int 	pSerial; // 게시물 본문글 번호
	String 	attFile; // 저장된 파일명
	String 	oriAttFile; // 사용자가 업로드한 파일명
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getpSerial() {
		return pSerial;
	}
	public void setpSerial(int pSerial) {
		this.pSerial = pSerial;
	}
	public String getAttFile() {
		return attFile;
	}
	public void setAttFile(String attFile) {
		this.attFile = attFile;
	}
	public String getOriAttFile() {
		return oriAttFile;
	}
	public void setOriAttFile(String oriAttFile) {
		this.oriAttFile = oriAttFile;
	}
	
}
