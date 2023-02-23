import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class TestBufferedWriter {

  public static void main(String args[]) {
  
    File file = new File("C://Users/AnselmeG/Documents/Exercices/AdvEx3File/texte.txt");
    if (!file.exists()) {
    	try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    } else {
    	List<String> lines = Arrays.asList("Un","Deux","Trois","Quatre");
		try {
			FileWriter writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("Salut les gens !");
			bw.write("comment ça va ?");
			bw.write("test !");
			
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
				System.out.println(line);
			}
			
			bw.close();
			writer.close();  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String line = reader.readLine();
		
		while(line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
}