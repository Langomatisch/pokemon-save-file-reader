package de.langomatisch.text;

public class Gen1Text {

    public static String translateText(Byte[] input) {
        String text = "";
        for (byte b : input) {
            if (b == 0x50) return text;
            char translatedChar = translateByteToChar(b);
            text += translatedChar;
        }
        return text;
    }

    private static final String TEXT_TABLE_EN =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ():;[]}" +
                    "abcdefghijklmnopqrstuvwxyz" +
                    /* custom chars */
                    "édlstv" +
                    /* junk data */
                    "                " +
                    "                " +
                    "'PM-rm?!.ァゥェ▷▶▼♂" +
                    "$×./,♀0123456789";

    private static char translateByteToChar(byte b) {
        byte offset = (byte) (b - (byte) 0x80);
        return TEXT_TABLE_EN.charAt(offset);
    }
}
