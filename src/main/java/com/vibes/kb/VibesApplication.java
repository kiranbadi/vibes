package com.vibes.kb;

import com.vibes.kb.helper.FileProcessor;
import com.vibes.kb.model.MesageModel;

import java.io.FileNotFoundException;
import java.util.List;

public class VibesApplication {

  // For now reading it from file location
    private static final String FILE_PATH = "C:\\logs\\persons.txt";
    private static FileProcessor fileProcessor;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Project Set up works");
        processFile();
    }

  public static void processFile() throws FileNotFoundException {
      fileProcessor = new FileProcessor();
      List<MesageModel> counts  = fileProcessor.readFile(FILE_PATH);
      fileProcessor.printMessages(counts);
  }

}
