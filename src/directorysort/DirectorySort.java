package directorysort;

import java.io.*;
import java.util.*;

public class DirectorySort {

    public static void main(String[] args) {
        int val = 1;
        while (val == 1) {
            val = readFile();
        }
    }
    
    

    

    public static int readFile() {
        int flag = 0;
        // Read file
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();
        String line;
        String f = "";

        try {

            System.out.println("Please enter the filename which contains the list of directories: ");
            f = sc.next();
            File input = new File(f);
            sc = new Scanner(input);

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String alpha = line, numeric = line;
                //Get the alphabetic part
                alpha = alpha.replaceAll("[0-9]", "");
                //get the numeric part.n,
                numeric = numeric.replaceAll("[^\\d.]", "");
                //System.out.println("<" + alpha + "> <" + numeric +">");
                names.add(alpha);
                if (map.containsKey(alpha)) {
                    String value = map.get(alpha);
                    value = value + " " + numeric;
                    map.put(alpha, value);
                } else {
                    map.put(alpha, numeric);
                }
            }
            Collections.sort(names);

            for (int i = 0; i < names.size(); i++) {

                if ((i == 0) || (!names.get(i).equals(names.get(i - 1)))) {

                    String key = names.get(i);
                    String value = map.get(key);

                    ArrayList<Integer> val = new ArrayList<>();
                    StringTokenizer st = new StringTokenizer(value, " ");
                    while (st.hasMoreTokens()) {
                        val.add(Integer.parseInt(st.nextToken()));
                    }

                    Collections.sort(val);
                    for (int j = 0; j < val.size(); j++) {
                        System.out.println(key + val.get(j));
                    }
                }
            }

            flag = 0;
        } catch (Exception e) {
            System.out.println("error in loading file:");
            flag = 1;
        }
        return flag;
    }
}
