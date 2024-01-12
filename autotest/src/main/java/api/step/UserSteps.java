package api.step;

import api.config.Requests;

import api.dto.request.UserRequest;
import api.dto.response.UserResponse;
import api.endpoints.Endpoints;
import api.utils.Utils;
import io.restassured.response.Response;

public class UserSteps {

    Requests requests = new Requests();

    public UserResponse generateToken() {
        var request = requests.post(new UserBuilders().userDefaultBuilder(),
                Endpoints.GENERATE_TOKEN.getEndpoints()).body().asString();

        return Utils.fromJson(request, UserResponse.class);
    }
}
