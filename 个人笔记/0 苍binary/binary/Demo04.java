package binary;

import java.io.RandomAccessFile;

public class Demo04 {
	public static void main(String[] args) {
		/**
		 * ����Ļ����Գ���
		 * 
		 * ~ �����ǽ����ݵ�2����ֵȡ�� 1��0 0��1
		 */
		int n = 100;
		int m = ~n+1;
		System.out.println(m);//-100
		//չʾ��ȡ����һ�Ĺ���ԭ��
		n = 8;
		System.out.println(
				Integer.toBinaryString(n));
		System.out.println(
				Integer.toBinaryString(~n));
		System.out.println(
				Integer.toBinaryString(~n+1));
		
		//����������Ŀ��
		System.out.println(~-5);
		//���ϴ���Ľ���ǣ�  �� �𰸣�B
		//A.-5  B.4  C.5  D.6
		
		//RandomAccessFile raf;
		//raf.writeInt(v);
		
	}
}



