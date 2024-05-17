package kadai40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);

		String url = "jdbc:postgresql:canon_db";
		String user = "postgres";
		String pass = "himitu";

		System.out.print("名前を入力してください：");
		String key = scan.next();

		String sql = "SELECT * FROM emp WHERE name LIKE ?";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("JDBCドライバが登録されていません");
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url, user, pass);) {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "%" + key + "%");

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
