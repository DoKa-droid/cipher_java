import com.example.caesar.Caesar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaesarTest {
    @Test
    void encryptTest() {
        Assertions.assertEquals(Caesar.encrypt("Task At QA", 3), "Wdvn Dw TD");
    }
}
