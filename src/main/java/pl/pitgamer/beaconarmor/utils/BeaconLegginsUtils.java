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

public class BeaconLegginsUtils {
    private final Plugin plugin;
    private final BeaconArmorUtils armorUtils = new BeaconArmorUtils();

    public BeaconLegginsUtils(Plugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack createBeaconLeggins() {
        ItemStack beaconLeggins = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = beaconLeggins.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Beacon Hose");
            meta.setLore(List.of("§7Macht dich unaufhaltsam", "§7Besondere Rüstung auf dem Server"));

            meta.addEnchant(Enchantment.PROJECTILE_PROTECTION, 8, true); // Schutz
            meta.addEnchant(Enchantment.BLAST_PROTECTION, 8, true);
            meta.addEnchant(Enchantment.FIRE_PROTECTION, 8, true);
            meta.addEnchant(Enchantment.PROTECTION, 8, true);
            meta.addEnchant(Enchantment.UNBREAKING, 6, true);              // Haltbarkeit
            meta.addEnchant(Enchantment.SWIFT_SNEAK, 6, true);
            meta.addEnchant(Enchantment.MENDING, 2, true);  

            beaconLeggins.setItemMeta(meta);
        }
        return beaconLeggins;
    }

    public void addCraftingRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "beacon_leggings");
        ShapedRecipe recipe = new ShapedRecipe(key, createBeaconLeggins());

        recipe.shape(
            "BBB",
            "B B",
            "B B"
        );
        recipe.setIngredient('B', Material.BEACON);

        Bukkit.addRecipe(recipe);
    }

    public void applyBeaconEffects(Player player) {
        boolean hasFullBeaconArmor = armorUtils.hasFullBeaconArmor(player);
        int effectLevel = hasFullBeaconArmor ? 2 : 1;
        ItemStack leggings = player.getInventory().getLeggings();

        if (leggings != null && leggings.hasItemMeta() && leggings.getItemMeta().getDisplayName().equals("§6Beacon Hose")) {
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
