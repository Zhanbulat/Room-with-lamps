package app.entities;

public class Room {
    private String name;
    private String country;
    private Boolean light;

    public Room() {
    }

    public Room(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public Boolean getLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light= light;
    }
}
