/**
 * Skip lists of strings, stored alphabetically.
 */
public class SkipListOfStrings implements SetOfStrings {
	public static final int MAX_LEVEL = 6;
	public static final double P = 0.5;

	public final SkipNode header = new SkipNode(MAX_LEVEL, null);
	public int level = 0;

	class SkipNode {
		public final String value;
		public final SkipNode[] forward;

		public SkipNode(int level, String value) {
			forward = new SkipNode[level + 1];
			this.value = value;
		}
	}

	@Override
	public boolean contains(String str) {
		SkipNode x = header;
		for (int i = level; i >= 0; i--) {
			while (x.forward[i] != null && x.forward[i].value.compareTo(str) < 0) {
				x = x.forward[i];
			}
		}
		x = x.forward[0];
		return x != null && x.value.equals(str);
	}// contains(String str)

	@Override
	public void add(String str) {
		SkipNode x = header;
		SkipNode[] update = new SkipNode[MAX_LEVEL + 1];

		for (int i = level; i >= 0; i--) {
			while (x.forward[i] != null && x.forward[i].value.compareTo(str) < 0) {
				x = x.forward[i];
			}
			update[i] = x;
		}
		x = x.forward[0];

		if (x == null || !x.value.equals(str)) {
			int lvl = (int) (Math.log(1. - Math.random()) / Math.log(1. - P));
			lvl = Math.min(lvl, MAX_LEVEL);

			if (lvl > level) {
				for (int i = level + 1; i <= lvl; i++) {
					update[i] = header;
				}
				level = lvl;
			}

			x = new SkipNode(lvl, str);
			for (int i = 0; i <= lvl; i++) {
				x.forward[i] = update[i].forward[i];
				update[i].forward[i] = x;
			}
		}
	} // add

	@Override
	public void remove(String str) {
		SkipNode x = header;
		SkipNode[] update = new SkipNode[MAX_LEVEL + 1];

		for (int i = level; i >= 0; i--) {
			while (x.forward[i] != null && x.forward[i].value.compareTo(str) < 0) {
				x = x.forward[i];
			}
			update[i] = x;
		}
		x = x.forward[0];

		if (x.value.equals(str)) {
			for (int i = 0; i <= level; i++) {
				if (update[i].forward[i] != x)
					break;
				update[i].forward[i] = x.forward[i];
			}
		}

		while (level > 0 && header.forward[level] == null) {
			level--;
		}
	} // remove

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		SkipNode x = header.forward[0];
		while (x != null) {
			sb.append(x.value);
			x = x.forward[0];
			if (x != null)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	} // toString

	public static void main(String[] args) {
		SkipListOfStrings set = new SkipListOfStrings();
		set.add("a");
		set.add("b");
		System.out.println(set);
		set.add("a");
		System.out.println(set);
		set.add("c");
		set.remove("a");
		System.out.println(set);
		for(int i = 0; i < 100; i++){
			set.add(String.valueOf(i));
		}
		System.out.println(set);
	} // main
} // class SkipListOfStrings