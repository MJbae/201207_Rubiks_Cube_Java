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
            // up side cube 출력
            printUp(threeDimensionalCube, i);

            // left side cube 출력
            printLeft(threeDimensionalCube, i);

            // down side cube 출력
            printDown(threeDimensionalCube, i);

            // right side cube 출력
            printRight(threeDimensionalCube, i);

            System.out.println("");
        }
        System.out.println("");

        // front side 출력
        printFront(threeDimensionalCube);
    }

    // 메소드: Left/Right/Up/Down Side 출력의 내부 로직
    public void printCoreOfLeftRightUpDown(char[][][] threeDimensionalCube, int side, int index) {
        for (char elementOfCube : threeDimensionalCube[side][index]) {
            System.out.print(elementOfCube + " ");
        }
    }

    // 메소드: Right Side 출력
    public void printRight(char[][][] threeDimensionalCube, int index) {
        System.out.print("  ");
        printCoreOfLeftRightUpDown(threeDimensionalCube, RIGHT_SIDE, index);
    }

    // 메소드: Up Side 출력
    public void printUp(char[][][] threeDimensionalCube, int index) {
        System.out.print("  ");
        printCoreOfLeftRightUpDown(threeDimensionalCube, UP_SIDE, index);
    }

    // 메소드: Down Side 출력
    public void printDown(char[][][] threeDimensionalCube, int index) {
        System.out.print("  ");
        printCoreOfLeftRightUpDown(threeDimensionalCube, DOWN_SIDE, index);
    }

    // 메소드: Left Side 출력
    public void printLeft(char[][][] threeDimensionalCube, int index) {
        System.out.print("  ");
        printCoreOfLeftRightUpDown(threeDimensionalCube, LEFT_SIDE, index);
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

    // 메소드: Back, Front side 출력의 내부로직
    public void printOneDimensionCube(char[] oneDimensionalCube) {
        System.out.print("                  ");
        for (char elementOfCube : oneDimensionalCube) {
            System.out.print(elementOfCube + " ");
        }
        System.out.println("");
    }
}
