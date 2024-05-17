package kadai40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);

		String url = "jdbc:postgresql:canon_db";
		String user = "postgres";
		String pass = "himitu";

		System.out.print("コードを入力してください：");
		int key = scan.nextInt();

		String sql1 = "DELETE FROM emp WHERE code = ?";
		String sql2 = "SELECT * FROM emp ORDER BY code";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("JDBCドライバが登録されていません");
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url, user, pass);) {

			PreparedStatement ps = con.prepareStatement(sql1);

			ps.setInt(1, key);

			int n = ps.executeUpdate();
			System.out.println(n + "件、レコードを削除しました");

		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url, user, pass);) {

			PreparedStatement ps = con.prepareStatement(sql2);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");

				System.out.println(code + ":" + name + ":" + age + ":" + tel);
			}
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
