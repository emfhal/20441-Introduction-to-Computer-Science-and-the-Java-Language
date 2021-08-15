/**
 * @(#)CityNode.java
 *
 * Represents information about a country of Maman15 question1 2019a
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (22/01/2019)
 */


public class CityNode {

    public City _city;
    public CityNode _next;

    /**
     * Constructs a new CityNode list.
     * @param c new city to be put inside the list.
     */
    public CityNode(City c){
        _city = c;
        _next = null;
    }
    /**
     * Constructs a new CityNode with a given city and modifies her next node pointer.
     * @param c City to be entered.
     * @param n next object pointer.
     */
    public CityNode(City c, CityNode n){
        _city = c;
        _next = n;
    }
    /**
     * Copy constructor for CityNode.
     * @param c cityNode to be copied.
     */
public CityNode(CityNode c) {
        _city = c.getCity();
        _next = c.getNext();
    }


    /**
     * Method to get the City.
     * @return the city.
     */
    public City getCity(){
        return _city;
    }

    /**
     * Method to get the pointer to the next Node.
     * @return pointer of the next node.
     */
    public CityNode getNext(){
        return _next;
    }

    public void setCity(City c){
        _city = c;
    }

    public void setNext(CityNode next){
        _next = next;
    }



}
