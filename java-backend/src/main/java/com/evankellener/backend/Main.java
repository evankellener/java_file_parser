package src.main.java.com.evankellener.backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <JavaFilePath>");
            return;
        }

        String inputFilePath = args[0];

        try {
            ParsedClass parsed = JavaFileParser.parseFile(inputFilePath);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(parsed);

            String outputPath = "output/" + parsed.className + ".json";
            try (FileWriter writer = new FileWriter(outputPath)) {
                writer.write(jsonOutput);
                System.out.println("✅ Saved to " + outputPath);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
