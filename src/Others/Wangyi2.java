package Others;

import java.util.*;

public class Wangyi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            // one file system
            int n = in.nextInt();
            in.nextLine();
            int fd = 0;
            ArrayList<Integer> fdList = new ArrayList<>();
            fdList.add(fd);
            HashMap<Integer, String> fs = new HashMap<>();
            while(n > 0) {
                String s = in.nextLine();
                String[] temp = new String[3];
                temp = s.split(" ");
                if (temp[0].equals("open")) {
                    if (fs.containsValue(temp[1])) {
                        for (Integer i: fs.keySet()) {
                            if (fs.get(i).equals(temp[1])) {
                                System.out.println(i);
                                break;
                            }
                        }
                    } else {
                        fd++;
                        fdList.add(fd);
                        fs.put(fdList.get(0), temp[1]);
                        System.out.println(fdList.get(0));
                        fdList.remove(0);
                    }
                } else if (temp[0].equals("dup")) {
                    String fileName = fs.get(Integer.parseInt(temp[1]));
                    fd++;
                    fdList.add(fd);
                    fs.put(fdList.get(0), fileName);
                    System.out.println(fdList.get(0));
                    fdList.remove(0);
                } else if (temp[0].equals("dup2")) {
                    String fileName = fs.get(Integer.parseInt(temp[1]));
                    if (fs.keySet().contains(Integer.parseInt(temp[2]))) {
                        fs.replace(Integer.parseInt(temp[2]), fileName);
                    } else {
                        fs.put(Integer.parseInt(temp[2]), fileName);
                    }
                } else if (temp[0].equals("close")) {
                    fs.remove(Integer.parseInt(temp[1]));
                    fdList.add(Integer.parseInt(temp[1]));
                    Collections.sort(fdList);
                } else if (temp[0].equals("query")) {
                    System.out.println(fs.get(Integer.parseInt(temp[1])));
                }
                n--;
            }
            t--;
        }
    }
}
/*
2
10
open libc.so
open libm.so
open libd1.so
dup 2
dup2 0 2
close 0
query 1
query 2
query 3
open log.txt
10
open output.txt
dup2 0 1000000
close 0
open output2.txt
dup2 0 100000
close 0
open 1.txt
dup 100000
query 1
query 0
 */