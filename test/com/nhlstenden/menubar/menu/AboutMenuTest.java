package com.nhlstenden.menubar.menu;

import com.nhlstenden.menubar.Language;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.Translation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        List<Component> jabberMenus = new ArrayList<>(List.of(this.aboutMenu.getComponents()));

        assertTrue(jabberMenus.isEmpty());
    }

    @Test
    void AboutMenu_MenuLabel_ShouldBeABOUT()
    {
        assertEquals(MenuLabel.ABOUT, this.aboutMenu.getMenuLabel());
    }

    @Test
    void AboutMenu_HasMouseListener_ShouldHaveOne()
    {
//        Two because it standards comes with one
        assertEquals(2, this.aboutMenu.getMouseListeners().length);
    }
}