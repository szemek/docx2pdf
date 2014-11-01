package com.example.docx2pdf;

import java.io.OutputStream;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;


public class ConvertDocx2Pdf {
    protected static String input;

    static {
        input = null;
    }

    public static void main(String[] args) throws Exception {
        try {
            if (args.length==0) throw new IllegalArgumentException("Missing filename");
            input = args[0];
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        WordprocessingMLPackage wordMLPackage;
        System.out.println("Loading file from: " + input);
        wordMLPackage = WordprocessingMLPackage.load(new java.io.File(input));
        String output = input + ".pdf";
        OutputStream os = new java.io.FileOutputStream(output);
        Docx4J.toPDF(wordMLPackage, os);
        System.out.println("Saved: " + output);
    }
}
