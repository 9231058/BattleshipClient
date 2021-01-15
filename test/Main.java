import battleshipclient.CilentGameMannager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CilentGameMannager cilentGameMannager = new CilentGameMannager(
				"127.0.0.1", 1373);
		cilentGameMannager.run();
	}

}
