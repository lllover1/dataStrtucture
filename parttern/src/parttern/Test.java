package parttern;

public class Test {
	public static void main(String[] args){
		Utils u = new Utils();
		System.out.println("��--����ƥ��"+u.BruteForce("qeweqwerr", "eqqq"));
		System.out.println("��--��ȷƥ��"+u.BruteForce("qeweqwerr", "eqw"));
		
		System.out.println("kmp--����ƥ��"+u.KMP("abcabcabcabc", "abab"));
		System.out.println("kmp--��ȷƥ��"+u.KMP("abcabcabababcabc", "abab"));
		
		System.out.println("kmp--����ƥ��"+u.KMPOpt("abcabcabcabc", "abab"));
		System.out.println("kmp--��ȷƥ��"+u.KMPOpt("abcabcabababcabc", "abab"));
	}
}
