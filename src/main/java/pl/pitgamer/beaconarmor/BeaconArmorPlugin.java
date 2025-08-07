package pl.pitgamer.beaconarmor;

import pl.pitgamer.beaconarmor.utils.BeaconChestPlateUtils;
import pl.pitgamer.beaconarmor.utils.BeaconHelmetUtils;
import pl.pitgamer.beaconarmor.utils.BeaconLegginsUtils;
import pl.pitgamer.beaconarmor.utils.BeaconShoesUtils;

import pl.pitgamer.beaconarmor.utils.tools.BeaconPickaxeUtils;
import pl.pitgamer.beaconarmor.utils.tools.BeaconSwordUtils;
import pl.pitgamer.beaconarmor.utils.tools.BeaconAxeUtils ;
import pl.pitgamer.beaconarmor.utils.tools.BeaconHoeUtils;
import pl.pitgamer.beaconarmor.utils.tools.BeaconShovelUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BeaconArmorPlugin extends JavaPlugin {

    private BeaconHelmetUtils beaconHelmetUtils;
    private BeaconChestPlateUtils beaconChestPlateUtils;
    private BeaconLegginsUtils beaconLegginsUtils;
    private BeaconShoesUtils beaconShoesUtils;

    private BeaconSwordUtils beaconSwordUtils;
    private BeaconPickaxeUtils beaconPickaxeUtils;
    private BeaconAxeUtils beaconAxeUtils;
    private BeaconHoeUtils beaconHoeUtils;
    private BeaconShovelUtils beaconShovelUtils;

    @Override
    public void onEnable() {
        getLogger().info("BeaconArmorPlugin ist Aktiviert!");

        // Initialisiere die Klassen
        beaconHelmetUtils = new BeaconHelmetUtils(this);
        beaconChestPlateUtils = new BeaconChestPlateUtils(this);
        beaconLegginsUtils = new BeaconLegginsUtils(this);
        beaconShoesUtils = new BeaconShoesUtils(this);

        beaconSwordUtils = new BeaconSwordUtils(this);
        beaconPickaxeUtils = new BeaconPickaxeUtils(this);
        beaconAxeUtils = new BeaconAxeUtils(this);
        beaconHoeUtils = new BeaconHoeUtils(this);
        beaconShovelUtils = new BeaconShovelUtils(this);


        // Rezepte hinzufügen
        beaconHelmetUtils.addCraftingRecipe();
        beaconChestPlateUtils.addCraftingRecipe();
        beaconLegginsUtils.addCraftingRecipe();
        beaconShoesUtils.addCraftingRecipe();

        beaconSwordUtils.addCraftingRecipe();
        beaconPickaxeUtils.addCraftingRecipe();
        beaconAxeUtils.addCraftingRecipe();
        beaconHoeUtils.addCraftingRecipe();
        beaconShovelUtils.addCraftingRecipe();

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    beaconHelmetUtils.applyBeaconEffects(player);
                    beaconChestPlateUtils.applyBeaconEffects(player);
                    beaconLegginsUtils.applyBeaconEffects(player);
                    beaconShoesUtils.applyBeaconEffects(player);
                }
            }
        }.runTaskTimer(this, 0, 20);
    }

    @Override
    public void onDisable() {
        getLogger().info("BeaconArmorPlugin ist deaktiviert!");
    }
}
