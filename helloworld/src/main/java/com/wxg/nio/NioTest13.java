package com.wxg.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 *
 */
public class NioTest13 {
    public static void main(String[] args) throws Exception{
        String root_path = NioTest13.class.getClassLoader().getResource("").getPath();

        File inputFile = new File(root_path, "NioTest3_In.txt");
        File outputFile = new File(root_path, "NioTest3_Out.txt");

        RandomAccessFile inputRaf = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRaf = new RandomAccessFile(outputFile, "rw");

        long inputLen = inputFile.length();

        FileChannel inputChannel = inputRaf.getChannel();
        FileChannel outputChannel = outputRaf.getChannel();

        MappedByteBuffer inputData = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputLen);

        // Charset.forName("iso-8859-1");
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(inputData);

        ByteBuffer outputData = encoder.encode(charBuffer);

        outputChannel.write(outputData);

        inputRaf.close();
        outputRaf.close();
    }
}
