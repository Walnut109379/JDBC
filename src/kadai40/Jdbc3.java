package kadai40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);

		String url = "jdbc:postgresql:canon_db";
		String user = "postgres";
		String pass = "himitu";

		System.out.print("コードを入力してください：");
		int _code = scan.nextInt();
		System.out.print("名前を入力してください：");
		String _name = scan.next();
		System.out.print("年齢を入力してください：");
		int _age = scan.nextInt();
		System.out.print("電話番号を入力してください：");
		String _tel = scan.next();

		String sql = "INSERT INTO emp VALUES (?, ?, ?, ?)";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("JDBCドライバが登録されていません");
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url, user, pass);) {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, _code);
			ps.setString(2, _name);
			ps.setInt(3, _age);
			ps.setString(4, _tel);

			int n = ps.executeUpdate();
			System.out.println(n + "件、レコードを登録しました");
		} catch (SQLException e) {
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}

}
