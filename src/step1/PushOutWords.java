package step1;

public class PushOutWords {
	
	// �޼ҵ�: ������ �������� �Է� ���� �ܾ ȸ��
	public char[] getRightpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray�� ���� ������ ��Ҹ� �� ������ �̵�
		for (int i = lengthOfinputString; i > lengthOfinputString - inputCount; i--) {
			char tempChar = inputCharArray[lengthOfinputString - 1];

			for (int j = lengthOfinputString - 1; j > 0; j--) {
				inputCharArray[j] = inputCharArray[j - 1];
			}

			inputCharArray[0] = tempChar;
		}
		return inputCharArray;
	}
	
	// �޼ҵ�: ���� �������� �Է� ���� �ܾ ȸ��
	public char[] getLeftpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray�� ���� ù��° ��Ҹ� ���������� �̵�
		for (int index = 0; index < inputCount; index++) {
			char tempChar = inputCharArray[0];

			for (int j = 0; j < lengthOfinputString - 1; j++) {
				inputCharArray[j] = inputCharArray[j + 1];
			}

			inputCharArray[inputCharArray.length - 1] = tempChar;
		}

		return inputCharArray;
	}
}
