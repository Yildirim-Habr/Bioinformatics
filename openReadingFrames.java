import java.io.*;
import java.util.*;

/******************************\
 * The solution is at the top *
 *                            *
 *   Created by : azhar556    *
\******************************/

public class A {
	static String reverseComplement (String s, HashMap<Character, Character> thisPair) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		for (int i = 0; i < n / 2; i++) {
			char swap = ch[i];
			ch[i] = ch[n - 1 - i];
			ch[n - 1 - i] = swap;
		}
		s = "";
		for (char x : ch) {
			s += thisPair.get(x);
		}
		return s;
	}
    static void solve() {
		HashMap<Character, Character> thisPair = new HashMap<>();
		thisPair.put('A', 'T');
		thisPair.put('T', 'A');
		thisPair.put('G', 'C');
		thisPair.put('C', 'G');
		HashMap<String, String> codonTable = new HashMap<>();
		codonTable.put("ATT", "I");
		codonTable.put("ATC", "I");
		codonTable.put("ATA", "I");
		codonTable.put("ATG", "M");
		codonTable.put("ACT", "T");
		codonTable.put("ACC", "T");
		codonTable.put("ACA", "T");
		codonTable.put("ACG", "T");
		codonTable.put("AAT", "N");
		codonTable.put("AAC", "N");
		codonTable.put("AAA", "K");
		codonTable.put("AAG", "K");
		codonTable.put("AGT", "S");
		codonTable.put("AGC", "S");
		codonTable.put("AGA", "R");
		codonTable.put("AGG", "R");
		codonTable.put("TTT", "F");                  
		codonTable.put("TTC", "F");                  
		codonTable.put("TTA", "L");                  
		codonTable.put("TTG", "L");                  
		codonTable.put("TCT", "S");                  
		codonTable.put("TCC", "S");                  
		codonTable.put("TCA", "S");                  
		codonTable.put("TCG", "S");                  
		codonTable.put("TAT", "Y");                  
		codonTable.put("TAC", "Y");                  
		codonTable.put("TAA", "Stop");               
		codonTable.put("TAG", "Stop");               
		codonTable.put("TGT", "C");                  
		codonTable.put("TGC", "C");                  
		codonTable.put("TGA", "Stop");
		codonTable.put("TGG", "W");                  
		codonTable.put("CTT", "L");
		codonTable.put("CTC", "L");
		codonTable.put("CTA", "L");
		codonTable.put("CTG", "L");
		codonTable.put("CCT", "P");
		codonTable.put("CCC", "P");
		codonTable.put("CCA", "P");
		codonTable.put("CCG", "P");
		codonTable.put("CAT", "H");
		codonTable.put("CAC", "H");
		codonTable.put("CAA", "Q");
		codonTable.put("CAG", "Q");
		codonTable.put("CGT", "R");
		codonTable.put("CGC", "R");
		codonTable.put("CGA", "R");
		codonTable.put("CGG", "R");
		codonTable.put("GTT", "V");
		codonTable.put("GTC", "V");
		codonTable.put("GTA", "V");
		codonTable.put("GTG", "V");
		codonTable.put("GCT", "A");
		codonTable.put("GCC", "A");
		codonTable.put("GCA", "A");
		codonTable.put("GCG", "A");
		codonTable.put("GAT", "D");
		codonTable.put("GAC", "D");
		codonTable.put("GAA", "E");
		codonTable.put("GAG", "E");
		codonTable.put("GGT", "G");
		codonTable.put("GGC", "G");
		codonTable.put("GGA", "G");
		codonTable.put("GGG", "G"); 
		
		Scanner sc = new Scanner(System.in);
		sc.next();
		String s = "";
		while (sc.hasNext()) {
			s += sc.next();
		}
		Vector<String> res = new Vector<>();
		HashMap<String, Boolean> udah = new HashMap<>();
		for (int j = 0; j < 3; j++) {			
			for (int i = 0; i + j <= s.length() - 3; i += 3) {
				int ii = i + j;
				String now = s.substring(ii, ii + 3);
				if (now.equals("ATG")) {
					res.add("");
					// err.println(j + " s " + ii);
				}
				else if (now.equals("TAA") || now.equals("TAG") || now.equals("TGA")) {
					for (String ss : res) {
						if (udah.get(ss) == null) out.println(ss);
						udah.put(ss, true);
						// err.println(j + " f " + ii);
					}
					res = new Vector<>();
				}
				for (int k = 0; k < res.size(); k++) {
					res.set(k, res.get(k) + codonTable.get(now));
				}
			}
			res = new Vector<>();
		}
		s = reverseComplement(s, thisPair);
		res = new Vector<>();
		for (int j = 0; j < 3; j++) {			
			for (int i = 0; i + j <= s.length() - 3; i += 3) {
				int ii = i + j;
				String now = s.substring(ii, ii + 3);
				if (now.equals("ATG")) {
					res.add("");
					// err.println(j + " s " + ii);
				}
				else if (now.equals("TAA") || now.equals("TAG") || now.equals("TGA")) {
					for (String ss : res) {
						if (udah.get(ss) == null) out.println(ss);
						udah.put(ss, true);
						// err.println(j + " f " + ii);
					}
					res = new Vector<>();
				}
				for (int k = 0; k < res.size(); k++) {
					res.set(k, res.get(k) + codonTable.get(now));
				}
			}
			res = new Vector<>();
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
