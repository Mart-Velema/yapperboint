package com.nhlstenden.presentation;

import com.nhlstenden.facade.RenderFacade;
import java.util.ArrayList;
import java.util.List;

public class Presentation
{
    private String version;
    private String presentationTitle;
    private int currentSlideNumber;
    private List<Slide> slides;
    private static final Presentation INSTANCE = new Presentation();

    private Presentation()
    {
        this.version = "0.0.1";
        this.presentationTitle = "YabberBoint";
        this.currentSlideNumber = 0;
        this.slides = new ArrayList<>();
    }

    public static Presentation getInstance()
    {
        return INSTANCE;
    }

    public String getVersion()
    {
        return this.version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getPresentationTitle()
    {
        return this.presentationTitle;
    }

    public void setPresentationTitle(String presentationTitle)
    {
        this.presentationTitle = presentationTitle;
    }

    public int getCurrentSlideNumber()
    {
        return this.currentSlideNumber;
    }

    public void setCurrentSlideNumber(int currentSlideNumber)
    {
        if (!this.slides.isEmpty())
        {
            this.currentSlideNumber = Math.clamp(currentSlideNumber, 0, this.slides.size() - 1);
        }
        else
        {
            this.currentSlideNumber = 0;
        }
    }

    public List<Slide> getSlides()
    {
        return this.slides;
    }

    public void setSlides(List<Slide> slides)
    {
        this.slides = slides;
        this.setCurrentSlideNumber(0);
    }

    public void addSlide(Slide slide)
    {
        if (slide == null)
        {
            return;
        }

        this.slides.add(slide);
    }

    public void goToSlide(int index)
    {
        this.setCurrentSlideNumber(index);

        RenderFacade.getInstance().renderSlide(this.getCurrentSlide());
    }

    public void nextSlide()
    {
        this.goToSlide(++this.currentSlideNumber);
    }

    public void previousSlide()
    {
        this.goToSlide(--this.currentSlideNumber);
    }

    public Slide getCurrentSlide()
    {
        if (this.slides.isEmpty())
        {
            return new Slide();
        }

        return this.slides.get(currentSlideNumber);
    }
}
