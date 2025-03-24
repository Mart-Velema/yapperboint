package com.nhlstenden.accessor;

import com.nhlstenden.presentation.Presentation;
import com.nhlstenden.presentation.Slide;
import com.nhlstenden.presentation.item.SlideImageItem;
import com.nhlstenden.presentation.item.SlideItem;
import com.nhlstenden.presentation.item.SlideTextItem;
import com.nhlstenden.style.StyleBuilder;
import com.nhlstenden.style.StyleDirector;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XMLAccessor implements Accessor
{
    private XMLEventReader eventReader;


    // XML tag names
    private static final String PRESENTATION = "presentation";
    private static final String VERSION = "version";
    private static final String PRESENTATION_TITLE = "presentationTitle";
    private static final String SLIDE = "slide";
    private static final String TITLE = "title";
    private static final String TEXT_ITEM = "textItem";
    private static final String IMAGE_ITEM = "imageItem";

    // QNames to get Attributes
    private static final QName STYLE = new QName("style");
    private static final QName FONT = new QName("font");
    private static final QName COLOR = new QName("color");
    private static final QName SIZE = new QName("size");
    private static final QName INDENT = new QName("indent");
    private static final QName IMAGE_X = new QName("x");
    private static final QName IMAGE_Y = new QName("y");

    @Override
    public void loadFile(String fileName)
    {
        try (InputStream inputStream = new FileInputStream(fileName))
        {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            eventReader = factory.createXMLEventReader(inputStream);

            Presentation presentation = Presentation.getInstance();
            presentation.getSlides().clear();

            while (eventReader.hasNext())
            {
                XMLEvent event = eventReader.nextEvent();
                if (!event.isStartElement())
                {
                    continue;
                }
                StartElement startElement = event.asStartElement();


                switch (startElement.getName().getLocalPart())
                {
                    case VERSION:
                        event = eventReader.nextEvent();
                        presentation.setVersion(event.asCharacters().getData());
                        break;
                    case PRESENTATION_TITLE:
                        event = eventReader.nextEvent();
                        presentation.setPresentationTitle(event.asCharacters().getData());
                        break;
                    case SLIDE:
                        presentation.addSlide(new Slide());
                        break;
                    case TITLE:
                        event = eventReader.nextEvent();
                        presentation.getSlides().getLast().setTitle(event.asCharacters().getData());
                        break;
                    case TEXT_ITEM:
                        presentation.getSlides().getLast().addItem(handleTextItem(startElement));
                        break;
                    case IMAGE_ITEM:
                        presentation.getSlides().getLast().addItem(handleImageItem(startElement));
                        break;
                }
            }
        } catch (Exception e)
        {
            // TODO: Print to screen. After cooking RenderFacade
            e.printStackTrace();
        }
    }

    private String getValueFromAttribute(Attribute attribute)
    {
        return (attribute != null) ? attribute.getValue() : null;
    }

    private SlideItem handleTextItem(StartElement startElement) throws XMLStreamException, IOException, FontFormatException
    {
        Attribute styleType = startElement.getAttributeByName(STYLE);

        Attribute font = startElement.getAttributeByName(FONT);
        Attribute color = startElement.getAttributeByName(COLOR);
        Attribute size = startElement.getAttributeByName(SIZE);
        Attribute indent = startElement.getAttributeByName(INDENT);

        String text = "";
        StyleDirector styleDirector = new StyleDirector();
        StyleBuilder styleBuilder = new StyleBuilder();

        try
        {
            styleBuilder = switch (Integer.parseInt(this.getValueFromAttribute(styleType)))
            {
                case 1 -> styleDirector.makeHeading1(styleBuilder);
                case 2 -> styleDirector.makeHeading2(styleBuilder);
                case 4 -> styleDirector.makeHeading4(styleBuilder);
                case 5 -> styleDirector.makeHeading5(styleBuilder);
                default -> styleDirector.makeHeading3(styleBuilder);
            };
        } catch (NumberFormatException e)
        {
            styleDirector.makeHeading3(styleBuilder);
        }

        if (font != null)
        {
            styleBuilder.font(this.getValueFromAttribute(font));
        }
        if (color != null)
        {
            styleBuilder.color(Color.getColor(this.getValueFromAttribute(color)));
        }
        if (size != null)
        {
            styleBuilder.fontSize(Integer.parseInt(this.getValueFromAttribute(size)));
        }
        if (indent != null)
        {
            styleBuilder.indent(Integer.parseInt(this.getValueFromAttribute(indent)));
        }

        XMLEvent event = eventReader.nextEvent();
        if (event.isCharacters())
        {
            text = event.asCharacters().getData();
        }

        return new SlideTextItem(text, styleBuilder.build());
    }

    private SlideItem handleImageItem(StartElement startElement) throws XMLStreamException
    {
        Attribute xPos = startElement.getAttributeByName(IMAGE_X);
        Attribute yPos = startElement.getAttributeByName(IMAGE_Y);

        String filepath = "";

        XMLEvent event = eventReader.nextEvent();
        if (event.isCharacters())
        {
            filepath = event.asCharacters().getData();
        }

        return new SlideImageItem(filepath, Integer.parseInt(xPos.getValue()), Integer.parseInt(yPos.getValue()));
    }
}