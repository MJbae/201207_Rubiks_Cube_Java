package step2;

import step1.*;

public class PushTwoDimensionalCube {
	// TODO: 자바에서 메소드를 매개변수로 전달하는 방법 학습 후 R,R',L,L' 중복코드 제거하기
	public char[][] getPushedCube(char[][] twoDimensionalCube, String inputDir, int SIZE_OF_CUBE) {

		PushOutWords pushWords = new PushOutWords();
		char[] tempCube = new char[SIZE_OF_CUBE];

		switch (inputDir) {
		case "U":
			twoDimensionalCube[0] = pushWords.getLeftpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
			break;
		case "U'":
			twoDimensionalCube[0] = pushWords.getRightpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
			break;
		case "R":
			for (int i = 0; i < SIZE_OF_CUBE; i++)
				tempCube[i] = twoDimensionalCube[i][SIZE_OF_CUBE - 1];
			tempCube = pushWords.getLeftpushedString(tempCube, 1, SIZE_OF_CUBE);
			for (int j = 0; j < SIZE_OF_CUBE; j++)
				twoDimensionalCube[j][SIZE_OF_CUBE - 1] = tempCube[j];
			break;
		case "R'":
			for (int i = 0; i < SIZE_OF_CUBE; i++)
				tempCube[i] = twoDimensionalCube[i][SIZE_OF_CUBE - 1];
			tempCube = pushWords.getRightpushedString(tempCube, 1, SIZE_OF_CUBE);
			for (int j = 0; j < SIZE_OF_CUBE; j++)
				twoDimensionalCube[j][SIZE_OF_CUBE - 1] = tempCube[j];
			break;
		case "L":
			for (int i = 0; i < SIZE_OF_CUBE; i++)
				tempCube[i] = twoDimensionalCube[i][0];
			tempCube = pushWords.getRightpushedString(tempCube, 1, SIZE_OF_CUBE);
			for (int j = 0; j < SIZE_OF_CUBE; j++)
				twoDimensionalCube[j][0] = tempCube[j];
			break;
		case "L'":
			for (int i = 0; i < SIZE_OF_CUBE; i++)
				tempCube[i] = twoDimensionalCube[i][0];
			tempCube = pushWords.getLeftpushedString(tempCube, 1, SIZE_OF_CUBE);
			for (int j = 0; j < SIZE_OF_CUBE; j++)
				twoDimensionalCube[j][0] = tempCube[j];
			break;
		case "B":
			twoDimensionalCube[SIZE_OF_CUBE - 1] = pushWords.getLeftpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1],
					1, SIZE_OF_CUBE);
			break;
		case "B'":
			twoDimensionalCube[SIZE_OF_CUBE - 1] = pushWords.getRightpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1],
					1, SIZE_OF_CUBE);
			break;
		default:
			break;
		}

		return twoDimensionalCube;
	}
}