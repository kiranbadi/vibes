package com.vibes.kb;

import com.vibes.kb.helper.FileProcessor;
import com.vibes.kb.model.MesageModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class VibesApplication {

  // For now reading it from file location
    private static final String FILE_PATH = "C:\\logs\\persons.txt";
    private static FileProcessor fileProcessor;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Spring Set up works");
        getPrint();
        SpringApplication.run(VibesApplication.class, args);
    }

  public static void getPrint() throws FileNotFoundException {
      fileProcessor = new FileProcessor();
      List<MesageModel> counts  = fileProcessor.readFile(FILE_PATH);
      fileProcessor.printMessages(counts);
  }

}
