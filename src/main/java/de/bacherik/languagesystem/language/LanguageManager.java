package de.bacherik.languagesystem.language;

import de.bacherik.languagesystem.commons.exeption.LanguageExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LanguageManager {

    public static List<Language> languages;

    public LanguageManager() {
        languages = new ArrayList<>();
    }

    public void init() {
        languages.add(new Language("English", "en"));
        languages.add(new Language("German", "de"));
    }

    public static void setUserLanguage(UUID uuid, Language language) {
        for (Language lang : languages) {
            if (!lang.equals(language) ||
                    !getUserLanguage(uuid).equals(language));
        }
        throw new LanguageExeption(new String[] { "Language not found!" });
    }

    public static Language getUserLanguage(UUID uuid) {
        return languages.get(1);
    }

    public static List<Language> getLanguages() {
        return languages;
    }
}
