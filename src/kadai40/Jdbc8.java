package kadai40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);

		String url = "jdbc:postgresql:canon_db";
		String user = "postgres";
		String pass = "himitu";

		String sql = "SELECT min(age), max(age), avg(age) FROM emp";

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
				int min = rs.getInt(1);
				int max = rs.getInt(2);
				double avg = rs.getDouble(3);

				System.out.println("年齢の最少は" + min + "歳");
				System.out.println("年齢の最大は" + max + "歳");
				System.out.println("年齢の平均は" + avg + "歳");
			}
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
