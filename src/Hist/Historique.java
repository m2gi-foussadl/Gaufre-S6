package Hist;

import Modele.Coup;
import Modele.Plateau;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.Stack;
public class Historique {
    // 2 pile : une pour les coups passer, l'autre pour les coups future (lorsquel'on demande de refaire des coups)
    // chaque element de pile contiendront un tableau des contours mangé (tableau du premier carré vide de chaque ligne)
    // et le coup jouer "sur"/"pour avoir" cet etat

    Stack<Element_pile_histo> pil_passer;
    Stack<Element_pile_histo> pil_futur;

    public Historique(){
        this.pil_passer = new Stack<Element_pile_histo>();
        this.pil_futur = new Stack<Element_pile_histo>();
    }

    public void ajouter(Coup c, Plateau p){
        Element_pile_histo elem = new Element_pile_histo(c.get_x(), c.get_y(), p);
        pil_passer.push(elem);
        // on doit vider la pile si l'on fait de nouveau coup après avoir reculer
        while(!pil_futur.empty()){
            pil_futur.pop();
        }
    }

    public void reculer(){
        if (!pil_passer.empty()){
            pil_futur.push(pil_passer.pop());
            // mettre a jour le plateau puis le renvoyer (procédure "manger" inverser puis aplication du tableau)
        }else{
            System.out.println("Pas de coup précedent enregister");
        }
    }

    public void avancer() {
        if (!pil_futur.empty()) {
            pil_passer.push(pil_futur.pop());
            // mettre a jour le plateau puis le renvoyer (procédure "manger" inverser puis aplication du tableau)
        } else {
            System.out.println("Pas de coup suivant enregister");
        }
    }

    public void sauvegarder(String fichier, Plateau p) throws Exception {
        // Init fichier
        File f = new File(fichier);
        f.setReadable(true);
        f.setWritable(true);
        PrintWriter w_f = new PrintWriter(f);

        // Init var
        String sauv_data = "";
        Element_pile_histo elem_hist;

        w_f.println(p.colonnes() + " " + p.lignes() +" ");

        // On vide la pile des coup dans pil_passer pour commencer par ecrire le dernier coup dans le fichier
        while(!pil_futur.empty()){
            pil_passer.push(pil_futur.pop());
        }

        //On creer le String de data de sauvegarde (i.e la liste des coup réaliser)
        while(!pil_passer.empty()){
            elem_hist = pil_passer.pop();
            sauv_data += elem_hist.get_save_string() + " ";
        }
        w_f.println(sauv_data);
        w_f.close();
    }

    public Plateau charger(String fichier) {

        int c, r, col, row;
        Plateau plat;
        Scanner sc_f;

        // Init fichier
        try {
            sc_f = new Scanner(new File(fichier));
        }catch (Exception E){
            System.out.println(fichier + " isn't accesible");
            return null;
        }

        // Tant que le fichier n'est pas vide, vérifie que le fichier est comforme et joue si il trouve un coup
        try {
            col = sc_f.nextInt();
            row = sc_f.nextInt();
            plat = new Plateau(col,row);
            while(sc_f.hasNext()) {
                r = sc_f.nextInt();
                c = sc_f.nextInt();
                Coup coup = new Coup(r,c);
                Coup[] cont = new Coup[row];
                for (int i = 0; i<row; i++){
                    r = sc_f.nextInt();
                    c = sc_f.nextInt();
                    cont[i] = new Coup(r, c);
                }
                pil_futur.push(new Element_pile_histo(coup,cont));
            }
        }catch (Exception E) {
            System.out.println(fichier + " isn't a save file");
            return null;
        }

        while(!pil_futur.empty()){
            reculer();
        }
        sc_f.close();
        return plat;
    }
}