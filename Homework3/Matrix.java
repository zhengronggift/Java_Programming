public class Matrix{
	private int row;
	private int column;
	private double x[];

	public Matrix (int row, int column, double x[])
	{
		this.row = row;
		this.column = column;
		this.x = new double[x.length];
		this.x = x;
		/*double [][] array = new double [row][column];
		for ( int i = 0; i < (row*column); i++)
		{
			for (int u = 0; u < row; u++)
			{
				for (int k = 0; k < column; k++)
				{
					array[u][k] = x[i];
				}
			}
		}*/
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
		double [][] array2 = new double[this.row][this.column];
		double [][] array = new double[this.column][this.row];
		
		int y = 0;
		for (int u = 0; u < this.row; u++)
		{
			for (int k = 0; k < this.column; k++)
			{
				array2[u][k] = this.x[y];
				y++;
			}
		}
		for (int i = 0; i < this.row; i++)
		{
			for (int k = 0; k < this.column; k++)
			{
				array[k][i] = array2[i][k];
				row2 ++;
			}
			column2++;
		}
		double [] x2 = new double [row2*column2];
		for (int z = 0; z < (this.row * this.column); z++)
		{
			for (int u = 0; u < this.row; u++)
			{
				for (int k = 0; k < this.column; k++)
				{
					x2[z] = array[k][u];
					System.out.print(x2[z]);
				}
			}
		}
		//Matrix A;

		this.row = column2;
		this.column = row2;
		this.x = x2;
		return this;
	}
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
						System.out.print(m.x[i]);
						System.out.print(this.x[i]);
						return ret_value;
					}
					else
					{
						System.out.print(m.x[i]);
						System.out.print(this.x[i]);
						ret_value = true;
					}
			}
		}	
		return ret_value;
	}
}
