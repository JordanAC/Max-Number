import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxNumber {
    
    public static void main(String[] args) throws FileNotFoundException {
      File f = new File("your file here");
      Scanner s = new Scanner(f);
      ArrayList<int[]> lines = new ArrayList();
      int maxnumber = 0;
      String cline;
      String [] currln;
      int parsedlines[];
      
      while(s.hasNextLine()){
          cline = s.nextLine();
          currln = cline.split(" ");
          parsedlines = new int[currln.length];
          for(int j = 0; j< currln.length; j++){
              parsedlines[j] = Integer.parseInt(currln[j]);
          }
          
          lines.add(parsedlines);
          
      }
      
       for(int i = lines.size() - 2; i >= 0; i--){
                  int [] current = lines.get(i);
                  int [] previous = lines.get(i + 1) ;
                  int [] t = combineLines(current,previous);
                  lines.set(i , t);

       }
          
        maxnumber = lines.get(0)[0];
        System.out.println("Answer is: " + maxnumber);
      
    }
    
    public static int getLarger(int n1, int n2){
        
        if( n1 > n2){
            return n1;
        } else if( n1 < n2) {
            return n2;
        } else{
            return n1;
        }
    }
    
    public static int[] combineLines(int [] a, int [] b){
        int temp[] = new int[a.length];
        int high;
        for(int i = 0; i < a.length  ; i++){
            high = getLarger(b[i]+a[i], b[i+1]+a[i]);
            temp[i] = high;
        }
        return temp;
    }
    
}
