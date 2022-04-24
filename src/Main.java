import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameProgress game = new GameProgress(100, 1, 1, 41);
        GameProgress game1 = new GameProgress(34, 2, 3, 54);
        GameProgress game2 = new GameProgress(74, 3, 15, 304);
        game.saveGame("/Users/macbookpro/Games/savegames/save0.dat", game);
        game1.saveGame("/Users/macbookpro/Games/savegames/save1.dat", game1);
        game2.saveGame("/Users/macbookpro/Games/savegames/save2.dat", game2);
        List<String> listSave = new ArrayList<>();
        listSave.add("/Users/macbookpro/Games/savegames/save0.dat");
        listSave.add("/Users/macbookpro/Games/savegames/save1.dat");
        listSave.add("/Users/macbookpro/Games/savegames/save2.dat");
        for (int i = 0; i < listSave.size(); i++) {
            game.zipFiles("/Users/macbookpro/Games/savegames/save" + i + ".zip", listSave);
            File file = new File("/Users/macbookpro/Games/savegames/save" + i + ".dat");
            if (!file.equals(".zip")) {
                file.delete();
            }
        }
    }
}
