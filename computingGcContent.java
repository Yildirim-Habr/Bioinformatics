import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
	static class Data {
		double Max = 0.0;
		String Name = "";
	}
    static void solve() {
		Scanner sc = new Scanner(System.in);
		Data result = new Data();
		String name = "";
		String nameCadangan = "";
		boolean nameCadanganDipake = false;
		while (sc.hasNext()) {			
			if (!nameCadanganDipake) name = sc.next();
			else {
				name = nameCadangan;
				nameCadanganDipake = false;
			}
			name = name.substring(1, name.length());
			String s = "";
			while (sc.hasNext()) {
				nameCadangan = sc.next();
				if (nameCadangan.charAt(0) == '>') {
					nameCadanganDipake = true;
					break;
				}
				s += nameCadangan;
			}
			int GC = 0;
			for (char x : s.toCharArray()) {
				if (x == 'G' || x == 'C') GC++;
			}
			// err.println(GC + " " + s.length());
			double val = 100.0 * GC / s.length();
			if (val > result.Max) {
				result.Max = val;
				result.Name = name;
			}
		}
		out.printf("%s\n%.6f", result.Name, result.Max);
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
