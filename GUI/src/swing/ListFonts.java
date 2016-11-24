package swing;

import java.awt.*;

public class ListFonts
{
   public static void main(String[] args)
   {
      String[] fontNames = GraphicsEnvironment
         .getLocalGraphicsEnvironment()
         .getAvailableFontFamilyNames();
      for (String fontName : fontNames)
         System.out.println(fontName);
      Font font =new Font("nguyen Van Binh",Font.BOLD,30);
      System.out.println(font);
   }
}


