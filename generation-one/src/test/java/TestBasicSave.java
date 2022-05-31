import de.langomatisch.reader.Gen1SaveFileReader;
import de.langomatisch.save.Gen1SaveFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestBasicSave {

    @Test
    public void testName() throws IOException {
        Gen1SaveFile saveFile = getSaveFile("saves/gen1/second_save.sav");
        assertEquals("MATTHEW", saveFile.getName());
    }

    @Test
    public void testRivalName() throws IOException {
        Gen1SaveFile saveFile = getSaveFile("saves/gen1/second_save.sav");
        assertEquals("STEVEN", saveFile.getRivalName());
    }

    private Gen1SaveFile getSaveFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) {
            throw new FileNotFoundException("file not found");
        }
        return new Gen1SaveFileReader(file).parse();
    }

}
