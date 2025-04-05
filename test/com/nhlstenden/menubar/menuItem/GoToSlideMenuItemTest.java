package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.accessor.XMLAccessor;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class GoToSlideMenuItemTest
{
    GoToSlideMenuItem goToSlideMenuItem;

    @BeforeEach
    void setUp()
    {
        this.goToSlideMenuItem = new GoToSlideMenuItem();
        new XMLAccessor().loadFile("demo.xml");
        System.setProperty("java.awt.headless", "true");
    }

    @Test
    void GoToSlideMenuItem_GoToSlideOneActionEvent_ShouldReturnOne()
    {
        try (MockedStatic<JOptionPane> mockedJOptionPane = Mockito.mockStatic(JOptionPane.class))
        {
            mockedJOptionPane.when(() -> JOptionPane.showInputDialog(anyString())).thenReturn("2");

            ActionListener actionListener = this.goToSlideMenuItem.getActionListeners()[0];

            ActionEvent actionEvent = new ActionEvent(actionListener, ActionEvent.ACTION_PERFORMED, null);
            actionListener.actionPerformed(actionEvent);
        }

        assertEquals(1, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_ToFirstSlide_ShouldReturnSlideZero()
    {
        try (MockedStatic<JOptionPane> mockedJOptionPane = Mockito.mockStatic(JOptionPane.class))
        {
            mockedJOptionPane.when(() -> JOptionPane.showInputDialog(anyString())).thenReturn("1");

            this.goToSlideMenuItem.onClick();
        }

        assertEquals(0, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_ToSecondSlide_ShouldReturnSlideOne()
    {
        try (MockedStatic<JOptionPane> mockedJOptionPane = Mockito.mockStatic(JOptionPane.class))
        {
            mockedJOptionPane.when(() -> JOptionPane.showInputDialog(anyString())).thenReturn("2");

            this.goToSlideMenuItem.onClick();
        }

        assertEquals(1, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void GoToSlideMenuItem_MenuLabel_ShouldBeGO_TO_SLIDE()
    {
        assertEquals(MenuLabel.GO_TO_SLIDE, this.goToSlideMenuItem.getMenuLabel());
    }
}