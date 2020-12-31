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
        printBack(threeDimensionalCube);

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
        printFront(threeDimensionalCube);
    }

    // 메소드: Left/Right/Up/Down Side 출력
    public void printLeftRightUpDown(char[][][] threeDimensionalCube, int side, int index) {
        for (char elementOfCube : threeDimensionalCube[side][index]) {
            System.out.print(elementOfCube + " ");
        }
    }

    // 메소드: Front Side 출력
    public void printFront(char[][][] threeDimensionalCube) {
        for (char[] oneDimensionalCube : threeDimensionalCube[FRONT_SIDE]) {
            printOneDimensionCube(oneDimensionalCube);
        }
        System.out.println("");
    }

    // 메소드: Back Side 출력
    public void printBack(char[][][] threeDimensionalCube) {
        for (char[] oneDimensionalCube : threeDimensionalCube[BACK_SIDE]) {
            printOneDimensionCube(oneDimensionalCube);
        }
        System.out.println("");
    }

    public void printOneDimensionCube(char[] oneDimensionalCube) {
        System.out.print("                  ");
        for (char elementOfCube : oneDimensionalCube) {
            System.out.print(elementOfCube + " ");
        }
        System.out.println("");
    }
}
