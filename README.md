# Java Smart Documentation Assistant
<pre> <code>
## Project Structure
```
java-backend/
├── output
│  └──ParsedClass.json  <- parsed files
├── target/classes/com/user/backend
│   └──Main.class
│   ├── JavaFileParser.class
│   ├── ParsedClass.class
│   └── ParsedMethod.class
├── src/
│   └── main/
│       └── java/
│           └── your/package/name/
│               ├── Main.java
│               ├── JavaFileParser.java
│               ├── ParsedClass.java
│               └── ParsedMethod.java
├── pom.xml
node_modules/
node-backend/
├── index.js   <-main serve file
├── package.json 
package-lock.json
package.json
``` </code> </pre>

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
   cd java-backend
   mvn compile
   ```

2. Run the parser:
   ```
   #Change 'path/to/JavaFile.java' to whateve file you want to parse
   mvn exec:java -Dexec.args="path/to/JavaFile.java"
   ```

3. Find output in:
   ```
   output/ClassName.json
   ```

## Running the server

1. cd into node-backend and run the index.js file:
   ```
   cd node-backend
   node index.js
   ```

   you should get the following message:
   ```
   Server is running on http://localhost:3000
   ```

## Connecting To OpenAi LLM

1. Input your own API token in the .env file:
   ```
   OPENAI_API_KEY="sk-proj-.....jdUq"
   ```

2. Install the requirmenets.txt file:
   ```
   pip install -r requirements.txt
   ```

3. Ensure the express.js server is running and run the langchainTool.py:
   ```
   python langchainTool.py
   ```
   you should get the following message:
   
   ```
   > Entering new AgentExecutor chain...
   I should use the GetJavaClassStructure tool to find out the structure of the Java class.
   Action: GetJavaClassStructure
   Action Input: x (the Java class in question)
   Observation: {'className': 'ParsedClass', 'methods': [{'methodName': 'sayHello', 'returnType': 'void', 'javadoc': ''}]}
   Thought:The Java class is named ParsedClass and contains a method called sayHello that returns void.
   Final Answer: The Java class contains a method named sayHello that returns void.

   > Finished chain.
   The Java class contains a method named sayHello that returns void.
   ```

## Technology Stack
- Java
- Maven
- Gson (for JSON processing)
- LangChain (future)
- Node.js (JavaScript runtime)
- Express.js (web framework)