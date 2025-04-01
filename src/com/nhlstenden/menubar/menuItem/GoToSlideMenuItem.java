package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.JabberMenuItem;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.presentation.Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToSlideMenuItem extends JabberMenuItem
{
    public GoToSlideMenuItem()
    {
        super(MenuLabel.GO_TO_SLIDE);
        addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                String pageNumberStr = JOptionPane.showInputDialog("Page number");
                int pageNumber = Integer.parseInt(pageNumberStr);
                Presentation.getInstance().setCurrentSlideNumber(pageNumber - 1);
            }
        });
    }
}
