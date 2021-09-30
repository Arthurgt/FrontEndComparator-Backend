package pl.edu.wit.frontendcomparator.models;

public class Game {

    private String title;
    private String category;
    private String studio;
    private String country;
    private String year;
    private String description;
    private String imdbrating;
    private String poster;

    public Game() {
        super();
    }

    public Game(String title, String category, String studio, String country, String year, String description, String imdbrating, String poster) {
        super();
        this.title = title;
        this.category = category;
        this.studio = studio;
        this.country = country;
        this.year = year;
        this.description = description;
        this.imdbrating = imdbrating;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImdbrating() {
        return imdbrating;
    }

    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
