package binary;

public class Demo06 {

	public static void main(String[] args) 
		throws Exception {
		/**
		 * UTF-8 ������ʾ
		 * 
		 * 0~127 1�ֽڱ���
		 * 128~2047 2�ֽڱ���
		 * 2048~65535 3�ֽڱ���
		 * 65536~1000000 4�ֽڱ���
		 */
		// 65      ������1�ֽ�
		// 2000 ������2�ֽ�
		// '��' ������3�ֽ�
		char[] chs = {65, 2000, '��'};
		String str = new String(chs);
		//UTF-8����
		byte[] bytes=str.getBytes("UTF-8");
		System.out.println(bytes.length); 
		
		//UTF-8����
		String s = new String(bytes, "UTF-8");
		System.out.println(s);
	}

}
