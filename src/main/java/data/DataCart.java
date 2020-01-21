package data;

import java.util.ArrayList;

public class DataCart {
    private static DataCart instance;
    private ArrayList<Cart> carts = new ArrayList<>();

    public static synchronized DataCart getInstance() {
        if (instance == null) {
            instance = new DataCart();
        }
        return instance;
    }

    public void add(Seed seed) {
        carts.add(new Cart(seed, 0));
    }

    public Cart getBySeed(Seed seed) {
        int index = -1;
        int i = 0;
        for (Cart cart : carts) {
            if (cart.getSeed().getId().equals(seed.getId())) {
                index = i;
                break;
            }
            i++;
        }
        if (index >= 0) {
            return carts.get(index);
        }
        return null;
    }

    public void setQty(String id, int qty) {
        int index = -1;
        int i = 0;
        for (Cart cart : carts) {
            if (cart.getSeed().getId().equals(id)) {
                index = i;
                break;
            }
            i++;
        }
        if (index >= 0) {
            carts.get(index).setQty(qty);
        }
    }

    public void remove(Seed seed) {
        int index = -1;
        int i = 0;
        for (Cart cart : carts) {
            if (cart.getSeed().getId().equals(seed.getId())) {
                index = i;
                break;
            }
            i++;
        }
        if (index >= 0) {
            carts.remove(index);
        }
    }

    public ArrayList<Cart> get() {
        return carts;
    }

    public void setCarts(ArrayList<Cart> carts) {
        this.carts = carts;
    }
}
