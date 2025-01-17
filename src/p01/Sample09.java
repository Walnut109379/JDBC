package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample09 {

	public static void main(String[] args) {
		//JDBCドライバの登録
		//JDBCドライバマネージャに使用するDBの種類を教える
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("JDBCドライバが登録されていません");
			e.printStackTrace();
		}

		//接続情報の設定
		String url = "jdbc:postgresql:canon_db"; //接続するDB
		String user = "postgres"; //ユーザ名
		String pass = "himitu"; //パスワード
		String sql = "INSERT INTO users VALUES (?, ?, ?)";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				Connection con = DriverManager.getConnection(url, user, pass);) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			String id = "06";
			String name = "菊水";
			int age = 27;

			//プレースホルダの部分に値を設定する
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);

			//SQL文を実行して結果を取得する
			//INSERT, UPDATE, DELETEのSQLはexecuteUpdateで実行する
			//戻り値は登録・変更・削除した数（int）
			int n = ps.executeUpdate();
			System.out.println("登録数：" + n);

			if (n == 1) {
				System.out.println("登録成功");
			} else {
				System.out.println("登録失敗");
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}
}