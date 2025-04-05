package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.Language;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.Translation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class LanguageMenuItemTest
{
    LanguageMenuItem languageMenuItem;

    @BeforeEach
    void setUp()
    {
        this.languageMenuItem = new LanguageMenuItem();
    }

    @Test
    void LanguageMenuItem_AmountOfMenuItems_ShouldBeEqualsToAmountOfLanguages()
    {
        assertEquals(Language.values().length, this.languageMenuItem.getMenuComponentCount());
    }

    @Test
    void LanguageMenuItem_ChangeLanguageToEN_ShouldSetTranslationToEN()
    {
        Language language = Language.values()[0];
        String translation = Translation.getInstance().getLanguage(language, MenuLabel.CHANGE_LANGUAGE);

        JMenuItem component = (JMenuItem) this.languageMenuItem.getMenuComponent(0);

        ActionEvent actionEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, null);
        component.getActionListeners()[0].actionPerformed(actionEvent);

        assertEquals(translation, this.languageMenuItem.getText());
    }

    @Test
    void LanguageMenuItem_ChangeLanguageToNL_ShouldSetTranslationToNL()
    {
        Language language = Language.values()[1];
        String translation = Translation.getInstance().getLanguage(language, MenuLabel.CHANGE_LANGUAGE);

        JMenuItem component = (JMenuItem) this.languageMenuItem.getMenuComponent(1);

        ActionEvent actionEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, null);
        component.getActionListeners()[0].actionPerformed(actionEvent);

        assertEquals(translation, this.languageMenuItem.getText());
    }

    @Test
    void LanguageMenuItem_MenuLabel_ShouldBeCHANGE_LANGUAGE()
    {
        assertEquals(MenuLabel.CHANGE_LANGUAGE, this.languageMenuItem.getMenuLabel());
    }
}