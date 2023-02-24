/**
 * 
 * @author Anselme Guillaume
 * Essai sur les entrée et sortie
 */
import java.io.*;

public class TestBufferedReader {
  protected String source;
  
  public TestBufferedReader(String source) {
    this.source = source;
    lecture();
  }

  public static void main(String args[]) {
    new TestBufferedReader("C://Users/AnselmeG/Documents/Exercices/AdvEx3File/texte.txt");
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
