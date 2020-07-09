package sample.test;

/**
 *
 * Test及びModel例用クラス
 * 本来はここでDBアクセス
 */
public class Model {

    /**
     * Mr.追加
     * @param name
     * @return String
     */
    public static String appendMr(String name) {
        return "Mr." + name;
    }
}
