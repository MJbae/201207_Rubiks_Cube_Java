package step2;

import step1.*;

public class PushTwoDimensionalCube {
	// 메소드: 문자 이동방향에 따라 하위 메소드 호출
	public char[][] getPushedCube(char[][] flatCube, String inputDir, int SIZE_OF_CUBE) {

		char[] tempCube = new char[SIZE_OF_CUBE];

		// contains 메소드 활용하여 이동방향의 부분값으로 하위 메소드 구분 호출
		 if(inputDir.contains("U")){
			 flatCube[0] = getUpBottomPushed(flatCube[0], SIZE_OF_CUBE, inputDir);
		 } else if(inputDir.contains("B")) {
			 flatCube[SIZE_OF_CUBE - 1] = getUpBottomPushed(flatCube[SIZE_OF_CUBE - 1], SIZE_OF_CUBE, inputDir);
		 } else if(inputDir.contains("L")) {
			 flatCube = getLeftPushed(flatCube, SIZE_OF_CUBE, inputDir, tempCube);
		 } else if(inputDir.contains("R")) {
			 flatCube = getRightPushed(flatCube, SIZE_OF_CUBE, inputDir, tempCube);
		 }
		 
		return flatCube;
	}
	
	// 메소드: Right side로 문자 이동
	public char[][] getRightPushed(char[][] inputArray, int SIZE_OF_CUBE, String inputDir, char[] tempCube) {
		PushOutWords pushWords = new PushOutWords();

		for (int i = 0; i < SIZE_OF_CUBE; i++)
			tempCube[i] = inputArray[i][SIZE_OF_CUBE - 1];
		
		// 시계방향, 반시계방향 구분하여 임시 변수에 이동할 문자 할당
		tempCube = (inputDir.equals("R"))
				? pushWords.getLeftPushedString(tempCube, 1, SIZE_OF_CUBE)
				: pushWords.getRightPushedString(tempCube, 1, SIZE_OF_CUBE);
		
		for (int j = 0; j < SIZE_OF_CUBE; j++)
			inputArray[j][SIZE_OF_CUBE - 1] = tempCube[j];
		
		return inputArray;
	}
	
	// 메소드: Left side로 문자 이동
	public char[][] getLeftPushed(char[][] inputArray, int SIZE_OF_CUBE, String inputDir, char[] tempCube) {
		PushOutWords pushWords = new PushOutWords();

		for (int i = 0; i < SIZE_OF_CUBE; i++)
			tempCube[i] = inputArray[i][0];
		
		// 시계방향, 반시계방향 구분하여 임시 변수에 이동할 문자 할당
		tempCube = (inputDir.equals("L"))
				? pushWords.getRightPushedString(tempCube, 1, SIZE_OF_CUBE)
				: pushWords.getLeftPushedString(tempCube, 1, SIZE_OF_CUBE);
		
		for (int j = 0; j < SIZE_OF_CUBE; j++)
			inputArray[j][0] = tempCube[j];
		
		return inputArray;
	}

	// 메소드: Up or Bottom side로 문자 이동
	public char[] getUpBottomPushed(char[] inputArray, int SIZE_OF_CUBE, String inputDir) {
		PushOutWords pushWords = new PushOutWords();

		if (inputDir.equals("U") || inputDir.equals("B'")) {
			return pushWords.getLeftPushedString(inputArray, 1, SIZE_OF_CUBE);
		} else if (inputDir.equals("U'") || inputDir.equals("B")) {
			return pushWords.getRightPushedString(inputArray, 1, SIZE_OF_CUBE);
		} else {
			return null;
		}
	}
}
