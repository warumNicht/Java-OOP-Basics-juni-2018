package Avatar.models.Monuments;

public abstract class Monument {
    private String name;

    protected Monument(String name) {
        this.name = name;
    }
    public abstract int getAffinity();

    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();
}
