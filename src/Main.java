import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Nguoi> list = new ArrayList<>();
    static File save = new File("./src/save.txt");

    public static void main(String[] args) throws IOException {
        docFile();
        for (Nguoi n : list) {
            System.out.println(n);
        }
        list.add(new Nguoi("Dung", 23, "nam", "113"));
        ghiFile();
    }

    public static void docFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(save));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] str = line.split(",");
            if (str.length >= 4) {
                list.add(new Nguoi(str[0].trim(), Integer.parseInt(str[1].trim()), str[2].trim(), str[3].trim()));
            }
        }
        br.close();
    }

    public static void ghiFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(save));
        for (Nguoi n : list) {
            bw.write(n.ghiFile());
            bw.newLine();
        }
        bw.close();
    }
}
