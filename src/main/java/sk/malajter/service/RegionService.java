package sk.malajter.service;

import sk.malajter.world.location.Location;
import sk.malajter.world.region.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionService {

    private final List<Region> regionList;

    public RegionService() {
        this.regionList = createDefaultRegions();

    }

    public List<Region> getRegionList() {
        return regionList;
    }

    private Region getRegionByDifficulty(List <Region> regions, int difficulty) {
        for (Region region : regions) {
            if (region.getDifficulty() == difficulty) {
                return region;
            }
        }
        return null;
    }

    private List<Region> createDefaultRegions() {
        List<Region> regions = new ArrayList<>();

        Region mysticForest = new Region("Mystic Forest", "A mysterious forest filled with magical creatures.", 1);
        mysticForest.getLocations().put(
                1, new Location("Foggy Alley", "A gigantic oak tree glowing with mystical energy.", 1)
        );
        mysticForest.getLocations().put(
                2, new Location("Luminous Mushrooms", "Glowing mushrooms lighting the path to danger.", 2)
        );

        regions.add(mysticForest);

        return regions;
    }
}
