package com.nhlstenden.menubar.menu;

import com.nhlstenden.menubar.JabberMenu;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.Translation;
import com.nhlstenden.menubar.menuItem.GoToSlideMenuItem;
import com.nhlstenden.menubar.menuItem.LanguageMenuItem;
import com.nhlstenden.menubar.menuItem.NextSlideMenuItem;
import com.nhlstenden.menubar.menuItem.PreviousSlideMenuItem;

public class ViewMenu extends JabberMenu
{
    public ViewMenu()
    {
        super(MenuLabel.VIEW);
        this.add(new NextSlideMenuItem());
        this.add(new PreviousSlideMenuItem());
        this.add(new GoToSlideMenuItem());
        this.addSeparator();
        this.add(new LanguageMenuItem());
    }
}
