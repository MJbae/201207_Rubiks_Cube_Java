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
		 } else if(inputDir.contains("L")) {
			 twoDimensionalCube = getLeftPushed(twoDimensionalCube, SIZE_OF_CUBE, inputDir, tempCube);
		 } 
		 
		switch (inputDir) {
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
		default:
			break;
		}

		return twoDimensionalCube;
	}
	
	public char[][] getLeftPushed(char[][] inputArray, int SIZE_OF_CUBE, String inputDir, char[] tempCube) {
		PushOutWords pushWords = new PushOutWords();

		for (int i = 0; i < SIZE_OF_CUBE; i++)
			tempCube[i] = inputArray[i][0];
		
		if (inputDir.equals("L")) {
			tempCube = pushWords.getRightpushedString(tempCube, 1, SIZE_OF_CUBE);
		} else if (inputDir.equals("L'")) {
			tempCube = pushWords.getLeftpushedString(tempCube, 1, SIZE_OF_CUBE);
		} else {
			inputArray = null;
		}
		
		for (int j = 0; j < SIZE_OF_CUBE; j++)
			inputArray[j][0] = tempCube[j];
		
		return inputArray;
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