//핵심 아이디어
//1. 입력 받은 String을 char[]로 변환
//2. 입력명령에 따라 char[]을 조작
//3. left 밀어내기
//	3-1. index 0부터 입력명령까지 순차증가하여 순회
//4. right 밀어내기
//	4-1. index 마지막부터 마지막-입력명령까지 순차감소하여 순회

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
