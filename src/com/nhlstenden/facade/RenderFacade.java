package com.nhlstenden.facade;

import com.nhlstenden.menubar.JabberMenuBar;
import com.nhlstenden.menubar.Language;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.Translation;
import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.Slide;
import com.nhlstenden.presentation.item.SlideItem;

import javax.swing.*;
import java.awt.*;

public class RenderFacade
{
    private static final RenderFacade INSTANCE = new RenderFacade();
    private JFrame jFrame;
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;

    private RenderFacade()
    {
        this.jFrame = new JFrame(Translation.getInstance().getLanguage(Language.EN, MenuLabel.YABBER_BOINT_TITLE));

        this.makeWindow();
    }

    public static RenderFacade getInstance()
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

    public static int getWidth()
    {
        return WIDTH;
    }

    public static int getHeight()
    {
        return HEIGHT;
    }

    public void makeWindow()
    {
        this.jFrame.setJMenuBar(new JabberMenuBar());
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setSize(WIDTH, HEIGHT);
        this.jFrame.setVisible(true);
    }

    public void clear()
    {
        this.jFrame.getContentPane().removeAll();
        this.jFrame.repaint();
    }

    public void renderSlide(Slide slide)
    {
        this.clear();

        String presentationTitle = Presentation.getInstance().getPresentationTitle();
        this.jFrame.setTitle(presentationTitle + ": " + slide.getTitle());

        JLayeredPane layeredPane = new JLayeredPane();

        JPanel textJPanel = new JPanel();
        textJPanel.setBounds(0, 0, WIDTH, HEIGHT);
        textJPanel.setLayout(new BoxLayout(textJPanel, BoxLayout.Y_AXIS));
        textJPanel.setOpaque(false);

        for (SlideItem currentSlideItem : slide.getTextItems())
        {
            textJPanel.add(currentSlideItem.getJLabel());
        }

        layeredPane.add(textJPanel, 1);

        JPanel imageJPanel = new JPanel();
        imageJPanel.setBounds(0, 0, WIDTH, HEIGHT);
        imageJPanel.setLayout(null);
        imageJPanel.setOpaque(false);

        for (SlideItem currentSlideItem : slide.getImageItems())
        {
            imageJPanel.add(currentSlideItem.getJLabel());
        }

        layeredPane.add(imageJPanel, 0);
        layeredPane.setOpaque(false);

        this.jFrame.add(layeredPane);
        this.jFrame.setVisible(true);
        this.jFrame.repaint();
    }
}
