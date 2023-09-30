
public class Main {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private static final int X_COORDINATE = 700;
    private static final int Y_COORDINATE = 700;
    public static void main(String[] args) {
        System.out.println(GameImages.GAME_IMAGE_ICON[0]);
        RockPaperScissorsGui rg = new RockPaperScissorsGui();
        rg.setBounds(X_COORDINATE,Y_COORDINATE,WIDTH,HEIGHT);
        rg.setVisible(true);

    }
}