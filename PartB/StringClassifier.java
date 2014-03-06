/**
 * Objects that classify strings. Useful for DNF.
 */
public interface StringClassifier {
	/**
	 * Classify val into one of three categories, which we call "red", "white",
	 * and "blue" for convenience. If val is red, returns a negative number. If
	 * val is white, returns zero. If val is blue, returns a positive number.
	 */
	public int classify(String val);
} // interface StringClassifier