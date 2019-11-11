import java.util.Comparator;
class SquareComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return Comparator.comparingDouble(Country::getSquare).compare(o1, o2);
    }
}