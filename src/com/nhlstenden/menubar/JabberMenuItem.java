package com.nhlstenden.menubar;

import javax.swing.*;

public abstract class JabberMenuItem extends JMenuItem implements LanguageObserver
{
    private MenuLabel menuLabel;

    public JabberMenuItem(MenuLabel menuLabel)
    {
        super(Translation.getInstance().getLanguage(Language.EN, menuLabel));
        this.menuLabel = menuLabel;
    }

    public MenuLabel getMenuLabel()
    {
        return menuLabel;
    }

    public void setMenuLabel(MenuLabel menuLabel)
    {
        this.menuLabel = menuLabel;
    }

    @Override
    public void notify(Language language)
    {
        super.setText(Translation.getInstance().getLanguage(language, this.menuLabel));
    }
}
