//핵심 아이디어
//1. 2차원 배열을 활용하여 초기값을 할당
//2. 가장 왼쪽 및 오른쪽 회전 구현
//3. 가장 위쪽 및 아래쪽 회전 구현

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
