import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class C {
    static void solve() {
		char[] ch1 = ("." + ns()).toCharArray();
		char[] ch2 = ("." + ns()).toCharArray();
		int[] rev = new int[ch2.length]; rev[0] = 1; rev[1] = 1;
		
		int pvt = 1;
		for (int i = 2; i < ch2.length; i++) {
			if (ch2[i] != ch2[pvt]) {
				if (ch2[i] == ch2[1]) pvt = 2;
				else pvt = 1;
			}
			else {
				pvt++;
			}
			rev[i] = pvt;
			err.print(rev[i]);
		}
		pvt = 1;
		for (int i = 1; i < ch1.length; i++) {
			if (ch1[i] != ch2[pvt]) {
				pvt = rev[pvt - 1];
				if (ch1[i] == ch2[pvt]) pvt++;
				else if (ch1[i] == ch2[1]) pvt = 2;
				else pvt = 1;
				continue;
			}
			if (pvt == ch2.length - 1) {
				out.print((i - (ch2.length - 1) + 1) + " ");
				pvt = rev[pvt]; continue;
			}
			pvt++;
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
