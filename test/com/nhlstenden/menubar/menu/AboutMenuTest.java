package com.nhlstenden.menubar.menu;

import com.nhlstenden.menubar.JabberMenuBar;
import com.nhlstenden.menubar.MenuLabel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AboutMenuTest
{
    AboutMenu aboutMenu;

    @BeforeEach
    void setup()
    {
        this.aboutMenu = new AboutMenu();
    }

    @Test
    void AboutMenu_MenuComponents_ShouldHaveNoComponents()
    {
        java.util.List<Component> jabberMenus = new ArrayList<>(List.of(this.aboutMenu.getComponents()));

        assertTrue(jabberMenus.isEmpty());
    }

    @Test
    void AboutMenu_MenuLabel_ShouldBeABOUT()
    {
        assertEquals(MenuLabel.ABOUT, this.aboutMenu.getMenuLabel());
    }

    @Test
    void AboutMenu_HasActionListeners_ShouldHaveOne()
    {
        assertEquals(1, this.aboutMenu.getActionListeners().length);
    }
}