package albumsAndArtistsClasses;

public class Artist{

    private final String name;
    private final String nationality;
    private final boolean isBand;

    public Artist(String name, String nationality, boolean isBand){
        this.name = name;
        this.nationality = nationality;
        this.isBand = isBand;
    }

    public boolean isBand() {
        return isBand;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}
