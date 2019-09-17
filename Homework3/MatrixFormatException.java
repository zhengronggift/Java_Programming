import java.io.RuntimeException;  // need to import checked exceptions
import java.io.NullPointerException;  // need to import checked exceptions
public class MatrixFormatException extends RuntimeException {
	private int row;
	private int column;
	private double []x; 
	public MatrixFormatException (){
		
		//MatrixFormatException("");
		MatrixFormatException M = new MatrixFormatException("Null");
	}
	public MatrixFormatException(String reason)   // supply a String 
	{
		System.out.println(reason);
	}
//	public MatrixFormatException(String message) {
	//    super(message);
	//}
	
}
