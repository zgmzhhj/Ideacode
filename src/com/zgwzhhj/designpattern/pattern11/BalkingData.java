package com.zgwzhhj.designpattern.pattern11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BalkingData {
    private final String fileName;

    private String content;

    private boolean change;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.change = true;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
    }

    public synchronized void save() throws IOException {
        if (!change) {
            return;
        }
        doSave();
        this.change = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + "call to svae");
        try (Writer writer = new FileWriter(fileName, true)) {
            writer.write(content);
            writer.write("\n");
            writer.flush();
        }
    }
}

