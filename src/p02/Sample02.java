package p02;

public class Sample02 {

	public static void main(String[] args) {

		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();

		//findByIdメソッドの呼び出し
		User u = null;

		try {
			u = dao.findById("03");
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (u != null) {
			String id = u.getId();
			String name = u.getName();
			int age = u.getAge();

			System.out.println(id + "\t" + name + "\t" + age);
		} else {
			System.out.println("指定したIDに該当するレコードがありません");
		}
	}
}