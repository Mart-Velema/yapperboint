package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageMenuItem extends JabberMenu
{
    public LanguageMenuItem()
    {
        super(MenuLabel.CHANGE_LANGUAGE);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Translation.getInstance().notify();
            }
        });
        for (Language language: Language.values())
        {
            JMenuItem languageItem = new JMenuItem(String.valueOf(language));
            languageItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    Translation.getInstance().notify(language);
                    System.out.println(language);
                }
            });
            add(languageItem);
        }
    }
}
