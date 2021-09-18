package recursion;

import java.io.File;

public class DiskUsage {
    public static long diskUsage(File root){
        long total = root.length();
        if(root.isDirectory()){
            for(String childname: root.list()){
                File child = new File(root, childname);
                total += diskUsage(child);
            }
        }
        System.out.println(total + "\t" + root);
        return total;
    }

    public static void main(String[] args) {
        System.out.println(diskUsage(new File("C:\\Users\\Odedoyin Akindele\\Desktop\\Java\\Basics")));
    }
}
