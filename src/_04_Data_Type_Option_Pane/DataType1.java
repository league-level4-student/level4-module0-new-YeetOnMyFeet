package _04_Data_Type_Option_Pane;

public enum DataType1 {
 CHAR(8), INT(32), BYTE(8), SHORT(16), LONG(64), FLOAT(32), DOUBLE(64), BOOLEAN(1);
 
 DataType1(int i) {
	// TODO Auto-generated constructor stub
	bits = i; 
	
}

 public int getBits() {
	 return bits;
 }

private int bits;

}
