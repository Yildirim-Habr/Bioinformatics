import java.io.*;
import java.util.*;
import java.math.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class D {
    static class Task {
        public void solve() {		
			String s = in.read();
			out.println(s.replace('T', 'U'));
		}
    }
    public static void main(String[] args) {        
        long time = System.currentTimeMillis();
        // int t = in.readInt();
        int t = 1;
        Task solver = new Task();
        while (t-- > 0) solver.solve(); 
        err.println("Time elapsed : " + (System.currentTimeMillis() - time) / 1000F + " s.");
        err.close(); out.close();
    }
	static Util utils = new Util();
	static class Util {	
		public void swap (int[] arr, int a, int b) { int save = arr[a]; arr[a] = arr[b]; arr[b] = save; }
		public int[] nextPermutation (int[] arr) {
			int n = arr.length;
			int pvt = n - 2;
			while (pvt >= 0 && arr[pvt] >= arr[pvt + 1]) pvt--;
			if (pvt < 0) return arr;
			for (int i = n - 1; i > pvt; i--) {
				if (arr[i] > arr[pvt]) {
					swap(arr, i, pvt); break;
				}
			}
			for (int i = 0; i < (n - pvt - 1) / 2; i++) {
				swap(arr, pvt + 1 + i, n - 1 - i);
			}
			return arr;
		}
		public int[] radixSort (int[] f) { 
			int n = f.length;
			int[] to = new int[n];
			{
				int[] b = new int[65537];
				for (int i = 0;i < n;i++) b[1+(f[i]&0xffff)]++;
				for (int i = 1;i <= 65536;i++) b[i] += b[i-1];
				for (int i = 0;i < n;i++) to[b[f[i]&0xffff]++] = f[i];
				int[] d = f; f = to;to = d;
			}
			{
				int[] b = new int[65537];
				for (int i = 0;i < n;i++) b[1+(f[i]>>>16)]++;
				for (int i = 1;i <= 65536;i++) b[i] += b[i-1];
				for (int i = 0;i < n;i++) to[b[f[i]>>>16]++] = f[i];
				int[] d = f; f = to;to = d;
			}
			return f;
		}
	}
    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static PrintWriter err = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.err)));    
    static class InputReader {
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		private StringTokenizer token;
		public String read() {
			while (token == null || !token.hasMoreTokens()) {
				try {
					token = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return token.nextToken();
		}
		public char readChar() {
			return Character.valueOf(read().charAt(0));
		}
		public int readInt() {
			return Integer.parseInt(read());
		}
		public double readDouble() {
			return Double.parseDouble(read());
		}
		public long readLong() {
			return Long.parseLong(read());
		}
    }
}
// Collections Arrays Math
// Vector HashSet TreeSet HashMap TreeMap ArrayDeque 
