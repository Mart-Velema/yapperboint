package com.nhlstenden.facade;

import com.nhlstenden.menubar.JabberMenuBar;
import com.nhlstenden.presentation.Slide;
import com.nhlstenden.presentation.item.SlideTextItem;
import com.nhlstenden.style.Style;
import com.nhlstenden.style.StyleBuilder;
import com.nhlstenden.style.StyleDirector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RenderFacadeTest
{
    RenderFacade renderFacade;
    JFrame jFrame;

    @BeforeEach
    void setUp()
    {
        this.renderFacade = RenderFacade.getInstance();
        this.jFrame = renderFacade.getjFrame();
    }

    JPanel[] getTextAndImagePanels()
    {
//        First item is a Layered pane
        JRootPane rootPane = (JRootPane) this.jFrame.getComponent(0);

//        First is menubar, second is JPanel
        JLayeredPane layeredRootPane = (JLayeredPane) rootPane.getComponent(1);
        JPanel jPanel = (JPanel) layeredRootPane.getComponent(0);

//        JPanel has renderSlide()'s LayeredPanel
        JLayeredPane layeredPane = (JLayeredPane) jPanel.getComponent(0);

//        First should be imagePanel, second textPanel
        JPanel textPanel = (JPanel) layeredPane.getComponent(1);
        JPanel imagePanel = (JPanel) layeredPane.getComponent(0);

        return new JPanel[] {textPanel, imagePanel};
    }

    @Test
    void getInstance_GetFacadeInstance_ShouldBeEqualToRenderFacade()
    {
        assertEquals(this.renderFacade, RenderFacade.getInstance());
    }

    @Test
    void getHeight_GetHeight_ShouldBe800()
    {
        assertEquals(800, RenderFacade.getHeight());
    }

    @Test
    void getWidth_GetWidth_ShouldBe1200()
    {
        assertEquals(1200, RenderFacade.getWidth());
    }

    @Test
    void makeWindow_MenuBar_ShouldHaveJabberMenubar()
    {
        assertInstanceOf(JabberMenuBar.class, this.jFrame.getJMenuBar());
    }

    @Test
    void makeWindow_DefaultCloseOperation_ShouldBeEXIT_ON_CLOSE()
    {
        assertEquals(JFrame.EXIT_ON_CLOSE, this.jFrame.getDefaultCloseOperation());
    }

    @Test
    void makeWindow_WindowSize_ShouldBe1200x800()
    {
        assertEquals(800, this.jFrame.getSize().height);
        assertEquals(1200, this.jFrame.getSize().width);
    }

    @Test
    void makeWindow_Visibility_ShouldBeVisible()
    {
        assertTrue(this.jFrame.isVisible());
    }

    @Test
    void makeWindow_KeyController_ShouldHaveOfKeyController()
    {
        assertInstanceOf(KeyController.class, this.jFrame.getKeyListeners()[0]);
    }

    @Test
    void clear_OneItem_ShouldRemoveAll() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addTextItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(1, this.getTextAndImagePanels()[0].getComponentCount());

        this.renderFacade.clear();

        JRootPane rootPane = (JRootPane) this.jFrame.getComponent(0);

        JLayeredPane layeredRootPane = (JLayeredPane) rootPane.getComponent(1);
        JPanel jPanel = (JPanel) layeredRootPane.getComponent(0);

        assertEquals(0, jPanel.getComponentCount());
    }

    @Test
    void clear_TwoItems_ShouldRemoveAll() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addTextItem(new SlideTextItem("Test", style));
        slide.addTextItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(2, this.getTextAndImagePanels()[0].getComponentCount());

        this.renderFacade.clear();

        JRootPane rootPane = (JRootPane) this.jFrame.getComponent(0);

        JLayeredPane layeredRootPane = (JLayeredPane) rootPane.getComponent(1);
        JPanel jPanel = (JPanel) layeredRootPane.getComponent(0);

        assertEquals(0, jPanel.getComponentCount());
    }

    @Test
    void renderSlide_EmptySlide_ShouldHaveTwoComponents()
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        this.renderFacade.renderSlide(slide);

        assertEquals(2, this.getTextAndImagePanels().length);
    }

    @Test
    void renderSlide_JFrameTitle_ShouldBeTest()
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        this.renderFacade.renderSlide(slide);

        assertEquals("YabberBoint: test", this.jFrame.getTitle());
    }

    @Test
    void renderSlide_JFrameTitle_ShouldBeTestTwo()
    {
        Slide slide = new Slide();
        slide.setTitle("test two");

        this.renderFacade.renderSlide(slide);

        assertEquals("YabberBoint: test two", this.jFrame.getTitle());
    }

    @Test
    void renderSlide_OneTextItem_ShouldHaveOneTextItem() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addTextItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(1, this.getTextAndImagePanels()[0].getComponentCount());
        assertEquals(0, this.getTextAndImagePanels()[1].getComponentCount());
    }

    @Test
    void renderSlide_TwoTextItem_ShouldHaveTwoTextItem() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addTextItem(new SlideTextItem("Test", style));
        slide.addTextItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(2, this.getTextAndImagePanels()[0].getComponentCount());
        assertEquals(0, this.getTextAndImagePanels()[1].getComponentCount());
    }

    @Test
    void renderSlide_OneImageItem_ShouldHaveOneImageItem() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addImageItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(0, this.getTextAndImagePanels()[0].getComponentCount());
        assertEquals(1, this.getTextAndImagePanels()[1].getComponentCount());
    }

    @Test
    void renderSlide_TwoImageItem_ShouldHaveTwoImageItem() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addImageItem(new SlideTextItem("Test", style));
        slide.addImageItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(0, this.getTextAndImagePanels()[0].getComponentCount());
        assertEquals(2, this.getTextAndImagePanels()[1].getComponentCount());
    }

    @Test
    void renderSlide_OneImageOneTextItem_ShouldHaveOneImageOneTextItem() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addImageItem(new SlideTextItem("Test", style));
        slide.addTextItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(1, this.getTextAndImagePanels()[0].getComponentCount());
        assertEquals(1, this.getTextAndImagePanels()[1].getComponentCount());
    }

    @Test
    void renderSlide_TwoImageOneTextItem_ShouldHaveTwoImageOneTextItem() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addImageItem(new SlideTextItem("Test", style));
        slide.addImageItem(new SlideTextItem("Test", style));
        slide.addTextItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(1, this.getTextAndImagePanels()[0].getComponentCount());
        assertEquals(2, this.getTextAndImagePanels()[1].getComponentCount());
    }

    @Test
    void renderSlide_OneImageTwoTextItem_ShouldHaveOneImageTwoTextItem() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("test");

        Style style = new StyleDirector().makeHeading3(new StyleBuilder()).build();
        slide.addImageItem(new SlideTextItem("Test", style));
        slide.addTextItem(new SlideTextItem("Test", style));
        slide.addTextItem(new SlideTextItem("Test", style));

        this.renderFacade.renderSlide(slide);

        assertEquals(2, this.getTextAndImagePanels()[0].getComponentCount());
        assertEquals(1, this.getTextAndImagePanels()[1].getComponentCount());
    }
}