package workMain;

public class Executor {
    private IParser parser;

    public void setParser(IParser parser) {
        this.parser = parser;
    }

    public void execute(String inputFile, String outputFile){
        parser.parsing(inputFile, outputFile);
    }
}
