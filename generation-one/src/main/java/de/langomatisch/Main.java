package de.langomatisch;

import de.langomatisch.reader.Gen1SaveFileReader;
import de.langomatisch.save.Gen1SaveFile;
import lombok.SneakyThrows;

import java.io.*;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        new Main();
    }

    @SneakyThrows
    Main() throws FileNotFoundException {
        File file = new File("saves/gen1/third_save.sav");

        Gen1SaveFile gen1SaveFile = new Gen1SaveFileReader(file).parse();
        System.out.println(gen1SaveFile.toString());
    }

}