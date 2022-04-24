import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapon;
    private int lvl;
    private double distance;


    public GameProgress(int health, int weapon, int lvl, double distance) {
        this.health = health;
        this.weapon = weapon;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapon=" + weapon +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String path, GameProgress progress) {
        try (
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(progress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void zipFiles(String pathZip, List<String> path) {
        int count = 0;
        try {
            for (String pathSave : path) {
                try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(pathZip));
                     FileInputStream fis = new FileInputStream(pathSave)) {
                    count++;
                    ZipEntry zipEntry = new ZipEntry(count + "packed.txt");
                    zos.putNextEntry(zipEntry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                    zos.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
