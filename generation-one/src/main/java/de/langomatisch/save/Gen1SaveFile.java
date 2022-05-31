package de.langomatisch.save;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Gen1SaveFile {

    private int pokedexOwned;
    private String name;
    private String rivalName;

}
