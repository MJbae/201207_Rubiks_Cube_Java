package step1;

public class PushOutWords {
	
	// 오른쪽 방향으로 입력 받은 단어를 회전시키는 메소드
	public char[] getRightpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray에 대해 마지막 요소를 맨 앞으로 옮기는 로직
		for (int i = lengthOfinputString; i > lengthOfinputString - inputCount; i--) {
			char tempChar = inputCharArray[lengthOfinputString - 1];

			for (int j = lengthOfinputString - 1; j > 0; j--) {
				inputCharArray[j] = inputCharArray[j - 1];
			}

			inputCharArray[0] = tempChar;
		}
		return inputCharArray;
	}
	
	// 왼쪽 방향으로 입력 받은 단어를 회전시키는 메소드
	public char[] getLeftpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		// inputCharArray에 대해 첫번째 요소를 마지막으로 옮기는 로직
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
