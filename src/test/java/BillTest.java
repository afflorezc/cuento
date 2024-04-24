import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.afflorezc.controller.*;

public class BillTest {

    @Test
    public void createBillTest(){

        // Instanciación de primera factura
        Bill bill= new Bill("Kawakii Motorcicles", "9458978541", 
                              "Calle 58 # 45DD 37 Medellin", "604 2458970");
        // Bill number: debe ser igual a 0001
        Assertions.assertEquals("0001", bill.getBillNumber());
    }
    @Test
    public void calculateBasePriceTest(){

        Item item1 = new Item("04521", "Kawasaki Ninja 650", 18699854.0f);
        Item item2 = new Item("003540", "Carburador 4T", 245990.0f);

        Bill bill = new Bill("Kawakii Motorcicles", "9458978541", 
                           "Calle 58 # 45DD 37 Medellin", "604 2458970");

        bill.addItem(item1);
        bill.addItem(item2);
        bill.calculateBasePrice();                   
        Assertions.assertEquals(18945844.0f, bill.getBasePrice());
    }
 

}
