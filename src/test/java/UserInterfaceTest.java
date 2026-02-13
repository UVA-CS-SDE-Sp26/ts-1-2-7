import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserInterfaceTest {
    @Test
    void runProgramTest() {
        String[] args = {"1"};

        ProgramControl mockProgramControl = mock(ProgramControl.class);

        UserInterface ui = new UserInterface(mockProgramControl);

        ui.runProgram(args);

        verify(mockProgramControl).main(args);
    }
    @Test
    void runProgramWithNoArgsTest() {
        String[] args = {};

        ProgramControl mockProgramControl = mock(ProgramControl.class);

        UserInterface ui = new UserInterface(mockProgramControl);

        ui.runProgram(args);

        verify(mockProgramControl).main(args);
    }
}
