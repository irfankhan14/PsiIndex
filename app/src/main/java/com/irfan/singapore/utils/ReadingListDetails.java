package com.irfan.singapore.utils;

import com.irfan.singapore.model.ReadingDetailsPair;
import com.irfan.singapore.model.Readings;

import java.util.ArrayList;

/**
 * Created by ikhans
 */
public class ReadingListDetails {

    public static String getRegionTitle(String value) {
        String[] arrValue = value.split(": ");
        String title = arrValue[1];
        return title;
    }

    public static ArrayList getReadingDetails(Readings readings, String identifier) {
        ArrayList readingDetailsPair = new ArrayList();
        readingDetailsPair.clear();
        if (identifier != null) {
            if (identifier.equals(PsiAppConstants.NORTH)) {
                readingDetailsPair = getNorthReadings(readings);
            } else if (identifier.equals(PsiAppConstants.SOUTH)) {
                readingDetailsPair = getSouthReadings(readings);
            } else if (identifier.equals(PsiAppConstants.EAST)) {
                readingDetailsPair = getEastReadings(readings);
            } else if (identifier.equals(PsiAppConstants.WEST)) {
                readingDetailsPair = getWestReadings(readings);
            } else if (identifier.equals(PsiAppConstants.CENTRAL)) {
                readingDetailsPair = getCentralReadings(readings);
            }
        }

        return readingDetailsPair;
    }

    public static ArrayList getNorthReadings(Readings readings) {
        ArrayList readingDetailsPair = new ArrayList();
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_eight_hour_max, readings.getCo_eight_hour_max().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_sub_index, readings.getCo_sub_index().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.no2_one_hour_max, readings.getNo2_one_hour_max().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_eight_hour_max, readings.getO3_eight_hour_max().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_sub_index, readings.getO3_sub_index().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_sub_index, readings.getPm10_sub_index().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_twenty_four_hourly, readings.getPm10_twenty_four_hourly().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_sub_index, readings.getPm25_sub_index().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_twenty_four_hourly, readings.getPm25_twenty_four_hourly().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.psi_twenty_four_hourly, readings.getPsi_twenty_four_hourly().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_sub_index, readings.getSo2_sub_index().getNorth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_twenty_four_hourly, readings.getSo2_twenty_four_hourly().getNorth()));
        return readingDetailsPair;
    }

    private static ArrayList getSouthReadings(Readings readings) {
        ArrayList readingDetailsPair = new ArrayList();
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_eight_hour_max, readings.getCo_eight_hour_max().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_sub_index, readings.getCo_sub_index().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.no2_one_hour_max, readings.getNo2_one_hour_max().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_eight_hour_max, readings.getO3_eight_hour_max().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_sub_index, readings.getO3_sub_index().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_sub_index, readings.getPm10_sub_index().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_twenty_four_hourly, readings.getPm10_twenty_four_hourly().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_sub_index, readings.getPm25_sub_index().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_twenty_four_hourly, readings.getPm25_twenty_four_hourly().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.psi_twenty_four_hourly, readings.getPsi_twenty_four_hourly().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_sub_index, readings.getSo2_sub_index().getSouth()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_twenty_four_hourly, readings.getSo2_twenty_four_hourly().getSouth()));
        return readingDetailsPair;
    }

    private static ArrayList getEastReadings(Readings readings) {
        ArrayList readingDetailsPair = new ArrayList();
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_eight_hour_max, readings.getCo_eight_hour_max().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_sub_index, readings.getCo_sub_index().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.no2_one_hour_max, readings.getNo2_one_hour_max().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_eight_hour_max, readings.getO3_eight_hour_max().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_sub_index, readings.getO3_sub_index().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_sub_index, readings.getPm10_sub_index().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_twenty_four_hourly, readings.getPm10_twenty_four_hourly().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_sub_index, readings.getPm25_sub_index().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_twenty_four_hourly, readings.getPm25_twenty_four_hourly().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.psi_twenty_four_hourly, readings.getPsi_twenty_four_hourly().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_sub_index, readings.getSo2_sub_index().getEast()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_twenty_four_hourly, readings.getSo2_twenty_four_hourly().getEast()));
        return readingDetailsPair;
    }

    private static ArrayList getWestReadings(Readings readings) {
        ArrayList readingDetailsPair = new ArrayList();
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_eight_hour_max, readings.getCo_eight_hour_max().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_sub_index, readings.getCo_sub_index().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.no2_one_hour_max, readings.getNo2_one_hour_max().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_eight_hour_max, readings.getO3_eight_hour_max().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_sub_index, readings.getO3_sub_index().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_sub_index, readings.getPm10_sub_index().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_twenty_four_hourly, readings.getPm10_twenty_four_hourly().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_sub_index, readings.getPm25_sub_index().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_twenty_four_hourly, readings.getPm25_twenty_four_hourly().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.psi_twenty_four_hourly, readings.getPsi_twenty_four_hourly().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_sub_index, readings.getSo2_sub_index().getWest()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_twenty_four_hourly, readings.getSo2_twenty_four_hourly().getWest()));
        return readingDetailsPair;
    }

    private static ArrayList<ReadingDetailsPair> getCentralReadings(Readings readings) {
        ArrayList readingDetailsPair = new ArrayList();
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_eight_hour_max, readings.getCo_eight_hour_max().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.co_sub_index, readings.getCo_sub_index().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.no2_one_hour_max, readings.getNo2_one_hour_max().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_eight_hour_max, readings.getO3_eight_hour_max().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.o3_sub_index, readings.getO3_sub_index().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_sub_index, readings.getPm10_sub_index().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm10_twenty_four_hourly, readings.getPm10_twenty_four_hourly().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_sub_index, readings.getPm25_sub_index().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.pm25_twenty_four_hourly, readings.getPm25_twenty_four_hourly().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.psi_twenty_four_hourly, readings.getPsi_twenty_four_hourly().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_sub_index, readings.getSo2_sub_index().getCentral()));
        readingDetailsPair.add(new ReadingDetailsPair(PsiAppConstants.so2_twenty_four_hourly, readings.getSo2_twenty_four_hourly().getCentral()));
        return readingDetailsPair;
    }
}
