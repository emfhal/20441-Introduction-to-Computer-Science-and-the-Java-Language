/**
 * @(#)Country.java
 *
 * Represents information about a country of Maman15 question1 2019a
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (22/01/2019)
 */

public class Country {

    private CityNode _head;
    private String _countryName;

    /**
     * country list constructor, creates a city nodes lists.
     * -Time complexity : O(1)
     * -Space complexity: O(1)
     * @param countryName will define the name of the country.
     */
    public Country(String countryName)
    {
        this._head = null;
        this._countryName = countryName;
    }

    /**
     * public boolean addCity?(java.lang.String cityName,
                       double cityCenterX,
                       double cityCenterY,
                       double centralStationX,
                       double centralStationY,
                       long numOfResidents,
                       int noOfNeighborhoods)
     * Adds a new city to the country and updates the count of cities .
     * -Time complexity : O(n)
     * -Space complexity: O(1)
     * @param name The name of the city.
     * @param xCenter The X coordinate of the center point of the city.
     * @param yCenter The Y coordinate of the center point of the city.
     * @param xStation The X coordinate of the central station of the city
     * @param yStation The Y coordinate of the central station of the city
     * @param numOfResidents The number of residents in the city.
     * @param noOfNeighborhoods The number of neighborhoods in the city.
     * @return True If the city has been added.
     */
    public boolean addCity(String name, double xCenter, double yCenter, double xStation, double yStation, long numOfResidents, int noOfNeighborhoods)
    {
        if(!nameFound(name)){
        City newCity = new City(name, xCenter, yCenter, xStation, yStation, numOfResidents, noOfNeighborhoods);
            _head = new CityNode(newCity,_head);
            return true;
        } else return false;
    }

    /**
     * Returns the longest distance between 2 cities of the country (between the city center point).
     * If the country is less then 2 cities returns 0.
     * -Time complexity : O(n^2)
     * -Space complexity: O(1)
     * @return The longest distance between 2 cities of the country.
     */
    public double longestDistance() {
        double longest = 0, temp;
        CityNode city1=_head, city2=_head.getNext();

        if(_head.getNext()==null)
            return -1;

        while(city1 !=null) {
            while (city2 != null) {
                temp = city1.getCity().getCityCenter().distance(city2.getCity().getCityCenter());
                if (temp > longest)
                    longest = temp;
                city2 = city2.getNext();
            }
            city1 = city1.getNext();
            city2 = city1;
        }
        return longest;
    }


    /**
     * Summary the number of country residents.
     * -Time complexity : O(n)
     * -Space complexity: O(1)
     * @return The total number of residents at the country.
     */
    public long getNumOfResidents() {
        CityNode temp = _head;
        long sum = 0;
        while (temp != null) {
            sum += temp.getCity().getNumOfResidents();
            temp = temp.getNext();
        }
        return sum;
    }

    /**
     * A string that contein cities northern than the city that was given.
     * If there is no city with this name return that and if there are not a norther cities return that as well.
     * -Time complexity : O(n)
     * -Space complexity: O(n)
     * @param cityName The name of the northess city.
     * @return A string with all the northern cities of the spesific cityName that was given
     */
    public String citiesNorthOf(String cityName) {

        String string = "";
        if(nameFound(cityName)) {
            string = "The cities north of " + cityName + " are:\n\n";
            CityNode tempNode = _head;
            CityNode temp = getNode(cityName);
            boolean foundNorther = false;
            while (tempNode != null) {
                if (temp.getCity().getCityCenter().isUnder(tempNode.getCity().getCityCenter())) {
                    string += tempNode.getCity().toString() + "\n\n";
                    foundNorther = true;
                }
                tempNode = tempNode.getNext();
            }
            if (!foundNorther)
                string = "There are no cities north of " + cityName;
        }else  string = "There is no city with the name " + cityName;

        return string;
    }


    /**
     * Returns the country name.
     * -Time complexity : O(1)
     * -Space complexity: O(1)
     * @return The country name.
     */
    public String getCountryName() {
        return this._countryName;
    }

    /**
     * Return the number of cities in the country.
     * -Time complexity : O(n)
     * -Space complexity: O(1)
     * @return The number of cities in the country.
     */
    public int getNumOfCities() {
            CityNode temp;
            int sum=0;
            for(temp=_head ;temp!=null; temp=temp.getNext())
                sum++;
            return sum;
        }

    /**
     * Returns copied list of the cities in the country.
     * -Time complexity : O(n)
     * -Space complexity: O(n)
     * @return Cities list copied from the country with the same order.
     */
    public Country getCities() {
        Country copy = new Country(_countryName);
        CityNode temp ,temp2=copy._head;
       for(temp=_head;temp!=null;temp = temp.getNext()) {
           temp2 = copy._head;
           copy._head = new CityNode(temp.getCity(),temp2);
        }
        copy.reverse();
        return copy;
    }

    /**
     * Returns the southest city in the country calculate by the lower city center.
     * If there are no cities in the country returns null.
     * -Time complexity : O(n^2)
     * -Space complexity: O(1)
     * @return The southest city of the country.
     */
    public City southernmostCity() {
        CityNode city1 = _head, city2 = _head.getNext();
        City temp = new City(_head.getCity());
        
        if (_head == null) return null;
        while (city1 != null) {
            while (city2 != null) {
                if (city1.getCity().getCityCenter().isUnder(city2.getCity().getCityCenter())) {
                    if (city1.getCity().getCityCenter().isUnder(temp.getCityCenter()))
                        temp = city1.getCity();
                } else {
                    if (city2.getCity().getCityCenter().isUnder(temp.getCityCenter()))
                        temp = city2.getCity();
                }
                city2 = city2.getNext();
            }
            city1 = city1.getNext();
            city2 = city1;
        }
        return temp;
    }


    /**
     * Return a unified city from 2 cities names.
     * Takes 2 cities and unify them as one following the rules: Unified city name is CityName1 name + "-" + CityName2 name. Unified city number of residents is the total num of the cities residents combined. Unified city number of neighborhoods is the sum of both cities neighborhoods combined. Unified city center location is between the 2 cities center exactly. Unified city central station location stays in place of the larger city central station. 
     * unifiedCity takes the place of the larger city in the array while the smaller city gets deleted. if one of the cities given by user are not found in the country the country list will stay untouched and the return will be null.
     * -Time complexity : O(n)
     * -Space complexity: O(1)
     * @param cityName1 The first city name to unify.
     * @param cityName2 The second city name to unify.
     * @return The new / unified city.
     */
    public City unifyCities(String cityName1, String cityName2) {
        CityNode city1 = getNode(cityName1);
        CityNode city2 = getNode(cityName2);
        
        String updatedCityName = city1.getCity().getCityName() + "-" + city2.getCity().getCityName();
        double updatedCityCenterX = city1.getCity().getCityCenter().getX() / 2 + city2.getCity().getCityCenter().getX() / 2;
        double updatedCityCenterY = city1.getCity().getCityCenter().getY() / 2 + city2.getCity().getCityCenter().getY() / 2;
        Point updatedCentralStation;
        if (city2.getCity().getCentralStation().isLeft(city1.getCity().getCentralStation()))
            updatedCentralStation = new Point(city2.getCity().getCentralStation());
        else updatedCentralStation = new Point(city1.getCity().getCentralStation());
        long updatedNoOfNieghborhoods = city1.getCity().getNoOfNeighborhoods() + city2.getCity().getNoOfNeighborhoods();
        long updatedNumOfResidents = city1.getCity().getNumOfResidents() + city2.getCity().getNumOfResidents();
        
        City unifiedCity = new City(updatedCityName,updatedCityCenterX,updatedCityCenterY,updatedCentralStation.getX(),updatedCentralStation.getY(),updatedNumOfResidents,updatedNoOfNieghborhoods);

    if (city2.getCity().getNumOfResidents() > city1.getCity().getNumOfResidents()) {
        city2.setCity(unifiedCity);
        remove(city1.getCity().getCityName());
    } else {
        city1.setCity(unifiedCity);
        remove(city2.getCity().getCityName());
    }
    return unifiedCity;

    }


    /**
     * Returns all of the cities details in the country.
     * -Time complexity : O(n)
     * -Space complexity: O(1)
     * @return A string with all the cities data.
     */
    public String toString() {

        CityNode p;
        String res = "\nCities of " + getCountryName() + ":"+ "\n\n";

        if(_head == null)
            res = "There are no cities in this country.";
        else {
            for (p=_head ; p!=null ; p = p.getNext())
                res += p.getCity().toString() + "\n\n";
        }

        return res;
    }

	/* --------------------------------- Class's Private Methods ---------------------------------- */


    private int position(String cityName)
    {
        CityNode temp = _head;
        int count=1; 
        while(temp!=null && !temp.getCity().getCityName().equals(cityName) )
        {
            temp = temp.getNext();
            count++;
        }
        if(temp==null)
            return -1;
        return count;
    }
    
    private void remove (String x) {
        if (_head != null) {
            if (_head.getCity().getCityName().equals(x))
                _head = _head.getNext();
            else {
                CityNode temp = _head;
                while (temp.getNext() != null) {
                    if (temp.getNext().getCity().getCityName().equals(x)) {
                        temp.setNext(temp.getNext().getNext());
                        return;
                    }
                    else
                        temp = temp.getNext();
                }
            }
        }
    }

    
    private boolean nameFound(String s)
    {
        CityNode temp ;
        for (temp =_head; temp != null; temp = temp.getNext()) {
            if (temp.getCity().getCityName().equals(s))
                return true;
        }
        return false;
    }

    private CityNode getNode (String nodeCityName)
    {
        if (_head == null)
            return null;
        CityNode temp = _head;
        while (temp != null)
        {
            String tempName = temp.getCity().getCityName();
            if (tempName.equals(nodeCityName))
                return temp;
            else
                temp = temp.getNext();
        }
        return null;
    }
    
    private void reverse()
    {
        CityNode rev,temp;
        rev=null;
        temp=_head;
        while(temp!=null)
        {
            _head = _head.getNext();
            temp.setNext(rev);
            rev = temp;
            temp = _head;
        }
        _head = rev;
    }


}

