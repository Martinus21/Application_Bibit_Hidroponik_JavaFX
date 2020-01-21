package data;

public class Cart {
    private Seed seed;
    private int qty;

    public Cart(Seed seed, int qty) {
        this.seed = seed;
        this.qty = qty;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
