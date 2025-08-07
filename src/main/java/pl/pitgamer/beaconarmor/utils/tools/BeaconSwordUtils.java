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

public class BeaconSwordUtils {
    private final Plugin plugin;

    public BeaconSwordUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBeaconSword() {
        ItemStack beaconSword = new ItemStack(Material.NETHERITE_SWORD); // Kann auch DIAMOND_Shoes sein
        ItemMeta meta = beaconSword.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Schwert"); // Name der Brustplatte
            meta.setLore(List.of("Macht dich stärker als dein gegner!", "PvP ist ein Kinderspiel!!!"));
            
            // Verzauberungen hinzufügen
            meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS, 10, true); 
            meta.addEnchant(Enchantment.SHARPNESS, 10, true);
            meta.addEnchant(Enchantment.SMITE, 10, true);
            meta.addEnchant(Enchantment.LOOTING, 6, true);
            meta.addEnchant(Enchantment.SWEEPING_EDGE, 6, true);
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);              // Haltbarkeit
            meta.addEnchant(Enchantment.FIRE_ASPECT, 4, true);
            meta.addEnchant(Enchantment.MENDING, 2, true);                 // Reparatur
             // Brustplatte ist unzerbrechlich
            beaconSword.setItemMeta(meta);
        }
        return beaconSword;
    }
    /**
     * Fügt ein Crafting-Rezept für die Beacon-Brustplatte hinzu.
     */
    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_Sword");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconSword());

        recipe.shape(
                " B ",
                " B ",
                " S "
        );
        recipe.setIngredient('B', Material.BEACON);    // Beacons als Material
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
