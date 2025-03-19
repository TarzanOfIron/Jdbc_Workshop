package se.lexicon.model;

/**
 * Represents a City entity based on the 'city' table in the 'world' database.
 */
public class City {
    // TODO: Needs completion

    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;


    // Constructor
    public City(int id, String name, String countryCode, String district, int population) {
        this(id, name, countryCode);
        setDistrict(district);
        setPopulation(population);
    }

    public City(int id, String name, String countryCode) {
        setId(id);
        setName(name);
        setCountryCode(countryCode);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }


    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // Override
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
