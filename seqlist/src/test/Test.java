package test;

import adt.List;
import adt.SeqList;

public class Test {
	public static void main(String[] args) {
		
		List<String> list = new SeqList<>();
		list.insert("1");
		List<String> list1 = new SeqList<>();
		list1.insert("1");
		System.out.println("�Ƿ���ȣ�"+list.equals(list1));
		System.out.println("��ȡԪ�أ�"+list.get(0));
		System.out.println("�Ƿ�Ϊ�գ�"+list.isEmpty());
		System.out.println("������"+list1.size());
		list.set(0, "2");
		System.out.println("set:"+list.get(0));
		list.insert("3");
		System.out.println("inset:"+list.get(0));
		list1.remove(0);
		System.out.println("remove"+list1.size());
		
	}
}