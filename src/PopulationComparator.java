import java.util.Comparator;

class PopulationComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return Comparator.comparingInt(Country::getPopulation).compare(o1, o2);
    }
}
