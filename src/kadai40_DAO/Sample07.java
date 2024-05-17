package kadai40_DAO;

import java.util.Scanner;

public class Sample07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//UserDAOのインスタンスを生成
		MemberDAO dao = new MemberDAO();

		//メソッドの呼び出し
		boolean check = false;

		try {
			System.out.print("コードを入力してください：");
			int key = scan.nextInt();
			check = dao.delete(key);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		if (check == true) {
			System.out.println("削除成功");
		} else {
			System.out.println("削除失敗");
		}
	}
}