package com.tru.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by yassnet on 4/13/17.
 */

public class PositionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidLatitude() {

        new Position(-1234132491, 0);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(startsWith("Latitude"));
        expectedException.expectMessage(endsWith("is invalid. Must be between -90.0 and 90.0 inclusive."));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_invalidLongitude() {

        new Position(0, 18100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_invalidLatitudeAndLongitude() {

        new Position(-91, 18100);
    }

    @Test
    public void testConstructor_validLatitudeAndLongitude() {

        Position position = new Position(-90, 180);
        Assert.assertNotNull(position.getX());
        Assert.assertNotNull(position.getY());
    }
}