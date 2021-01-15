package battleshipclient.screen;

import java.util.Scanner;
import battleshipclient.Screen;

public class StringBaseScreen implements Screen {

	private static Scanner cin = new Scanner(System.in);

	@Override
	public int getInt(String message) {
		System.out.println(message);
		return cin.nextInt();
	}

	@Override
	public int getInt() {
		return cin.nextInt();
	}

	@Override
	public void showNextLine() {
		System.out.println();
	}

	@Override
	public void showScore(int score1, int score2) {
		System.out.println("Player 1 Score : " + score1);
		System.out.println("Player 2 Score : " + score2);
	}

	@Override
	public String getString(String message) {
		System.out.println(message);
		return cin.next();
	}

	@Override
	public void showMassage(String message) {
		System.out.println(message);
	}

}
