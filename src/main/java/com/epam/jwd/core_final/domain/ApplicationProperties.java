package com.epam.jwd.core_final.domain;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class should be IMMUTABLE!
 * <p>
 * Expected fields:
 * <p>
 * inputRootDir {@link String} - base dir for all input files
 * outputRootDir {@link String} - base dir for all output files
 * crewFileName {@link String}
 * missionsFileName {@link String}
 * spaceshipsFileName {@link String}
 * <p>
 * fileRefreshRate {@link Integer}
 * dateTimeFormat {@link String} - date/time format for {@link java.time.format.DateTimeFormatter} pattern
 */
public class ApplicationProperties {

    private final String inputRootDir = "input";
    private final String outputRootDir = "output";
    private final String crewFileName = "crew";
    private final String missionsFileName = "missions";
    private final String spaceshipsFileName = "spaceships";
    private final String planetsFileName = "spacemap";
    private final Integer fileRefreshRate = 60;
    private final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //todo
}
