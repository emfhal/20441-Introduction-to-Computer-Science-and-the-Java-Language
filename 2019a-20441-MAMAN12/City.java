/**
 * @(#)City.java
 *
 * Represents information about a city Maman12 question2 2019a
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (24/11/2018)
 */


public class City {

 private java.lang.String _CityName;
 private Point _CentralStation;
 private Point _CityCenter;
 private long _NumOfResidents;
 private int _NoOfNeighborhoods;

 private final int MIN_RESIDENTS = 0;
 private final int MIN_NEIGBORHOODS = 1;

 /**
  * Constructor for objects of class City. Construct a new city with the specified info. If numOfResidents is smaller than MIN_RESIDENTS, MIN_RESIDENTS is used. If noOfNeighborhoods is smaller than MIN_NEIGBORHOODS, MIN_NEIGBORHOODS is used. If any coordinate is negative - 0 is used instead.
  * @param	cityName  The name of the city
  * @param	cityCenterX  The X coordinate of the center point of the city
  * @param	cityCenterY  The Y coordinate of the center point of the city
  * @param	centralStationX  The X coordinate of the central station of the city
  * @param	centralStationY  The Y coordinate of the central station of the city
  * @param	numOfResidents  The number of residents in the city
  * @param	noOfNeighborhoods  The number of neighborhoods in the city
  */
 public City(java.lang.String cityName,
  double cityCenterX,
  double cityCenterY,
  double centralStationX,
  double centralStationY,
  long numOfResidents,
  int noOfNeighborhoods) {
  _CityName = cityName;
  _CentralStation = new Point(centralStationX, centralStationY);
  _CityCenter = new Point(cityCenterX, cityCenterY);
  _NumOfResidents = numOfResidents;
  _NoOfNeighborhoods = noOfNeighborhoods;
 }

 /**
  * Constructor for objects of class City. Copy constructor, construct a city using another city.
  * @param	other The city from which to construct the new object
  */
 public City(City other) {
  if (other != null) { // check that the given object is initialized
   _CityName = other._CityName;
   _CentralStation = other._CentralStation;
   _CityCenter = other._CityCenter;
   _NumOfResidents = other._NumOfResidents;
   _NoOfNeighborhoods = other._NoOfNeighborhoods;
  }
 }

 /**
  * Move the location of the central station of the city with the given deltas. If the new location has a negative coordinate - the central station keeps its original location..
  * @param	deltaX  How much the x coordinate of the central station of the city is to be moved
  * @param	deltaY  How much the y coordinate of the central station of the city is to be moved
  */
 public void moveCentralStation(double deltaX,
  double deltaY) {
  _CentralStation = new Point(this._CentralStation.getX() + deltaX, this._CentralStation.getY() + deltaY);
 }

 /**
  * Creates a new city with a new name, and where its center and central station are moved by the given deltas from this city. If either new point has negative coordinates - it gets the center or central station of this city. Its number of residents is set to MIN_RESIDENTS and its number of neightborhoods is set to MIN_NEIGBORHOODS.
  * @param	newCityName  The name of the new city
  * @param	dx  How much the x coordinates of the city's center and central station are to be moved for the new city
  * @param	dy  How much the y coordinates of the city's center and central station are to be moved for the new city
  * @return A new city with the given values
  */
 public City newCity(java.lang.String newCityName,
  double dX,
  double dY) {
  return new City(newCityName, (this._CityCenter.getX() + dX), (this._CityCenter.getY() + dY), (this._CentralStation.getX() + dX), (this._CentralStation.getY() + dY), MIN_RESIDENTS, MIN_NEIGBORHOODS);
 }

 /**
  * Calculates the distance between the center of this city and its central station.
  * @return The distance between the center of this city and its central station
  */
 public double distanceBetweenCenterAndStation() {

  double dx2 = Math.pow((this._CityCenter.getX() - this._CentralStation.getX()), 2);
  double dy2 = Math.pow((this._CityCenter.getY() - this._CentralStation.getY()), 2);
  double d = Math.sqrt(dx2 + dy2);
  return Math.round(d * 10000) / (double) 10000;

 }



 /**
  * Adds the given number of residents - either positive or negative number - to the city. If the resulted number of residents is smaller than MIN_RESIDENTS, MIN_RESIDENTS is set to be the new number of residents of the city, and false is returned. Otherwise (i.e. the resulted number is bigger or equal to MIN_RESIDENTS), true is returned.
  * @param	residentsUpdate  The update number of new residents
  * @return false if resulted number of residents is smaller than MIN_RESIDENTS, true otherwise.
  */
 public boolean addResidents(long residentsUpdate) {

  if (_NumOfResidents + residentsUpdate <= MIN_RESIDENTS)
   return false;
  else
   _NumOfResidents += residentsUpdate;
  return false;
 }

 /**
  * Returns a string representation of this City in the format
City Name: Tel Aviv
City Center: (5.0,8.0)
Central Station: (3.0,4.0)
Number of Residents: 1004
Number of Neighborhoods: 5
  * @Overrides toString in class java.lang.Object
  * @return A String representation of this city.
  */
 public String toString() {
  return "City Name: " + _CityName + "\r\n" +
   "City Center: " + _CityCenter + "\r\n" +
   "Central Station: " + _CentralStation + "\r\n" +
   "Number of Residents: " + _NumOfResidents + "\r\n" +
   "Number of Neighborhoods: " + _NoOfNeighborhoods;
 }

 /**
  * Sets the central station point of the city.
  * @param centralStation  The new central station point of the city
  */
 public void setCentralStation(Point CentralStation) {
  _CentralStation = CentralStation;
 }
 /**
  * Returns the centeral station of the city as a Point object.
  * @return The central station of the city
  */
 public Point getCentralStation() {
  return (_CentralStation);
 }

 /**
  * Sets the center point of the city.
  * @param cityCenter  The new center point of the city
  */
 public void setCityCenter(Point CityCenter) {
  _CityCenter = CityCenter;
 }

 /**
  * Returns the center of the city as a Point object.
  * @return The center point of the city
  */
 public Point getCityCenter() {
  return (_CityCenter);
 }

 /**
  * Sets the name of the city.
  * @param cityName  The new name of the city
  */
 public void setCityName(java.lang.String cityName) {
  _CityName = cityName;
 }

 /**
  * Returns the name of the city.
  * @return The name of the city
  */
 public java.lang.String getCityName() {
  return _CityName;
 }

 /**
  * Sets the number of neighborhoods of the city, but only if it is bigger or equal to MIN_NEIGBORHOODS.
  * @param noOfNeighborhoods   The new number of neighborhoods in the city
  */
 public void setNoOfNeighborhoods(int noOfNeighborhoods) {
  if (noOfNeighborhoods >= MIN_NEIGBORHOODS)
   _NoOfNeighborhoods = noOfNeighborhoods;
 }

 /**
  * Returns the number of neighborhoods of the city.
  * @return The number of neighborhoods of the city
  */
 public int getNoOfNeighborhoods() {
  return _NoOfNeighborhoods;
 }

 /**
  * Sets the number of residents of the city, but only if it is bigger or equal to MIN_RESIDENTS.
  * @param numOfResidents  The new number of residents in the city
  */
 public void setNumOfResidents(long NumOfResidents) {
  if (NumOfResidents >= MIN_RESIDENTS)
   _NumOfResidents = NumOfResidents;
 }

 /**
  * Returns the number of residents of the city.
  * @return The number of residents of the city
  */
 public long getNumOfResidents() {
  return _NumOfResidents;
 }


}
