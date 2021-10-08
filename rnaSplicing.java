import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
	static int tot = 0;
	static void makeItDot (int awal, int akhir, char[] pat) {
		for (int i = awal; i <= akhir; i++) {
			pat[i] = '.';
		}
	}
	static int[] makeRev (char[] sample) {
		int[] rev = new int[sample.length]; rev[0] = 0; rev[1] = 0;
		int pvt = 0;
		for (int i = 2; i < sample.length; i++) {
			if (sample[i] != sample[pvt + 1]) {
				if (sample[i] == sample[1]) pvt = 1;
				else pvt = 0;
			}
			else {
				pvt++;
			}
			rev[i] = pvt;
		}
		return rev;
	}
	static void match (char[] pat, char[] sample) {
		int[] rev = makeRev(sample);
		int pvt = 0;
		for (int i = 1; i < pat.length; i++) {			
			while (pat[i] != sample[pvt + 1] && pvt != 0) {
				pvt = rev[pvt];
			}
			if (pat[i] == sample[pvt + 1]) pvt++;
			if (pvt == sample.length - 1) {
				makeItDot(i - (sample.length - 1) + 1, i, pat);
				tot += sample.length - 1;
				break;
			}
		}
	}
    static void solve() {
		HashMap<String, String> codonTable = new HashMap<>();
		codonTable.put("UUU", "F");      
		codonTable.put("UUC", "F");      
		codonTable.put("UUA", "L");      
		codonTable.put("UUG", "L");      
		codonTable.put("UCU", "S");      
		codonTable.put("UCC", "S");      
		codonTable.put("UCA", "S");      
		codonTable.put("UCG", "S");      
		codonTable.put("UAU", "Y");      
		codonTable.put("UAC", "Y");      
		codonTable.put("UAA", "Stop");   
		codonTable.put("UAG", "Stop");   
		codonTable.put("UGU", "C");      
		codonTable.put("UGC", "C");      
		codonTable.put("UGA", "Stop");   
		codonTable.put("UGG", "W");      
		codonTable.put("CUU", "L");      
		codonTable.put("CUC", "L");      
		codonTable.put("CUA", "L");      
		codonTable.put("CUG", "L");      
		codonTable.put("CCU", "P");      
		codonTable.put("CCC", "P");      
		codonTable.put("CCA", "P");      
		codonTable.put("CCG", "P");      
		codonTable.put("CAU", "H");      
		codonTable.put("CAC", "H");      
		codonTable.put("CAA", "Q");      
		codonTable.put("CAG", "Q");      
		codonTable.put("CGU", "R");      
		codonTable.put("CGC", "R");      
		codonTable.put("CGA", "R");      
		codonTable.put("CGG", "R");      
		codonTable.put("AUU", "I");      
		codonTable.put("AUC", "I");      
		codonTable.put("AUA", "I");      
		codonTable.put("AUG", "M");      
		codonTable.put("ACU", "T");      
		codonTable.put("ACC", "T");      
		codonTable.put("ACA", "T");      
		codonTable.put("ACG", "T");      
		codonTable.put("AAU", "N");      
		codonTable.put("AAC", "N");      
		codonTable.put("AAA", "K");      
		codonTable.put("AAG", "K");      
		codonTable.put("AGU", "S");      
		codonTable.put("AGC", "S");      
		codonTable.put("AGA", "R");      
		codonTable.put("AGG", "R");      
		codonTable.put("GUU", "V");
		codonTable.put("GUC", "V");
		codonTable.put("GUA", "V");
		codonTable.put("GUG", "V");
		codonTable.put("GCU", "A");
		codonTable.put("GCC", "A");
		codonTable.put("GCA", "A");
		codonTable.put("GCG", "A");
		codonTable.put("GAU", "D");
		codonTable.put("GAC", "D");
		codonTable.put("GAA", "E");
		codonTable.put("GAG", "E");
		codonTable.put("GGU", "G");
		codonTable.put("GGC", "G");
		codonTable.put("GGA", "G");
		codonTable.put("GGG", "G"); 
		
		Scanner sc = new Scanner(System.in);
		Vector<String> dnas = new Vector<>();
		while (sc.hasNext()) {
			String s = "";
			while (sc.hasNext()) {
				String masuk = sc.next();
				if (masuk.charAt(0) == '>') break;
				s += masuk;
			}	
			if (s != "") dnas.add(s); 
		}
		Collections.sort(dnas, new Comparator<String>(){
			public int compare (String a, String b) {
				return b.length() - a.length();
			}
		});
		char[] pat = ("." + dnas.remove(0)).toCharArray();
		// err.println(pat.length);
		while (!dnas.isEmpty()) {
			char[] sample = ("." + dnas.remove(0)).toCharArray();
			match(pat, sample);
		}
		String s = "";
		for (char ch : pat) {
			if (ch != '.') s += ch;
		}
		// err.println(s.length() + tot + " " + s.length() + " " + tot + " " + (s.length() % 3 == 0));
		for (int i = 0; i < s.length(); i+= 3) {
			String prot = codonTable.get(s.substring(i, i + 3).replace('T', 'U'));
			if (prot != "Stop") out.print(prot);
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
