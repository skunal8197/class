//UIUC CS125 FALL 2012 MP. File: ExampleCharacters.java, CS125 Project: Challenge3-TopSecret, Version: 2012-09-22T01:39:04-0500.114506000
public class ExampleCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int offset = 1;
		offset = offset % 26; // -25 to +25
		String mesg = "CHOOSE THE PATH TO WISDOM OR LET IT CHOOSE YOU";

		char c = mesg.charAt(1);
		int letter = c - 'A';
		int encryptedDelta = (26 + letter + offset) % 26;
		char encyptedAsLetter = (char) (encryptedDelta + 'A');

		System.out.println("Encrypted First char is " + encyptedAsLetter);
}	}
