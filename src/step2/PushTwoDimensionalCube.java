//�ٽ� ���̵��
//1. 2���� �迭�� Ȱ���Ͽ� �ʱⰪ�� �Ҵ�
//2. ���� ���� �� ������ ȸ�� ����
//3. ���� ���� �� �Ʒ��� ȸ�� ����

package step2;

public class PushTwoDimensionalCube {
	
	private static char[][] TWO_DIMENSIONAL_CUBE = {{'R', 'R', 'W'}, {'R', 'R', 'W'}, {'R', 'R', 'W'}};

	public static void main(String[] args) {
		for(char[] oneDimensionalCube : TWO_DIMENSIONAL_CUBE) {
			for(char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}

	}

}
