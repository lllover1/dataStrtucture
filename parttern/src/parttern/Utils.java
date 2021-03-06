package parttern;

public class Utils {
	
	/**
	 * �ַ�����ƥ��
	 * @param target    Ŀ���ַ���
	 * @param parttern  ģʽ�ַ���
	 * @return ����ֵ -1 ƥ��ʧ�ܣ����� ��ʼλ��
	 */
	public  int BruteForce(String target,String parttern){
		int pLength = parttern.length();
		int tLength = target.length();
		if(pLength==0||tLength<pLength){
			return -1;
		}
		int i=0,j=0;
		while(i<tLength&&j<pLength){
			if(target.charAt(i)==parttern.charAt(j)){
				i++;
				j++;
			}else{
				i = i-j+1;
				j =0;
				if(i>tLength-pLength){
					break;
				}
			}
		}
		if(j==pLength){
			return i-j;
		}else{
			return -1;
		}
	}
	
	/**
	 * �ַ���KMPƥ���㷨
	 * @param target    Ŀ���ַ���
	 * @param parttern  ģʽ�ַ���
	 * @return ����ֵ -1 ƥ��ʧ�ܣ����� ��ʼλ��
	 */
	public int KMP(String target,String parttern){
		int tLength = target.length();
		int pLength = parttern.length();
		int[] next = getNext(parttern);
		if(tLength<pLength||pLength==0){
			return -1;
		}
		int i = 0,j=0;
		while(i<tLength&&j<pLength){
			if(j==-1||target.charAt(i)==parttern.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
				if(pLength-j>tLength-i){
					break;
				}
			}
		}
		
		if(j==pLength){
			return i-j;
		}
		return -1;
	}
	
	private int[] getNext(String parttern){
		int pLength = parttern.length();
		int[] next = new int[pLength];
		next[0] = -1;
		int j =0;
		int k = -1;
		while(j<pLength-1){
			if(k==-1||parttern.charAt(j)==parttern.charAt(k)){
				j++;
				k++;
				next[j] = k;
			}else{
				k = next[k];
			}
		}
		return next;
	}
	
	public int KMPOpt(String target,String parttern){
		int tLength = target.length();
		int pLength = parttern.length();
		int[] next = getNextOpt(parttern);
		if(tLength<pLength||pLength==0){
			return -1;
		}
		int i = 0,j=0;
		while(i<tLength&&j<pLength){
			if(j==-1||target.charAt(i)==parttern.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
				if(pLength-j>tLength-i){
					break;
				}
			}
		}
		
		if(j==pLength){
			return i-j;
		}
		return -1;
	}
	
	private int[] getNextOpt(String parttern){
		int pLength = parttern.length();
		int[] next = new int[pLength];
		next[0] = -1;
		int j =0;
		int k = -1;
		while(j<pLength-1){
			if(k==-1||parttern.charAt(j)==parttern.charAt(k)){
				j++;
				k++;
				if(parttern.charAt(j)!= parttern.charAt(k)){
					next[j] = k;
				}else{
					next[j] = next[k]; 
				}
			}else{
				k = next[k];
			}
		}
		return next;
	}
	
}