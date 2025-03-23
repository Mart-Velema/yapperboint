package com.nhlstenden.menubar.menu;

import com.nhlstenden.menubar.JabberMenu;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.menuItem.ExitMenuItem;
import com.nhlstenden.menubar.menuItem.OpenMenuItem;

public class FileMenu extends JabberMenu
{
    public FileMenu()
    {
        super(MenuLabel.FILE);
        this.add(new OpenMenuItem());
        this.add(new ExitMenuItem());
    }
}
