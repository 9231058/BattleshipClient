package battleshipclient;

public interface Screen {

	void showNextLine();

	void showScore(int score1, int score2);

	int getInt(String message);

	int getInt();

	String getString(String message);

	void showMassage(String message);
}
