package api.endpoints;

public enum Endpoints {
    GENERATE_TOKEN("/Account/v1/GenerateToken");

    private final String endpoints;

    Endpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getEndpoints() {
        return endpoints;
    }
}
