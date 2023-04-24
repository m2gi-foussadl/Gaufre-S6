package Hist;

import Modele.Coup;
import Modele.Plateau;

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

    // push, pop, peek, empty
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
    public void sauvegarder(){
        while(!pil_passer.empty()){
            pil_passer.pop();
        }
        // vider les coup de la pile futur dans le fichier
    }
    public void charger(){
        // lire et jouer les coup du fichier dans l'ordre
    }

}
