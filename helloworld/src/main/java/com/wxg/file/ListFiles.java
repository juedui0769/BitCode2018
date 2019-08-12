package com.wxg.file;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ListFiles {

    @Test
    public void test01() {
        String path = new String("C:\\Users\\Wxg\\Desktop\\22\\xx");
        File rootFile = new File(path);
        File[] listFiles = rootFile.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
//                System.out.println(dir.getPath());
//                System.out.println(dir.getName());
//                System.out.println(name);
                File _file = new File(dir.getPath(), name);
                if (_file.isDirectory()) {
                    return true;
                } else {
                    if(name.endsWith(".php")) {
                        return true;
                    }
                }
                return false;
            }
        });
        for (File _file : listFiles) {
            System.out.println(_file.getPath());
        }

    }

    @Test
    public void test02() {
        String path = new String("C:\\Users\\Wxg\\Desktop\\22\\xx");
        File rootFile = new File(path);
        List<File> resultList = new ArrayList<>();
        listFiles(resultList, rootFile, ".php");
        if (null != resultList) {
            for (File file : resultList) {
                System.out.printf("%s,%s\n", file.getName(), file.getPath().replace(path, ""));
            }
        }
    }

    private void listFiles(List<File> resultList, File startFile, String suffix) {
        if(startFile.isDirectory()) {
            File[] files = startFile.listFiles();
            if (null != files) {
                for (File file : files) {
                    listFiles(resultList, file, suffix);
                }
            }
        } else {
            if (startFile.getName().endsWith(suffix)) {
                resultList.add(startFile);
            }
        }
    }


}
