import java.util.Objects;

public class Country{
    private String name;
    private String capital;
    private Continents continent;
    private int population;
    private double square;
    private int id;


    public Country(String name, String capital, Continents continent, int population, double square, int id) {                      //prisvoenie danyh
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.population = population;
        this.square = square;
        this.id = id;
    }

    public Country(Country country) {
    }
    //pozvolyaet minyat private peremenye (getter setter)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Continents getContinent() {
        return continent;
    }

    public void setContinent(Continents continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {                                                                                                   //method vyvoda danyh
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", square=" + square +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {                                                                                             //sravnivaet objects
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return population == country.population &&
                square == country.square &&
                id == country.id &&
                Objects.equals(name, country.name) &&
                Objects.equals(capital, country.capital) &&
                Objects.equals(continent, country.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, continent, population, square, id);
    }

}
