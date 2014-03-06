public class DNF {
	/**
	 * Rearrange vals so that red values precede white values and white values
	 * precede blue values.
	 * 
	 * @post Exist P and Q, 0 <= P <= Q <= vals.length, s.t. For all i, 0 <= i <
	 *       P, classifier.classify(vals[i]) < 0 For all i, P <= w < Q,
	 *       classifier.classify(vals[i]) == 0 For all i, Q <= i < vals.length,
	 *       classifier.classify(vals[i]) > 0 Values have neither been added to
	 *       nor removed from vals; the new vals is a permutation of the
	 *       original.
	 */
	public void dnf(String[] vals, StringClassifier classifier) {
		int current = 0;
		int end = vals.length - 1;
		int begin = 0;

		while (current <= end) {
			if (classifier.classify(vals[current]) < 0) {
				// change between current and begin
				String temp = vals[current];
				vals[current] = vals[begin];
				vals[begin] = temp;

				current++;
				begin++;
			} else if (classifier.classify(vals[current]) == 0) {
				current++;
			} else if (classifier.classify(vals[current]) > 0) {
				// change between current and end
				String temp = vals[current];
				vals[current] = vals[end];
				vals[end] = temp;

				end--;
			} // if
		} // while
	} // dnf(String[], StringClassifier)

	public static void main(String[] args) {
		String a = "a";
		String a5 = "aaaaa";
		String a10 = "aaaaaaaaaa";

		String[] vals = { a, a5, a10, a5, a5, a10, a, a10, a5, a };
		DNF dnf = new DNF();
		dnf.dnf(vals, new SimpleStringSizeClassifier());
		for(int i = 0; i < vals.length; i++){
			System.out.println(vals[i]);
		}
	}
}
