//�ٽ� ���̵��
//1. �Է� ���� String�� char[]�� ��ȯ
//2. �Է¸�ɿ� ���� char[]�� ����
//3. left �о��
//	3-1. index 0���� �Է¸�ɱ��� ���������Ͽ� ��ȸ
//4. right �о��
//	4-1. index ���������� ������-�Է¸�ɱ��� ���������Ͽ� ��ȸ

package step1;

public class PushOutWords {
	public String getRightpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		for (int i = lengthOfinputString; i > lengthOfinputString-inputCount; i--) {
			char tempChar = inputCharArray[lengthOfinputString - 1];
			System.out.println("tempChar " + tempChar);

			for (int j = lengthOfinputString - 1; j > 0; j--) {
				inputCharArray[j] = inputCharArray[j - 1];
				System.out.println("inputCharArray " + inputCharArray[j]);
			}

			inputCharArray[0] = tempChar;
		}
		return String.valueOf(inputCharArray);
	}
	
	public String getLeftpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		for (int index = 0; index < inputCount; index++) {
			char tempChar = inputCharArray[0];
			System.out.println("tempChar " + tempChar);

			for (int j = 0; j < lengthOfinputString - 1; j++) {
				inputCharArray[j] = inputCharArray[j + 1];
				System.out.println("inputCharArray " + inputCharArray[j]);
			}

			inputCharArray[inputCharArray.length - 1] = tempChar;
		}

		return String.valueOf(inputCharArray);
	}
	

	
	

	public static void main(String[] args) {

		String inputString = "apple";
		int inputCount = 3;
		String inputDir = "l";
		int lengthOfinputString = inputString.length();
		PushOutWords pushWords = new PushOutWords();

		char[] inputCharArray = inputString.toCharArray();
		inputDir = inputDir.toUpperCase();

		if (inputDir.equals("R")) {
			String answer = pushWords.getRightpushedString(inputCharArray, inputCount, lengthOfinputString);
			
			System.out.println("test R " + answer);
			
		} else if (inputDir.equals("L")) {
			String answer = pushWords.getLeftpushedString(inputCharArray, inputCount, lengthOfinputString);
			
			System.out.println("test L " + answer);
			
		} else {
			System.out.println("��ȿ�� ��ɾ �Է��Ͻʽÿ�");
		}

	}
}
