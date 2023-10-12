import java.util.*;
import java.io.*;
import java.net.*;

class Program {

    public static void main(String[] args) throws Exception {
        Properties store = new Properties();
        try(var input = new FileInputStream("CitiTek.xml")){
            store.loadFromXML(input);
        }
        //Step 1
        var listener = new ServerSocket(4000);
        for(int i = 0; i < 3; ++i){
            var servant = new Thread(() -> service(listener, store));
            servant.start();
        }
    }

    private static void service(ServerSocket listener, Properties store) {
        do {
            //Step 2
            try(var connection = listener.accept()){
                var input = connection.getInputStream();
                var output = connection.getOutputStream();
                var reader = new BufferedReader(new InputStreamReader(input));
                var writer = new PrintWriter(output, true);
                writer.println("Welcome to CitiTek Computers");
                String item = reader.readLine();
                String info = store.getProperty(item);
                if(info != null)
                    writer.println(info);
                writer.close();
                reader.close();
            }catch(IOException e){}
            //Step 3
        }while(true);
    }
}