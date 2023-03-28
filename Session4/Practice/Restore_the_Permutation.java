import java.util.*;
import java.io.*;

public class Restore_the_Permutation {
	static Scanner sc;
	static PrintWriter pw;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n / 2];

			for (int i = 0; i < n / 2; i++) {
				arr[i] = sc.nextInt();
			}

			TreeSet<Integer> set = new TreeSet<>();

			for (int i = 1; i <= n; i++) {
				set.add(i);
			}

			boolean flag = true;
			int[] res = new int[n];
			for (int i = 0; i < n / 2; i++) {
				res[2 * i + 1] = arr[i];
				if (!set.contains(arr[i])) {
					flag = false;
				}
				set.remove(arr[i]);

			}

			for (int i = n / 2 - 1; i >= 0; i--) {

				if (arr[i] > set.first()) {
					int num = set.lower(arr[i]);
					set.remove(num);
					res[2 * i] = num;
				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				for (int i = 0; i < n; i++) {
					pw.print(res[i] + " ");
				}
				pw.println();
			} else {
				pw.println(-1);
			}

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
