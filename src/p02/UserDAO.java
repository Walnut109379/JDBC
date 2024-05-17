package p02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {

	//単一検索メソッド（idによる検索）
	public User findById(String _id) throws DAOException {

		User u = null;

		String sql = "SELECT * FROM users WHERE id = ?";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//プレースホルダの部分に値を設定する
			ps.setString(1, _id);

			//SQL文を実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) { //レコードがある回数繰り返す
				//レコードの列のデータを取得する
				String id = rs.getString("id"); //idの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age");

				u = new User(id, name, age);
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return u;
	}

	//全件検索メソッド
	public List<User> findAll() throws DAOException {

		List<User> users = new ArrayList<>();

		String sql = "SELECT * FROM users";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//SQL文を実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがある回数繰り返す
				//レコードの列のデータを取得する
				String id = rs.getString("id"); //idの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int age = rs.getInt("age");

				users.add(new User(id, name, age));
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return users;
	}

	//登録メソッド1
	public boolean insert(String id, String name, int age) throws DAOException {

		boolean check = false;

		String sql = "INSERT INTO users VALUES (?, ?, ?)";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);

			//SQL文を実行して結果を取得する
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return check;
	}

	//登録メソッド2
	public boolean insert(User u) throws DAOException {

		boolean check = false;

		String id = u.getId();
		String name = u.getName();
		int age = u.getAge();

		String sql = "INSERT INTO users VALUES (?, ?, ?)";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);

			//SQL文を実行して結果を取得する
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return check;
	}

	//変更メソッド
	public boolean update(String id, String name, int age) throws DAOException {

		boolean check = false;

		String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, id);

			//SQL文を実行して結果を取得する
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return check;
	}

	//削除メソッド
	public boolean delete(String id) throws DAOException {

		boolean check = false;

		String sql = "DELETE FROM users WHERE id = ?";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			//SQL文を実行して結果を取得する
			int row = ps.executeUpdate();

			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return check;
	}

}
