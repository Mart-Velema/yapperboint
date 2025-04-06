package com.nhlstenden.menubar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;

public class Translation
{
    private static final Translation INSTANCE = new Translation();
    private HashSet<LanguageObserver> languageObservers;
    private HashMap<MenuLabel, HashMap<Language, String>> translations;

    private Translation()
    {
        this.languageObservers = new HashSet<>();
        this.translations = this.getTranslationsFromFile();
    }

    public static Translation getInstance()
    {
        return Translation.INSTANCE;
    }

    public HashSet<LanguageObserver> getLanguageObservers()
    {
        return languageObservers;
    }

    public void setLanguageObservers(HashSet<LanguageObserver> languageObservers)
    {
        this.languageObservers = languageObservers;
    }

    public HashMap<MenuLabel, HashMap<Language, String>> getTranslations()
    {
        return translations;
    }

    public void setTranslations(HashMap<MenuLabel, HashMap<Language, String>> translations)
    {
        this.translations = translations;
    }

    public void subscribe(LanguageObserver languageObserver)
    {
        this.languageObservers.add(languageObserver);
    }

    public void unsubscribe(LanguageObserver languageObserver)
    {
        this.languageObservers.remove(languageObserver);
    }

    public void notify(Language language)
    {
        for (LanguageObserver currentLanguageObserver : this.languageObservers)
        {
            currentLanguageObserver.notify(language);
        }
    }

    public String getLanguage(Language language, MenuLabel menuLabel)
    {
        return this.translations.get(menuLabel).get(language);
    }

    private HashMap<MenuLabel, HashMap<Language, String>> getTranslationsFromFile()
    {
        try
        {
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new FileReader("./resources/translations.json"));

            Type type = new TypeToken<HashMap<MenuLabel, HashMap<Language, String>>>() {}.getType();

            return gson.fromJson(jsonReader, type);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException("ERROR: Failed to start JabberPoint: " + e.getMessage() + e.getCause());
        }
    }
}
