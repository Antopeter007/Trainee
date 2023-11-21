package RegexExpresion;

import java.util.Scanner;

public class FindTheCharacters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Names ");
		String str = sc.nextLine();
//		if (Constrants.checking(str, Constrants.vowels)) {
//			System.out.println("The Given String is correct " + str);
//		} else {
//			System.out.println("The Given String is inCorrect " + str);
//		}
		String replaced = str.replaceAll(Constrants.dashAddBeforeVowels, "-$1-");
		System.out.println("Successfully Changed " + replaced);
		System.out.println(replaced.length());
	}
}
