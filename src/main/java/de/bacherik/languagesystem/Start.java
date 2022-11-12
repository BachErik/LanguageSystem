package de.bacherik.languagesystem;

import de.bacherik.languagesystem.language.LanguageManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Start extends JavaPlugin {

    public void onLoad() {
        LanguageManager languageManager = new LanguageManager();
        languageManager.init();
    }
}
