package com.evankellener.backend;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class JavaFileParser {

    public static ParsedClass parseFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String className = null;
        List<ParsedMethod> methods = new ArrayList<>();

        String currentJavadoc = "";

        Pattern classPattern = Pattern.compile("public class (\\w+)");
        Pattern methodPattern = Pattern.compile("public (\\w+) (\\w+)\\(");

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("/**")) {
                currentJavadoc = line;
            } else if (line.startsWith("*") && !line.contains("*/")) {
                currentJavadoc += "\n" + line;
            } else if (line.endsWith("*/")) {
                currentJavadoc += "\n" + line;
            }

            Matcher classMatcher = classPattern.matcher(line);
            if (classMatcher.find()) {
                className = classMatcher.group(1);
            }

            Matcher methodMatcher = methodPattern.matcher(line);
            if (methodMatcher.find()) {
                String returnType = methodMatcher.group(1);
                String methodName = methodMatcher.group(2);
                methods.add(new ParsedMethod(methodName, returnType, currentJavadoc));
                currentJavadoc = "";
            }
        }

        return new ParsedClass(className, methods);
    }
}
