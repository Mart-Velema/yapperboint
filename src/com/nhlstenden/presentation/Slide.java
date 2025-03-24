package com.nhlstenden.presentation;

import com.nhlstenden.presentation.item.SlideItem;

import java.util.ArrayList;
import java.util.List;

public class Slide
{
    private String title;
    private List<SlideItem> items;

    public Slide()
    {
        this.items = new ArrayList<>();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<SlideItem> getItems()
    {
        return items;
    }

    public void setItems(List<SlideItem> items)
    {
        this.items = items;
    }

    public void addItem(SlideItem item)
    {
        this.items.add(item);
    }
}