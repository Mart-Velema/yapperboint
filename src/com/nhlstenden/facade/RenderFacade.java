package com.nhlstenden.facade;

import com.nhlstenden.menubar.JabberMenuBar;
import com.nhlstenden.menubar.Language;
import com.nhlstenden.menubar.MenuLabel;
import com.nhlstenden.menubar.Translation;
import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.Slide;
import com.nhlstenden.presentation.item.SlideItem;

import javax.swing.*;

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
        this.jFrame.setTitle(presentationTitle + ": " +  slide.getTitle());

        JLayeredPane layeredPane = new JLayeredPane();

        JPanel textJPanel = new JPanel();
        textJPanel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        textJPanel.setLayout(new BoxLayout(textJPanel, BoxLayout.Y_AXIS));

        for (SlideItem currentSlideItem : slide.getTextItems())
        {
            textJPanel.add(currentSlideItem.getJLabel());
        }

        layeredPane.add(textJPanel, 0);

        JPanel imageJPanel = new JPanel();

        for (SlideItem currentSlideItem : slide.getImageItems())
        {
            imageJPanel.add(currentSlideItem.getJLabel());
        }

        layeredPane.add(textJPanel, 1);

        this.jFrame.repaint();
    }
}
