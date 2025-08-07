package pl.pitgamer.beaconarmor.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.Plugin;

import pl.pitgamer.beaconarmor.utils.BeaconArmorUtils;

import java.util.List;

public class BeaconShoesUtils {
    private final Plugin plugin;
    private final BeaconArmorUtils armorUtils = new BeaconArmorUtils();

    public BeaconShoesUtils(Plugin plugin) {
        this.plugin = plugin;
    }
    public ItemStack createBeaconShoes() {
        ItemStack beaconShoes = new ItemStack(Material.NETHERITE_BOOTS); // Kann auch DIAMOND_Shoes sein
        ItemMeta meta = beaconShoes.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Schuhe"); // Name der Brustplatte
            meta.setLore(List.of("§7Macht dich unaufhaltbar", "§7Gibt dir spezielle Buffs!"));
            
            // Verzauberungen hinzufügen
            meta.addEnchant(Enchantment.PROJECTILE_PROTECTION, 8, true); // Schutz
            meta.addEnchant(Enchantment.BLAST_PROTECTION, 8, true);
            meta.addEnchant(Enchantment.FIRE_PROTECTION, 8, true);
            meta.addEnchant(Enchantment.PROTECTION, 8, true);
            meta.addEnchant(Enchantment.FEATHER_FALLING, 8, true);
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);              // Haltbarkeit
            meta.addEnchant(Enchantment.DEPTH_STRIDER, 6, true);
            meta.addEnchant(Enchantment.MENDING, 2, true);                 // Reparatur
             // Brustplatte ist unzerbrechlich
            beaconShoes.setItemMeta(meta);
        }
        return beaconShoes;
    }

    /**
     * Fügt ein Crafting-Rezept für die Beacon-Brustplatte hinzu.
     */
    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_Shoes");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconShoes());

        recipe.shape(
                "   ",
                "B B",
                "B B"
        );
        recipe.setIngredient('B', Material.BEACON);    // Beacons als Material

        Bukkit.addRecipe(recipe);
    }

    /**
     * Gibt einem Spieler spezifische Buffs, wenn die Brustplatte getragen wird.
     *
     * @param player Der Spieler
     */
    public void applyBeaconEffects(Player player) {
        boolean hasFullBeaconArmor = armorUtils.hasFullBeaconArmor(player);

        int effectLevel = hasFullBeaconArmor ? 2 : 1;
        ItemStack Shoes = player.getInventory().getBoots();
        if (Shoes != null && Shoes.hasItemMeta() && Shoes.getItemMeta().getDisplayName().equals("§6Beacon Brustplatte")) {
            // Spezielle Effekte hinzufügen
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, effectLevel - 1, true, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 20, effectLevel - 1, true, false)); // Haste
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 20, effectLevel - 1, true, false)); // Sprungkraft
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, effectLevel - 1, true, false)); // Regeneration
            player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 20, effectLevel - 1, true, false)); // Resistenz
            player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 20, effectLevel - 1, true, false)); // Stärke
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 86400, 255, true, false)); // Glowing
        }
    }
}
