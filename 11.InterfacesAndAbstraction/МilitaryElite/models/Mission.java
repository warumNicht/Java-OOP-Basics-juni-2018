package МilitaryElite.models;

public class Mission {
    private String name;
    private String state;

    public Mission(String name, String state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s",name,state);
    }
}
