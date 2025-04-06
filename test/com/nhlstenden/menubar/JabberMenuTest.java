package com.nhlstenden.menubar;

import com.nhlstenden.menubar.menu.AboutMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JabberMenuTest
{
    JabberMenu jabberMenu;

    @BeforeEach
    void setUp()
    {
        this.jabberMenu = new AboutMenu();
    }

    @Test
    void jabberMenu_EnglishLanguage_ShouldHaveEnglishTranslation()
    {
        assertEquals(Translation.getInstance().getLanguage(Language.EN, MenuLabel.ABOUT), this.jabberMenu.getText());
    }

    @Test
    void setJabberMenu_SubscribeToTranslations_ShouldBeSubscribed()
    {
        assertTrue(Translation.getInstance().getLanguageObservers().contains(this.jabberMenu));
    }

    @Test
    void notify_SetLanguageToEN_ShouldReturnAbout()
    {
        this.jabberMenu.notify(Language.EN);

        assertEquals("About", this.jabberMenu.getText());
    }

    @Test
    void notify_SetLanguageToNL_ShouldReturnJabberPointafsluiten()
    {
        this.jabberMenu.notify(Language.NL);

        assertEquals("Over ons", this.jabberMenu.getText());
    }
}