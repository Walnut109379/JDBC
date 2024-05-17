package kadai40_DAO;

import java.util.List;
import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//UserDAOのインスタンスを生成
		MemberDAO dao = new MemberDAO();

		//findAllメソッドの呼び出し
		List<Member> members = null;

		try {
			System.out.print("名前を入力してください：");
			String key = scan.next();
			members = dao.findAll(key);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		for (Member m : members) {
			int code = m.getCode();
			String name = m.getName();
			int age = m.getAge();
			String tel = m.getTel();

			System.out.println(code + "\t" + name + "\t" + age + "\t" + tel);
		}
	}
}