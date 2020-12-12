package step3;

public class MixCube {
	
	public char[][][] getMixedCube(char[][][] rubiksCube) {
		PushRubiksCube pushRubiks = new PushRubiksCube();
		String[] mixedInputs = { "L", "R" };

		for (String inputDir : mixedInputs) {
			rubiksCube = pushRubiks.getPushedRubiks(rubiksCube, inputDir);
		}

		System.out.println("");
		PrintAllSides printAll = new PrintAllSides();
		printAll.printResult(rubiksCube);

		return rubiksCube;
	}

}
