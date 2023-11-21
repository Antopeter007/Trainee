package RegexExpresion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constrants {
	public static final String alphaNumeric = ".*[a-zA-Z0-9@#$%^&*!].*";
	public static final String followedBy = "[pq*]";
	public static final String lowerCaseLetters = "[a-z]+_[a-z]+";
	public static final String alphabetFollowedBy = "[A-Z] [a-z]+";
	public static final String followedBy_p = "^p.*q$";
	public static final String contatins_g = ".*g.*";
	public static final String withoutContains_g = "\\b[^gG]+[gG][^gG]+\\b";
	public static final String containsLetter_UnderScore = "^[a-zA-Z0-9_]+$";
	public static final String startsWithNumber = "^[7].*";
	public static final String remove_Zero = "";// 10th bending
	public static final String numberEndOfString = ".*\\d$";
	public static final String vowels = "(?i)[^aeiou]+";
	public static final String removeVowels = "[^aeiouAEIOU]";
	public static final String validMobileNumber = "^[6-9]\\d{9}$";
	public static final String countDecimal = "^\\d+[.?]\\d+";
	public static final String identification = "\\d{4}";
	public static final String hexCode = "^#[0-9A-Z]{6}";
	public static final String removeSpecificLetters = "[pqr]*";
	public static final String removeNonAlphabet = "[^a-zA-Z0-9]*";
	public static final String dashAddBeforeVowels = "([aeiouAEIOU])";
	public static final String python = "(?i)python";//
	public static final String code = "code";// both same questions answer
	public static final String removeConsonants = "[A-Za-z]*";
	public static final String dashAddBeforeLetter = "([a-z])([A-Z])";

	public static boolean checking(String str, String pattern) {

		Pattern regexPattern = Pattern.compile(pattern);

		Matcher matcher = regexPattern.matcher(str);

		return matcher.matches();

	}

}
