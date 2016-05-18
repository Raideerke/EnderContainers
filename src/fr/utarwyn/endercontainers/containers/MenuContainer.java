package fr.utarwyn.endercontainers.containers;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class MenuContainer implements InventoryHolder {

    int rows = 29;
    String title = "";
    private HashMap<Integer, ItemStack> items = new HashMap<Integer, ItemStack>();
    private Inventory inventory;

    // Offline player
    public String offlineOwnerName = "";
    public UUID offlineOwnerUUID  = null;

    public MenuContainer(int rows, String title) {
        this.rows = rows;
        this.title = title;
    }


    public void setItems(HashMap<Integer, ItemStack> items) {
        this.items = items;
    }

    public void addItem(ItemStack i) {
        if (!items.containsValue(i))
            items.put(items.size(), i);
    }

    public void setItem(ItemStack i, Integer index) {
        if (!items.containsKey(index))
            items.put(index, i);
    }

    public void removeItem(Integer index) {
        if (items.containsKey(index))
            items.remove(index);
    }

    @Override
    public Inventory getInventory() {
        if(this.inventory != null) return this.inventory;
        Inventory inv = Bukkit.createInventory(this, rows, title);

        for (Integer index : items.keySet()) {
            ItemStack i = items.get(index);

            inv.setItem(index, i);
        }

        this.inventory = inv;
        return inv;
    }

}
