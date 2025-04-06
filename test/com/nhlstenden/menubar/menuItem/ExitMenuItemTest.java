package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.MenuLabel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitMenuItemTest
{
    ExitMenuItem exitMenuItem;

    @BeforeEach
    void setUp()
    {
        this.exitMenuItem = new ExitMenuItem();
    }

    @Test
    void ExitMenuItem_MenuLabel_ShouldBeEXIT()
    {
        assertEquals(MenuLabel.EXIT, this.exitMenuItem.getMenuLabel());
    }

    @Test
    void ExitMenuItem_HasActionListeners_ShouldHaveOne()
    {
//        System.exit() cannot be tested, so test if it has an ActionListener
        assertEquals(1, this.exitMenuItem.getActionListeners().length);
    }

    @Test
    @Disabled("Running onClick halts all tests due to System.exit(0)")
    void ExitMenuItem_ExitOnClick_ShouldExitProgram()
    {
        this.exitMenuItem.onClick();
    }
}