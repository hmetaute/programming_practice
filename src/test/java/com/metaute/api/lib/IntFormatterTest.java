package com.metaute.api.lib;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class IntFormatterTest {

    /**
     * Handles the duplication of creating a formatter, transforming and asserting the number
     * it also provides an additional error message detailing the fail
     * @param toTransform
     * @param expectedWhenFormatted
     */
    private void testNumber(int toTransform, String expectedWhenFormatted) {
        IntFormatter converter = new IntFormatter();
        String transformed = converter.format(toTransform);
        assertEquals(String.format("Error formatting %d. Expected: \"%s\" Got: \"%s\"",
                toTransform, expectedWhenFormatted, transformed), expectedWhenFormatted, transformed);
    }

    /**
     * Runs test cases from the files names passed in
     * @param resourceFileLocation
     */
    private void testCasesFromResourceFile(String resourceFileLocation) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(resourceFileLocation);
        try (Stream<String> stream = Files.lines(Paths.get(resource.toURI()))) {
            stream.forEach(line -> {
                String[] split = line.split(",");
                Integer testNumber = Integer.parseInt(split[0]);
                String expectedRepresentation = split[1];
                testNumber(testNumber, expectedRepresentation);
            });
        } catch (Exception e) {
            Assert.fail("Could not open and process test data for file" + resourceFileLocation);
        }
    }

    private void testResourceFileLoads(String resourceFileLocation) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resourceLocation = classLoader.getResource(resourceFileLocation);
        assertNotNull("Didn't find resource file", resourceLocation);
        File file = new File(resourceLocation.getFile());
        assertTrue("Couldn't load resource file", file.exists());
    }

    @Test
    public void testSignedTens() {
        String resourceFileLocation = "test-data/signedTens.csv";
        testResourceFileLoads(resourceFileLocation);
        testCasesFromResourceFile(resourceFileLocation);
    }

    @Test
    public void testSignedDecimals() {
        String resourceFileLocation = "test-data/signedDecimals.csv";
        testResourceFileLoads(resourceFileLocation);
        testCasesFromResourceFile(resourceFileLocation);
    }

}
