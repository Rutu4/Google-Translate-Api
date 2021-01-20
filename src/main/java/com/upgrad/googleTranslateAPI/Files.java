package com.upgrad.googleTranslateAPI;

import java.io.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    public class Files {

        private Files() {
        }


        public static void write(final File file, final String content) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);
            bw.close();
        }


        public static String read(final File file) throws IOException {
            final StringBuilder sb = new StringBuilder();
            String line;

            final BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }

            return sb.toString();
        }
    }

