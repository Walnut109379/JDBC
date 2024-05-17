package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample10 {

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
		String sql = "UPDATE users SET age = ? WHERE id = ?";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				Connection con = DriverManager.getConnection(url, user, pass);) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			int age = 30;
			String id = "06";

			//プレースホルダの部分に値を設定する
			ps.setInt(1, age);
			ps.setString(2, id);

			//SQL文を実行して結果を取得する
			//INSERT, UPDATE, DELETEのSQLはexecuteUpdateで実行する
			//戻り値は登録・変更・削除した数（int）
			int n = ps.executeUpdate();
			System.out.println("変更数：" + n);

			if (n == 1) {
				System.out.println("変更成功");
			} else {
				System.out.println("変更失敗");
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}
}