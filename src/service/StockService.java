package service;

import dao.ItemDAO;
import model.Item;
import java.util.List;

public class StockService {
    private ItemDAO itemDAO = new ItemDAO();

    public void showLowStockItems() {
        List<Item> items = itemDAO.getAllItems();
        boolean found = false;

        System.out.println("\n⚠️ Low Stock Items:");
        for (Item item : items) {
            if (item.getCurrentStock() < item.getMinStock()) {
                found = true;
                System.out.println(" - " + item.getName() +
                        " | Current: " + item.getCurrentStock() +
                        " | Min: " + item.getMinStock());
            }
        }

        if (!found)
            System.out.println("✅ All stocks are above minimum level!");
    }
}
