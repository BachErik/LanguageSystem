package de.bacherik.languagesystem.language;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Map;

public class Language {

    private final String name;

    private JsonObject jsonObject;

    public Language(String name, String acronym) {
        this.name = name;
        try {
            this.jsonObject = (new JsonParser()).parse(new FileReader("languages\\" + acronym + "\\translations.json")).getAsJsonObject();
        } catch (Exception exception) {
            if (exception.getClass().equals(FileNotFoundException.class)) {
                File file = new File("languages\\" + acronym + "\\translations.json");
                file.getParentFile().mkdirs();
                try {
                    if (file.createNewFile()) {
                        FileWriter fileWriter = new FileWriter(file);
                        fileWriter.write("{}");
                        fileWriter.close();
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else {
                exception.printStackTrace();
            }
            this.jsonObject = null;
        }
    }

    public boolean existKey(String key) {
        return this.jsonObject.has(key);
    }

    public String getValue(String key) {
        return existKey(key) ? this.jsonObject.get(key).getAsString() : null;
    }

    public String getValue(String key, LanguageReplaycement languageReplacement) {
        String value = getValue(key);
        for (Map.Entry<String, String> replacement : languageReplacement.getReplacements().entrySet())
            value = value.replace("%" + (String)replacement.getKey() + "%", replacement.getValue());
        return value;
    }

    public String getName() {
        return this.name;
    }
}
