package battleshipclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import battleshipclient.screen.StringBaseScreen;

public class CilentGameMannager implements Runnable {

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private BattleshipType[] battleshipTypeEnums = BattleshipType.values();
	private Socket socket;
	private Screen screen = new StringBaseScreen();

	public CilentGameMannager(String IPAddress, int port) {
		try {
			socket = new Socket(IPAddress, port);
			objectOutputStream = new ObjectOutputStream(
					socket.getOutputStream());
			objectOutputStream.flush();
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void run() {
		for (int i = 0; i < battleshipTypeEnums.length; i++) {
			screen.showMassage("You must put battleship with size "
					+ battleshipTypeEnums[i].toString());
			try {
				screen.showMassage("Please enter 2 intger for battleship start place");
				objectOutputStream.writeObject((Integer) screen.getInt());
				objectOutputStream.writeObject((Integer) screen.getInt());
				objectOutputStream.writeObject((String) screen
						.getString("Enter direction for your battleship"));
				objectOutputStream.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			while ((((String) objectInputStream.readObject())
					.equalsIgnoreCase("CONTINUE"))) {
				System.out.print((String) objectInputStream.readObject());
				System.out.print((String) objectInputStream.readObject());
				System.out.println("Your Map :");
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						System.out.print((String) objectInputStream
								.readObject());
					}
					System.out.print((String) objectInputStream.readObject());
				}
				System.out.println("Your Enemy Map :");
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						System.out.print((String) objectInputStream
								.readObject());
					}
					System.out.print((String) objectInputStream.readObject());
				}
				screen.showMassage("Please enter 2 integer for fire zone");
				objectOutputStream.writeObject((Integer) screen.getInt());
				objectOutputStream.writeObject((Integer) screen.getInt());
				objectOutputStream.flush();
			}
			System.out.println((String) objectInputStream.readObject());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
