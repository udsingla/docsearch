import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical");
    URI rootPath = new URI("http://localhost/");
    assertEquals("There are 837 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/biomed/");
    URI rootPath = new URI("http://localhost/search?q=hello");
    //String expect = "Found 3 paths:\n./written_2/travel_guides/berlitz1/WhatToJapan.txt\n./written_2/travel_guides/berlitz1/WhereToJapan.txt\n./written_2/travel_guides/berlitz2/California-WhereToGo.txt";
    String expect = "Couldn't find query parameter q";
    assertEquals(expect, h.handleRequest(rootPath));
	}
}

