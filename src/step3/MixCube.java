package step3;

public class MixCube {

	private static final String[] INPUTS = PromptRubiks.VALID_INPUTS;

	// 메소드: 유효명령어 배열의 요소를 무작위로 선택하여 각각의 명령어로 큐브를 회전
	public char[][][] getMixedCube(char[][][] rubiksCube) {
		PushRubiksCube pushRubiks = new PushRubiksCube();
		int tempRandom = getRandomInt();
		// 무작위 수가 너무 작을 경우에 대해 default값 적용
		int randomInt = (tempRandom > 2) ? tempRandom : 3;
		String[] mixedInputs = new String[randomInt];

		// 유효한 명령어 배열(INPUTS)에서 요소를 무작위로 선택하여 mixedInputs 배열에 할당
		for (int i = 0; i < randomInt; i++) {
			int randomInt2 = getRandomInt();

			mixedInputs[i] = INPUTS[randomInt2];
		}

		// 무작위로 선택한 실행명령어 배열의 모든 요소에 따라 큐브 회전
		for (String inputDir : mixedInputs)
			rubiksCube = pushRubiks.getPushedRubiks(rubiksCube, inputDir);

		System.out.println("");
		PrintAllSides printAll = new PrintAllSides();
		printAll.printResult(rubiksCube);

		return rubiksCube;
	}

	// 메소드: 무작위 숫자 생성하여 정수형태로 반환
	public int getRandomInt() {
		double randomNum = Math.random();
		return (int) (randomNum * 10);
	}


}
