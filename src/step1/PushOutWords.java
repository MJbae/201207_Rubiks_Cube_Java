//�ٽ� ���̵��
//1. �Է� ���� String�� char[]�� ��ȯ
//2. �Է¸�ɿ� ���� char[]�� ����
//3. left �о��
//	3-1. index 0���� �Է¸�ɱ��� ���������Ͽ� ��ȸ
//4. right �о��
//	4-1. index ���������� ������-�Է¸�ɱ��� ���������Ͽ� ��ȸ

package step1;

public class PushOutWords {
	
	
	public static void main(String[] args) {
		
		String inputString = "apple";
		int inputCount = 3;
		char inputDir = 'L';
		
		char[] inputCharArray = inputString.toCharArray();
		
		for(int index = 0; index < inputCount; index++) {
			char tempChar = inputCharArray[0];
			System.out.println("tempChar " + tempChar);
			
			for(int j = 0; j < inputCharArray.length - 1; j++) {
				inputCharArray[j] = inputCharArray[j + 1];
				System.out.println("inputCharArray " + inputCharArray[j]);
			}
			
			inputCharArray[inputCharArray.length - 1] = tempChar;
		}
		
		String answer = String.valueOf(inputCharArray);
		System.out.println("test " + answer);
	}
}
