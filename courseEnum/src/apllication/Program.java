package apllication;

import entities.Order;
import entities.enums.OrderStatus;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PROCESSING);
        //para converter para String tem que escrever o metodo .toString() la na Class Order
        System.out.println(order);

        //Ja para converter de String para Enumerado tem q passar o metodo valueOf(`igual ao enumerado`)

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);


    }
}
