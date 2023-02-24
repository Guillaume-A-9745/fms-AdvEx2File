import java.io.BufferedReader;
import java.io.FileReader;

public class TprestoReader {
	protected String source;
	  
	  public TprestoReader(String source) {
	    this.source = source;
	    lecture();
	  }

	  public static void main(String args[]) {
	    new TestBufferedReader("C://Users/AnselmeG/Documents/Exercices/AdvEx3File/menu.txt");
	  }

	  private void lecture() { 
	    try {
	      String ligne ;
	      BufferedReader fichier = new BufferedReader(new FileReader(source));
	      
	      while ((ligne = fichier.readLine()) != null) {
	          System.out.println(ligne);
	      }

	      fichier.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }     
	  }    
}
