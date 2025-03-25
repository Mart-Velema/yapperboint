package com.nhlstenden.presentation;

import com.nhlstenden.presentation.item.SlideItem;

import java.util.ArrayList;
import java.util.List;

public class Slide
{
    private String title;
    private List<SlideItem> textItems;
    private List<SlideItem> imageItems;

    public Slide()
    {
        this.textItems = new ArrayList<>();
        this.imageItems = new ArrayList<>();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<SlideItem> getTextItems()
    {
        return textItems;
    }

    public void setTextItems(List<SlideItem> textItems)
    {
        this.textItems = textItems;
    }

    public void addTextItem(SlideItem slideItem)
    {
        this.textItems.add(slideItem);
    }

    public List<SlideItem> getImageItems()
    {
        return imageItems;
    }

    public void setImageItems(List<SlideItem> imageItems)
    {
        this.imageItems = imageItems;
    }

    public void addImageItem(SlideItem slideItem)
    {
        this.imageItems.add(slideItem);
    }
}