public class Matrix{
	private int row;
	private int column;
	private double x[];
	
	//constructor, initialize variables and throw exceptions
	public Matrix (int row, int column, double x[]) throws MatrixFormatException
	{
		this.row = row;
		this.column = column;
		this.x = new double[x.length];
		this.x = x;
		double [][] array = new double [row][column];
		if ( (this.row * this.column) != this.x.length)
		{
			throw new MatrixFormatException("Wrong Input");
		}
	}
	
	//return the number of rows in the Matrix object.
	public int getNumberRows()
	{	
		int row = this.row;
		return row;
	}
	
	//return the number of columns in the Matrix object.
	public int getNumberColumns()
	{
		int column = this.column;
		return column;
	}
	
	//return the transpose of the Matrix object.
	//This method must create and return a new Matrix 
	//object and not modify the current object.
	public Matrix getTranspose()
	{
		int row2 = 0;
		int column2 = 0;
		double [] back = this.x;
		double [][] array2 = new double[this.row][this.column];
		double [][] array = new double[this.column][this.row];
		
		int y = 0;
		for (int u = 0; u < this.row; u++)
		{
			for (int k = 0; k < this.column; k++)
			{
				array2[u][k] = back[y];
				array[k][u] = array2[u][k];
				//System.out.print(array[k][u]);
				y++;
			}
		}
		/*System.out.println();*/
		int z = 0;
		double [] x2 = new double [this.row*this.column];
		for (int u = 0; u < this.column; u++)
		{
			for (int k = 0; k < this.row; k++)
			{
				x2[z] = array[u][k];
				System.out.print(x2[z]);
				z++;
			}
		}
		Matrix A = new Matrix(this.column, this.row, x2);
		int temp = row;
		A.row = column;
		A.column = temp;
		A.x = x2;
		
		//System.out.println();
		for (int i = 0; i < (A.row*A.column); i++)
		{
			this.x[i] = A.x[i];
			System.out.print(this.x[i]);
		}
		this.x = A.x;
		
		return A;
	}
	
	//check if rows, columns, and the matrix numbers will be matching.
	//return false if they don't
	public boolean equals(Matrix m)
	{
		boolean ret_value = true;
		if (m.row != this.row || m.column != this.column)
		{
			ret_value = false;
		}
		if (m.row == this.row && m.column == this.column)
		{
			for (int i = 0; i < (this.column*this.row); i++)
			{
				if (m.x[i] != this.x[i])
					{
						ret_value = false;
						//System.out.print(m.x[i]);
						//System.out.print(this.x[i]);
						return ret_value;
					}
					else
					{
						//System.out.print(m.x[i]);
						//System.out.print(this.x[i]);
						ret_value = true;
					}
			}
		}	
		return ret_value;
	}
}
