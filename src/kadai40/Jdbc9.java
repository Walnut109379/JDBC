package kadai40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc9 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String url = "jdbc:postgresql:canon_db";
		String user = "postgres";
		String pass = "himitu";

		String sql = "SELECT SUM (CASE WHEN age BETWEEN 20 AND 29 THEN 1 END) AS ２０代,"
				+ " SUM (CASE WHEN age BETWEEN 30 AND 39 THEN 1 END) AS ３０代,"
				+ " SUM (CASE WHEN age BETWEEN 40 AND 49 THEN 1 END) AS ４０代,"
				+ " SUM (CASE WHEN age BETWEEN 50 AND 59 THEN 1 END) AS ５０代 "
				+ "FROM emp";
		;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("JDBCドライバが登録されていません");
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url, user, pass);) {

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("20代:" + rs.getInt("２０代") + "人");
				System.out.println("30代:" + rs.getInt("３０代") + "人");
				System.out.println("40代:" + rs.getInt("４０代") + "人");
				System.out.println("50代:" + rs.getInt("５０代") + "人");
			}
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
