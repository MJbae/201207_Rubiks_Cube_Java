//�ٽ� ���̵��
//1. �Է� ���� String�� char[]�� ��ȯ
//2. �Է¸�ɿ� ���� char[]�� ����
//3. left �о��
//	3-1. index 0���� �Է¸�ɱ��� ���������Ͽ� ��ȸ
//4. right �о��
//	4-1. index ���������� ������-�Է¸�ɱ��� ���������Ͽ� ��ȸ

package step1;

public class PushOutWords {
	
	// ������ �������� �Է� ���� �ܾ ȸ����Ű�� �޼ҵ�
	public String getRightpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray�� ���� ������ ��Ҹ� �� ������ �ű�� ����
		for (int i = lengthOfinputString; i > lengthOfinputString - inputCount; i--) {
			char tempChar = inputCharArray[lengthOfinputString - 1];

			for (int j = lengthOfinputString - 1; j > 0; j--) {
				inputCharArray[j] = inputCharArray[j - 1];
			}

			inputCharArray[0] = tempChar;
		}
		return String.valueOf(inputCharArray);
	}
	
	// ���� �������� �Է� ���� �ܾ ȸ����Ű�� �޼ҵ�
	public String getLeftpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray�� ���� ù��° ��Ҹ� ���������� �ű�� ����
		for (int index = 0; index < inputCount; index++) {
			char tempChar = inputCharArray[0];

			for (int j = 0; j < lengthOfinputString - 1; j++) {
				inputCharArray[j] = inputCharArray[j + 1];
			}

			inputCharArray[inputCharArray.length - 1] = tempChar;
		}

		return String.valueOf(inputCharArray);
	}
}
