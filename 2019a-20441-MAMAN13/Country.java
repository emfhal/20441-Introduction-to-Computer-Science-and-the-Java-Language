/**
 * @(#)Country.java
 *
 * Represents information about a country of Maman13 question1 2019a
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (09/12/2018)
 */

public class Country {
 private int MAX_NUM_CITIES = 1000;
 private String _countryName;
 private City[] _cities;
 private int _noOfCities;

 /**
   * Constructor for country
   * 
   * @param countryName name of the new country
   */

 public Country(java.lang.String countryName) {
  _noOfCities = 0;
  this._countryName = countryName;
  _cities = new City[MAX_NUM_CITIES];
 }
 
 /**
   * public boolean addCity​(java.lang.String cityName,
                       double cityCenterX,
                       double cityCenterY,
                       double centralStationX,
                       double centralStationY,
                       long numOfResidents,
                       int noOfNeighborhoods)
   * Adds a new city to the country and updates the count of cities .
   * 
   * @param cityName  the city's name to add to the country.
   * @param cityCenterX  the x part of the city center point on the surface in the cartesian system
   * @param cityCenterY  the y part of the city center point on the surface in the cartesian system
   * @param centralStationX  the x part of the city's Central station point on the surface in the cartesian system
   * @param centralStationY  the y part of the city's Central station point on the surface in the cartesian system
   * @param numOfResidents  the number of residents in the city
   * @param noOfNeighborhoods  the number of neighborhoods in the city.
   * 
   * @return true if the count of cities is less them MAX NUMBER CITIES which is 1000 and the city was successfully added to the country.
   */
  
 public boolean addCity(java.lang.String name, double xCenter, double yCenter, double xStation, double yStation, long numOfResidents, int noOfNeighborhoods) {
  if (_noOfCities < MAX_NUM_CITIES) {
   _cities[_noOfCities++] = new City(name, xCenter, yCenter, xStation, yStation, numOfResidents, noOfNeighborhoods);
   return true;
  } else {
   return false;
  }
 }
 
 /**
   * public long getNumOfResidents()
   * Gets the number of residents in the country
   * 
   * @return numOfResidents the count of population in the country;
   */
  
 public long getNumOfResidents() {
  long numOfResidents = 0;
  for (int i = 0; i < _noOfCities; i++) {
   numOfResidents += this._cities[i].getNumOfResidents();
  }
  return numOfResidents;
 }
 
 /**
   * public double longestDistance()
   * finds the longest distance between tow cities in the country
   * 
   * @return longestDistanceOfCities the distance between the tow cities which are most far from each other.
   */
  
 public double longestDistance() {
  double longestDistanceOfCities = 0;
  double distanceOfCities;

  if (_noOfCities < 2) {
   return 0;
  } else {
   for (int i = 0; i < _noOfCities; i++) {

    for (int j = 0; j < _noOfCities; j++) {

     distanceOfCities = this._cities[i].getCityCenter().distance(this._cities[j].getCityCenter());
     if (distanceOfCities > longestDistanceOfCities) longestDistanceOfCities = distanceOfCities;
    }

   }
   return longestDistanceOfCities;
  }
 }

 /**
   * public java.lang.String citiesNorthOf​(java.lang.String cityName)
   * Finds all the cities that are north then a given city.
   * 
   * @param cityName - indicates the city given. 
   * 
   * @return citiesNorthOf a string representation of all cities north of given city. 
   * @return if the city is the northeasts city shall return "There are no cities north of ..." 
   * @return if there is no city in the country in that name shall return "There is no city in that name".
   */
  
 public java.lang.String citiesNorthOf(java.lang.String cityName) {
  City[] citiesNorth = new City[MAX_NUM_CITIES];
  int noOfCitiesNorth = 0;
  int counter = 0;
  String str = "";

  for (int j = 0; j < _noOfCities; j++) {
   if (_cities[j].getCityName().equals(cityName)) {
    counter++;
    for (int i = 0; i < _noOfCities; i++) {
     if (this._cities[i].getCityCenter().isAbove(this._cities[j].getCityCenter())) {
      citiesNorth[noOfCitiesNorth++] = this._cities[i];
     }
    }
   }
  }

  if (counter == 0) {
   str = "There is no city with the name " + cityName;
  } else {
   if (noOfCitiesNorth == 0) {
    str = "There are no cities north of " + cityName;
   } else {
    str = "The cities north of " + cityName + " are: \n";
    for (int i = 0; i < noOfCitiesNorth; i++) {
     str += citiesNorth[i].toString() + "\n";
    }
   }
  }
  return str;
 }

 /**
   * public City southernmostCity()
   * Finds the southeast city in the country
   * 
   * @return most southern city.
   */
  
 public City southernmostCity() {
  City South = null;

  if (_noOfCities > 0) {
   for (int j = 0; j < _noOfCities; j++) {

    for (int i = 0; i < _noOfCities; i++) {

     if (this._cities[i].getCityCenter().isUnder(this._cities[j].getCityCenter())) {
      South = this._cities[i];
     }
    }
   }
  }
  return South;
 }

  /**
   * public java.lang.String getCountryName()
   * Gets the name of the country
   * 
   * @return country name.
   */
 public String getCountryName() {
  return _countryName;
 }

   /**
   * public int getNumOfCities()
   * Gets the number of cities in the country
   * 
   * @return noOfCities;
   */
 public int getNumOfCities() {
  return _noOfCities;
 }

   /**
   * public City[] getCities()
   * Makes a copy list of cities in the country
   * 
   * @return City[] cities.
   */
 public City[] getCities() {
  City[] cities = new City[_noOfCities];
  for (int i = 0; i < _noOfCities; i++) {
   cities[i] = new City(_cities[i]);
  }
  return cities;
 }

   /**
   * public City unifyCities​(java.lang.String _cityName1,
                        java.lang.String _cityName2)
   * Takes tow cities and unify them as one following the rules: Unified city name is CityName1 name + "-" + CityName2 name. Unified city number of residents is the total num of the cities residents combined. Unified city number of neighborhoods is the sum of both cities neighborhoods combined. Unified city center location is between the tow cities center exactly. Unified city central station location stays in place of the larger city central station. 
   * newCity takes the place of the larger city in the array while the smaller city gets deleted. if one of the cities given by user are not found in the country the country list will stay untouched and the return will be null.
   * @param _cityName1 first city to be unified.
   * @param _cityName2 scened city to be unified.
   * @return newCity.
   */
 public City unifyCities(java.lang.String cityName1, java.lang.String cityName2) {
  City newCity = null;

  for (int i = 0; i < _noOfCities; i++) {
   for (int j = 0; j < _noOfCities; j++) {
    if (_cities[i].getCityName().equals(cityName2) && _cities[j].getCityName().equals(cityName1)) {

     Point cityCenterUnited = new Point(((_cities[i].getCityCenter().getX() + _cities[j].getCityCenter().getX()) / 2), ((_cities[i].getCityCenter().getY() + _cities[j].getCityCenter().getY()) / 2));
     Point centralStationUnited = _cities[i].getCentralStation().isLeft(_cities[j].getCentralStation()) ? _cities[i].getCentralStation() : _cities[j].getCentralStation();
     newCity = new City(_cities[i].getCityName() + "-" + _cities[j].getCityName(), cityCenterUnited.getX(), cityCenterUnited.getY(), centralStationUnited.getX(), centralStationUnited.getY(), _cities[i].getNumOfResidents() + _cities[j].getNumOfResidents(), _cities[i].getNoOfNeighborhoods() + _cities[j].getNoOfNeighborhoods());

     if (_cities[j].getNumOfResidents() > _cities[i].getNumOfResidents()) {
      _cities[j] = newCity;
      _cities[i] = null;
     } else {
      _cities[i] = newCity;
      _cities[j] = null;
     }
     break;
    }
   }
  }
//order _cities so the null value go to the end
  for (int j = 0; j < _noOfCities; j++) {
   if (_cities[j] == null) {
    for (int i = _noOfCities - 1; i < 0; i--) {
     if (_cities[i] != null) {
      _cities[j] = _cities[i];
      _cities[i] = null;
      _noOfCities--;
     }
    }
   }
  }

  return newCity;
 }

   /**
   * public java.lang.String toString()
   * Returns the cities list in String format as the exp below: 
   * City Name: New York
   * City center: (50.0,75.0)
   * Central Station: (0.0,0.0)
   * NumOfResidents: 5000
   * Num Of Neighborhoods: 12
   * @param toString in class java.lang.Object
   * @return str string format.
   */
 public String toString() {
  String str;
  if (_noOfCities > 0) {
   str = "Cities of " + this._countryName + ": \n\n";
   for (int i = 0; i < _noOfCities; i++) {
    if (this._cities[i] != null) {
     str += this._cities[i].toString() + "\n\n";
    }
   }
  } else {
   str = "There are no cities in country.";
  }
  return str;
 }


}
