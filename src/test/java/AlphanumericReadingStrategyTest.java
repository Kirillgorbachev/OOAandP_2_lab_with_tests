import org.example.AlphanumericReadingStrategy;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AlphanumericReadingStrategyTest {

    @Test
    public void testPrintName() {
        // Перехватываем стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Вызываем метод printName()
        new AlphanumericReadingStrategy().printName();

        // Получаем фактический вывод
        String actualOutput = outputStream.toString().trim();
        System.out.println("Actual Output: '" + actualOutput + "'");

        // Проверяем, что вывод соответствует ожидаемому
        assertEquals("Algorithm: AlphanumericReadingStrategy", actualOutput);
    }

    @Test
    public void testPrintDescription() {
        // Перехватываем стандартный вывод
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Вызываем метод printDescription()
        new AlphanumericReadingStrategy().printDescription();

        // Получаем фактический вывод
        String actualOutput = outputStream.toString().trim();
        System.out.println("Actual Output: '" + actualOutput + "'");

        // Проверяем, что вывод соответствует ожидаемому
        assertEquals("Description: Reads letters and numbers from the file.", actualOutput);
    }
    
}
