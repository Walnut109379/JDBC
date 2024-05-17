package kadai40_DAO;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//UserDAOのインスタンスを生成
		MemberDAO dao = new MemberDAO();

		//insertメソッドの呼び出し
		boolean check = false;

		try {
			System.out.print("コードを入力してください：");
			int code = scan.nextInt();
			System.out.print("名前を入力してください：");
			String name = scan.next();
			System.out.print("年齢を入力してください：");
			int age = scan.nextInt();
			System.out.print("電話番号を入力してください：");
			String tel = scan.next();

			check = dao.insert(code, name, age, tel);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (check == true) {
			System.out.println("登録成功");
		} else {
			System.out.println("登録失敗");
		}
	}
}