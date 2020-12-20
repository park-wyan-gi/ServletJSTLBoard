package bean;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	//오라클 드라이버명 (상수)
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String path = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "";
	private String pwd = "";

	private Connection conn;// DB의 연결 정보를 기억

	public DBConn() {
		this("jobtc", "1234");
	}

	public DBConn(String user, String pwd) {
		this.user = user;
		this.pwd = pwd;
		try {
			// 드라이버 로딩
			Class.forName(driver).newInstance();
			// DB 연결
			conn = DriverManager.getConnection(path, user, pwd);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// Connection 정보를 반환하기 위한 getter
	public Connection getConn() {
		return conn;
	}
}
