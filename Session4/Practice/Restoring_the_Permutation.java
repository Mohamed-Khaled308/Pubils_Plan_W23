import java.util.*;
import java.io.*;

public class Restoring_the_Permutation {
	static Scanner sc;
	static PrintWriter pw;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int[] min = new int[n], max = new int[n];

			TreeSet<Integer> availableMin = new TreeSet<>();
			TreeSet<Integer> availableMax = new TreeSet<>();

			for (int i = 1; i < n; i++) {
				availableMax.add(i);
				availableMin.add(i);
			}

			for (int i = 0; i < n; i++) {
				availableMax.remove(arr[i]);
				availableMin.remove(arr[i]);
			}

			min[0] = max[0] = arr[0];

			for (int i = 1; i < n; i++) {
				if (arr[i] == arr[i - 1]) {
					min[i] = availableMin.first();
					availableMin.remove(min[i]);
					max[i] = availableMax.lower(arr[i]);
					availableMax.remove(max[i]);
				} else {
					min[i] = max[i] = arr[i];
				}
			}

			for (int i = 0; i < n; i++) {
				pw.print(min[i] + " ");
			}
			pw.println();

			for (int i = 0; i < n; i++) {
				pw.print(max[i] + " ");
			}
			pw.println();
		}

		pw.flush();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String readAllLines(BufferedReader reader) throws IOException {
			StringBuilder content = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				content.append(line);
				content.append(System.lineSeparator());
			}

			return content.toString();
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public long[] nextlongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public Long[] nextLongArray(int n) throws IOException {
			Long[] a = new Long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
