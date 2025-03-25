package com.nhlstenden.menubar;

import com.nhlstenden.menubar.menu.AboutMenu;
import com.nhlstenden.menubar.menu.FileMenu;
import com.nhlstenden.menubar.menu.ViewMenu;

import javax.swing.*;

public class JabberMenuBar extends JMenuBar
{
    public JabberMenuBar()
    {
        super();
        this.add(new FileMenu());
        this.add(new ViewMenu());
        this.add(new AboutMenu());
    }
}
