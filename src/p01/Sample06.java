package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample06 {

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
		String _id = "' OR '100' = '100";
		String sql = "SELECT * FROM users WHERE id = '" + _id + "'";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				Connection con = DriverManager.getConnection(url, user, pass);) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			//SQL文を実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) { //レコードがある回数繰り返す
				//レコードの列のデータを取得する
				String id = rs.getString("id"); //idの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age");

				System.out.println(id + "\t" + name + "\t" + age);
			} else {
				System.out.println("指定したIDに該当するレコードがありません");
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("データベース関連エラー");
			e.printStackTrace();
		}
	}
}