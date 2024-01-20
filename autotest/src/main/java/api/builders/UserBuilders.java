package api.builders;

import api.dto.request.UserDto;

public class UserBuilders {
    public static final String defaultUser = "Lil";

    public UserDto userDefaultBuilder() {
        return UserDto.builder()
                .id(123)
                .username(defaultUser)
                .build();
    }
}
