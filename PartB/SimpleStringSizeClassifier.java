/**
 * Classify strings as red (fewer than 5 characters), white (5 characters), or
 * blue (more than 5 characters).
 */
public class SimpleStringSizeClassifier implements StringClassifier {
	public int classify(String val) {
		return val.length() - 5;
	} // classify
} // class SimpleStringClassifier