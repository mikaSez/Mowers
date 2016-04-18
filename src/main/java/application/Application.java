package application;

import runner.Runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class Application{
    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args){
		if(args != null && args.length==1){
            try {
               List<String> content =  Files.readAllLines(Paths.get(args[0]));
               Runner r = new Runner();
                r.runScenario(content);
            } catch (IOException e) {
                log.severe("The argument should be a valid file path : " + e);
            }
        } else {
            log.severe("Application should have exactly one argument : file path");
        }
	}
}