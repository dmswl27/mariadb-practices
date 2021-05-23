package mariadb_practices;

public class ConnectionTest {

	public static void main(String[] args) {
		// 1. JDBC Driver 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("ok");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이브 로딩 실패:" + e);
		}

	}

}
