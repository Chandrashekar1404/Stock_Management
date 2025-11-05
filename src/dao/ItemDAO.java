package dao;

import Db.DBConnection;
import model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public void addItem(Item item) {
        String query = "INSERT INTO items(name, current_stock, min_stock) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, item.getName());
            ps.setInt(2, item.getCurrentStock());
            ps.setInt(3, item.getMinStock());
            ps.executeUpdate();
            System.out.println("✅ Item added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String query = "SELECT * FROM items";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("current_stock"),
                        rs.getInt("min_stock")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStock(int id, int newStock) {
        String query = "UPDATE items SET current_stock = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, newStock);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Stock updated successfully!");
            else
                System.out.println("❌ Item not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(int id) {
        String query = "DELETE FROM items WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("🗑️ Item deleted successfully!");
            else
                System.out.println("❌ Item not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
