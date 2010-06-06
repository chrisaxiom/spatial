/*
 * Copyright (c) 2010
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.gis.spatial;

import com.vividsolutions.jts.geom.Envelope;

/**
 * @author Davide Savazzi
 */
public class SpatialIndexPerformanceProxy implements SpatialIndexReader {

    // Constructor

    public SpatialIndexPerformanceProxy(SpatialIndexReader spatialIndex) {
        this.spatialIndex = spatialIndex;
    }

    // Public methods

    public Envelope getLayerBoundingBox() {
        long start = System.currentTimeMillis();
        Envelope result = spatialIndex.getLayerBoundingBox();
        long stop = System.currentTimeMillis();
        System.out.println("# exec time(getLayerBoundingBox): " + (stop - start) + "ms");
        return result;
    }

    public int count() {
        long start = System.currentTimeMillis();
        int count = spatialIndex.count();
        long stop = System.currentTimeMillis();
        System.out.println("# exec time(count): " + (stop - start) + "ms");
        return count;
    }

    public void executeSearch(Search search) {
        long start = System.currentTimeMillis();
        spatialIndex.executeSearch(search);
        long stop = System.currentTimeMillis();
        System.out.println("# exec time(executeSearch("+search+")): " + (stop - start) + "ms");
    }

    // Attributes

    private SpatialIndexReader spatialIndex;

}