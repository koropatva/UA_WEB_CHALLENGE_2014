package com.uawebchallenge.balancer.models;



public class CommingData {

    static final String MAP_NAME = "-m";
    static final String TOP_CLAN_COUNT = "-tcc";
    static final String TANK_LEVELS = "-tl";

    public CommingData(String[] args, String mapName, Integer topClanCount, Integer[] tankLevels) {
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (MAP_NAME.equals(args[i]) && args[i + 1] != null) {
                    mapName = args[i + 1];
                } else if (TOP_CLAN_COUNT.equals(args[i]) && args[i + 1] != null) {
                    topClanCount = Integer.parseInt(args[i + 1].trim());
                } else if (TANK_LEVELS.equals(args[i]) && args[i + 1] != null) {
                    String[] listLevels = args[i + 1].split(",");
                    tankLevels = new Integer[listLevels.length];
                    for (int j = 0; j < listLevels.length; j++) {
                        tankLevels[j] = Integer.parseInt(listLevels[j].trim());
                    }
                }
            }
        }
        this.mapName = mapName;
        this.topClanCount = topClanCount;
        this.tankLevels = tankLevels;
    }

    private String mapName;

    private Integer topClanCount;

    private Integer[] tankLevels;

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public Integer getTopClanCount() {
        return topClanCount;
    }

    public void setTopClanCount(Integer topClanCount) {
        this.topClanCount = topClanCount;
    }

    public Integer[] getTankLevels() {
        return tankLevels;
    }

    public void setTankLevels(Integer[] tankLevels) {
        this.tankLevels = tankLevels;
    }

}
