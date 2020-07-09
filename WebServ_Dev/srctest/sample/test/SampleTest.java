package sample.test;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testコードサンプル
 * テスト対象とフォルダを分け、パッケージを同じにする慣習あり
 */
public class SampleTest {
    /**
     * @throws Exception
     */
    @Test
    public void testAppendMr() throws Exception {
        String name = Model.appendMr("sato");
        assertEquals("Mr.sato", name);
    }
}
