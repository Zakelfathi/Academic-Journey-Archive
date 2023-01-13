/*  CALCULS SUR LES POLYNOMES,*/

//Declaration de bibliotheques
#include <stdio.h>   //  (entrees, sorties,..etc)
#include <stdlib.h>	 
#include<math.h>
#define Degremax 20   // definition d'une constante de nom 'Degremax' 

// Definition d'une structure de deux champs 
typedef struct
{
    int degre; // -1 pour le polynôme nul 
    float coeff[Degremax + 1];   // declaration d'une variable (tableau de de case Degremax ) de type float (reel)
} pol;

// QUESTION 1: une procédure NulPoly renvoyant en paramètre le polynôme nul
void NulPoly(pol *p)  //  le parametre est un pointeur de type 'pol' 
{
	int i;  // variable a utliser comme compteur
	// boucle de remlpissage du tableau
   for(i=0;i<=Degremax; i++){ // boucle debutant de 0 jusqu'a Degremax
    p->degre = -1;   // affectation de -1 comme valeur du degre du polynome nul par convention
    p->coeff[i] = 0; // affectation ou remplissage de la case i par 0;
}
}

// QUSTION 2: procedure permettant d'entrer au clavier le degré et les coefficients d'un polynôme P passé en paramètre.
void SaisiePoly(pol *p)  // procedure de nom 'SaisirePoly' et le parametre est un pointeur de type 'pol' 
{
    int i,n;                                       // declaration de deux variables de nom ' n','i' de type entiers(int)
    printf("ENTRER LE DEGRE DE VOTRE POLYNOME ");  // Affichage du message 'ENTRER LE DEGRE DE VOTRE POLYNOME'
    scanf("%d", &(p->degre));                     // prise d'une valeur de type entier et la stocker dans p->degre 
    n = p->degre + 1;                             // affectation du degre du pointeur a n 
   // disjonction de cas selon n
	if (n == 0)                                  // le cas ou n est nulle                     
    {
        NulPoly(p);                               // affecation du polynome nul a p 
    }
    for ( i = 0; i < n; i++)					// boucle debutant de 0 jusqu'au n et de pas egale a 1 
    {
        printf("saisir le %d coefficient : ", i + 1);  // affichage du message ' saisir le i+1-eme coefficient :' 
        scanf("%f", &(p->coeff[i]));                            // stocker la valeur entrer par l'utilisateur dans le coefficient i
    }
}

// QUESTION 3: Procedure affichant l'expression de P(x), P étant un polynôme donné en paramètre.
void VoirPoly(pol p) // procedure de nom 'VoirPoly' et de parametre p
{
    int n,i;  // variable de type entier 'int' et de nom 'n'                        
    n = p.degre + 1;     //affectation du degre de p a n
    for ( i = n; i > 0; i--) // boucle de i(definition de type entier ) debutant de n jusqu'a la condition soit satisfaite i>0 , en ordre decoissant
    {
        if (p.coeff[n - i] != 0) // test: si le coefficient  numero 'n-i' est different de 0
            if (i != 1)            // deuxieme test de i s'elle est different de 1
            {
                printf("%0.2f*x^%d + ", p.coeff[n - i], i - 1); // affichage du polynome 
            }
            else          // sinon dans le cas echeant 
            {
                printf("%0.2f    ", p.coeff[n - i]); // affichage du message (pour ne pas avoir un plus a la fin du polynome
            }
    }
    printf("\t\n");  // tabulation et retour a la ligne 
}


// QUESTION 4:  la fonction calculant la valeur de P(x), le réel x et le polynôme P étant passés en paramètres
void EvalPoly(float x, pol *p) // procedure de nom 'EvalPoly' et de parametres le reel x et le pointeur p
{
    int n,i;              // declaration de la variale n de type entier
    float racine = 0;  // declaration et initialisation de la variable 'racine de type reel 
    n = p->degre + 1;                                      // affectation de degre de p a n
    printf("le resultat de P(%0.2f) = ", x); // affichage du message 'p(x)' 
    for ( i = 1; i <= n; i++) // boucle de i(initialisation ) =1 jusqu'a la condition i<=n soit verifiee de pas =1 
    {
        racine = racine + pow(x,  i- 1) * p-> coeff[i-1];  // calcul de 'racine' qui est la somme des coefficients multiplier par les puissances de x
    }
    printf("%0.2f", racine); // affichage de la valeur variable racine
}

// QUESTION 5:  procedure calculant la somme de deux polynômes P et Q. 
void AddPoly(pol p1, pol p2, pol *p) // definition de la procedure 'AddPoly' de parametres p1,p2 et pointeur p
{
    int n,i, a; // definition des variables entiers n et a
    p->degre = (p1.degre > p2.degre) ? p1.degre : p2.degre; // affectation a degre de p le degre de p1 si degre p1 est superieur a degre de p2, sinon on affecte le degre de p2
    a = (p1.degre > p2.degre) ? p1.degre - p2.degre : p2.degre - p1.degre; // affectation a a la difference des degre 
    n = p->degre + 1;                                                     // affectation de degre de p a n
    for ( i = 0; i < n; i++) // boucle de debut i=0 (definition), jusaue i<n soit verifier de pas egale a 1
    {
        if (p1.degre > p2.degre) // test: si le degre de p1 est superieure a degre de p2
        {
            p->coeff[i] = p2.coeff[i - a] + p1.coeff[i]; // affectation de la somme de p2 d'indice i-a et celui de p1 d'indice i au coefficient numero i
        }
        else if (p1.degre < p2.degre) // sinon si degre de p1 est superieure a celui de p2
        {
            p->coeff[i] = p2.coeff[i] + p1.coeff[i - a];// affectation de coeffecient numero i en somme de celui de p1 numero i-a au coefficient i de p
        }
        else // dans le cas echeant
        {
            p->coeff[i] = p2.coeff[i] + p1.coeff[i]; // affectation de la somme de coefficient i de p1 et coefficient i de p2 a p   
        }
    }
    printf("\n LA SOMME DE CES DEUX POLYNOME EST  : \n ");  // affichage du message 
    VoirPoly(*p); // appel de la procedure VoirPoly de parametre le pointeur p
}

// QUESTION 6: procedure calculant le produit de deux polynômes P et Q. 
void MultPoly(pol p1, pol p2, pol *p) // declaration de la  procedure de nom 'MultPoly' et de parametres p1, p2 et le pointeur p
{
    int n,i,j, a;// declaration des variables n et a de types entiers
    n = (p->degre) = p1.degre + p2.degre; // affectation de la somme des degres de p1 et p2 a degre de p puis l'affecter a n 
    a = (p1.degre > p2.degre) ? p1.degre : p2.degre; // affectation de degre de p1 a a si ( degre de 1 superieur a celui de p2 ) sinon on affecte le dgre de p2
    for (i = 0; i <= n; i++) // boucle debutant de 0 (i declarer et initialiser) jusqu'a i<=n soit verifier avec un pas de 1
    {
        for (j = 0; j <= i; j++) // // boucle debutant de 0 (j declarer et initialiser) jusqu'a j<=i soit verifier avec un pas de 1 
        {
            p->coeff[i] += (p1.coeff[j] * p2.coeff[i - j]); // sommation des coefficients 
        }
    }
    printf(" \nLE PRODUIT DES DEUX POLYNOMES EST  :\n "); // message d'effichage 
    VoirPoly(*p);           // appel de la procedure avec comme parametre le pointeur p
}

// LA FONCTION Menu pour faciliter l'affichage et le rendre plus lisible
int menu()
{
    int choix;  // declaration de la variable choix de type entier a servir dans la boucle aui suit
	do // boucle de controle de saisie
    {

        printf("\n\ FAIRE UN CHOIX !\n");  // message d'appel a faire un choix
        printf("   1: \tpour la saisie de votre polynome :\n");                         // l'option 1  pour appel a saisie
        printf("   2:  \tPour l'affichage de votre polynome' :\n");                   //  l'option 2 appel a faire une saisie
        printf("   3:   \tPour evaluer votre polynome : \n");                            // l'option 3 pour evaluer 
        printf("   4:    \tPour additionner deux polynome :\n");     // l'option 4 pour additionner les polynomes
        printf("   5:     \tPour multiplier votre polynome \n");                 // l'option 5 pour multiplier les polynome
        printf("   0:      \tPour quitter le programme \n");  // pour quitter le programme
        printf("\n Votre choix :");  
        scanf("%d", &choix);          // prise de la valeur entrer et la stocker dans choix de type entier
		if (choix < 0 || choix > 5)   // si la variable entree est inferieure a 0 ou superieur a 5  
        {
        	system("CLS");
            printf("\n CHOISIR UN NOMBRE COMPRIS ENTRE 0 ET 5\n");
        }
    } while (choix < 0 || choix > 6);// condition de controle de saisie 
}


// LA FONCTION PRINCIPALE
int main()
{
    int choix, choix_pol = 0, stp;   // definition de trois entiers 'choix', 'choix_pol' (initialisee a 0) et 'stp'
    float X; // declaration de la variable 'X' de type reel
    printf("\n WELCOME TO MY PROGRAMME \n");
    pol p = {0, {0}}, p1 = {0, {0}}, p2 = {0, {0}}; // declaration et initialisation de 3 tableaux de type 'pol', p,p1 et p2
    do// controle de saisie 
    {
        if (stp != 0) // si stp est different de 0
        {
            do //controle de saisie
            {
                choix = menu();// affectation du choix de l'utilisateur a la variable 'choix'
                if (choix != 1) // si choix est different de 1
                    printf(" \n\n ENTRER VOTRE POLYNOME \n"); // appel a saisie du polynome
            } while (choix != 1); // condition de controle de saisie 
        }
        stp = 0; //affectation de 0 a stp
       // etude selon les cas de la variable choix
	    switch (choix)
        {
        case 1: // pour choix egale a 1
            printf("SAISIR VOTRE 1ER POLYNOME: \n"); // appel a saisie de p1
            SaisiePoly(&p1);                             // prise de la valeur de p1
            printf("SAISIR VOTRE 2EME POLYNOME : \n"); // appel a saisie de p2
            SaisiePoly(&p2);                                                   // stockage de la valeur dans p2
            break;  // quitter l'iteration
        case 2: // le cas ou choix egale a 2
            printf(" VOTRE POLYNOME \nP1(x) = "); // affichage de message           
            VoirPoly(p1);                                    // affichage de p1 
            printf("\n");             // retour a la ligne
            printf("VOTRE POLYNOME \nP2(x) = "); // affichage du message
            VoirPoly(p2);     //affichage de p2
            break; // quittter l'iteration
        case 3: // cas ou choix =3
            printf("ENTRER LA VALEUR DE X :\n"); // appel a saisie
            scanf("%f", &X); // stocker l'entrer dans X
            printf("\nCHOISIR UN POLYNOM A EVALUER :/n "); // appel a saisie
            scanf("%d", &choix_pol); // prise de valeur entree et la stocker dans choix_pol
            // disjonction de cas selon choix_pol
			if (choix_pol == 1)  // s'elle est egale a 1
                EvalPoly(X, &p1); // evaluation de p1 avec la valeur X
            else if (choix_pol == 2) // s'elle est egale a 2
                EvalPoly(X, &p2); //evaluation de p2 avec la valeur X
            else
                printf("\nERREUR , Saisir une valeur valide\n"); // appel a saisie 

            break;// quitter la boucle
        case 4: // cas ou choix est egale a 4
            AddPoly(p1, p2, &p); // appel a AddPoly avec p1,p2 et pointeur p comme parametres 
            break; // quitter la boucle
        case 5: // cas ou choix est egale a 5
            MultPoly(p1, p2, &p); // appel a MultPoly avec parametres p1,p2 bet le pointeur p2
            break; //quitter la boucle
        }

        choix = menu(); // stocker la valeur de menu a la variable choix
    } while (choix != 0); // condition de controle de saisie
    system ("CLS");
	printf("\n WELL DONE, merci ^^ "); // 
}
