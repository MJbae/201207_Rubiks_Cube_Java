package step1;

public class PushOutWords {
	public char[] getPushed(char[] inputCharArray, int inputCount, String inputDir, int lengthOfinputString) {
		// ���������� ���ڸ� ȸ����Ű�� ���
		if ((inputCount >= 0 && inputDir.equals("R")) || (inputCount < 0 && inputDir.equals("L"))) {
			inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
			return getRightpushedString(inputCharArray, inputCount, inputCharArray.length);
		// �������� ���ڸ� ȸ����Ű�� ���
		} else if ((inputCount >= 0 && inputDir.equals("L")) || (inputCount < 0 && inputDir.equals("R"))) {
			inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
			return getLeftpushedString(inputCharArray, inputCount, inputCharArray.length);
		} else {
			return null;
		}
	}

	// ������ �������� �Է� ���� �ܾ ȸ����Ű�� �޼ҵ�
	public char[] getRightpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray�� ���� ������ ��Ҹ� �� ������ �ű�� ����
		for (int i = lengthOfinputString; i > lengthOfinputString - inputCount; i--) {
			char tempChar = inputCharArray[lengthOfinputString - 1];

			for (int j = lengthOfinputString - 1; j > 0; j--) {
				inputCharArray[j] = inputCharArray[j - 1];
			}

			inputCharArray[0] = tempChar;
		}
		return inputCharArray;
	}

	// ���� �������� �Է� ���� �ܾ ȸ����Ű�� �޼ҵ�
	public char[] getLeftpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray�� ���� ù��° ��Ҹ� ���������� �ű�� ����
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
