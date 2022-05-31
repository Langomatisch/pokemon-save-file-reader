package de.langomatisch.reader;

import de.langomatisch.save.Gen1Pokemon;
import de.langomatisch.save.Gen1SaveFile;
import de.langomatisch.text.Gen1Text;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gen1SaveFileReader {

    private final byte[] data;

    public Gen1SaveFileReader(File file) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        data = reader.readAllBytes();
    }

    public Gen1SaveFile parse() {
        Gen1SaveFile saveFile = new Gen1SaveFile();
        String name = readString(Gen1DataPoint.PLAYER_NAME_START);
        saveFile.setName(name);
        String rivalName = readString(Gen1DataPoint.RIVAL_NAME_START);
        saveFile.setRivalName(rivalName);
        int pokedex = data[Gen1DataPoint.POKEDEX_OWNED];
        saveFile.setPokedexOwned(pokedex);
        readParty();
        return saveFile;
    }

    private List<Gen1Pokemon> readParty() {
        byte partyStart = (byte) Gen1DataPoint.PARTY_START;
        byte count = data[partyStart];
        System.out.println("count: " + count);
        byte[] species = new byte[count];
        byte current = partyStart;
        for (byte i = 0; i < count; i++) {
            species[i] = data[current];
            current += 0x01;
        }
        System.out.println("start species");
        for (byte b : species) {
            System.out.println(b);
        }
        return new ArrayList<>();
    }

    private String readString(int starting) {
        int i = starting;
        List<Byte> stringData = new ArrayList<>();
        while (data[i] != Gen1DataPoint.STRING_TERMINATION) {
            byte newChar = data[i++];
            stringData.add(newChar);
        }
        return Gen1Text.translateText(stringData.toArray(new Byte[0]));
    }

    private int readInt(int starting) {
        return data[starting];
    }
}
