package com.evankellener.backend;

public class ParsedMethod {
    public String methodName;
    public String returnType;
    public String javadoc;

    public ParsedMethod(String methodName, String returnType, String javadoc) {
        this.methodName = methodName;
        this.returnType = returnType;
        this.javadoc = javadoc;
    }
}