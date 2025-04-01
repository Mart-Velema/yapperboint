package com.nhlstenden.presentation;

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
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getPresentationTitle()
    {
        return presentationTitle;
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
        this.currentSlideNumber = currentSlideNumber;
    }

    public List<Slide> getSlides()
    {
        return slides;
    }

    public void setSlides(List<Slide> slides)
    {
        this.slides = slides;
    }

    public void addSlide(Slide slide)
    {
        this.slides.add(slide);
    }

    public Slide goToSlide(int index)
    {
        this.setCurrentSlideNumber(index);

        return this.slides.get(currentSlideNumber);
    }

    public Slide nextSlide()
    {
        return this.goToSlide(this.currentSlideNumber++);
    }

    public Slide previousSlide()
    {
        return this.goToSlide(this.currentSlideNumber--);
    }

    public Slide getCurrentSlide()
    {
        return this.slides.get(currentSlideNumber);
    }
}
