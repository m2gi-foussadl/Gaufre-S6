import java.util.*
public class Plateau{
    ArrayList<ArrayList<int>> plateau;
    int col;
    int row;

    boolean fini;
    public Plateau(){
        col =5;
        row =5;
        fini = false;
        for(int i = 0; i < row; i++){
            ArrayList<int> cols = new ArrayList<int>();
            for(int j =0; j < col; j++){
                cols.add(1);
            }
            plateau.add(cols);
        }
    }//

    public Plateau(int c, int r){
        col =c;
        row =r;
        fini = false;
        for(int i = 0; i < row; i++){
            ArrayList<int> cols = new ArrayList<int>();
            for(int j =0; j < col; j++){
                cols.add(1);
            }

            plateau.add(cols);
        }
    }//

    public void coup(int c, int r){
        if(c == 0 && r == 0){
            //match fini
            fini = true;
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if((i>=r) && (j>=c)){
                    plateau.get(i).get(j) = 0;
                }
            }
        }

    }//

    public boolean estTerminer(){
        return fini;
    }
}
