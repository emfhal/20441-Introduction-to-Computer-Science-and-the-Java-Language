/**
 * @(#)Point.java
 *
 * Point Represents coordination point on the polar system
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (24/11/2018)
 */


public class Point
{
  private final int DEFAULT_VAL = 0;
  private double _radius;
  private double _alpha;
  
 /**
  * Constructor for objects of class Point. Construct a new point with the specified x y coordinates. If the x coordinate is negative it is set to zero. If the y coordinate is negative it is set to zero.
  * @param	x  The x coordinate.
  * @param	y  The y coordinate.
  */   
    
  public Point(double x, double y)
  {
    if (x < DEFAULT_VAL) x = DEFAULT_VAL;
    if (y < DEFAULT_VAL) y = DEFAULT_VAL;
    _radius = Math.sqrt(x * x + y * y);
    double c = 180 * Math.atan(y / x);
    _alpha = (c / Math.PI);
  }
  

 /**
  * Constructor for objects of class Point. Copy constructor, construct a point using another point.
  * @param	other  The point from which to construct the new object.
  */   
  public Point(Point other)
  {
    double x = other.getX();
    double y = other.getY();
    if (x < DEFAULT_VAL)
      x = DEFAULT_VAL;
    if (y < DEFAULT_VAL)
      y = DEFAULT_VAL;
    _radius = Math.sqrt(x * x + y * y);
    double c = 180 * Math.atan(y / x);
    _alpha = (c / Math.PI);
  }
  
 /**
  * getX - This method returns the x coordinate of the point.
  * @return	The x coordinate of the point. 
  */     
  public double getX()
  {
    double x = _alpha * Math.PI / 180;
    x = _radius * Math.cos(x);
    return Math.round(x * 10000) / (double)10000;
  }
  /**
  * getY - This method returns the y coordinate of the point.
  * @return	The y coordinate of the point. 
  */          
  public double getY()
  {
    double r = _alpha * Math.PI;
    r /= 180;
    r = _radius * Math.sin(r);
    return Math.round(r * 10000) / (double)10000;
  }
  

  /**
  * setX - This method sets the x coordinate of the point. If the new x coordinate is negative the old x coordinate will remain unchanged.
  * @param	x  The new x coordinate
  */     

  public void setX(double x)
  {
    if (x != DEFAULT_VAL)
    {
      double y = getY();
      _radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
      
      double alpha = 180 * Math.atan(y / x);
      _alpha = (alpha / Math.PI);
    }
  }
  
  /**
  * setY - This method sets the x coordinate of the point. If the new y coordinate is negative the old x coordinate will remain unchanged.
  * @param	y  The new y coordinate
  */   


  public void setY(double y)
  {
    if (y != DEFAULT_VAL)
    {
      double x = getX();
      _radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
      double alpha = 180 * Math.atan(y / x);
      _alpha = (alpha / Math.PI);
    }
  }


  public String toString()
  {
    return "(" + getX() + "," + getY() + ")";
  }
  


 /**
  * equals - Check if the given point is equal to this point.
  * @param	other  The point to check equality with.
  * @return	True if the given point is equal to this point. 
  */   

  public boolean equals(Point other)
  {
      return (getX() == other.getX()) && (getY() == other.getY());
  }
  
 /**
  * isAbove - Check if this point is above a received point.
  * @param	other   The point to check if this point is below
  * @return	True if this point is above the other point.
  */   
  public boolean isAbove(Point other)
  {
    if (getY() > other.getY()) {
      return true;
    }
    return false;
  }
  
 /**
  * isUnder - Check if this point is below a received point.
  * @param	other   The point to check if this point is below
  * @return	True if this point is below the other point.
  */   

  public boolean isUnder(Point other)
  {
    if (getY() == other.getY()) {
      return false;
    }
    return !other.isAbove(this);
  }
  
 /**
  * isLeft - Check if this point is left of a received point.
  * @param	other   The point to check if this point is left of
  * @return	True if this point is left of the other point.
  */   
  public boolean isLeft(Point other)
  {
    if (getX() < other.getX()) {
      return true;
    }
    return false;
  }
  
 /**
  * isRight - Check if this point is right of a received point.
  * @param	other   The point to check if this point is right of
  * @return	True if this point is right of the other point.
  */  
  public boolean isRight(Point other)
  {
    if (getX() == other.getX()) {
      return false;
    }
    return !other.isLeft(this);
  }
  



 /**
  * distance - calculate the distance between this point and a given point.
  * @param	other  The point to check the distance from.
  * @return	the distance between two points. 
  */   
  public double distance(Point other)
  {
    double distance = 0;
    distance = (getX() - other.getX()) * (getX() - other.getX());
    distance += (getY() - other.getY()) * (getY() - other.getY());
    distance = Math.sqrt(distance);
    return Math.round(distance * 10000) / (double)10000;
  }
  

 /**
  * Moves the Point by deltaX in the x-direction and by deltaY in the y-direction.
  * @param	deltaX	The deltaX to move by.
  * @param	deltaY	The deltaY to move by.
  */
  public void move(double dx, double dy)
  {
    if (getX() + dx >= DEFAULT_VAL)
      setX(getX() + dx);
    if (getY() + dy >= DEFAULT_VAL) {
      setY(getY() + dy);
    }
  }
}
