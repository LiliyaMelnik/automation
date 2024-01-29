package api.endpoints;

public enum UserEndpoints {
    ADD_USER("v2/user/"),
    GET_USER("v2/user/"),
    DELETE_USER("v2/user/");

    private final String endpoints;

    UserEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getEndpoints() {
        return endpoints;
    }
}
