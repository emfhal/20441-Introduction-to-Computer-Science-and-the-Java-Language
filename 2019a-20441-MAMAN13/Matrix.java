/**
 * @(#)Matrix.java
 *
 * Represents information about a real matrix of Maman13 question2 2019a
 *
 * @author Emmanuel Fhal, ID:XXXXXXX
 * @version 1.00 2019a (09/12/2018)
 */


public class Matrix {

 // The elements of the matrix
 private int[][] _elements;

 /**
   * Matrix(int[][] elements) in a constractor that accepts a two dimentional array and makes a Matrix from it.
   * The dimentions and the values in the Matrix will be equal to the ones that are in the array.
   * 
   * @param elements is an array of int[][]
   */
  public Matrix(int[][] elements)
  {
    if (elements.length == 0 || elements[0].length ==0) System.out.println("Illegal Matrix - one of the planes is zero"); 
    else{
        _elements = new int[elements.length][elements[0].length];
        for (int i = 0 ; i <elements.length ; i++)
        {
            for (int j = 0 ; j < elements[i].length; j++)
            {
                _elements[i][j] = elements[i][j]; //Copies the values from elements array to _elements array
            }
        }
    }
  }

 /**
  * Constructs a new matrix with a given number of rows and columns.
  *  Constructs the matrix if rows and columns are positive numbers.
  * @param rows a positive number
  * @param columns a positive number
  */
 public Matrix(int rows, int columns) {
     
  if (rows > 0 && columns > 0){
   _elements = new int[rows][columns];
   }else{
   System.out.println("Illegal Matrix - one of the planes is zero");     
   }
}


  /**
   * toString is a method that convets the entire matrix object to string and outputs it as a usual matrix.
   * 
   * @return toString A spring of the Matrix in the usual matrix format.
   */
 public String toString() {
    String toString = new String();

    for (int i = 0 ; i < this._elements.length ; i++)
    {

        for (int j = 0 ; j < this._elements[i].length ; j++)
        {
            if ((j+1) == _elements[i].length) toString += _elements[i][j] + "\n";
            else toString += _elements[i][j] + "\t";
        }
    }
    return toString;
  }
  
 
 
  /**
   * rotateCounterClockwise is a method that rotates a Matrix object counter clockwise.
   * The method takes a Matrix object, copies it to a new Matrix object and rotates it.
   * The method outputs only the rotated Matrix object and doesnt effect the input Matrix.
   * 
   * @return rotatedMatrix A new, counter clockwise rotated matrix of the original matrix.
   */
public Matrix rotateCounterClockwise() {
  int totalCols = _elements[0].length; //Total columns of Original Matrix
  int totalRows = _elements.length; //Total rows of Original Matrix
  Matrix rotatedMatrix = new Matrix (totalCols,totalRows);
  
		for(int i = 0; i < totalRows; i++){
			for(int j = 0; j < totalCols ; j++){
				rotatedMatrix._elements[j][i] = _elements[i][totalCols-j -1];
        }
    }
    return rotatedMatrix;
 }
 
  /**
   * rotateClockwise is a method that rotates a Matrix object clockwise.
   * The method takes a Matrix object, copies it to a new Matrix object and rotates it.
   * The method outputs only the rotated Matrix object and doesnt effect the input Matrix.
   * 
   * @return rotatedMatrix A new, clockwise rotated matrix of the original matrix.
   */
public Matrix rotateClockwise() {
  int totalCols = _elements[0].length; //Total columns of Original Matrix
  int totalRows = _elements.length; //Total rows of Original Matrix
  Matrix rotatedMatrix = new Matrix (totalCols,totalRows);
  
		for(int i = 0; i < totalRows; i++){
			for(int j = 0; j < totalCols ; j++){
				rotatedMatrix._elements[j][i] = _elements[totalRows-i-1][j];
        }
    }
    return rotatedMatrix;
 }

 /**
   * flipVertical is a method that flips a Matrix object vertically.
   * The method takes a Matrix object, copies it to a new Matrix object and flip it.
   * The method outputs only the flipped Matrix object and doesnt effect the input Matrix.
   * 
   * @return rotatedMatrix A new, vertically flipped matrix of the original matrix.
   */
  
public Matrix flipVertical() {
  int totalCols = _elements[0].length; //Total columns of Original Matrix
  int totalRows = _elements.length; //Total rows of Original Matrix
  Matrix rotatedMatrix = new Matrix (totalRows,totalCols);
  
		for (int j = 0; j < totalCols; j++) {
			for (int i = 0; i < totalRows; i++) {
				rotatedMatrix._elements[i][j] = _elements[totalRows-i-1][j];
			}
		}
		return rotatedMatrix;
	}
	
/**
   * flipHorizontal is a method that flips a Matrix object horizontally.
   * The method takes a Matrix object, copies it to a new Matrix object and flip it.
   * The method outputs only the flipped Matrix object and doesnt effect the input Matrix.
   * 
   * @return rotatedMatrix A new, horizontally flipped matrix of the original matrix.
   */
  
public Matrix flipHorizontal() {
  int totalCols = _elements[0].length; //Total columns of Original Matrix
  int totalRows = _elements.length; //Total rows of Original Matrix
  Matrix rotatedMatrix = new Matrix (totalRows,totalCols);
  
		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				rotatedMatrix._elements[i][j] = _elements[i][totalCols-j-1];
			}
		}
		return rotatedMatrix;
	}	
	

 
 /**
  * 
  * Returns the number of rows  the matrix has.
  * @return the number of rows the matrix has
  */
 public int getNumberOfRows() {
  return _elements.length;
 }


 /**
     **Returns the number of columns the matrix has.
   
     * @return the number of columns the matrix has
     */
 public int getNumberOfColumns() {
  return _elements[0].length;
 }

 /**
  * Returns the value of a given index.
  *  If row or column not in matrix bounds 12345 is returned.
  * @return the value of a given index or 12345 if indexes not valid
  * @param row the row number
  * @param column the column number
  */
 public int getElement(int row, int column) {
  if (isValid(row, column))
   return _elements[row][column];
  return 12345;
 }
 
 /**
  * Look for the given number in the given array and reatun true if the number is in the array and false otherwise
  * 
  * @param mat an array
  * @param x a number
  * 
  * @return true if the number is in the array and false otherwise
  */
 //In the worst case it will cost O(logN).
 //For that to happen the number need to be in the last place it's looking for - in the middle of the last quater.
 public static boolean find(int[][] mat, int x) {
  int _midRow = mat.length / 2, _midCol = mat[0].length / 2;
  int _topRow = mat.length - 1, _topCol = mat[0].length - 1, _bottomRow = 0, _bottomCol = 0;

  return findNum(mat, _topRow, _bottomRow, _topCol, _bottomCol, x);
 }
 
 // check if row and column valid
 private boolean isValid(int row, int col) {
  return (((row > -1) && (row < _elements.length)) &&
   ((col > -1) && (col < _elements[0].length)));
 }
 /**
  * Sets the value of a given index to a given value.
  *  If the row or column are in the matrix bounds the  value is changed.
  * @param row the row number
  * @param column the column number
  * @param value the new value
  */
 public void setElement(int row, int column, int value) {
  if (isValid(row, column))
   _elements[row][column] = value;
 }

 //Get parameters and check if the given number is in the array using binary search
 private static boolean findNum(int[][] _mat, int _topRow, int _bottomRow, int _topCol, int _bottomCol, int x) {
  boolean _found = false;

  //Making sure the number is in the matrix
  if (x >= _mat[_bottomRow][_bottomCol] && x <= _mat[_topRow][_topCol]) {
   while (_topCol >= _bottomCol && _topRow >= _bottomRow && _found != true) {
    int _midCol = (_topCol + _bottomCol) / 2;
    int _midRow = (_topRow + _bottomRow) / 2;

    //Making sure the top and bottom are not the same
    if (!(_topRow == _bottomRow && _topCol == _bottomCol)) {
     //If it's in the first or second sub matrixes
     if (x <= _mat[_midRow][_topCol]) {
      //SubMatrix number 1
      if (x <= _mat[_midRow][_midCol]) {
       _topCol = _midCol;
       _topRow = _midRow;
      }
      //SubMatrix number 2
      else {
       _bottomCol = _midCol + 1;
       _topRow = _midRow;
      }
     }
     //If it's in the third of forth sub matrixes
     else {
      //SubMatrix number 3
      if (x <= _mat[_bottomRow][_midCol]) {
       _topCol = _midCol;
       _bottomRow = _midRow + 1;
      }
      //SubMatrix number 4
      else {
       _bottomCol = _midCol + 1;
       _bottomRow = _midRow + 1;
      }
     }

    }
    //If topRow == bottomRow && topCol == bottomCol
    else {
     if (_mat[_topRow][_topCol] == x)
      return true;
     else
      return false;
    }
   }
  }
  return _found;
 }


}
