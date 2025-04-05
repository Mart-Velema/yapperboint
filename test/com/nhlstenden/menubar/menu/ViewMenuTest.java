package com.nhlstenden.menubar.menu;

import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.menuItem.GoToSlideMenuItem;
import com.nhlstenden.menubar.menuItem.LanguageMenuItem;
import com.nhlstenden.menubar.menuItem.NextSlideMenuItem;
import com.nhlstenden.menubar.menuItem.PreviousSlideMenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewMenuTest
{
    ViewMenu viewMenu;

    @BeforeEach
    void setUp()
    {
        this.viewMenu = new ViewMenu();
    }

    @Test
    void ViewMenu_MenuComponents_ShouldHaveNextPreviousGoToSeperatorLanguageMenu()
    {
        assertInstanceOf(NextSlideMenuItem.class, this.viewMenu.getMenuComponent(0));
        assertInstanceOf(PreviousSlideMenuItem.class, this.viewMenu.getMenuComponent(1));
        assertInstanceOf(GoToSlideMenuItem.class, this.viewMenu.getMenuComponent(2));
        assertInstanceOf(JSeparator.class, this.viewMenu.getMenuComponent(3));
        assertInstanceOf(LanguageMenuItem.class, this.viewMenu.getMenuComponent(4));
    }

    @Test
    void ViewMenu_MenuLabel_ShouldBeVIEW()
    {
        assertEquals(MenuLabel.VIEW, this.viewMenu.getMenuLabel());
    }
}