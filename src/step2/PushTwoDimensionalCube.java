//�ٽ� ���̵��
//1. 2���� �迭�� Ȱ���Ͽ� �ʱⰪ�� �Ҵ�
//2. ���� ���� �� ������ ȸ�� ����
//3. ���� ���� �� �Ʒ��� ȸ�� ����

package step2;

import step1.*;

public class PushTwoDimensionalCube {
	
	public char[][] getPushedCube(char[][] twoDimensionalCube, String inputDir, int SIZE_OF_CUBE) {
		
		PushOutWords pushWords = new PushOutWords();

		switch(inputDir) {
		case "U":
			twoDimensionalCube[0] = pushWords.getLeftpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
			break;
		case "U'":
			twoDimensionalCube[0]= pushWords.getRightpushedString(twoDimensionalCube[0], 1, SIZE_OF_CUBE);
			break;
		case "B":
			twoDimensionalCube[SIZE_OF_CUBE - 1] = pushWords.getLeftpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1], 1, SIZE_OF_CUBE);
			break;
		case "B'":
			twoDimensionalCube[SIZE_OF_CUBE - 1] = pushWords.getRightpushedString(twoDimensionalCube[SIZE_OF_CUBE - 1], 1, SIZE_OF_CUBE);
			break;
		default:
			break;
		}
		
		return twoDimensionalCube;
	}
}
