package life.steeze.hcfpluspapi;

import life.steeze.hcfplus.FileUtils.ConfigManager;
import life.steeze.hcfplus.HCFPlugin;
import life.steeze.hcfplus.Objects.Faction;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

public class HCFPlusPAPIExtension extends PlaceholderExpansion {
    private Plugin p = Bukkit.getPluginManager().getPlugin("HCFPlus");
    private HCFPlugin hcfplus = null;
    private boolean color = ConfigManager.SHOW_COLOR_IN_PLACEHOLDER;

    @Override
    public boolean canRegister(){
        if(p==null) return false;
        hcfplus = (HCFPlugin) p;
        return true;
    }

    @Override
    public String getIdentifier() {
        return "HCFPlusPAPIExtension";
    }

    @Override
    public String getAuthor() {
        return "ViperCobra";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("hcffaction")){
            Faction f = hcfplus.getData().getFaction(player);
            if(f != null){
                return (color ? f.getColor() + "" : "") + f.getName();
            }
        }
        return null;
    }
}
