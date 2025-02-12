import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextItemTest
{

    @Test
    void testToString()
    {
        TextItem textItem = new TextItem(1,"test");

        assertEquals("TextItem[1,test]", textItem.toString());
    }

}