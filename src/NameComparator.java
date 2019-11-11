import java.util.Comparator;

class NameComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
