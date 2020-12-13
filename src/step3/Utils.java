package step3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	// 메소드: Rubiks Cube에 대한 깊은복사
	public char[][][] copyOfRubiks(char[][][] rubiks) {
		// 루빅스큐브의 초기상태에 대한 깊은 복사
		char[][][] initialRubiksCube = new char[rubiks.length][rubiks[0].length][rubiks[0][0].length];

		for (int i = 0; i < rubiks.length; i++) {
			for (int j = 0; j < rubiks[i].length; j++) {
				System.arraycopy(rubiks[i][j], 0, initialRubiksCube[i][j], 0, rubiks[0][0].length);
			}
		}

		return initialRubiksCube;
	}

	// 메소드: 매개변수로 전달받은 시간과 본 메소드가 호출된 시간 간 차이에 대해 출력
	public void getElapsedTime(long startTime) {
		long endTime = System.currentTimeMillis();
		long elapsedSec = endTime - startTime;

		SimpleDateFormat time = new SimpleDateFormat("mm:ss");
		String showTime = time.format(new Date(elapsedSec));
		System.out.println("  경과시간: " + showTime);
	}
}
