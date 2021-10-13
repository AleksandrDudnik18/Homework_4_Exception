package task_4_2;

import task_4_2.servies.PinValidator;
import task_4_2.servies.TerminalImpl;
import task_4_2.server.TerminalServer;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new PinValidator());
        terminal.start();



    }

//    public static int myMethod()  {
//        try {
//            throw new Exception();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}


