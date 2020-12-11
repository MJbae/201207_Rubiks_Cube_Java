package step1;

public class PushOutWords {
	// �޼ҵ�: ����� �Է°��� ���� ��������� �̵��ϴ� ������ ���� ��쿡 ���� ������ �޼ҵ� ����
	public char[] getPushed(char[] inputCharArray, int inputCount, String inputDir) {
		// ���������� �Է´ܾ �̵��ϴ� ���(�Է����� ����, �̵����� ���� + ���� ���, �̵����� ������) 
		if ((inputCount >= 0 && inputDir.equals("R")) || (inputCount < 0 && inputDir.equals("L"))) {
			inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
			return getRightPushedString(inputCharArray, inputCount, inputCharArray.length);
			
		// �������� �Է´ܾ �̵��ϴ� ���(�Է������� ���, �̵����� ������ + ���� ����, �̵����� ����) 
		} else if ((inputCount >= 0 && inputDir.equals("L")) || (inputCount < 0 && inputDir.equals("R"))) {
			inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
			return getLeftPushedString(inputCharArray, inputCount, inputCharArray.length);
		} else {
			return null;
		}
	}

	// �޼ҵ�: ������ �������� �Է´ܾ� �̵�
	public char[] getRightPushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
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

	// �޼ҵ�: ���� �������� �Է´ܾ� �̵�
	public char[] getLeftPushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
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
