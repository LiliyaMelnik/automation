package api.test;

import api.builders.UserBuilders;
import api.dto.response.GetUserDto;
import api.dto.response.UserDto;
import api.step.UserSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CoolTest {

    private final UserSteps steps = new UserSteps();

    @Test
    void createAndDeleteUser() {
        UserDto user = steps.createUser();
        assertThat(user.getMessage()).isEqualTo("123");

        GetUserDto getUsr = steps.getUser();
        assertThat(getUsr.getId()).isEqualTo(123);

        UserDto delUsr = steps.deleteOkUser();
        assertThat(delUsr.getMessage()).isEqualTo(UserBuilders.defaultUser);
    }
    @Test
    void delete2timesUser() {
        UserDto user = steps.createUser();
        assertThat(user.getMessage()).isEqualTo("123");

        GetUserDto getUsr = steps.getUser();
        assertThat(getUsr.getId()).isEqualTo(123);

        UserDto delUsr = steps.deleteOkUser();
        assertThat(delUsr.getMessage()).isEqualTo(UserBuilders.defaultUser);

        steps.deleteNotFoundUser();
    }
}
