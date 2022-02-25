import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void subtraction() {
        assertEquals(10, 20-10);
    }

    @Test
    public void testGetLinks1() throws IOException {
        String fileContents = Files.readString(Path.of("test3.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertTrue("ArrayList should contain no elements", testOutput.isEmpty());
    }

    @Test
    public void testGetLinks2() throws IOException {
        String fileContents = Files.readString(Path.of("test4.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertEquals("Check first element in array", "math18.com", testOutput.get(0));
        assertEquals("Array should only contain one element", 1, testOutput.size());
    }

    @Test
    public void testLabReportTest1() throws IOException {
        String fileContents = Files.readString(Path.of("lab-report-test-1.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertEquals("Check first element in array", "`google.com", testOutput.get(0));
        assertEquals("Check second element in array", "google.com", testOutput.get(1));
        assertEquals("Check third element in array", "ucsd.edu", testOutput.get(2));
        assertEquals("Array should contain three elements", 3, testOutput.size());
    }

    @Test
    public void testLabReportTest2() throws IOException {
        String fileContents = Files.readString(Path.of("lab-report-test-2.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertEquals("Check first element in array", "a.com", testOutput.get(0));
        assertEquals("Check second element in array", "a.com(())", testOutput.get(1));
        assertEquals("Check third element in array", "example.com", testOutput.get(2));
        assertEquals("Array should contain three elements", 3, testOutput.size());
    }

    @Test
    public void testLabReportTest3() throws IOException {
        String fileContents = Files.readString(Path.of("lab-report-test-3.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertEquals("Check first element in array", "https://ucsd-cse15l-w22.github.io/", testOutput.get(0));
        assertEquals("Array should contain one element", 1, testOutput.size());
    }
}



/*import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks1() throws IOException {
        String fileContents = Files.readString(Path.of("/Users/aprilhsu/Documents/GitHub/markdown-parse/test-file.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertEquals("Check first element in ArrayList", "https://something.com", testOutput.get(0));
        assertEquals("Check second element in ArrayList", "some-page.html", testOutput.get(1));
        assertEquals("ArrayList should only contain two elements", 2, testOutput.size());
    }

    @Test
    public void testGetLinks2() throws IOException {
        String fileContents = Files.readString(Path.of("/Users/aprilhsu/Documents/GitHub/markdown-parse/test2.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertEquals("Check first element in ArrayList", "https://so(meth)ing.com", testOutput.get(0));
        assertEquals("ArrayList should only contain one element", 1, testOutput.size());
    }

    @Test
    public void testGetLinks3() throws IOException {
        String fileContents = Files.readString(Path.of("/Users/aprilhsu/Documents/GitHub/markdown-parse/test3.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        assertTrue("ArrayList should contain no elements", testOutput.isEmpty());
    }
}
*/
