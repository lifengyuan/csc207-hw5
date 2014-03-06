/**
 * Classify strings as red (starts with a lowercase letter), white (starts with
 * an uppercase letter), or blue (starts with anything else, or is empty).
 */
public class ClassifyStringsByFirstCharacter implements StringClassifier {
	public int classify(String val) {
		// Empty strings don't start with uppercase or lowercase letters,
		// and are therefore blue.
		if (val.length() == 0)
			return 1;
		// Strings that start with a lowercase letter are red.
		else if (Character.isLowerCase(val.charAt(0)))
			return -1;
		// Strings that start with an uppercase letter are white.
		else if (Character.isUpperCase(val.charAt(0)))
			return 0;
		// Everything else is blue
		else
			return 1;
	} // classify(String)
} // ClassifyStringsByFirstCharacter