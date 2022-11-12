package de.bacherik.languagesystem.commons.exeption;

public class LanguageExeption extends RuntimeException{
    public LanguageExeption(Throwable throwable, String... messages) {
        super(String.join("\n", (CharSequence[])messages), throwable, false, true);
    }

    public LanguageExeption(String... messages) {
        super(String.join("\n", (CharSequence[])messages), null, false, true);
    }

    public LanguageExeption(Throwable throwable, boolean enableSuppression, boolean writableStackTrace, String... messages) {
        super(String.join("\n", (CharSequence[])messages), throwable, enableSuppression, writableStackTrace);
    }
}
