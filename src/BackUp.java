import java.io.*;

public class BackUp extends Thread {

    private static File file;
    private static Database database;

    public BackUp(String pathname, Database database) {
        file = new File(pathname);
        BackUp.database = database;
    }

    @Override
    public void run() {
        BackUp();
    }

    private static void BackUp() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(database.list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
