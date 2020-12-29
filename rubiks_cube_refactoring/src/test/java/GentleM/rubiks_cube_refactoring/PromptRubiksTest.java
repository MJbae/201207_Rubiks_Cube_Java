package GentleM.rubiks_cube_refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PromptRubiksTest {

    @ParameterizedTest(name = "[{index}] {argumentsWithNames}")
    @CsvSource({"true, R", "true, R'", "true, R2", "true, L2", "true, L", "true, F'", "true, B", "true, U", "true, U2", "false, 2R", "fasle, K"})
    void isValidInput(ArgumentsAccessor argumentsAccessor) {
        PromptRubiks prompt = new PromptRubiks();
        String inputString = argumentsAccessor.getString(1);
        assertEquals(argumentsAccessor.getBoolean(0), prompt.isValidInput(inputString), inputString + " is not Valid");
    }
}