//핵심 아이디어
//1. 입력 받은 String을 char[]로 변환
//2. 입력명령에 따라 char[]을 조작
//3. left 밀어내기
//	3-1. index 0부터 입력명령까지 순차증가하여 순회
//4. right 밀어내기
//	4-1. index 마지막부터 마지막-입력명령까지 순차감소하여 순회

package step1;

public class PushOutWords {
	
	public String getRightpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		for (int i = lengthOfinputString; i > lengthOfinputString - inputCount; i--) {
			char tempChar = inputCharArray[lengthOfinputString - 1];

			for (int j = lengthOfinputString - 1; j > 0; j--) {
				inputCharArray[j] = inputCharArray[j - 1];
			}

			inputCharArray[0] = tempChar;
		}
		return String.valueOf(inputCharArray);
	}

	public String getLeftpushedString(char[] inputCharArray, int inputCount, int lengthOfinputString) {
		for (int index = 0; index < inputCount; index++) {
			char tempChar = inputCharArray[0];

			for (int j = 0; j < lengthOfinputString - 1; j++) {
				inputCharArray[j] = inputCharArray[j + 1];
			}

			inputCharArray[inputCharArray.length - 1] = tempChar;
		}

		return String.valueOf(inputCharArray);
	}

	public static void main(String[] args) {
	}
}
