//�ٽ� ���̵��
//1. 2���� �迭�� Ȱ���Ͽ� �ʱⰪ�� �Ҵ�
//2. ���� ���� �� ������ ȸ�� ����
//3. ���� ���� �� �Ʒ��� ȸ�� ����

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
