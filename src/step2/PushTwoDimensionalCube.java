package step2;

import step1.*;

public class PushTwoDimensionalCube {
	// TODO: 자바에서 메소드를 매개변수로 전달하는 방법 학습 후 R,R',L,L' 중복코드 제거하기
	public char[][] getPushedCube(char[][] twoDimensionalCube, String inputDir, int SIZE_OF_CUBE) {

		PushOutWords pushWords = new PushOutWords();
		char[] tempCube = new char[SIZE_OF_CUBE];

		// else if로 중간 구분하고 switch 사용 X
		 if(inputDir.contains("U")){
			 twoDimensionalCube[0] = getUpBottomPushed(twoDimensionalCube[0], SIZE_OF_CUBE, inputDir);
		 } else if(inputDir.contains("B")) {
			 twoDimensionalCube[SIZE_OF_CUBE - 1] = getUpBottomPushed(twoDimensionalCube[SIZE_OF_CUBE - 1], SIZE_OF_CUBE, inputDir);
		 }
		 
		switch (inputDir) {
//		case "U":
//			twoDimensionalCube[0] = pushWords.getLeftpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
//			break;
//		case "U'":
//			twoDimensionalCube[0] = pushWords.getRightpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
//			break;
//		case "B":
//			twoDimensionalCube[SIZE_OF_CUBE - 1] = pushWords.getLeftpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1],
//					1, SIZE_OF_CUBE);
//			break;
//		case "B'":
//			twoDimensionalCube[SIZE_OF_CUBE - 1] = pushWords.getRightpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1],
//					1, SIZE_OF_CUBE);
//			break;
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
		default:
			break;
		}

		return twoDimensionalCube;
	}

	public char[] getUpBottomPushed(char[] inputArray, int SIZE_OF_CUBE, String inputDir) {
		PushOutWords pushWords = new PushOutWords();

		if (inputDir.equals("U") || inputDir.equals("B")) {
			return pushWords.getLeftpushedString(inputArray, 1, SIZE_OF_CUBE);
		} else if (inputDir.equals("U'") || inputDir.equals("B'")) {
			return pushWords.getRightpushedString(inputArray, 1, SIZE_OF_CUBE);
		} else {
			return null;
		}
	}
}