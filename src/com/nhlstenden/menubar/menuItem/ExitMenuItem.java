package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.JabberMenuItem;
import com.nhlstenden.menubar.MenuLabel;

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
                onClick();
            }
        });
    }

    @Override
    public void onClick()
    {
        System.exit(0);
    }
}
