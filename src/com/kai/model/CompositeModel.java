package com.kai.model;

/**
 * Created by FengKai on 2018/6/22.
 */
public class CompositeModel {
    /**
     * 组合模式（Composite）
     * 组合模式是为了表示那些层次结构，同时部分和整体也可能是一样的结构，常见的如文件夹或者树
     * @param args
     */
    public static void main(String[] args) {
        File file1 = new File("文件1.txt");
        File file2 = new File("文件2.txt");
        File file3 = new File("文件3.txt");
        Folder folder1_1 = new Folder("文件夹1-1", new Component[]{
                file1, file2, file3
        });
        Folder folder1_2_1 = new Folder("文件夹1-2-1", new Component[]{
                file2, file3
        });
        Folder folder1_2 = new Folder("文件夹1-2", new Component[]{
                file1, file3, folder1_2_1
        });
        Folder folder1_3 = new Folder("文件夹1-3", new Component[]{
                file1, file3
        });
        Folder folder = new Folder("根文件夹", new Component[]{
                file1, file2, file3, folder1_1, folder1_2, folder1_3
        });
        // 遍历第一级 传 0 递归+1
        folder.scan(0);
    }
}

// 抽象构件
abstract class Component {
}

class File extends Component {
    String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }
}

class Folder extends Component {
    Component[] files;
    String folderName;

    public Folder(String folderName, Component[] files) {
        this.files = files;
        this.folderName = folderName;
    }

    public void scan(int level) {
        StringBuilder prefixBuilder = new StringBuilder();
        for (int i = 0; i <= level; i++) {
            prefixBuilder.append("--");
        }
        String prefix = prefixBuilder.toString();

        for (Component component : files) {
            if (component instanceof File) {
                System.out.println(prefix + ">" + ((File) component).fileName);
            } else if (component instanceof Folder) {
                System.out.println(prefix + ">" + ((Folder) component).folderName);
                ((Folder) component).scan(level + 1);
            }
        }

    }
}


