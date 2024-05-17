package kadai40_DAO;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//UserDAOのインスタンスを生成
		MemberDAO dao = new MemberDAO();

		//findByNameメソッドの呼び出し
		Member m = null;

		try {
			System.out.print("番号を入力してください：");
			int key = scan.nextInt();
			m = dao.findByCode(key);
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (m != null) {
			int code = m.getCode();
			String name = m.getName();
			int age = m.getAge();
			String tel = m.getTel();

			System.out.println(code + "\t" + name + "\t" + age + "\t" + tel);
		} else {
			System.out.println("該当するレコードがありません");
		}
	}
}