package com.evankellener.backend;

import java.util.List;

public class ParsedClass {
    public String className;
    public List<ParsedMethod> methods;

    public ParsedClass(String className, List<ParsedMethod> methods) {
        this.className = className;
        this.methods = methods;
    }

    public void sayHello() {
        System.out.println("Hello from ParsedClass!");
    }
}
