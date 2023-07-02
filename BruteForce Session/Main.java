import java.util.*;
import java.io.*;

public class Main {

	static Scanner sc;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);

		int[] arr = { 1, 2, 3 , 4};

//		generateSubset(0, arr, new LinkedList<Integer>());
		
//		generateSubsetWithMask(arr);
		
//		permute(0, arr, "");
		
		generateString(3, "");
		
		pw.flush();
	}
	
	public static void generateString(int length, String s) {
		if(length == 0) {
			pw.println(s);
			return;
		}
		for(int i = 0;i < 26;i++) {
			char curChar = (char) ('a' + i);
			generateString(length - 1, s + curChar);
		}
	}

	public static void permute(int msk, int[] arr, String perm) { // n! * n, n = 11
		if(Integer.bitCount(msk) == arr.length) {
			pw.println(perm);
			return;
		}
		
		for(int i = 0;i < arr.length;i++) {
			if((msk & (1 << i)) == 0) {
				permute(msk | (1 << i), arr, perm + " " + arr[i]);
			}
		}

	}


	public static void generateSubsetWithMask(int[] arr) { // (2 ^ n) * n, n = 20
		
		for(int msk = 0;msk < (1 << arr.length);msk++) {
			String subset = "";
			for(int i = 0;i < arr.length;i++) {
				if((msk & (1 << i)) != 0) {
					subset += " " + arr[i];
				}
			}
			pw.println(subset);
		}
		
	}

	public static void generateSubset(int i, int[] arr, LinkedList<Integer> subset) { // n * 2 ^ n
		if(i == arr.length) {
			pw.println(subset);
			return;
		}
		
		subset.add(arr[i]);
		generateSubset(i + 1, arr, subset );  // take
		subset.removeLast();
		
		generateSubset(i + 1, arr, subset); // leave
		
	}

	static class Scanner {

		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String file) throws IOException {
			br = new BufferedReader(new FileReader(file));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
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
			return Double.parseDouble(next());
		}

	}
}