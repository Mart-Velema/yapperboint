package com.nhlstenden.presentation.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static org.junit.jupiter.api.Assertions.*;

class SlideImageItemTest
{
    SlideImageItem slideImageItem;
    @BeforeEach
    void setUp()
    {
        slideImageItem = new SlideImageItem("/test", 1, 1);
    }


    @Test
    void getJLabel_correctFields_correctJLabel()
    {
        slideImageItem.setImagePath("fedora-extra-small.png");
        JLabel jLabel = slideImageItem.getJLabel();

        JLabel expected = new JLabel(new ImageIcon("./resources/images/fedora-extra-small.png"));
        expected.setLocation(1, 1);
        expected.setBounds(expected.getX(), expected.getY(), expected.getPreferredSize().width, jLabel.getPreferredSize().height);

        assertEquals(expected.getX(), jLabel.getX());
        assertEquals(expected.getY(), jLabel.getY());
        assertEquals(expected.getBounds(), jLabel.getBounds());
        assertEquals(expected.getIcon().toString(), jLabel.getIcon().toString());
    }

    @Test
    void getJLabel_otherCorrectFields_correctJLabel()
    {
        slideImageItem.setImagePath("test.png");
        slideImageItem.setPositionX(200);
        slideImageItem.setPositionY(200);
        JLabel jLabel = slideImageItem.getJLabel();

        JLabel expected = new JLabel(new ImageIcon("./resources/images/test.png"));
        expected.setLocation(200, 200);
        expected.setBounds(expected.getX(), expected.getY(), expected.getPreferredSize().width, jLabel.getPreferredSize().height);

        assertEquals(expected.getX(), jLabel.getX());
        assertEquals(expected.getY(), jLabel.getY());
        assertEquals(expected.getBounds(), jLabel.getBounds());
        assertEquals(expected.getIcon().toString(), jLabel.getIcon().toString());
    }
}