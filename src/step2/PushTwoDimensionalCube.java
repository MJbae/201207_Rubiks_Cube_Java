//핵심 아이디어
//1. 2차원 배열을 활용하여 초기값을 할당
//2. 가장 왼쪽 및 오른쪽 회전 구현
//3. 가장 위쪽 및 아래쪽 회전 구현

package step2;

import step1.*;

public class PushTwoDimensionalCube {

	final static int SIZE_OF_CUBE = 3;

	public static void main(String[] args) {
		char[][] twoDimensionalCube = { { 'R', 'R', 'W' }, { 'R', 'R', 'W' }, { 'R', 'R', 'W' } };
		String inputDir = "B'";

		PushOutWords pushWords = new PushOutWords();

		switch(inputDir) {
		case "U":
			pushWords.getLeftpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
			break;
		case "U'":
			pushWords.getRightpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
			break;
		case "B":
			pushWords.getLeftpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1], 1, SIZE_OF_CUBE);
			break;
		case "B'":
			pushWords.getRightpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1], 1, SIZE_OF_CUBE);
			break;
		}
		
		for(char[] oneDimensionalCube : twoDimensionalCube) {
			for(char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}

	}

}
