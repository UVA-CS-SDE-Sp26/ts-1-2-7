import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserInterfaceTest {
    @Test
    void runProgramCallsProgramControlMain() {
        String[] args = {"1"};

        ProgramControl mockProgramControl = mock(ProgramControl.class);

        UserInterface ui = new UserInterface(mockProgramControl);

        ui.runProgram(args);

        verify(mockProgramControl).main(args);
    }
    @Test
    void runProgramWithNoArgsCallsProgramControl() {
        String[] args = {};

        ProgramControl mockProgramControl = mock(ProgramControl.class);

        UserInterface ui = new UserInterface(mockProgramControl);

        ui.runProgram(args);

        verify(mockProgramControl).main(args);
    }
}
