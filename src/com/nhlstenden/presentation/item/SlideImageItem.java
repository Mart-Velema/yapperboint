package com.nhlstenden.presentation.item;

import javax.swing.*;

public class SlideImageItem implements SlideItem
{
    private String imagePath;
    private int positionX;
    private int positionY;

    public SlideImageItem(String imagePath, int positionX, int positionY)
    {
        this.imagePath = imagePath;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public int getPositionX()
    {
        return positionX;
    }

    public void setPositionX(int positionX)
    {
        this.positionX = positionX;
    }

    public int getPositionY()
    {
        return positionY;
    }

    public void setPositionY(int positionY)
    {
        this.positionY = positionY;
    }

    @Override
    public JLabel getJLabel()
    {
        JLabel jLabel = new JLabel(new ImageIcon(this.imagePath));
        jLabel.setLocation(this.positionX, this.positionY);
        jLabel.setBounds(jLabel.getX(), jLabel.getY(), jLabel.getPreferredSize().width, jLabel.getPreferredSize().height);

        return jLabel;
    }
}