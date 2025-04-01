package com.nhlstenden.facade;

import com.nhlstenden.presentation.Presentation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter
{
    public KeyController()
    {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                Presentation.getInstance().nextSlide();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                Presentation.getInstance().previousSlide();
                break;
            case 'q':
            case 'Q':
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
