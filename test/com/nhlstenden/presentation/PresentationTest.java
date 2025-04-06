package com.nhlstenden.presentation;

import com.nhlstenden.presentation.item.SlideTextItem;
import com.nhlstenden.style.Style;
import com.nhlstenden.style.StyleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PresentationTest
{
    Presentation presentation;
    @BeforeEach
    void setup()
    {
        this.presentation = Presentation.getInstance();
        this.presentation.getSlides().clear();
        this.presentation.setCurrentSlideNumber(0);
    }

    @Test
    void addSlide_addOne_lengthOfOne()
    {
        this.presentation.addSlide(new Slide());
        int size = this.presentation.getSlides().size();

        assertEquals(1, size);
    }

    @Test
    void addSlide_addTwenty_lengthOfTwenty()
    {
        this.addSlides(20);
        int size = this.presentation.getSlides().size();

        assertEquals(20, size);
    }

    @Test
    void addSlide_addNull_empty()
    {
        this.presentation.addSlide(null);

        assertTrue(this.presentation.getSlides().isEmpty());
    }

    @Test
    void goToSlide_negativeSlide_clampToZero()
    {
        this.presentation.goToSlide(-10);

        assertEquals(0, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void goToSlide_higherThanSizeSlide_clampToHighest()
    {
        this.addSlides(20);
        this.presentation.goToSlide(30);

        assertEquals(19, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void goToSlide_inRangeSlide_getSlide()
    {
        this.addSlides(20);
        this.presentation.goToSlide(12);

        assertEquals(12, presentation.getCurrentSlideNumber());
    }

    @Test
    void nextSlide_goToNext_goesToNext()
    {
        this.addSlides(20);
        this.presentation.setCurrentSlideNumber(9);
        this.presentation.nextSlide();

        assertEquals(10, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void nextSlide_goToNextAtMax_staysAtMax()
    {
        this.addSlides(20);
        this.presentation.setCurrentSlideNumber(19);
        this.presentation.nextSlide();

        assertEquals(19, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void previousSlide_goToPrevious_goesToPrevious()
    {
        this.addSlides(20);
        this.presentation.setCurrentSlideNumber(10);
        this.presentation.previousSlide();

        assertEquals(9, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void previousSlide_goToPreviousAtZero_staysOnZero()
    {
        this.addSlides(20);
        this.presentation.previousSlide();

        assertEquals(0, this.presentation.getCurrentSlideNumber());
    }

    @Test
    void getCurrentSlide_noSlides_getEmptySlide()
    {
        Slide slide = this.presentation.getCurrentSlide();

        assertTrue(slide.getTextItems().isEmpty() && slide.getImageItems().isEmpty());
    }

    @Test
    void getCurrentSlide_withSlide_getCorrectSlide() throws IOException, FontFormatException
    {
        Slide slide = new Slide();
        slide.setTitle("Test slide");
        slide.addTextItem(new SlideTextItem("test", new StyleBuilder().build()));

        this.presentation.addSlide(slide);

        assertEquals(slide, this.presentation.getCurrentSlide());
    }

    void addSlides(int count)
    {
        for (int i = 0; i < count; i++)
        {
            this.presentation.addSlide(new Slide());
        }
    }
}