package com.nhlstenden.menubar.menuItem;

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

class OpenMenuItemTest
{
    OpenMenuItem openMenuItem;

    @BeforeEach
    void setUp()
    {
        this.openMenuItem = new OpenMenuItem();
    }

    @Test
    void OpenMenuItem_LoadValidFileActionEvent_ShouldLoadFile()
    {
        try (MockedStatic<JOptionPane> mockedJOptionPane = Mockito.mockStatic(JOptionPane.class))
        {
            mockedJOptionPane.when(() -> JOptionPane.showInputDialog(anyString())).thenReturn("./resources/presentations/demo.xml");

            ActionListener actionListener = this.openMenuItem.getActionListeners()[0];

            ActionEvent actionEvent = new ActionEvent(actionListener, ActionEvent.ACTION_PERFORMED, null);
            actionListener.actionPerformed(actionEvent);
        }

        assertEquals("Demo presentation", Presentation.getInstance().getPresentationTitle());
    }

    @Test
    void onClick_LoadValidFile_ShouldLoadFile()
    {
        try (MockedStatic<JOptionPane> mockedJOptionPane = Mockito.mockStatic(JOptionPane.class))
        {
            mockedJOptionPane.when(() -> JOptionPane.showInputDialog(anyString())).thenReturn("./resources/presentations/demo.xml");

            this.openMenuItem.onClick();
        }

        assertEquals("Demo presentation", Presentation.getInstance().getPresentationTitle());
    }

    @Test
    void onClick_LoadInvalidFile_ShouldLoadErrorPage()
    {
        try (MockedStatic<JOptionPane> mockedJOptionPane = Mockito.mockStatic(JOptionPane.class))
        {
            mockedJOptionPane.when(() -> JOptionPane.showInputDialog(anyString())).thenReturn("nonexistent.xml");

            this.openMenuItem.onClick();
        }

        assertEquals("ERROR", Presentation.getInstance().getPresentationTitle());
    }

    @Test
    void onClick_LoadNullFile_ShouldLoadNothing()
    {
        try (MockedStatic<JOptionPane> mockedJOptionPane = Mockito.mockStatic(JOptionPane.class))
        {
            mockedJOptionPane.when(() -> JOptionPane.showInputDialog(anyString())).thenReturn(null);

            this.openMenuItem.onClick();
        }

        assertEquals("Demo presentation", Presentation.getInstance().getPresentationTitle());
    }

    @Test
    void OpenMenuItem_MenuLabel_ShouldBeOPEN()
    {
        assertEquals(MenuLabel.OPEN, this.openMenuItem.getMenuLabel());
    }
}