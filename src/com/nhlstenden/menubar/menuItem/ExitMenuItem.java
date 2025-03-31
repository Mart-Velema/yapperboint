package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.JabberMenuItem;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.Translation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuItem extends JabberMenuItem
{
    public ExitMenuItem()
    {
        super(MenuLabel.EXIT);
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                System.exit(0);
            }
        });
    }
}
