package pl.pitgamer.beaconarmor.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BeaconArmorUtils {

    /**
     * Prüft, ob ein Spieler die komplette Beacon-Rüstung trägt.
     *
     * @param player Der Spieler, der überprüft wird.
     * @return true, wenn der Spieler die vollständige Beacon-Rüstung trägt, sonst false.
     */
    public boolean hasFullBeaconArmor(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        return isBeaconArmorPiece(helmet, "§6Beacon Helm") &&
               isBeaconArmorPiece(chestplate, "§6Beacon Brustplatte") &&
               isBeaconArmorPiece(leggings, "§6Beacon Hose") &&
               isBeaconArmorPiece(boots, "§6Beacon Schuhe");
    }

    /**
     * Prüft, ob ein Rüstungsteil ein bestimmtes Beacon-Rüstungsteil ist.
     *
     * @param item        Das Rüstungsteil, das überprüft wird.
     * @param displayName Der erwartete Anzeigename des Items.
     * @return true, wenn das Item den richtigen Namen hat, sonst false.
     */
    private boolean isBeaconArmorPiece(ItemStack item, String displayName) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta != null && meta.getDisplayName().equals(displayName);
    }
}