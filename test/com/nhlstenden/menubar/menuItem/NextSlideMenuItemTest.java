package com.nhlstenden.menubar.menuItem;

import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;

class NextSlideMenuItemTest
{
    NextSlideMenuItem nextSlideMenuItem;

    @BeforeEach
    void setUp()
    {
        this.nextSlideMenuItem = new NextSlideMenuItem();
        Presentation.getInstance().getSlides().clear();
        Presentation.getInstance().addSlide(new Slide());
        Presentation.getInstance().addSlide(new Slide());
        Presentation.getInstance().addSlide(new Slide());
    }

    @Test
    void NextSlideMenuItem_FromZeroToOneActionEvent_ShouldReturnOne()
    {
        Presentation.getInstance().setCurrentSlideNumber(0);

        ActionListener actionListener = this.nextSlideMenuItem.getActionListeners()[0];

        ActionEvent actionEvent = new ActionEvent(actionListener, ActionEvent.ACTION_PERFORMED, null);
        actionListener.actionPerformed(actionEvent);

        assertEquals(1, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_FromZeroToOne_ShouldReturnOne()
    {
        Presentation.getInstance().setCurrentSlideNumber(0);

        this.nextSlideMenuItem.onClick();

        assertEquals(1, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_FromOneToTwo_ShouldReturnTwo()
    {
        Presentation.getInstance().setCurrentSlideNumber(1);

        this.nextSlideMenuItem.onClick();

        assertEquals(2, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void onClick_FromTwo_ShouldReturnTwo()
    {
        Presentation.getInstance().setCurrentSlideNumber(2);

        this.nextSlideMenuItem.onClick();

        assertEquals(2, Presentation.getInstance().getCurrentSlideNumber());
    }

    @Test
    void NextSlideMenuItem_MenuLabel_ShouldBeNEXT_SLIDE()
    {
        assertEquals(MenuLabel.NEXT_SLIDE, this.nextSlideMenuItem.getMenuLabel());
    }
}