package data;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class DataSeed {
    private static DataSeed instance;
    private ArrayList<Seed> seeds = new ArrayList<>();

    public static synchronized DataSeed getInstance() {
        if (instance == null) {
            instance = new DataSeed();
        }
        return instance;
    }

    public void add(Seed seed) {
        seeds.add(seed);
    }

    public ArrayList<Seed> get() {
        return seeds;
    }
}
