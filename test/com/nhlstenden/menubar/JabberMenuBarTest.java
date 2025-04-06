package com.nhlstenden.menubar;

import com.nhlstenden.menubar.menu.AboutMenu;
import com.nhlstenden.menubar.menu.FileMenu;
import com.nhlstenden.menubar.menu.ViewMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JabberMenuBarTest
{

    @Test
    void JabberMenuBar_Menu_ShouldHaveFileViewAboutInorder()
    {
        JabberMenuBar jabberMenuBar = new JabberMenuBar();

        assertInstanceOf(FileMenu.class, jabberMenuBar.getComponent(0));   // Check if first item is FileMenu
        assertInstanceOf(ViewMenu.class, jabberMenuBar.getComponent(1));   // Check if second item is ViewMenu
        assertInstanceOf(AboutMenu.class, jabberMenuBar.getComponent(2));  // Check if third item is AboutMenu
    }
}