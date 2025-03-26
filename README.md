# Java Smart Documentation Assistant

## Current State
This project is a Java file parser that extracts class and method information from Java source files and outputs it as structured JSON. Currently, it:

- Parses Java source files to identify class names
- Extracts method signatures (name and return type)
- Captures Javadoc comments
- Outputs the structured data to JSON files

The parser uses regex patterns to identify classes and methods, and Java NIO for file operations.

## Future Plans
This project will evolve into a Smart Documentation Assistant using LangChain, with the following planned features:

1. **Enhanced Code Analysis**
   - Parse parameters, visibility modifiers, and inheritance
   - Analyze method implementations and dependencies
   - Extract field definitions and annotations

2. **LangChain Integration**
   - Connect parsed code with LLM capabilities
   - Generate improved documentation from code context
   - Analyze code quality and suggest improvements

3. **Documentation Enhancement**
   - Automatically generate comprehensive Javadoc
   - Create architectural diagrams from code structure
   - Identify and document code patterns

4. **Interactive Documentation**
   - Build a web UI for browsing code and documentation
   - Enable natural language queries about codebase
   - Allow documentation editing with AI assistance

## Getting Started
1. Build the project:
   ```
   mvn compile
   ```

2. Run the parser:
   ```
   mvn exec:java -Dexec.args="path/to/JavaFile.java"
   ```

3. Find output in:
   ```
   output/ClassName.json
   ```

## Technology Stack
- Java
- Maven
- Gson (for JSON processing)
- LangChain (future)