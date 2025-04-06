package com.nhlstenden.menubar.menu;

import com.nhlstenden.menubar.JabberMenu;
import com.nhlstenden.menubar.MenuLabel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AboutMenu extends JabberMenu
{
    public AboutMenu()
    {
        super(MenuLabel.ABOUT);
        this.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Dit is jabberpoint van Ian F. Darwin maar dan beter maar ook weer zeer scuffed",
                        getText(),
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("./resources/images/fedora-extra-small.png")
                );
            }
        });
    }
}
