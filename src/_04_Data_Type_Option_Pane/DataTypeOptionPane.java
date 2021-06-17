package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    public static void main(String[] args) {

        DataType1[] dataTypes = DataType1.values();
        String array[] = {"char", "int", "byte", "short", "long", "float", "double", "boolean"};
       int user =  JOptionPane.showOptionDialog(null, "What datatype do you want to learn about?", "Datatype", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, array, array[0]);
    
       switch (user) {

       case 0:
    	   JOptionPane.showMessageDialog(null, "Char contains positive values" + dataTypes[0].getBits());
           break;
       case 1:
    	   JOptionPane.showMessageDialog(null, "Ints contains whole numbers" + dataTypes[1].getBits());
           break;
       case 2:
    	   JOptionPane.showMessageDialog(null, "Bytes contains decimal numbers between 0 and 255"+ dataTypes[2].getBits());
           break;
       case 3:
    	   JOptionPane.showMessageDialog(null, "Shorts contains positive and negative values "+ dataTypes[3].getBits());
           break;
       case 4:
    	   JOptionPane.showMessageDialog(null, "Long contains positive and negative values"+ dataTypes[4].getBits());
           break;
       case 5:
    	   JOptionPane.showMessageDialog(null, "Floats contains non whole numbers"+ dataTypes[5].getBits());
    	   break;
       case 6:
    	   JOptionPane.showMessageDialog(null, "Doubles contains decimal numbers"+ dataTypes[6].getBits());
           break;
       case 7:
    	   JOptionPane.showMessageDialog(null, "Booleans contains true or false numbers"+ dataTypes[7].getBits());
           break;
       default:
           System.out.println("Something went wrong from switch :(");
           break;

       }
    
    }
}
