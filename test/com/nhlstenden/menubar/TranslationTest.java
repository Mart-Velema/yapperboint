package com.nhlstenden.menubar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslationTest
{
    Translation translation;
    LanguageObserverHelper languageObserver1;
    LanguageObserverHelper languageObserver2;

    @BeforeEach
    void setUp()
    {
        this.translation = Translation.getInstance();

        this.languageObserver1 = new LanguageObserverHelper();
        this.languageObserver2 = new LanguageObserverHelper();
    }

    @Test
    void subscribe_AddOneItem_ShouldContainOne()
    {
        this.translation.subscribe(this.languageObserver1);

        assertTrue(this.translation.getLanguageObservers().contains(this.languageObserver1));
    }

    @Test
    void subscribe_AddTwoItems_ShouldContainTwo()
    {
        this.translation.subscribe(this.languageObserver1);
        this.translation.subscribe(this.languageObserver2);

        assertTrue(this.translation.getLanguageObservers().contains(this.languageObserver1));
        assertTrue(this.translation.getLanguageObservers().contains(this.languageObserver2));
    }

    @Test
    void unsubscribe_HasOneItemRemoveOneItem_ShouldRemoveOne()
    {
        this.translation.subscribe(this.languageObserver1);
        this.translation.unsubscribe(this.languageObserver1);

        assertFalse(this.translation.getLanguageObservers().contains(this.languageObserver1));
    }

    @Test
    void unsubscribe_HasTwoItemsRemoveOneItem_ShouldRemoveOne()
    {
        this.translation.subscribe(this.languageObserver1);
        this.translation.subscribe(this.languageObserver2);

        this.translation.unsubscribe(this.languageObserver1);

        assertFalse(this.translation.getLanguageObservers().contains(this.languageObserver1));
        assertTrue(this.translation.getLanguageObservers().contains(this.languageObserver2));
    }

    @Test
    void unsubscribe_HasTwoItemsRemoveTwoItems_ShouldRemoveTwo()
    {
        this.translation.subscribe(this.languageObserver1);
        this.translation.subscribe(this.languageObserver2);

        this.translation.unsubscribe(this.languageObserver1);
        this.translation.unsubscribe(this.languageObserver2);

        assertFalse(this.translation.getLanguageObservers().contains(this.languageObserver1));
        assertFalse(this.translation.getLanguageObservers().contains(this.languageObserver2));
    }

    @Test
    void notify_HasOneItem_ShouldSetLanguageToEN()
    {
        this.translation.subscribe(this.languageObserver1);

        this.translation.notify(Language.EN);

        assertEquals(Language.EN, this.languageObserver1.language);
    }

    @Test
    void notify_HasOneItem_ShouldSetLanguageToNL()
    {
        this.translation.subscribe(this.languageObserver1);

        this.translation.notify(Language.NL);

        assertEquals(Language.NL, this.languageObserver1.language);
    }

    @Test
    void notify_HasTwoItems_ShouldSetLanguageToEN()
    {
        this.translation.subscribe(this.languageObserver1);
        this.translation.subscribe(this.languageObserver2);

        this.translation.notify(Language.EN);

        assertEquals(Language.EN, this.languageObserver1.language);
        assertEquals(Language.EN, this.languageObserver2.language);
    }

    @Test
    void getLanguage_FileTranslationEN_ShouldReturnFile()
    {
        assertEquals("File", this.translation.getLanguage(Language.EN, MenuLabel.FILE));
    }

    @Test
    void getLanguage_FileTranslationEN_ShouldReturnBestand()
    {
        assertEquals("Bestand", this.translation.getLanguage(Language.NL, MenuLabel.FILE));
    }

    private static class LanguageObserverHelper implements LanguageObserver
    {
        Language language;

        @Override
        public void notify(Language language)
        {
            this.language = language;
        }
    }
}