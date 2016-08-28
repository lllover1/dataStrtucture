package parttern;

public class Test {
	public static void main(String[] args){
		Utils u = new Utils();
		System.out.println("¼òµ¥--´íÎóÆ¥Åä"+u.BruteForce("qeweqwerr", "eqqq"));
		System.out.println("¼òµ¥--ÕıÈ·Æ¥Åä"+u.BruteForce("qeweqwerr", "eqw"));
		
		System.out.println("kmp--´íÎóÆ¥Åä"+u.KMP("abcabcabcabc", "abab"));
		System.out.println("kmp--ÕıÈ·Æ¥Åä"+u.KMP("abcabcabababcabc", "abab"));
		
		System.out.println("kmp--´íÎóÆ¥Åä"+u.KMPOpt("abcabcabcabc", "abab"));
		System.out.println("kmp--ÕıÈ·Æ¥Åä"+u.KMPOpt("abcabcabababcabc", "abab"));
	}
}
