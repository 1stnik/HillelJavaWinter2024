package com.hillel.lesson_19.folders;

import java.io.File;
import java.io.IOException;

public class MakeDir {

    public static void main(String[] args) throws IOException {
        String baseName = "/Users/oleksandrstepurko/IdeaProjects/HillelJavaWinter2024/classwork/src/com/hillel/lesson_19/folders"; // base path

        String dirName = baseName + "/newDir"; // dir path
        String createFile = dirName + "/test.txt"; // file path
        String dirName1 = baseName + "/newDir/1/2/3/4"; // dir paths
        String dirName2 =dirName1 + "/5"; // dir paths

        File dir = new File(dirName);
        System.out.println(dir.mkdir()); // one next folder
        File dir1 = new File(dirName1);
        System.out.println(dir1.mkdirs()); // folder hierarchy
        File dir2 = new File(dirName2);
        System.out.println(dir2.mkdirs()); // one folder


        File file = new File(createFile);

        // create file
        if (!file.exists()) // check if exist
            System.out.println(file.createNewFile()); // create file

        // delete file
        if (file.exists()) // check if exist
            System.out.println(file.delete()); // delete file


//        System.out.println("dir exist: " + dir2.exists()); // check if path exist
//        System.out.println("isDirectory: " + dir2.isDirectory()); // if true directory, else file
//        System.out.println("isHidden: " + dir2.isHidden()); // is hidden or not
//        System.out.println("isFile: " + dir2.isFile()); // if true file, else directory
//        System.out.println("canRead : " + dir2.canRead()); // available read
//        System.out.println("canWrite : " + dir2.canWrite()); // available write
//        System.out.println("canExecute : " + dir2.canExecute()); // available execute




        System.out.println("dir name : " + dir.getName());
        System.out.println("get Parent:" + dir.getParent());
        System.out.println("list files :" + dir.listFiles().length);
        System.out.println("parent list files :" + dir.getParentFile().length());

    }
}
