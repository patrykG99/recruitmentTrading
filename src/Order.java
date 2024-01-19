import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Order {
    private Long id;
    private String order;
    private String type;
    private Double price;
    private int quantity;


    public Order(Long id, String order, String type, Double price, int quantity) {
        this.id = id;
        this.order = order;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }

    public String getOrder() {
        return order;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}

class Calculations{

    PriorityQueue<Order> buyOrders = new PriorityQueue<>((Order o1, Order o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
    //Map to help removing data since PriorityQueue does not support removing data in the middle of the queue without having reference to the exact object that was added
    Map<Long,Order> buyOrderMap = new HashMap<>();
    PriorityQueue<Order> sellOrders = new PriorityQueue<>(Comparator.comparingDouble(Order::getPrice));
    Map<Long,Order> sellOrderMap = new HashMap<>();

    public void addOrder(Order order){

        if(order.getType().equals("Add")){
            if(order.getOrder().equals("Buy")){
                buyOrders.add(order);
                buyOrderMap.put(order.getId(),order);
            } else if (order.getOrder().equals("Sell")) {
                sellOrders.add(order);
                sellOrderMap.put(order.getId(),order);

            }
        }
        else if(order.getType().equals("Remove")){

            if(order.getOrder().equals("Buy")){
                Order toRemove = buyOrderMap.get(order.getId());
                buyOrders.remove(toRemove);
                buyOrderMap.remove(order.getId());
            } else if (order.getOrder().equals("Sell")) {
                Order toRemove = buyOrderMap.get(order.getId());
                sellOrders.remove(toRemove);
                sellOrderMap.remove(order.getId());

            }
        }
        showPrices();
    }
    public void showPrices(){
        int buy = 0;
        int sell = 0;

        if(!buyOrders.isEmpty()){
            double bestPrice = buyOrders.peek().getPrice();
            for(Order order : buyOrders){
                if(order.getPrice() == bestPrice)
                    buy += order.getQuantity();
            }
        }
        if(!sellOrders.isEmpty()){
            double bestPrice = sellOrders.peek().getPrice();
            for (Order order : sellOrders){
                if(order.getPrice() == bestPrice)
                    sell += order.getQuantity();

            }
        }
        System.out.println("Best buy order quantity:" + buy);
        System.out.println("Best sell order quantity:" + sell);
    }

}
