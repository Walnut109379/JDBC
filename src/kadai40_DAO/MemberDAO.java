package kadai40_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DAO {

	//単一検索メソッド（nameによる検索）
	public Member findByCode(int key) throws DAOException {

		Member m = null;

		String sql = "SELECT * FROM members WHERE code = ?";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//プレースホルダの部分に値を設定する
			ps.setInt(1, key);

			//SQL文を実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) { //レコードがある回数繰り返す
				//レコードの列のデータを取得する
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");

				m = new Member(code, name, age, tel);
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return m;
	}

	//全件検索メソッド（名前で検索）
	public List<Member> findAll(String key) throws DAOException {

		List<Member> members = new ArrayList<>();

		String sql = "SELECT * FROM members WHERE name LIKE ?";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "%" + key + "%");

			//SQL文を実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがある回数繰り返す
				//レコードの列のデータを取得する
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");

				members.add(new Member(code, name, age, tel));
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return members;
	}

	//全件検索メソッド（年齢順）
	public List<Member> findOrderByAge() throws DAOException {

		List<Member> members = new ArrayList<>();

		String sql = "SELECT * FROM members ORDER BY age";

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
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String tel = rs.getString("tel");

				members.add(new Member(code, name, age, tel));
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return members;
	}

	//登録メソッド1
	public boolean insert(int code, String name, int age, String tel) throws DAOException {

		boolean check = false;

		String sql = "INSERT INTO members VALUES (?, ?, ?, ?)";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, code);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, tel);

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

	//	//登録メソッド2
	//	public boolean insert(Member u) throws DAOException {
	//
	//		boolean check = false;
	//
	//		String id = u.getId();
	//		String name = u.getName();
	//		int age = u.getAge();
	//
	//		String sql = "INSERT INTO users VALUES (?, ?, ?)";
	//
	//		//データベースへの接続
	//		try (//正常にDBに接続されたときに使用できるリモコンcon
	//				//Connection con = DriverManager.getConnection(url, user, pass);
	//				Connection con = getConnect();) {
	//			//SQL文を実行する準備をする
	//			PreparedStatement ps = con.prepareStatement(sql);
	//			ps.setString(1, id);
	//			ps.setString(2, name);
	//			ps.setInt(3, age);
	//
	//			//SQL文を実行して結果を取得する
	//			int row = ps.executeUpdate();
	//
	//			if (row == 1) {
	//				check = true;
	//			}
	//
	//		} catch (Exception e) {
	//			throw new DAOException("データベース関連エラー");
	//			//System.out.println("データベース関連エラー");
	//			//e.printStackTrace();
	//		}
	//
	//		return check;
	//	}
	//
	//	//変更メソッド
	//	public boolean update(String id, String name, int age) throws DAOException {
	//
	//		boolean check = false;
	//
	//		String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
	//
	//		//データベースへの接続
	//		try (//正常にDBに接続されたときに使用できるリモコンcon
	//				//Connection con = DriverManager.getConnection(url, user, pass);
	//				Connection con = getConnect();) {
	//			//SQL文を実行する準備をする
	//			PreparedStatement ps = con.prepareStatement(sql);
	//			ps.setString(1, name);
	//			ps.setInt(2, age);
	//			ps.setString(3, id);
	//
	//			//SQL文を実行して結果を取得する
	//			int row = ps.executeUpdate();
	//
	//			if (row == 1) {
	//				check = true;
	//			}
	//
	//		} catch (Exception e) {
	//			throw new DAOException("データベース関連エラー");
	//			//System.out.println("データベース関連エラー");
	//			//e.printStackTrace();
	//		}
	//
	//		return check;
	//	}
	//
	//削除メソッド
	public boolean delete(int key) throws DAOException {

		boolean check = false;

		String sql = "DELETE FROM members WHERE code = ?";

		//データベースへの接続
		try (//正常にDBに接続されたときに使用できるリモコンcon
				//Connection con = DriverManager.getConnection(url, user, pass);
				Connection con = getConnect();) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
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
