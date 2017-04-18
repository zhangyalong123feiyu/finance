package com.bibinet.finance.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by bibinet on 2017-2-17.
 */
public class ListFile
{
    static class MyFileNameFilter implements FilenameFilter//过滤文件用
    {
        private String suffix = ".doc";

        public MyFileNameFilter(String str)
        {
            this.suffix = str;
        }

        public boolean accept(File dirFile, String name)
        {
            if (new File(dirFile, name).isFile())
                return name.endsWith(suffix);
            else
                return true;
        }

    }

    public static void listAllFiles(String dirName)
    {
        if (!dirName.endsWith(File.separator))
            dirName += File.separator;
        File dirFile = new File(dirName);
        if (!dirFile.exists() || !dirFile.isDirectory())
        {
            System.out.println("List失败找不到目录：" + dirName);
            return;
        }
        File[] files = dirFile.listFiles();//不带参数的列出文件或目录的方法
        for (int i = 0; i < files.length; i++)
        {
            if (files[i].isFile())
                System.out.println(files[i].getAbsolutePath() + "是文件");
            else if (files[i].isDirectory())
            {
                System.out.println(files[i].getAbsolutePath() + "是目录");
                ListFile.listAllFiles(files[i].getAbsolutePath());
            }
        }
    }

    public static void listFilesByFilenameFilter(FilenameFilter filter, String dirName)
    {
        if (!dirName.endsWith(File.separator))//是否以 \ 结尾
            dirName += File.separator;
        File dirFile = new File(dirName);
        if (!dirFile.exists() || (!dirFile.isDirectory()))
        {
            System.out.println("List 失败，找不到目录:" + dirFile.getAbsolutePath());
            return;
        }
        File[] files = dirFile.listFiles(filter);//带参数的    参数是实现 FilenameFilter的方法
        for (int i = 0; i < files.length; i++)
        {
            if (files[i].isFile())
                System.out.println(files[i].getAbsolutePath() + "是文件");
            else if (files[i].isAbsolute())
            {
                System.out.println(files[i].getAbsolutePath() + "是目录");
                ListFile.listFilesByFilenameFilter(filter, files[i].getAbsolutePath());
            }
        }
    }



    public static void main(String[] args)
    {
        String dirName = "C:/temp";
        System.out.println(dirName + "目录下的内容");
        ListFile.listAllFiles(dirName);
        System.out.println("过滤后的内容");
        MyFileNameFilter fileter = new MyFileNameFilter(".doc");
        ListFile.listFilesByFilenameFilter(fileter, dirName);
        System.out.println(File.separator);

    }

}