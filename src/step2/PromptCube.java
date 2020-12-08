package step2;

public class PromptCube {
	
	public void printResult(char[][] twoDimensionalCube) {
		for(char[] oneDimensionalCube : twoDimensionalCube) {
			for(char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// 초기값 선언
		char[][] twoDimensionalCube = { { 'R', 'R', 'W' }, { 'R', 'R', 'W' }, { 'R', 'R', 'W' } };
		final int SIZE_OF_CUBE = twoDimensionalCube[0].length;
		String inputDir = "U'";
		
		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();
		
		// 출력: 초기값 출력
		prompt.printResult(twoDimensionalCube);
		System.out.println("");
		// 입력: ex) UUR
		System.out.println("");
		
		// 반복: 각각의 명령 수행
		// 명령 실행 로직
		pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);
		
		// 출력: 각각의 명령
		// 출력: 명령을 수행한 결과물
		prompt.printResult(twoDimensionalCube);

	}

}
