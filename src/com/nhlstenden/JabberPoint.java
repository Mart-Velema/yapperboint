package com.nhlstenden;

import com.nhlstenden.accessor.Accessor;
import com.nhlstenden.accessor.XMLAccessor;

public class JabberPoint
{
    public static void main(String[] argv)
    {
        Accessor accessor = new XMLAccessor();
        if (argv.length == 0)
        {
            accessor.loadFile("./resources/presentations/demo.xml");
        }
        else
        {
            accessor.loadFile(argv[0]);
        }
    }
}
