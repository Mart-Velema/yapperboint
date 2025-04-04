package com.nhlstenden.menubar;

import com.nhlstenden.menubar.menu.AboutMenu;
import com.nhlstenden.menubar.menu.FileMenu;
import com.nhlstenden.menubar.menu.ViewMenu;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JabberMenuBarTest
{

    @Test
    void JabberMenuBar_Menu_ShouldHaveFileViewAboutInorder()
    {
        JabberMenuBar jabberMenuBar = new JabberMenuBar();

        List<Component> jabberMenus = new ArrayList<>(List.of(jabberMenuBar.getComponents()));

        assertInstanceOf(FileMenu.class, jabberMenus.get(0));   // Check if first item is FileMenu
        assertInstanceOf(ViewMenu.class, jabberMenus.get(1));   // Check if second item is ViewMenu
        assertInstanceOf(AboutMenu.class, jabberMenus.get(2));  // Check if third item is AboutMenu
    }
}