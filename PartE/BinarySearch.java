import java.util.Arrays;

public class BinarySearch {
	/**
	 * Search for val in values, return the index of an instance of val.
	 * 
	 * @param val
	 *            An integer we're searching for
	 * @param values
	 *            A sorted array of integers
	 * @result index, an integer
	 * @throws Exception
	 *             If there is no i s.t. values[i] == val
	 * @pre values is sorted in increasing order. That is, values[i] <
	 *      values[i+1] for all reasonable i.
	 * @post values[index] == val
	 */
	public static int binarySearch(int val, int[] vals) throws Exception {
		Arrays.sort(vals);
		int start = 0;
		int end = vals.length - 1;
		while (start <= end) {
			int middle = start + (end - start) / 2;
			if(val == vals[middle]){
				return middle;
			}else if(val < vals[middle]){
				end = middle - 1;
			}else {
				start = middle + 1;
			}
		}
		throw new Exception();
	} // binarySearch
}
