import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
	static Vector<Integer> New (Vector<Vector<Integer>> sol, int nambahIni, int code) {
		Vector<Integer> candidateNew = new Vector<>();
		Vector<Integer> applicant = new Vector<>();
		int minSize = 0;
		for (Vector<Integer> vx : sol) {
			int nowSize = 0;
			if (code == 1) for (int j = 0; j < vx.size(); j++) {
				if (vx.get(j) < nambahIni) {
					applicant.add(vx.get(j));
					nowSize++;
				}
				else break;
			}
			else for (int j = 0; j < vx.size(); j++) {
				if (vx.get(j) > nambahIni) {
					applicant.add(vx.get(j));
					nowSize++;
				}
				else break;
			}
			if (nowSize > minSize) {
				candidateNew = applicant;
				minSize = nowSize;
			}
			applicant = new Vector<>();
		}
		candidateNew.add(nambahIni);
		return candidateNew;
	}
	static Vector<Integer> vRes (int[] arr, int n, int code) {
		Vector<Vector<Integer>> sol = new Vector<>();
		for (int i = 0; i < n; i++) {
			sol.add(new Vector<>());
			sol.lastElement().addAll(New(sol, arr[i], code));
		}
		int minSizeSol = 0;
		int isxRes1 = -1;
		for (int i = 0; i < sol.size(); i++) {
			Vector<Integer> x = sol.get(i);
			if (x.size() > minSizeSol) {
				minSizeSol = x.size();
				isxRes1 = i;
			}
		}
		return sol.get(isxRes1);
	}
    static void solve() {
		int n = ni();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = ni();
		Vector<Integer> res = vRes(arr, n, 1);
		for (int x : res) {
			out.print(x + " ");
		}
		out.println();
		res = vRes(arr, n, 2);
		for (int x : res) {
			out.print(x + " ");
		}
    }    

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int t;// = ni();
        t = 1;
        while (t-- > 0) solve(); 
        err.println("Time elapsed : " + (System.currentTimeMillis() - time) / 1000F + " s.");
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
