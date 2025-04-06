package com.nhlstenden.facade;

import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class KeyControllerTest
{
    Presentation presentation;
    KeyController keyController;

    @BeforeEach
    void setUp()
    {
        this.keyController = new KeyController();
        this.presentation = Presentation.getInstance();

        Slide slide = new Slide();
        slide.setTitle("Test");

        this.presentation.addSlide(slide);
        this.presentation.addSlide(slide);
        this.presentation.addSlide(slide);
    }

    @Test
    void keyPressed_PageDown_ShouldReturnOne()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, KeyEvent.VK_PAGE_DOWN, KeyEvent.CHAR_UNDEFINED);

        this.presentation.setCurrentSlideNumber(0);

        this.keyController.keyPressed(keyEvent);

        assertEquals(1, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void keyPressed_RightArrow_ShouldReturnOne()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);

        this.presentation.setCurrentSlideNumber(0);

        this.keyController.keyPressed(keyEvent);

        assertEquals(1, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void keyPressed_Enter_ShouldReturnOne()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);

        this.presentation.setCurrentSlideNumber(0);

        this.keyController.keyPressed(keyEvent);

        assertEquals(1, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void keyPressed_Plus_ShouldReturnOne()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, KeyEvent.VK_PLUS, '+');

        this.presentation.setCurrentSlideNumber(0);

        this.keyController.keyPressed(keyEvent);

        assertEquals(1, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void keyPressed_PageUp_ShouldReturnZero()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, KeyEvent.VK_PAGE_UP, KeyEvent.CHAR_UNDEFINED);

        this.presentation.setCurrentSlideNumber(1);

        this.keyController.keyPressed(keyEvent);

        assertEquals(0, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void keyPressed_LeftArrow_ShouldReturnZero()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);

        this.presentation.setCurrentSlideNumber(1);

        this.keyController.keyPressed(keyEvent);

        assertEquals(0, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void keyPressed_Minus_ShouldReturnZero()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, KeyEvent.VK_MINUS, '-');

        this.presentation.setCurrentSlideNumber(1);

        this.keyController.keyPressed(keyEvent);

        assertEquals(0, this.presentation.getCurrentSlideNumber());
    }

    @Test
    @Disabled
    void keyPressed_Q_ShouldExit()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, 'Q', KeyEvent.CHAR_UNDEFINED);

        this.keyController.keyPressed(keyEvent);
    }

    @Test
    @Disabled
    void keyPressed_q_ShouldExit()
    {
        KeyEvent keyEvent = new KeyEvent(RenderFacade.getInstance().getjFrame().getContentPane(), KeyEvent.KEY_PRESSED, 1, 0, 'q', KeyEvent.CHAR_UNDEFINED);

        this.keyController.keyPressed(keyEvent);
    }
}