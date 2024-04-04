import org.example.LettersReadingStrategy;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class LettersReadingStrategyTest {

    @Test
    public void testReadFromFileWithOnlyLetters() throws IOException {
        // Создаем временный файл с буквами
        File tempFile = createTempFile("letters", ".txt", "abc\ndef\nghi");

        // Создаем экземпляр стратегии чтения
        LettersReadingStrategy strategy = new LettersReadingStrategy();

        // Перехватываем стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Вызываем метод чтения из файла
        strategy.readFromFile(tempFile.getAbsolutePath());

        // Получаем фактический вывод
        String actualOutput = outputStream.toString().trim();
        System.out.println("Actual Output: '" + actualOutput + "'");

        // Проверяем, что вывод соответствует ожидаемому
        assertEquals("Result: abcdefghi", actualOutput);
    }

    @Test
    public void testReadFromFileWithMixedCharacters() throws IOException {
        // Создаем временный файл с разными символами
        File tempFile = createTempFile("mixed", ".txt", "abc123\n$%^&\n123def");

        // Создаем экземпляр стратегии чтения
        LettersReadingStrategy strategy = new LettersReadingStrategy();

        // Перехватываем стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Вызываем метод чтения из файла
        strategy.readFromFile(tempFile.getAbsolutePath());

        // Получаем фактический вывод
        String actualOutput = outputStream.toString().trim();
        System.out.println("Actual Output: '" + actualOutput + "'");

        // Проверяем, что вывод соответствует ожидаемому
        assertEquals("Result: abcdef", actualOutput);
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

    @Test
    public void testPrintName() {
        // Перехватываем стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Вызываем метод printName()
        new LettersReadingStrategy().printName();

        // Получаем фактический вывод
        String actualOutput = outputStream.toString().trim();
        System.out.println("Actual Output: '" + actualOutput + "'");

        // Проверяем, что вывод соответствует ожидаемому
        assertEquals("Algorithm: LettersReadingStrategy", actualOutput);
    }

    @Test
    public void testPrintDescription() {
        // Перехватываем стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Вызываем метод printDescription()
        new LettersReadingStrategy().printDescription();

        // Получаем фактический вывод
        String actualOutput = outputStream.toString().trim();
        System.out.println("Actual Output: '" + actualOutput + "'");

        // Проверяем, что вывод соответствует ожидаемому
        assertEquals("Description: Reads only letters from the file.", actualOutput);
    }

    @Test
    public void testCalculateAndPrintExecutionTime() {
        // Перехватываем стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Создаем экземпляр стратегии и вызываем метод calculateAndPrintExecutionTime()
        LettersReadingStrategy strategy = new LettersReadingStrategy();
        strategy.calculateAndPrintExecutionTime();

        // Получаем фактический вывод
        String actualOutput = outputStream.toString().trim();
        System.out.println("Actual Output: '" + actualOutput + "'");

        // Проверяем, что вывод не пустой (время выполнения должно быть выведено)
        assertFalse(actualOutput.isEmpty());
    }

}
