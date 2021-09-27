import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
    static void solve() {
		Scanner sc = new Scanner(System.in);
		Vector<String> vs = new Vector<>();
		sc.next();
		while (sc.hasNext()) {
			String s = "";
			while (sc.hasNext()) {
				String line = sc.next();
				if (line.charAt(0) == '>') break;
				s += line;
			}
			vs.add(s);
		}
		int n = vs.size();
		int m = vs.get(0).length();
		int[][] karung = new int[4][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vs.get(i).charAt(j) == 'A') karung[0][j]++;
				else if (vs.get(i).charAt(j) == 'C') karung[1][j]++;
				else if (vs.get(i).charAt(j) == 'G') karung[2][j]++;
				else if (vs.get(i).charAt(j) == 'T') karung[3][j]++;
			}
		}
		char[] mol = {'A', 'C', 'G', 'T'};
		String con = "";
		for (int i = 0; i < m; i++) {
			int Max = 0;
			char winner = '.';
			for (int j = 0; j < 4; j++) {
				if (karung[j][i] > Max) {
					Max = karung[j][i];
					winner = mol[j];
				}
			}
			con += winner;
		}
		out.println(con);
		for (int i = 0; i < 4; i++) {
			out.print(mol[i] + ": ");
			for (int j = 0; j < m; j++) {
				out.print(karung[i][j] + " ");
			}
			out.println();
		}
    }    

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int t;// = ni();
        t = 1;
        while (t-- > 0) solve(); 
        err.println("\nTime elapsed : " + (System.currentTimeMillis() - time) / 1000F + " s.\n");
        err.close(); out.close();
    }

    static int[] radixSort(int[] f){ return radixSort(f, f.length); }
    static int[] radixSort(int[] f, int n)
    {
        int[] to = new int[n];
        {
            int[] b = new int[65537];
            for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < n;i++)to[b[f[i]&0xffff]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        {
            int[] b = new int[65537];
            for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
            for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
            int[] d = f; f = to;to = d;
        }
        return f;
    }

    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static PrintWriter err = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.err)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
        
    static String ns() {
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
    static char nc() {
        return Character.valueOf(ns().charAt(0));
    }
    static int ni() {
        return Integer.parseInt(ns());
    }
    static double nd() {
        return Double.parseDouble(ns());
    }
    static long nl() {
        return Long.parseLong(ns());
    }
}
// Collections Arrays Math
// Vector HashSet TreeSet HashMap TreeMap ArrayDeque
