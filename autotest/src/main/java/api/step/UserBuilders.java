package api.step;

import api.dto.request.UserRequest;

public class UserBuilders {

    public UserRequest userDefaultBuilder() {
        return UserRequest.builder()
                .userName("user15")
                .password("123456789Qa!!!")
                .build();
    }
}
