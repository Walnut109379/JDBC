package p02;

public class Sample06 {

	public static void main(String[] args) {
		String id = "06";
		String name = "齋藤";
		int age = 20;

		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();

		//メソッドの呼び出し
		boolean check = false;

		try {
			check = dao.update(id, name, age);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		if (check == true) {
			System.out.println("変更成功");
		} else {
			System.out.println("変更失敗");
		}
	}
}