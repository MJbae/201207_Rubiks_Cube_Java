package step2;

public class PromptCube {
	
	public void printResult(char[][] twoDimensionalCube) {
		for(char[] oneDimensionalCube : twoDimensionalCube) {
			for(char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// �ʱⰪ ����
		char[][] twoDimensionalCube = { { 'R', 'R', 'W' }, { 'R', 'R', 'W' }, { 'R', 'R', 'W' } };
		final int SIZE_OF_CUBE = twoDimensionalCube[0].length;
		String inputDir = "U'";
		
		PromptCube prompt = new PromptCube();
		PushTwoDimensionalCube pushCube = new PushTwoDimensionalCube();
		
		// ���: �ʱⰪ ���
		prompt.printResult(twoDimensionalCube);
		System.out.println("");
		// �Է�: ex) UUR
		System.out.println("");
		
		// �ݺ�: ������ ��� ����
		// ��� ���� ����
		pushCube.getPushedCube(twoDimensionalCube, inputDir, SIZE_OF_CUBE);
		
		// ���: ������ ���
		// ���: ����� ������ �����
		prompt.printResult(twoDimensionalCube);

	}

}
