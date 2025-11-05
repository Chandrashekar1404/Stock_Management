import dao.ItemDAO;
import model.Item;
import service.StockService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemDAO dao = new ItemDAO();
        StockService stockService = new StockService();

        while (true) {
            System.out.println("\n===== STOCK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Item");
            System.out.println("5. Check Low Stock Items");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter current stock: ");
                    int current = sc.nextInt();
                    System.out.print("Enter minimum stock: ");
                    int min = sc.nextInt();
                    dao.addItem(new Item(name, current, min));
                    break;

                case 2:
                    List<Item> items = dao.getAllItems();
                    System.out.println("\n🧾 Items List:");
                    for (Item item : items) {
                        System.out.println(item.getId() + " | " + item.getName() +
                                " | Stock: " + item.getCurrentStock() +
                                " | Min: " + item.getMinStock());
                    }
                    break;

                case 3:
                    System.out.print("Enter item ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new stock: ");
                    int newStock = sc.nextInt();
                    dao.updateStock(id, newStock);
                    break;

                case 4:
                    System.out.print("Enter item ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteItem(delId);
                    break;

                case 5:
                    stockService.showLowStockItems();
                    break;

                case 6:
                    System.out.println("👋 Exiting... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
