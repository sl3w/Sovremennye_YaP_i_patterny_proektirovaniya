package workMain;

public class Main {
    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFilDOM = args[1];
        String outputFilSAX = args[2];

        Executor executor = new Executor();
        executor.setParser(new ParserDOM());
        executor.execute(inputFile, outputFilDOM);

        executor.setParser(new ParserSAX());
        executor.execute(inputFile, outputFilSAX);
    }
}
