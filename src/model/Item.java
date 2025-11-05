package model;

public class Item {
    private int id;
    private String name;
    private int currentStock;
    private int minStock;

    public Item(int id, String name, int currentStock, int minStock) {
        this.id = id;
        this.name = name;
        this.currentStock = currentStock;
        this.minStock = minStock;
    }

    public Item(String name, int currentStock, int minStock) {
        this.name = name;
        this.currentStock = currentStock;
        this.minStock = minStock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getCurrentStock() { return currentStock; }
    public int getMinStock() { return minStock; }
}
