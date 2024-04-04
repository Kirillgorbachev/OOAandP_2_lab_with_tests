import org.example.NumbersReadingStrategy;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumbersReadingStrategyTest {

    @Test
    public void testReadFromFileWithNumbersOnly() throws IOException {
        // Создаем временный файл с числами
        File tempFile = createTempFile("numbers", ".txt", "123\n456\n789");

        // Создаем экземпляр стратегии чтения
        NumbersReadingStrategy strategy = new NumbersReadingStrategy();

        // Вызываем метод чтения из файла
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        strategy.readFromFile(tempFile.getAbsolutePath());

        // Проверяем, что вывод содержит ожидаемые числа
        assertEquals("Result: 123456789", outputStream.toString().trim());
    }

    @Test
    public void testReadFromFileWithMixedContent() throws IOException {
        // Создаем временный файл с комбинацией чисел и других символов
        File tempFile = createTempFile("mixed", ".txt", "123abc456def789");

        // Создаем экземпляр стратегии чтения
        NumbersReadingStrategy strategy = new NumbersReadingStrategy();

        // Вызываем метод чтения из файла
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        strategy.readFromFile(tempFile.getAbsolutePath());

        // Проверяем, что вывод содержит только числа без других символов
        assertEquals("Result: 123456789", outputStream.toString().trim());
    }

    @Test
    public void testPrintName() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method under test
        NumbersReadingStrategy strategy = new NumbersReadingStrategy();
        strategy.printName();

        // Verify the output
        assertEquals("Algorithm: NumbersReadingStrategy", outContent.toString().trim());
    }

    @Test
    public void testPrintDescription() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method under test
        NumbersReadingStrategy strategy = new NumbersReadingStrategy();
        strategy.printDescription();

        // Verify the output
        assertEquals("Description: Reads only numbers from the file.", outContent.toString().trim());
    }

    @Test
    public void testCalculateAndPrintExecutionTime() throws IOException {
        // Prepare a temporary test file with some content
        File tempFile = File.createTempFile("test", ".txt");
        tempFile.deleteOnExit(); // Ensure the file is deleted after test execution
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("abc123def456ghi789jkl");
        }

        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method under test
        NumbersReadingStrategy strategy = new NumbersReadingStrategy();
        strategy.calculateAndPrintExecutionTime();

        // Verify the output
        assertTrue(outContent.toString().contains("Execution Time:"));
    }

    // Вспомогательный метод для создания временного файла с заданным содержимым
    private File createTempFile(String prefix, String suffix, String content) throws IOException {
        File tempFile = File.createTempFile(prefix, suffix);
        tempFile.deleteOnExit(); // Удаляем файл после завершения теста
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println(content);
        }
        return tempFile;
    }
}
