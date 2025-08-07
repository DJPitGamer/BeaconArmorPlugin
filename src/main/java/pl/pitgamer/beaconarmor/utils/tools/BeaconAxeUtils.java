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

public class BeaconAxeUtils {
    private final Plugin plugin;

    public BeaconAxeUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBeaconAxe() {
        ItemStack beaconAxe = new ItemStack(Material.NETHERITE_AXE); // Kann auch DIAMOND_Shoes sein
        ItemMeta meta = beaconAxe.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Axt"); // Name der Brustplatte
            meta.setLore(List.of("Macht dich stärker als dein gegner!", "PvP ist ein Kinderspiel!!!"));
            
            // Verzauberungen hinzufügen
            meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS, 10, true); 
            meta.addEnchant(Enchantment.EFFICIENCY, 10, true);
            meta.addEnchant(Enchantment.SHARPNESS, 10, true);
            meta.addEnchant(Enchantment.SMITE, 10, true);
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);              // Haltbarkeit
            meta.addEnchant(Enchantment.FORTUNE, 6, true);
            meta.addEnchant(Enchantment.MENDING, 2, true);                 // Reparatur
             // Brustplatte ist unzerbrechlich
            beaconAxe.setItemMeta(meta);
        }
        return beaconAxe;
    }
    /**
     * Fügt ein Crafting-Rezept für die Beacon-Brustplatte hinzu.
     */
    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_Axe");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconAxe());

        recipe.shape(
                "BB ",
                "BS ",
                " S "
        );
        recipe.setIngredient('B', Material.BEACON);    // Beacons als Material
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
