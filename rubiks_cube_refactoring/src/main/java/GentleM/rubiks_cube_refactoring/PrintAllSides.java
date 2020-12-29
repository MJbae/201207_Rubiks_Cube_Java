package GentleM.rubiks_cube_refactoring;

public class PrintAllSides {
	private static final int BACK_SIDE = PushRubiksCube.BACK_SIDE;
	private static final int UP_SIDE = PushRubiksCube.UP_SIDE;
	private static final int LEFT_SIDE = PushRubiksCube.LEFT_SIDE;
	private static final int DOWN_SIDE = PushRubiksCube.DOWN_SIDE;
	private static final int RIGHT_SIDE = PushRubiksCube.RIGHT_SIDE;
	private static final int FRONT_SIDE = PushRubiksCube.FRONT_SIDE;

	// 메소드: Rubiks Cube 모든 Sides 전체 출력
	public void printResult(char[][][] threeDimensionalCube) {

		// back side 출력
		printFrontBack(threeDimensionalCube, BACK_SIDE);

		for (int i = 0; i < threeDimensionalCube[0][0].length; i++) {
			System.out.print("  ");

			// up side cube 출력
			printLeftRightUpDown(threeDimensionalCube, UP_SIDE, i);
			System.out.print("  ");

			// left side cube 출력
			printLeftRightUpDown(threeDimensionalCube, LEFT_SIDE, i);
			System.out.print("  ");

			// down side cube 출력
			printLeftRightUpDown(threeDimensionalCube, DOWN_SIDE, i);
			System.out.print("  ");

			// right side cube 출력
			printLeftRightUpDown(threeDimensionalCube, RIGHT_SIDE, i);
			System.out.println("");
		}
		System.out.println("");

		// front side 출력
		printFrontBack(threeDimensionalCube, FRONT_SIDE);
	}

	// 메소드: Left/Right/Up/Down Side 출력
	public void printLeftRightUpDown(char[][][] threeDimensionalCube, int side, int index) {
		for (char elementOfCube : threeDimensionalCube[side][index]) {
			System.out.print(elementOfCube + " ");
		}
	}

	// 메소드: Front/Back Side 출력
	public void printFrontBack(char[][][] threeDimensionalCube, int side) {
		// back side cube 출력
		for (char[] oneDimensionalCube : threeDimensionalCube[side]) {
			System.out.print("                  ");
			for (char elementOfCube : oneDimensionalCube) {
				System.out.print(elementOfCube + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
