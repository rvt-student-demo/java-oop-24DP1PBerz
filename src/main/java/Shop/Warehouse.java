package Shop;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Warehouse {
    Map<String, Integer> products = new HashMap<>();

    public void addProduct(String product, int price, int stock){
        products.put(product, price);
        products.put(product, stock);
    }

    public int price(String product){
        if(products.containsKey(product)){
            return products.get(product);
        }else{
            return -99;
        }
        
    }

    public int stock(String product){
        if(products.containsKey(product)){
            return products.get(product);
        }else{
            return 0;
        }
    }

    public boolean take(String product){
        if(products.containsKey(product) && products.get(product) > 0){
            products.put(product, products.get(product) - 1);
            return true;
        }else{
            return false;
        }
    }

    public Set<String> products(){
        return products.keySet();
    }

    
}
