package step3;

public class MixCube {
	
	public static final String[] INPUTS = PromptRubiks.VALID_INPUTS;
	
	public int getRandomNum() {
		double randomNum = Math.random();
		return (int)(randomNum * 10);
	}
	
	public char[][][] getMixedCube(char[][][] rubiksCube) {
		PushRubiksCube pushRubiks = new PushRubiksCube();
		int RandomNum = getRandomNum();
		String[] mixedInputs = new String[RandomNum];
		
		for(int i = 0; i < RandomNum; i++) {
			int RandomNum2 = getRandomNum();
			mixedInputs[i] = INPUTS[RandomNum2];
		}
		
		for (String inputDir : mixedInputs) 
			rubiksCube = pushRubiks.getPushedRubiks(rubiksCube, inputDir);

		System.out.println("");
		PrintAllSides printAll = new PrintAllSides();
		printAll.printResult(rubiksCube);

		return rubiksCube;
	}

}
