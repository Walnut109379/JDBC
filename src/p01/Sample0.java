package p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample0 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//接続情報の設定
		String url = "jdbc:postgresql:canon_db"; //接続するDB
		String user = "postgres"; //ユーザ名
		String pass = "himitu"; //パスワード

		String sql = "";

		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			//データベースへの接続
			Connection con = DriverManager.getConnection(url, user, pass);
			//PSオブジェクトの取得
			PreparedStatement st = con.prepareStatement(sql);
			//SQLの実行
			int rows = st.executeUpdate();
			System.out.println(rows + "件、データベースに登録しました");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
