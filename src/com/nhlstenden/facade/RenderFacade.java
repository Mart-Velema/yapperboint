package com.nhlstenden.facade;

import com.nhlstenden.presentation.Slide;

import javax.swing.*;

public class RenderFacade
{
    private static final RenderFacade INSTANCE = new RenderFacade();
    private JFrame jFrame;
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;

    private RenderFacade()
    {
        this.jFrame = new JFrame();
    }

    public RenderFacade getInstance()
    {
        return RenderFacade.INSTANCE;
    }

    public JFrame getjFrame()
    {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame)
    {
        this.jFrame = jFrame;
    }

    public int getWIDTH()
    {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH)
    {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT()
    {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT)
    {
        this.HEIGHT = HEIGHT;
    }

    public void makeWindow()
    {

    }

    public void renderSlide(Slide slide)
    {

    }

    public void clear()
    {

    }
}
