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

public class BeaconHelmetUtils {
    private final BeaconArmorUtils armorUtils = new BeaconArmorUtils();

    private final Plugin plugin;

    public BeaconHelmetUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Erstellt einen Beacon-Helm mit benutzerdefinierten Eigenschaften.
     *
     * @return ItemStack der Helm
     */
    public ItemStack createBeaconHelmet() {
        ItemStack beaconHelmet = new ItemStack(Material.NETHERITE_HELMET); // Du kannst auch DIAMOND_HELMET verwenden
        ItemMeta meta = beaconHelmet.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Helm"); // Name des Helms
            meta.setLore(List.of("§7Leuchtet wie ein Beacon", "§7Gibt dir alle Beacon-Effekte"));
            
            // Verzauberungen hinzufügen
            meta.addEnchant(Enchantment.PROJECTILE_PROTECTION, 8, true); // Schutz
            meta.addEnchant(Enchantment.BLAST_PROTECTION, 8, true);
            meta.addEnchant(Enchantment.FIRE_PROTECTION, 8, true);
            meta.addEnchant(Enchantment.PROTECTION, 8, true);
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);               // Haltbarkeit
            meta.addEnchant(Enchantment.RESPIRATION, 6, true);
            meta.addEnchant(Enchantment.AQUA_AFFINITY, 2, true);
            meta.addEnchant(Enchantment.MENDING, 2, true);                 // Reparatur
             // Helm ist unzerbrechlich
            beaconHelmet.setItemMeta(meta);
        }
        return beaconHelmet;
    }

    /**
     * Fügt ein Crafting-Rezept für den Beacon-Helm hinzu.
     */
    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconHelmet());

        recipe.shape(
                "BBB",
                "B B",
                "   "
        );
        recipe.setIngredient('B', Material.BEACON);    // Beacons als Material

        Bukkit.addRecipe(recipe);
    }

    /**
     * Gibt einem Spieler alle Beacon-Effekte, wenn der Helm getragen wird.
     *
     * @param player Der Spieler
     */
    public void applyBeaconEffects(Player player) {
        boolean hasFullBeaconArmor = armorUtils.hasFullBeaconArmor(player);

        int effectLevel = hasFullBeaconArmor ? 2 : 1;
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && helmet.hasItemMeta() && helmet.getItemMeta().getDisplayName().equals("§6Beacon Helm")) {
            // Alle Effekte hinzufügen
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
