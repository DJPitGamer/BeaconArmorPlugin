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

public class BeaconShovelUtils {

    private final Plugin plugin;

    public BeaconShovelUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBeaconShovel() {
        ItemStack beacoShovel = new ItemStack(Material.NETHERITE_SHOVEL); // Kann auch DIAMOND_Shoes sein
        ItemMeta meta = beacoShovel.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Schaufel"); // Name der Brustplatte
            meta.setLore(List.of("Fast as Fuck boiii!!!", "Schneller als jede andere Schaufel!!!"));
            
            // Verzauberungen hinzufügen
            meta.addEnchant(Enchantment.EFFICIENCY, 10, true);
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);   
            meta.addEnchant(Enchantment.FORTUNE, 6, true);           // Haltbarkeit
            meta.addEnchant(Enchantment.MENDING, 2, true);                 // Reparatur
             // Brustplatte ist unzerbrechlich
            beacoShovel.setItemMeta(meta);
        }
        return beacoShovel;
    }
    /**
     * Fügt ein Crafting-Rezept für die Beacon-Brustplatte hinzu.
     */
    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_Shovel");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconShovel());

        recipe.shape(
                " B ",
                " S ",
                " S "
        );
        recipe.setIngredient('B', Material.BEACON);    // Beacons als Material
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
