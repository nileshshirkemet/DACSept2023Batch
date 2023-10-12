import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Program {

    public static void main(String[] args) throws Exception {
        String item = args[0].toLowerCase();
        int quantity = Integer.parseInt(args[1]);
        //step 1
        var connection = new Socket(args[2], 4000);
        //step 2
        var input = connection.getInputStream();
        var output = connection.getOutputStream();
        var reader = new BufferedReader(new InputStreamReader(input));
        var writer = new PrintWriter(output);
        System.out.println(reader.readLine());
        writer.println(item);
        writer.flush();
        String message = reader.readLine();
        if(message != null){
            var info = ItemInfo.parse(message);
            if(quantity <= info.stock()){
                System.out.printf("Total Payment: %.2f%n", quantity * info.price());
            }else{
                System.out.println("Item out of stock!");
            }
        }else{
            System.out.println("Item not sold!");
        }
        //step 3
        connection.close();
    }
}