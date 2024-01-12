package api.test;

import api.dto.response.UserResponse;
import api.step.UserSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenerateTokenTest {

    @Test
    void generateToken() {
        UserResponse rT = new UserSteps().generateToken();

        assertThat(rT.getResult()).isEqualTo("User authorized successfully.");
        assertThat(rT.getStatus()).isEqualTo("Success");
    }
}
