package step1;

public class PushOutWords {

	// 메소드: 사용자 입력값에 따라 결과적으로 이동하는 방향이 같은 경우에 대해 적절한 메소드 구분
	public char[] getPushed(char[] inputCharArray, int inputCount, String inputDir) {
		// 오른쪽으로 입력단어가 이동하는 경우(입력정수 음수, 이동방향 왼쪽 + 정수 양수, 이동방향 오른쪽) 
		if ((inputCount >= 0 && inputDir.equals("R")) || (inputCount < 0 && inputDir.equals("L"))) {
			inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
			return getRightPushedString(inputCharArray, inputCount, inputCharArray.length);
			
		// 왼쪽으로 입력단어가 이동하는 경우(입력정수가 양수, 이동방향 오른쪽 + 정수 음수, 이동방향 왼쪽) 
		} else if ((inputCount >= 0 && inputDir.equals("L")) || (inputCount < 0 && inputDir.equals("R"))) {
			inputCount = inputCount < 0 ? inputCount * (-1) : inputCount;
			return getLeftPushedString(inputCharArray, inputCount, inputCharArray.length);
		} else {
			return null;
		}
	}

	// 메소드: 오른쪽 방향으로 입력단어 이동
	public char[] getRightPushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
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

	// 메소드: 왼쪽 방향으로 입력단어 이동
	public char[] getLeftPushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {

		// inputCharArray에 대해 첫번째 요소를 마지막으로 옮기는 로직
		for (int i = 0; i < inputCount; i++) {
			char tempChar = inputCharArray[0];

			for (int j = 0; j < lengthOfinputString - 1; j++) {
				inputCharArray[j] = inputCharArray[j + 1];
			}

			inputCharArray[inputCharArray.length - 1] = tempChar;
		}

		return inputCharArray;
	}
}
