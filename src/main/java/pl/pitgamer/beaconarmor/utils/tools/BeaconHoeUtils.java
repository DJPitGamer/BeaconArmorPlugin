package pl.pitgamer.beaconarmor.utils.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class BeaconHoeUtils {

    private final Plugin plugin;

    public BeaconHoeUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBeaconHoe() {
        ItemStack beaconHoe = new ItemStack(Material.NETHERITE_HOE); // Kann auch DIAMOND_Shoes sein
        ItemMeta meta = beaconHoe.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Sense"); // Name der Brustplatte
            meta.setLore(List.of("Farming tool.", "Geht nicht schnell kapput!"));
            
            // Verzauberungen hinzufügen
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);         // Haltbarkeit
            meta.addEnchant(Enchantment.MENDING, 2, true);                 // Reparatur
             // Brustplatte ist unzerbrechlich
            beaconHoe.setItemMeta(meta);
        }
        return beaconHoe;
    }
    /**
     * Fügt ein Crafting-Rezept für die Beacon-Brustplatte hinzu.
     */
    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_Hoe");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconHoe());

        recipe.shape(
                "BB ",
                " S ",
                " S "
        );
        recipe.setIngredient('B', Material.BEACON);    // Beacons als Material
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
