package api.step;

import api.builders.UserBuilders;
import api.config.Requests;
import api.dto.response.GetUserDto;
import api.dto.response.UserDto;
import api.endpoints.UserEndpoints;

import static api.config.RequestService.request;
import static api.config.ResponseService.ok;
import static api.config.ResponseService.notFound;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserSteps {

    Requests requests = new Requests();

    public UserDto createUser() {
        return requests.post(request(),
                        new UserBuilders().userDefaultBuilder(),
                        UserEndpoints.ADD_USER.getEndpoints())
                .then().spec(ok())
                .body(matchesJsonSchemaInClasspath("schemas/UserMessage.json"))
                .extract().body().as(UserDto.class);
    }

    public GetUserDto getUser() {
        return requests.get(request(),
                        UserEndpoints.GET_USER.getEndpoints() + UserBuilders.defaultUser)
                .then().spec(ok())
                .body(matchesJsonSchemaInClasspath("schemas/User.json"))
                .extract().body().as(GetUserDto.class);
    }

    public UserDto deleteOkUser() {
        return requests.delete(request(),
                        UserEndpoints.DELETE_USER.getEndpoints() + UserBuilders.defaultUser)
                .then().spec(ok())
                .body(matchesJsonSchemaInClasspath("schemas/UserMessage.json"))
                .extract().body().as(UserDto.class);
    }

    public void deleteNotFoundUser() {
        requests.delete(request(),
                        UserEndpoints.DELETE_USER.getEndpoints() + UserBuilders.defaultUser)
                .then().spec(notFound());
    }
}
