package binary;

public class Demo01 {
	public static void main(String[] args) {
		/**
		 * ��ʶ2����
		 */
		int n = 16; //10000
		//��һ�������ڴ��е�2������ʾ����
		System.out.println(
			Integer.toBinaryString(n));
		//API: ��10000 ת��Ϊ ��16����ʾ
		System.out.println(n);//16
		
		for(int i=0; i<100; i++){
			System.out.println(
				Integer.toBinaryString(i));
		}
		
	}
}





