package com.wxg.file;

import com.google.common.io.Resources;

import java.io.File;
import java.net.URL;

public class FileTools {
    private FileTools () {}

    public static FileParent beforeGetParent(String filepath) {
        return new FileParent(filepath);
    }

    public static void main(String[] args) {
        URL url = Resources.getResource("");
        System.out.println(FileTools.beforeGetParent(url.getPath()).parent().parent().file());
    }

    public static class FileParent {
        private File innerFile;
        public FileParent(String filepath) {
            try {
                this.innerFile = new File(filepath);
            } catch (Exception e) {
                throw new RuntimeException("无法根据传入的参数构造文件, filepath=" + filepath);
            }
            if (!innerFile.exists()) {
                throw new RuntimeException("文件不存在, filepath=" + filepath);
            }
        }
        public FileParent parent() {
            try {
                innerFile = new File(innerFile.getParent());
            } catch (Exception e) {
                throw new RuntimeException("无法获取父目录, filepath=" + innerFile.getPath());
            }
            return this;
        }
        public File file() {
            return innerFile;
        }
    }
}
