package GUI;

public class Canvas01 {

    private static MainCanvas canvas01;

    private Canvas01() {
    }

    public static MainCanvas getMainCanvas() {
        if (canvas01 == null) {
            return new MainCanvas();
        } else {
            return canvas01;
        }
    }
}
