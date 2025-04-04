package com.nhlstenden.menubar.menu;

import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.menuItem.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class FileMenuTest
{
    FileMenu fileMenu;

    @BeforeEach
    void setUp()
    {
        this.fileMenu = new FileMenu();
    }

    @Test
    void FileMenu_MenuComponents_ShouldHaveOpenExitMenu()
    {
        assertInstanceOf(OpenMenuItem.class, this.fileMenu.getMenuComponent(0));
        assertInstanceOf(ExitMenuItem.class, this.fileMenu.getMenuComponent(1));
    }

    @Test
    void FileMenu_MenuLabel_ShouldBeFILE()
    {
        assertEquals(MenuLabel.FILE, this.fileMenu.getMenuLabel());
    }
}