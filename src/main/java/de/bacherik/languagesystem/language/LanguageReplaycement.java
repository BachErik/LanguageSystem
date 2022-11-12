package de.bacherik.languagesystem.language;

import java.util.HashMap;
import java.util.Map;

public class LanguageReplaycement {
    Map<String, String> replacements = new HashMap<>();

    public void addReplacement(String key, String value) {
        this.replacements.put(key, value);
    }

    public Map<String, String> getReplacements() {
        return this.replacements;
    }
}
