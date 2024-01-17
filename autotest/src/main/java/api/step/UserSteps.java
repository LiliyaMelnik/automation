package api.step;

import api.config.Requests;
import api.dto.response.get.GetUserDto;
import api.endpoints.UserEndpoints;

import static api.config.RequestService.requestWithToken;
import static api.config.ResponseService.ok;

public class UserSteps {

    Requests requests = new Requests();

    public GetUserDto getUser() {
        return requests.get(requestWithToken(),
                UserEndpoints.GET_USER.getEndpoints() + "0b160a17-abb7-4a78-bc0b-a8557dfddeb4").then().spec(ok())
                .extract().body().as(GetUserDto.class);
    }
}
