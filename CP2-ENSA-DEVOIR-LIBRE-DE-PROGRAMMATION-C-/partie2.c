#include<stdio.h>  // appel de la bibliotheque (entrees, sortis,..etc)
#include<stdlib.h> // Pour exécuter diverses opérations dont la conversion, la génération de nombres pseudo-aléatoires, l'allocation de mémoire, le contrôle de processus, la gestion de l'environnement et des signaux, la recherche et le tri.
#include<math.h>// appel de la bibliotheque (outils mathematiques de base)

struct point { // declaration d'une structure de nom point 
	char nom ; //1er champ de type caractere 
	float x ; // 2eme champ de type float (reel)
	float y ;//3eme champ de type float (reel)
} ; 
struct vecteur { // declaration de d'une structure de nom vecteur 
	float x ; // 1er champ de type reel
	float y ;//2eme  champ de type float
} ;
typedef struct point  // declaration d'une structure  de nom spt et de champ spt
spt ;
typedef struct vecteur // declaration d'une structure  de nom svect et de champ vecteur  
svect ;

//QUESTION 2 FONCTION qui calcule la distance entre deux points p1 et p2.
float distance (spt p1, spt p2){  // declaration de la fonction de nom 'distance' de paranetre p1 et p2 de types 'spt', la retournee est de type float
	float dist;										 // declaration de 'dist' de type reel
	dist=sqrt(pow((p1.x-p2.x),2)+pow((p1.y-p2.y),2)); //distance entre deux point est la racine carree de la difference elevee au carree de leur abscisses et ordonnees 
	return dist; // la valeur de retour est : dist
}

//  QUESTION 3 FONCTION qui permet de déplacer le point p.
void Deplacer (spt* p, float dx, float dy){ // declaration de la procedure 'Deplacer' de parametres le pointeur de type spt et dx,dy de type float
	(*p).x+=dx; //ajout de dx a l'ascisse
	(*p).y+=dy;	//ajout de dx a l'ordonnee
}

// QUESTION 4 FONCTION qui calcule le produit scalaire de deux vecteurs.
float ProdScal(svect U, svect V){ // declaration de la fonction Prodscal de retournee de type float et de parametres de type svect
	float	abscisse, ordonnee; // declaration de deux variables de type float
	abscisse=U.x*V.x ; //affectation du produit des abscisses a la variable abscisse
	ordonnee=U.y*V.y ; //affectation du produit des ordonnee a la variable ordonnee
	return abscisse+ordonnee; // la valeur de retour est la somme  
}

// QUESTION 5 FONCTION qui retourne 1 si les trois points p1, p2 et p3 sont colinéaires, retourne 0 sinon.
 int Colineaires (spt p1, spt p2, spt p3){ // declaration de la fonction 'Colineaire' de type de retour entier et de parametres de types 'spt'
	float v1x,v2x,v1y,v2y; // definition de 3 variable a servir comme coordonnees des deux vecteurs
	v1x=p1.x-p2.x; // abscisse du premier vecteur 
	v1y=p1.y-p2.y; // ordonnee du 1er vecteur
 	v2x=p1.x-p3.x; // abscisse du deuxieme vecteur
 	v2y=p1.y-p3.y; // ordonnee du 2eme vecteur
 if((v1x*v2y-v2x*v1y)==0) return 1; // si la condition est bien verifier la valeur de retour sera alors 1 
 else return 0;  // sinon la valeur de retour sera 0
 }

// QUESTION 6 FONCTION qui affiche sur l’écran l’équation cartésienne de la droite (p1p2). 
void AfficheEquatCar(spt p1, spt p2) // declaration de la procedure de AfficheEquatCar  de parametres de type 'spt'
{
    float a; // declaration de la variable a de type reel
    float b; // declaration de la variable b de type reel
    float c;//declaration de la variable de c de type reel

    a = p1.y - p2.y; // la difference des ordonnees est stockee dans a
    b = p1.x - p2.x; // la difference des abscisse est stockee dans b
    c = a * (p1.x) + b * (p1.y); // calcul de c a partir de a et b
    printf("l'equation est : "); // affichage
    if (b < 0) // si l'abscisse de p1 est inferieure a celui de p2
    {
	printf("%fx - %fy = %f", a,b,c); // affichage de l'equation
    }
    else
	printf("%fx - %fy = %f", a,b,c); // affichage dans le cas echeant ou b>=0
}



 // QUESTION 7 FONCTION qui retourne 1 si  p1p2p3 est rectangle en un point, elle retourne 0 sinon.
 int triangleRrectangle (spt p1, spt p2, spt p3){ // declaration de la fonction de type de retour 'entier' et de parametres de type 'spt'
	float p1p2,p1p3,p2p3;  // declaration des variables de type reels
	p1p2=sqrt(pow(p1.x-p2.x,2 )+pow(p1.y-p2.y,2 )); // la distance entre p1 et p2
   	p1p3=sqrt(pow(p1.x-p3.x,2 )+pow(p1.y-p3.y,2 )); // la distance entre p1 et p3
 	p2p3=sqrt(pow(p3.x-p2.x,2 )+pow(p3.y-p2.y,2 ));//  la distance entre p2 et p3
	// la ligne suivante permet de tester a partir de la relation de pythagore si le triangle est rectangle
	if(pow(p1p2,2)==pow(p1p3,2)+pow(p2p3,2) || pow(p1p3,2)==pow(p1p2,2)+pow(p2p3,2)|| pow(p2p3,2)==pow(p1p3,2)+pow(p1p2,2) ) return 1; // retour de la valeur 1 si une des proposition est  verifiee
	else return 0; // retour de la valeur 0 dans le cas echeant
 }


// QUESTION 8 FONCTION qui retourne 1 si le triangle p1p2p3 est isocèle, de tête p2 ; elle retourne 0 sinon
 int triangleIsocele (spt p1, spt p2, spt p3){ // declaration de la foction de type de retour entier et de parametres de types spt
 	float p1p2,p2p3; // declaration des variables reels
 	p2p3=sqrt(pow(p3.x-p2.x,2 )+pow(p3.y-p2.y,2 )); // la distance entre p2 et p3
 	p1p2=sqrt(pow(p1.x-p2.x,2 )+pow(p1.y-p2.y,2 )); // la distance entre p1 et p2
 	if(p1p2==p2p3) return 1;// s'il s'agit de meme distance entre p1p2 et p2p3 la valeur de retour sera 1
 	else return 0; // le cas echeant la valeur de retour sera 0
 }
 
 
 // QUESTION 9 : commentaire 
 /* les points necessaires pour reproduire ce schema sont le centre du cercle et r le rayon du cercle circonscrit, donc Z c'est le point X 
 et pour reconstruire  le triangle on a besoin de plus le point E donc le point Q c'est le point E */
 
 
 // QUESTION 10 : la surface du triangle
 float SurfaceGEF (spt Z, spt Q, float r){  // declaration de la fonction 'SurfaceGEF' de type de retour reel et de parametre de type 'spt' et 'float'
  	spt F;   // declaration d'une variable de type 'spt'
  	spt G;     // declaration de type 'spt'
  	float R ; //declaration d'une variable de  type reel
  	float p;  
	  G.y= Z.y; // affectation de l'ordonnee entre(Z) a celle ci de G car ils ont le meme ordonnee 
	  G.x=(Z.x)-sqrt(2)*r; // l'ascisse de G est celui ci de Z moins l'abscisce de une distance egale a (sqrt2 )*r
	  F.x= Q.x; // affectation de l'abscisse de Q a celui de F
	  F.y=(Q.y)+2*sqrt(2)*r;     // affectation a l'ordonnee de F la distance entre E et F plus l'ordonnee de F
  	p=(distance(G,F)*distance(F,Q))/2; 
  	return p; //retour de la valeur de p
  }
 
 // QUESTION 11 : 
void ft_swap(spt *p1, spt *p2); // prototype de la fonction de parametres les pointeurs de type 'spt'
 void trier(spt *tab) // definition de la procedure de parametre un pointeur de type spt
{
    int i; // declaration de la variable de type int 
    float dis,dis2; // declaration de deux reel
    spt  orig; // declaration de la variable 'orig' de type 'spt'
    int j; // declaration de  la variable de type entier

    j = 0; // initialisation de i et j par la valeur 0
    i = 0;
    orig.x = 0;// initialisation de l'abscisse
    orig.y = 0;//  initialisation de l'ordonnee
    while (i < 100)  // introduction d'une boucle parcourant le tableau 
    {
	while (j < 100 -i -1) // boucle parcours du taleau de l'inverse 
	{
	    dis = distance(tab[j], orig);   //calcule de la distance entre l'origine et la j-eme case (point) 
	    dis2 = distance(tab[i+1], orig); // la 2eme distance sera la comparaison avec l'origine aussi mais avec le point de la case qui suit celle en j 
	    if (dis2 > dis)  // test se basant sur la distance entre le point origie et celle de j et j+1
		ft_swap(tab[j], tab[j + 1]); // utilisation de la fonction deja prototypee si la condition est verifiee  
	    j++; // incremetation du compteur 
	}
	i++; // incremetation du compteur
    }
}
void ft_swap(spt *p1, spt *p2)  // cette fonction est l'intermediaire pour echanger les elements du tableau donc ell prend en parametre deux elemet de ce tableau
{
    spt tmp;  // variable temporaire de type spt
    tmp = *p1; 
    *p1 = *p2;
    *p2 = tmp; //element echanges!
}

// QUESTION 12: 



