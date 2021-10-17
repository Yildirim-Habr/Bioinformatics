import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
	static class Data {
		int ances = -1;
		int success = -1;
		int diambil = 0;
		String strand;
		Data (String s) {
			this.strand = s;
		}
	}
	static void dirajang (Vector<Data> vStrand, Map<String, Vector<Integer>> cekPrev, Map<String, Vector<Integer>> cekSuff, int giliran) {
		String s = vStrand.lastElement().strand;
		int n = s.length();
		String prev = "";
		String suff = "";
		int diambil = 1;
		for (int i = 0; i < n / 2; i++) {
			prev += s.charAt(i);
			suff = s.charAt(n - 1 - i) + suff;
		}
		for (int i = n / 2; i < n; i++) {
			if (cekSuff.containsKey(prev += s.charAt(i))) {
				int cekSuffInt = cekSuff.get(prev).get(0);
				vStrand.lastElement().ances = cekSuffInt;
				vStrand.get(cekSuffInt).success = giliran;
				vStrand.lastElement().diambil = i + 1;
				cekSuff.get(prev).remove(0);
			}
			if (cekPrev.containsKey(suff = s.charAt(n - 1 - i) + suff)) {
				int cekPrevInt = cekPrev.get(suff).get(0);
				vStrand.lastElement().success = cekPrevInt;
				vStrand.get(cekPrevInt).ances = giliran;
				vStrand.get(cekPrevInt).diambil = i + 1;
				cekPrev.get(suff).remove(0);
			}
			if (!cekPrev.containsKey(prev)) cekPrev.put(prev, new Vector<>());
			cekPrev.get(prev).add(giliran);
			if (!cekSuff.containsKey(suff)) cekSuff.put(suff, new Vector<>());
			cekSuff.get(suff).add(giliran);
			diambil++;
		}
	}
	static void slashAndPrint (Data data) {
		for (int i = data.diambil; i < data.strand.length(); i++) {
			out.print(data.strand.charAt(i));
		}
	}
    static void solve() {
		Scanner sc = new Scanner(System.in);
		Map<String, Vector<Integer>> cekPrev = new HashMap<>();
		Map<String, Vector<Integer>> cekSuff = new HashMap<>();
		Vector<Data> vStrand = new Vector<>();
		int giliran = 0;
		sc.next();
		while (sc.hasNext()) {
			String s = "";
			while (sc.hasNext()) {
				String masuk = sc.next();
				if (masuk.charAt(0) == '>') break;
				s += masuk;	
			}
			vStrand.add(new Data(s));
			dirajang(vStrand, cekPrev, cekSuff, giliran);
			giliran++;
		}
		for (int i = 0; i < vStrand.size(); i++) {
			if (vStrand.get(i).ances == -1) {
				int pvt = i;
				do {
					slashAndPrint(vStrand.get(pvt));
					pvt = vStrand.get(pvt).success;
				} while (pvt != -1);
			}
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
