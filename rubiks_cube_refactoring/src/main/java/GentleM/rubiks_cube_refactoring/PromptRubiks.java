package GentleM.rubiks_cube_refactoring;

import java.util.Arrays;
import java.util.Scanner;

public class PromptRubiks {
	private static int numOfRotation = 0;
	public static final String[] VALID_INPUTS = { "R", "R'", "L", "L'", "U", "U'", "D", "D'", "F", "F'", "B", "B'",
			"R2", "L2", "U2", "D2", "F2", "B2" };

	// 메소드: 전체로직(사용자 입력부터 결과물 출력까지)에 대해 실행
	public void executePrompt(char[][][] rubiksCube) {
		PrintAllSides printAll = new PrintAllSides();
		MixCube mix = new MixCube();
		Utils util = new Utils();
		Scanner scanner = new Scanner(System.in);
		long startTime = System.currentTimeMillis();

		// 초기값 깊은 복사
		char[][][] initialRubiks = util.copyOfRubiks(rubiksCube);
		printAll.printResult(initialRubiks);
		
		// 무작위 섞기 및 프로그램 종료 안내 출력
		System.out.println("  조작 명령어(M: 무작위 섞기 Q: 프로그램 종료)");
		
		while (true) {

			// 사용자 입력 prompt
			System.out.print("  CUBE> ");
			String input = scanner.nextLine();

			// 프로그램 종료
			if (input.equals("Q"))
				break;

			// 무작위 섞기 기능 실행
			if (input.equals("M")) {
				rubiksCube = mix.getMixedCube(rubiksCube);
				continue;
			}

			// 입력값을 구분하여 String array에 할당
			String[] splitStringArray = splitInputString(input);

			// 각각의 명령에 따라 큐브 회전
			rubiksCube = runRotation(rubiksCube, splitStringArray, numOfRotation);

			// 초기상태 큐브와 비교
			// 같으면 축하메세지 출력 및 종료
			if (Arrays.deepEquals(initialRubiks, rubiksCube)) {
				System.out.println("  축하합니다. 모든 면을 맞추셨네요~");
				break;
			}
		}
		// printResult
		printResult(startTime);

		scanner.close();
	}

	// 메소드: 실행 종료에 따른 결과값(조작개수/경과시간) 출력
	public void printResult(long startTime){
		Utils util = new Utils();
		// 조작개수 출력
		System.out.println("  조작개수: " + numOfRotation);
		// 경과시간 출력
		util.getElapsedTime(startTime);
		System.out.println("  끝~ ");
	}

	// 메소드: 사용자 입력값을 유효한 명령으로 나누어 반환
	public String[] splitInputString(String input) {

		StringBuffer inputSplit = new StringBuffer(input);
		int indexOfSplit = 1;

		// String input의 각 문자에 대해 순회
		for (int i = 0; i < input.length() - 1; i++) {
			// 작은따옴표 or '2' or '3'이 있는 경우, 해당 문자 기준 우측에 공백 문자 삽입
			if (input.charAt(i + 1) == 39 || input.charAt(i + 1) == 50 || input.charAt(i + 1) == 51) {
				indexOfSplit += 1;
				inputSplit.insert(indexOfSplit, " ");
				i++;
				indexOfSplit += 2;
				// 일반 문자일 경우, 다음 문자에 작은 따옴표가 없다면 문자 기준 우측에 공백 문자 삽입
			} else {
				inputSplit.insert(indexOfSplit, " ");
				indexOfSplit += 2;
			}
		}
		return new String(inputSplit).split(" ");
	}

	// 메소드: 유효한 입력값인지 확인
	public boolean isValidInput(String input) {
		boolean isValid = false;

		for (String eachInput : VALID_INPUTS) {
			if (input.equals(eachInput)) {
				isValid = true;
				break;
			}
		}

		return isValid;
	}

	// 메소드: 명령에 따라 큐브 회전
	public char[][][] runRotation(char[][][] rubiksCube, String[] splitStringArray, int numOfRotation) {
		PushRubiksCube pushRubiks = new PushRubiksCube();
		PrintAllSides printAll = new PrintAllSides();

		for (String inputDir : splitStringArray) {
			// 각 입력값의 유효성 체크
			if (!isValidInput(inputDir)) {
				System.out.println("  " + inputDir + ": 유효하지 않은 입력값입니다");
				break;
			}
			// 입력개수 카운팅
			countRotation(inputDir);
			// 유효 입력에 따라 Rubiks Cube 회전
			rubiksCube = pushRubiks.getPushedRubiks(rubiksCube, inputDir);
			// 각 명령에 따른 회전 결과 출력
			System.out.println("");
			System.out.println("  " + inputDir);
			printAll.printResult(rubiksCube);
		}
		return rubiksCube;
	}

	// 메소드: 조작 개수 카운트
	public void countRotation(String input) {
		if (input.contains("2")) {
			numOfRotation += 2;
		} else if (input.contains("3")) {
			numOfRotation += 3;
		} else {
			numOfRotation += 1;
		}
	}

	public static void main(String[] args) {
		// 초기값 정의
		char[][] frontCube = { { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' } };
		char[][] upCube = { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' } };
		char[][] leftCube = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		char[][] downCube = { { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' } };
		char[][] rightCube = { { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' } };
		char[][] backCube = { { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' } };
		char[][][] rubiksCube = { backCube, upCube, leftCube, downCube, rightCube, frontCube };

		// prompt 실행
		PromptRubiks prompt = new PromptRubiks();
		prompt.executePrompt(rubiksCube);
	}

}