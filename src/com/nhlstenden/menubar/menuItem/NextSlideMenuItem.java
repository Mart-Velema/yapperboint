package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.JabberMenuItem;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.presentation.Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextSlideMenuItem extends JabberMenuItem
{
    public NextSlideMenuItem()
    {
        super(MenuLabel.NEXT_SLIDE);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Presentation.getInstance().nextSlide();
            }
        });
    }
}
