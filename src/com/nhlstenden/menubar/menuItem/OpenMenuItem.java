package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.accessor.Accessor;
import com.nhlstenden.accessor.XMLAccessor;
import com.nhlstenden.menubar.JabberMenuItem;
import com.nhlstenden.menubar.MenuLabel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenMenuItem extends JabberMenuItem
{
    public OpenMenuItem()
    {
        super(MenuLabel.OPEN);
        addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                String fileName = JOptionPane.showInputDialog("Open");
                if (fileName == null)
                {
                    return;
                }
                Accessor accessor = new XMLAccessor();
                accessor.loadFile(fileName);
            }
        });
    }
}
