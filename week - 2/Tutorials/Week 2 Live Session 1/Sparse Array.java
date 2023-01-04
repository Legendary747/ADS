package weblab;

import java.util.*;

class CookieList {

    Street street;

    public CookieList(Street street) {
        this.street = street;
    }

    /**
     * Prunes the street, to remove all mean people.
     * @param meanPeople - the list of mean people that will need to be removed from the array of street
     */
    public void pruneStreet(List<String> meanPeople) {
        if (meanPeople == null) return;
        int l = street.size();
        for (String s : meanPeople) {
            for (int i = 0; i < l; i++) {
                if (Objects.equals(street.getNeighbour(i), s)) street.removeNeighbour(i);
            }
        }
    }

    /**
     * Turns the sparse array containing all nice people in the street into a list,
     * where each element is a House object that stores the house number and name of the inhabitant.
     * @return a list of houses with all the nice people
     */
    public List<House> listAllFriendlyHouses() {
        ArrayList<House> houses = new ArrayList();
        int l = street.size();
        for (int i = 0; i < l; i++) {
            if (street.getNeighbour(i) != null) {
                houses.add(new House(i, street.getNeighbour(i)));
            }
        }
        return houses;
    }
}
