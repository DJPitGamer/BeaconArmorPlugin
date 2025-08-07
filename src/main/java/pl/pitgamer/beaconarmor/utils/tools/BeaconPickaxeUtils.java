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

public class BeaconPickaxeUtils {
    private final Plugin plugin;

    public BeaconPickaxeUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBeaconPickaxe() {
        ItemStack beaconPickaxe = new ItemStack(Material.NETHERITE_PICKAXE); // Kann auch DIAMOND_Shoes sein
        ItemMeta meta = beaconPickaxe.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Spitzhacke"); // Name der Brustplatte
            meta.setLore(List.of("Fast as Fuck boiii!!!", "Glück und erfolg beim nächsten minen!!!"));
            
            // Verzauberungen hinzufügen
            meta.addEnchant(Enchantment.EFFICIENCY, 10, true);
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);   
            meta.addEnchant(Enchantment.FORTUNE, 6, true);           // Haltbarkeit
            meta.addEnchant(Enchantment.MENDING, 2, true);                 // Reparatur
             // Brustplatte ist unzerbrechlich
            beaconPickaxe.setItemMeta(meta);
        }
        return beaconPickaxe;
    }
    /**
     * Fügt ein Crafting-Rezept für die Beacon-Brustplatte hinzu.
     */
    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_Pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconPickaxe());

        recipe.shape(
                "BBB",
                " S ",
                " S "
        );
        recipe.setIngredient('B', Material.BEACON);    // Beacons als Material
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
