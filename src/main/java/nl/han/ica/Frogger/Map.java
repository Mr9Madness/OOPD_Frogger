package nl.han.ica.Frogger;

import nl.han.ica.Frogger.Sections.BallSection;
import nl.han.ica.Frogger.Sections.RiverSection;
import nl.han.ica.Frogger.Sections.RoadSection;
import nl.han.ica.Frogger.Sections.Section;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;

import java.util.ArrayList;

public class Map {
    public ArrayList<Section> SectionList;

    public Map(GameEngine engine)
    {
        SectionList = new ArrayList<>();
        SectionList.add(new RoadSection(engine));
        SectionList.add(new RiverSection(engine));
        SectionList.add(new BallSection(engine));

        // TODO Move tilemap creation to this file
        // InitTileMap();
    }
}
