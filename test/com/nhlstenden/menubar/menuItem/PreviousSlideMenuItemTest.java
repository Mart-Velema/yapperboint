package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;

class PreviousSlideMenuItemTest
{
    PreviousSlideMenuItem previousSlideMenuItem;

    @BeforeEach
    void setUp()
    {
        this.previousSlideMenuItem = new PreviousSlideMenuItem();
        Presentation.getInstance().getSlides().clear();
        Presentation.getInstance().addSlide(new Slide());
        Presentation.getInstance().addSlide(new Slide());
        Presentation.getInstance().addSlide(new Slide());
    }

    @Test
    void PreviousSlideItem_MenuLabel_ShouldBeNEXT_SLIDE()
    {
        assertEquals(MenuLabel.PREVIOUS_SLIDE, this.previousSlideMenuItem.getMenuLabel());
    }

    @Test
    void PreviousSlideItem_FromOneToZeroActionEvent_ShouldReturnZero()
    {
        Presentation.getInstance().setCurrentSlideNumber(1);

        ActionListener actionListener = this.previousSlideMenuItem.getActionListeners()[0];

        ActionEvent actionEvent = new ActionEvent(actionListener, ActionEvent.ACTION_PERFORMED, null);
        actionListener.actionPerformed(actionEvent);

        assertEquals(0, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_FromOneToZero_ShouldReturnZero()
    {
        Presentation.getInstance().setCurrentSlideNumber(1);

        this.previousSlideMenuItem.onClick();

        assertEquals(0, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_FromTwoToOne_ShouldReturnOne()
    {
        Presentation.getInstance().setCurrentSlideNumber(2);

        this.previousSlideMenuItem.onClick();

        assertEquals(1, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_FromZero_ShouldReturnZero()
    {
        Presentation.getInstance().setCurrentSlideNumber(0);

        this.previousSlideMenuItem.onClick();

        assertEquals(0, Presentation.getInstance().getCurrentSlideNumber());
    }
}