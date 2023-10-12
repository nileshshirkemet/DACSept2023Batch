import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

class Program {

    public static void main(String[] args) throws Exception {
        if(args.length > 1){
            var input = new FileInputStream(args[0]);
            var output = new FileOutputStream(args[1]);
            byte[] buffer = new byte[80];
            while(input.available() > 0){
                int n = input.read(buffer, 0, buffer.length);
                Transformer.encode(buffer, n);
                output.write(buffer, 0, n);
            }
            output.close();
            input.close();
        }else if(args.length == 1){
            try(var file = new RandomAccessFile(args[0], "rw")){
                int n = (int)file.length();
                byte[] buffer = new byte[n];
                file.read(buffer);
                Transformer.reverse(buffer);
                file.seek(0);
                file.write(buffer);
            }
        }       
    }
}
