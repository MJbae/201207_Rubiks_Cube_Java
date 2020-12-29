package GentleM.rubiks_cube_refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromptRubiksTest {
    @Test
    void isValidInput() {
        PromptRubiks prompt = new PromptRubiks();
        String inputString = "L2";
        assertEquals(true, prompt.isValidInput(inputString), inputString + " is not Valid");
    }
}