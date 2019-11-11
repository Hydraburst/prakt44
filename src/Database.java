import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Database {
    public ArrayList list;
     List<Country> countries = new ArrayList<>();

    public void add(Country country){                                                                                      //method dobavlenia novyh stran
        countries.add(country);
    }

    public Database(int length){ this.list = new ArrayList<>(length); }

    public void remove(int population){
        countries.removeIf(country -> country.getPopulation()< population);                                                   //method udalenia lishnih danyh po population
    }


    public Country findAllByCapital(String name){
        for (Country country : countries) {
            if (country.getCapital().equals(name)) {                                                                            //sravnivaet imena stoits
                return country;
            }
        }
        return null;
    }

    public List<Country> findAllWhereSquareBiggerThan(double square){
        ArrayList<Country> result = new ArrayList<>();
        for (Country country : countries) {
            if (country.getSquare() > square) {                                                                                 //sravnivaet Square
                result.add(country);
            }
        }
        return result;
    }

    public List<Country> sort(Comparator<Country> comparator){
        List<Country> result = new ArrayList<>(countries);                                                                  //method sortirovki vyvodit v novyi list
        result.sort(comparator);
        return result;
    }

    public void printAll(){
        countries.forEach(System.out::println);
    }

}
