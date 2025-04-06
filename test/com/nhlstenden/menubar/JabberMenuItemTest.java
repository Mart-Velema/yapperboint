package com.nhlstenden.menubar;

import com.nhlstenden.menubar.menuItem.ExitMenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JabberMenuItemTest
{
    JabberMenuItem jabberMenuItem;

    @BeforeEach
    void setUp()
    {
        this.jabberMenuItem = new ExitMenuItem();
    }

    @Test
    void jabberMenu_EnglishLanguage_ShouldHaveEnglishTranslation()
    {
        assertEquals(Translation.getInstance().getLanguage(Language.EN, MenuLabel.EXIT), this.jabberMenuItem.getText());
    }

    @Test
    void setJabberMenu_SubscribeToTranslations_ShouldBeSubscribed()
    {
        assertTrue(Translation.getInstance().getLanguageObservers().contains(this.jabberMenuItem));
    }

    @Test
    void notify_SetLanguageToEN_ShouldReturnExitJabberPoint()
    {
        this.jabberMenuItem.notify(Language.EN);

        assertEquals("Exit JabberPoint", this.jabberMenuItem.getText());
    }

    @Test
    void notify_SetLanguageToNL_ShouldReturnOverons()
    {
        this.jabberMenuItem.notify(Language.NL);

        assertEquals("JabberPoint afsluiten", this.jabberMenuItem.getText());
    }
}