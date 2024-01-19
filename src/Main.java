import java.util.List;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Main {
    public static void main(String[] args) throws IOException {

        Calculations calculations = new Calculations();

        calculations.addOrder(new Order(1L,"Buy","Add",20.0,100));
        calculations.addOrder(new Order(2L,"Sell","Add",25.0,200));
        calculations.addOrder(new Order(3L,"Buy","Add",23.0,50));
        calculations.addOrder(new Order(4L,"Buy","Add",23.0,70));
        calculations.addOrder(new Order(3L,"Buy","Remove",23.0,50));
        calculations.addOrder(new Order(5L,"Sell","Add",28.0,100));












    }



}