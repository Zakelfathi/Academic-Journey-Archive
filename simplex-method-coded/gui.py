from PyQt5.QtWidgets import QApplication, QMainWindow, QWidget, QTableWidget, QTableWidgetItem, QMessageBox
from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import QVBoxLayout,QLabel,QComboBox,QPushButton,QHBoxLayout,QSizePolicy
from PyQt5 import QtGui
import sympy
import numpy as np
import warnings
import re
from functools import wraps
from collections import defaultdict
import win32com.client as win32


warnings.filterwarnings("ignore", category=RuntimeWarning)
M = sympy.Symbol('M', positive=True)
HEADER_SPACE=20

class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow,self).__init__()
        self.setWindowTitle("interface Simplex ENSA-khouribga")
        self.setWindowIcon(QtGui.QIcon('./materials/ensakh.png'))

        self.CONSTRAINT_EQUALITY_SIGNS = [u"\u2264", u"\u2265", "="]#vous pouvez choisir soit <=,>=,= pour la contrainte
        self.new_widgets = []#liste pour garder une trace de tous les nouveaux widgets créés (comme ceux pour montrer l'itération afin qu'ils puissent être facilement supprimés
        #lorsqu'un nouveau problème est donné

        self.ui_creation_fxn()
        self.set_ui_layout()

        self.setFixedWidth(self.sizeHint().width()+1000)
        self.setWindowFlags(Qt.WindowCloseButtonHint|Qt.WindowMinimizeButtonHint)

    def ui_creation_fxn(self):
        self.objective_function_label = QLabel("fonction objectif", self)
        self.objective_function_label.setStyleSheet('background-color :#dad873; font-size: 20px; ')
        # self.objective_function_label.setFixedHeight(self.objective_function_label.sizeHint().height())
        self.table_fxn_objectif = self.create_table(1, 4, ["="], self.create_header_labels(2))

        z_item = QTableWidgetItem("Z")
        self.table_fxn_objectif.setItem(0, 3, z_item)
        z_item.setFlags(Qt.ItemIsEnabled)

        #faites en sorte que la taille de la table objectif fxn corresponde parfaitement aux lignes
        self.table_fxn_objectif.setSizePolicy(QSizePolicy.Minimum,QSizePolicy.Minimum)
        self.table_fxn_objectif.setVerticalScrollBarPolicy(Qt.ScrollBarAlwaysOff)
        self.table_fxn_objectif.resizeColumnsToContents()
        self.table_fxn_objectif.setFixedHeight(self.table_fxn_objectif.verticalHeader().length()+self.table_fxn_objectif.horizontalHeader().height())

        self.contraintes_label = QLabel("Contraintes", self)
        self.contraintes_label.setFixedHeight(self.contraintes_label.sizeHint().height())
        self.contraintes_label.setStyleSheet('background-color :#dad873; font-size: 20px;')

        self.constraint_table = self.create_table(2, 4, self.CONSTRAINT_EQUALITY_SIGNS, self.create_header_labels(2))
        self.constraint_table.setFixedHeight(self.constraint_table.sizeHint().height())

        self.resulats_label = QLabel()

        self.ajouter_ligne_btn = QPushButton('Ajouter ligne', self)
        self.ajouter_ligne_btn.clicked.connect(self.ajouter_ligne_event)
        self.ajouter_ligne_btn.setStyleSheet('background-color : #454d66; color : #efeeb4')
        # self.ajouter_ligne_btn.setFixedSize(150, 60)
        self.ajouter_ligne_btn.setDown(True)
        

        self.ajouter_col_btn = QPushButton('Ajouter colonne', self)
        self.ajouter_col_btn.clicked.connect(self.ajouter_col_event)
        self.ajouter_col_btn.setStyleSheet('background-color : #454d66; color : #efeeb4')
        # self.ajouter_col_btn.setFixedSize(150, 60)
        self.ajouter_col_btn.setDown(True)

        self.supp_ligne_btn = QPushButton("supprimer ligne", self)
        self.supp_ligne_btn.clicked.connect(self.supp_ligne_event)
        self.supp_ligne_btn.setStyleSheet('background-color : #454d66; color : #efeeb4')
        # self.supp_ligne_btn.setFixedSize(150, 60)
        self.supp_ligne_btn.setDown(True)
        
        self.supp_col_btn = QPushButton("supprimer colonne", self)
        self.supp_col_btn.clicked.connect(self.supp_col_event)
        self.supp_col_btn.setStyleSheet('background-color : #454d66; color : #efeeb4')
        # self.supp_col_btn.setFixedSize(150, 60)
        self.supp_col_btn.setDown(True)

        self.solve_btn = QPushButton('resoudre', self)
        self.solve_btn.clicked.connect(self.solve_event)
        self.solve_btn.setStyleSheet('background-color : #454d66; color : #efeeb4')
        # self.solve_btn.setFixedSize(150, 60)
        self.solve_btn.setDown(True)

        self.export_btn = QPushButton("exporter en excel", self)
        self.export_btn.clicked.connect(self.exportPDF)
        self.export_btn.setStyleSheet('background-color : #454d66; color : #efeeb4')
        # self.export_btn.setFixedSize(150, 60)
        self.export_btn.setDown(True)


        self.operation_combo = QComboBox()
        for item in ["Maximize", "Minimize"]:
            self.operation_combo.addItem(item)
        self.operation_combo.setStyleSheet("QComboBox { background-color: #454d66; color : #efeeb4 }")
        # self.operation_combo.setFixedSize(150, 60)

    def set_ui_layout(self):
        vbox_layout1 = QHBoxLayout(self)
        self.vbox_layout2 = QVBoxLayout(self)

        vbox_layout1.addWidget(self.ajouter_ligne_btn)
        vbox_layout1.addWidget(self.ajouter_col_btn)
        vbox_layout1.addWidget(self.supp_ligne_btn)
        vbox_layout1.addWidget(self.supp_col_btn)
        vbox_layout1.addWidget(self.operation_combo)
        vbox_layout1.addWidget(self.solve_btn)
        vbox_layout1.addWidget(self.export_btn)

        central_widget = QWidget(self)
        self.setCentralWidget(central_widget)

        main_v_layout = QVBoxLayout(self)
        central_widget.setLayout(main_v_layout)

        self.vbox_layout2.addWidget(self.objective_function_label)
        self.vbox_layout2.addWidget(self.table_fxn_objectif)
        self.vbox_layout2.addWidget(self.contraintes_label)
        self.vbox_layout2.addWidget(self.constraint_table)
        self.vbox_layout2.addWidget(self.resulats_label)

        
        main_v_layout.addLayout(self.vbox_layout2)

        main_v_layout.addLayout(vbox_layout1)

        # méthode d'exportation pdf    def exportPDF(self):
    def exportPDF(self):
        table = QTableWidget(self)
        # Faire le redimensionnement des colonnes par contenu        table.resizeColumnsToContents()
        table.resizeRowsToContents()

        xlApp = win32.Dispatch('Excel.Application')
        xlApp.Visible = True

        # créer un nouveau classeur excel
        wb = xlApp.Workbooks.Add()

        # créer une nouvelle feuille de calcul excel
        ws = wb.worksheets.add
        ws.name = 'Excel Dummy Data'

        rows = []
        columnHeaders = []

        # récupérer le libellé des colonnes
        for j in range(self.table.model().columnCount()):
            columnHeaders.append(self.table.horizontalHeaderItem(j).text())

        # récupérer le contenu du tableau
        for row in range(self.table.rowCount()):
            record = []
            for col in range(self.table.columnCount()):
                record.append(self.table.item(row, col).text())
            rows.append(record)

        # insérer le contenu du tableau dans Excel
        ws.Range(
            ws.cells(2, 1),
            ws.cells(len(rows)+1, len(columnHeaders))
        ).value = rows

        # insérer des étiquettes de colonne vers Excel
        ws.Range(
            ws.cells(1, 1),
            ws.cells(1, len(columnHeaders))
        ).value = columnHeaders

    
    M=sympy.Symbol('M', positive=True)

    basis_variables = [] #détient toutes les variables de base

    basis_variable_column=[] #contient la colonne de la variable de base dans la matrice d'augmentation
    #la matrice d'augmentation est la partie du tableau qui ne contient que des variables d'écart et artificielles
    #la matrice d'augmentation est ensuite jointe à la matrice d'origine pour former le tableau
    def get_columns_to_add(self, constraint_equality_signs):
        """determine the size of the augment matrix ie how many columns will be 
        needed for all the slack and artificial variables that are going to be introduced
        """
        columns_to_add=0 #la colonne initiale à ajouter est définie sur zéro
        #parcourir les signes d'égalité de contrainte, s'il s'agit d'un signe <=, une variable d'écart sera
        #introduced alors ajoutez une variable pour le slack. Si c'est un signe >=, un surplus et artificiel
        #variable sera introduite donc ajoutez deux colonnes pour les variables excédentaires et artificielles
        #si c'est un signe égal à, une variable d'écart et artificielle sera introduite, donc ajoutez également deux
        #Colonnes
        for equality_symbol_index in range(len(constraint_equality_signs)):
            if constraint_equality_signs[equality_symbol_index] == u"\u2264": #<=
                #ajouter une variable d'écart
                columns_to_add+=1
                
            elif constraint_equality_signs[equality_symbol_index] == u"\u2265": # >=
                #ajouter une variable d'écart et une variable artificielle
                columns_to_add+=2
            
            else:#si c'est un signe égal à
                columns_to_add+=1

        return columns_to_add

    def  get_matrice_augmentee(self,constraint_equality_signs,cmd="maximize"):
        """
        obtient la matrice d'augmentation qui est la matrice d'augmentation est la partie du tableau qui ne contient que du mou et
        variables artificielles la matrice d'augmentation est ensuite jointe à la matrice d'origine pour former le tableau.
        Remarque : Deux lignes seront ajoutées dans la fonction get_tableau pour contenir les valeurs zj et cj-zj
        """
        columns_to_add=self.get_columns_to_add(constraint_equality_signs)
        numof_rows_augment_matrix=len(constraint_equality_signs)+1 #+1à cause de l'objectif fxn
        augment_matrix = np.zeros((numof_rows_augment_matrix,columns_to_add), dtype=sympy.Symbol)
        #l'objectif fxn occupera la première colonne de la matrice augmentée       
        introduced_variable_index=0#stocke le numéro de colonne que le mou introduit, artificiel ou
        #la variable excédentaire possédera dans la matrice augmentée
        #itérer à travers les signes d'égalité des contraintes, si c'est <= ajouter un écart, si c'est
        #>= soustraire un surplus et ajouter une variable artificielle multipliée par -M. Si c'est =,
        #introduire un mou et le multiplier par M
        
        for equality_symbol_index in range(len(constraint_equality_signs)):
            if constraint_equality_signs[equality_symbol_index] == u"\u2264":
                #ajouter une variable d'écart

                augment_matrix[equality_symbol_index+1,introduced_variable_index]=1
                introduced_variable_index+=1
                basis_variable_column.append(introduced_variable_index)
                
            elif constraint_equality_signs[equality_symbol_index] == u"\u2265":
                #soustraire une variable excédentaire et ajouter/soustraire une variable artificielle
                #soustraire une variable de surplus

                augment_matrix[equality_symbol_index+1,introduced_variable_index]=-1
                introduced_variable_index+=1
                if cmd == "maximize":
                    #soustraire une variable artificielle si c'est un problème de maximisation

                    augment_matrix[0,introduced_variable_index]=-1*M
                else:
                    #ajouter une variable artificielle si c'est un problème de minimisation

                    augment_matrix[0,introduced_variable_index]=1*M
                    
                augment_matrix[equality_symbol_index+1,introduced_variable_index]=1
                introduced_variable_index+=1
                basis_variable_column.append(introduced_variable_index)
            
            else:
                #si la contrainte est une égalité, soustraire la variable artificielle si sa maximisation et
                #ajouter une variable artificielle si sa minimisation
                if cmd == "maximize":
                    augment_matrix[0,introduced_variable_index]=-1*M
                else:
                    augment_matrix[0,introduced_variable_index]=1*M
                    
                augment_matrix[equality_symbol_index+1,introduced_variable_index]=1
                introduced_variable_index+=1
                basis_variable_column.append(introduced_variable_index)
        return augment_matrix


    M = sympy.Symbol('M', positive=True)
    LARGE_VALUE=99999999

    def get_expression_comparable(self,value):
        """REMARQUE : puisque nous ne pouvons pas vérifier directement si une expression telle que 2M+1 est supérieure
        que de dire 2, nous devons substituer une valeur dans M puis comparer et récupérer notre original
        expression. get_expression_comparable substitue un grand nombre dans M afin qu'il puisse
        être comparée à une autre valeur en termes de savoir si elle est supérieure à etc.
        """
        
        if type(value) == np.float64 or type(value)==int or type(value)==float:
                comparable_value=value
        else:
            comparable_value=value.subs({M:self.LARGE_VALUE})  
            
        return comparable_value

    def get_nbr_positif_max(self,row):
        #Assurer que la première ligne du tableau ne contient que des variables non basiques et basiques
        # en supprimant la valeur RHS (dernier élément) et le coefficient de Z (premier élément)
        #row = row[1 :]#supprimer le premier élément de la ligne

        coeffs_of_basic_and_non_basic_variables= row[1:]#supprimer le premier élément de la ligne
        
        #itérer dans la première ligne et trouver le nombre négatif maximum
        current_max_pos_num=0 #définir le nombre négatif maximal initial sur zéro afin qu'il puisse être remplacé
        for coeff in coeffs_of_basic_and_non_basic_variables:
            #stocker les expressions d'origine

            original_value_of_coeff=coeff
            original_value_of_current_max_pos_num=current_max_pos_num
            
            #vérifier si le coeff est un entier ou un flottant. Si c'est le cas, laissez-le tel quel
            # c'est ou bien c'est une expression de M alors substituez-y une grande valeur

            coeff=self.get_expression_comparable(coeff)
            
            #vérifier si le nombre négatif maximal actuel est un entier ou un flottant. Si c'est le cas,
            #laissez-le tel quel ou bien c'est une expression de M donc substituez-lui une grande valeur
            current_max_pos_num =self.get_expression_comparable(current_max_pos_num)
            
            #comparez le coeff au nombre négatif maximum actuel pour voir lequel est le plus négatif
            # et définissez le nombre négatif maximum actuel sur l'original le plus négatif
            #expression (défini sur l'expression d'origine pour récupérer toute expression de M après
            # substitution)
            if coeff > current_max_pos_num:
                current_max_pos_num = original_value_of_coeff
            else:
                current_max_pos_num=original_value_of_current_max_pos_num
                
        return current_max_pos_num

    def calculer_Zj(self,tableau,basis):
        #supprimer la fonction objectif
        constraint_tableau = np.delete(tableau,0,0)
        #supprimer cj-zj et zj
        constraint_tableau = np.delete(constraint_tableau,-1,0)
        constraint_tableau = np.delete(constraint_tableau,-1,0)
        
        numof_constraint_tableau_rows,numof_constraint_tableau_columns = constraint_tableau.shape
        zj_row = np.zeros((1,numof_constraint_tableau_columns), dtype=sympy.Symbol)
        
        for i in range(numof_constraint_tableau_rows):
            zj_row = zj_row + basis[i]*constraint_tableau[i]
        
        tableau[-2]=zj_row
        
        return zj_row

    def calculer_Cj_Zj(self,tableau,basis,cmd="maximize"):
        #supprimer la fonction objectif

        zj=self.calculer_Zj(tableau,basis)
        objective_function = tableau[0]
        if cmd=="maximize":
            cj_zj = objective_function - zj
        else:
            cj_zj = zj-objective_function
        tableau[-1]=cj_zj 
        
        return cj_zj

    def get_plusGrand_Cj_Zj_fxn(self,tableau):
        cj_zj_row = tableau[-1]
        #hir = taux d'augmentation le plus élevé

        hir= self.get_nbr_positif_max(cj_zj_row )
        return hir

    #déterminer la colonne pivot
    def get_index_pivot_col(self,tableau):
        cj_zj_row =tableau[-1] #converti en liste car numpy n'a pas de propriété d'index
        #hir = taux d'augmentation le plus élevé
        hir= self.get_nbr_positif_max(cj_zj_row )
        pivot_col_index = list(cj_zj_row).index(hir)
        return pivot_col_index

    def get_index_pivot_ligne(self,tableau,pivot_col):
        """Now that we have the pivot column, how do we determine the pivot row?
        Divide each row's Right Hand Side column by corresponding pivot value in column
        Find out which row has the minimum non negative number and return that row
        """
        nonneg_nums_after_RHS_division=[]
        
        #supprimer la fonction objectif
        constraint_tableau = np.delete(tableau,0,0)
        #supprimer cj-zj et zj
        constraint_tableau = np.delete(constraint_tableau,-1,0)
        constraint_tableau = np.delete(constraint_tableau,-1,0)
        
        #obtenir la ligne et l'index du tableau
        last_row_on_constraint_tableau_index,last_col_on_constraint_tableau_index=constraint_tableau.shape
        first_col_on_constraint_tableau_index=0#soustrayez 1 pour obtenir l'index correct puisque la numérotation des tableaux commence à zéro
        
        #itérer dans la table en effectuant num_in_bi_on_row_i/numinpivotcol_on_row_i et
        #stocker la sortie de tous les nombres non négatifs dans une liste puisque nous voulons un nombre minimum non négatif
        for i in range(last_row_on_constraint_tableau_index):
            num_in_bi_on_row_i=constraint_tableau[i,first_col_on_constraint_tableau_index]
            orig_num_in_bi_on_row_i = num_in_bi_on_row_i
            num_in_bi_on_row_i=self.get_expression_comparable(num_in_bi_on_row_i)
            
            numinpivotcol_on_row_i = constraint_tableau[i,pivot_col]
            orig_numinpivotcol_on_row_i = numinpivotcol_on_row_i 
            numinpivotcol_on_row_i = self.get_expression_comparable(numinpivotcol_on_row_i )
            try:
                num_after_pivot_div = num_in_bi_on_row_i/numinpivotcol_on_row_i
            except ZeroDivisionError:
                continue
            #si num est positif, ajouter aux nombres non négatifs après la division pivot
            if num_after_pivot_div > 0:
                num_in_bi_on_row_i = orig_num_in_bi_on_row_i  
                numinpivotcol_on_row_i = orig_numinpivotcol_on_row_i 
                num_after_pivot_div = num_in_bi_on_row_i/numinpivotcol_on_row_i
                
                nonneg_nums_after_RHS_division.append(num_after_pivot_div)
        
        #déterminer le minimum non négatif à partir de la liste des nombres non négatifs stockés
        try:
            min_non_neg_num=min(nonneg_nums_after_RHS_division)
        except ValueError:
            return None

        #itérer à nouveau pour trouver la ligne du nombre minimum non négatif en effectuant
        #num_in_bi_on_row_i/numinpivotcol_on_row_i pour voir quelle ligne nous donnera le minimum
        # nombre non négatif que nous venons de déterminer. Quand vous le trouvez, retournez-le
        for i in range(last_row_on_constraint_tableau_index):
            num_in_bi_on_row_i=constraint_tableau[i,first_col_on_constraint_tableau_index]
            numinpivotcol_on_row_i = constraint_tableau[i,pivot_col]
            try:
                num_after_pivot_div = num_in_bi_on_row_i/numinpivotcol_on_row_i
            except ZeroDivisionError:
                continue
            #si num est positif, ajouter aux nombres non négatifs après la division pivot
            if num_after_pivot_div == min_non_neg_num :
                min_non_neg_num_row_index = i+1#1 est ajouté car nous avons supprimé l'objectif fxn
                #qui a fait diminuer son index dans le tableau d'origine
                break
            
        return min_non_neg_num_row_index

    def get_nv_pivot_ligne(self,tableau,pivot_row_index,pivot_col_index):
        pivot_row = tableau[pivot_row_index]
        pivot_num = tableau[pivot_row_index, pivot_col_index]
        new_pivot_row = pivot_row/pivot_num 
        
        return new_pivot_row

    #effectuer une élimination gaussienne sur les lignes
    def get_nv_lignes(self,tableau,basis,all_variables, basic_variables,pivot_row_index,pivot_col_index):
        new_pivot_row = self.get_nv_pivot_ligne(tableau,pivot_row_index,pivot_col_index)
        obj_fxn=tableau[0]
        #supprimer la fonction objectif
        constraint_tableau = np.delete(tableau,0,0)
        #supprimer cj-zj et zj
        constraint_tableau = np.delete(constraint_tableau,-1,0)
        constraint_tableau = np.delete(constraint_tableau,-1,0)
        last_row_on_tableau_index,last_col_on_tableau_index=constraint_tableau.shape
        last_col_on_tableau_index-=1#soustraire 1 puisque la numérotation des tableaux commence à zéro
        #saisir une variable de base entrante et supprimer une variable de base sortante
        #basic_variables[pivot_row_index] = all_variables[pivot_col_index ]
        
        #saisir une variable de base entrante et supprimer une variable de base sortante
        basic_variables[pivot_row_index-1] = all_variables[pivot_col_index ]
        #soustrayez 1 car la ligne de base n'inclut pas la ligne objectif fxn
        basis[pivot_row_index-1]=obj_fxn[pivot_col_index]
        
        for i in range(1,last_row_on_tableau_index+1):
            row_to_be_changed = tableau[i]
            num_in_pivot_col_for_row_i = tableau[i,pivot_col_index]
            #multipliez le négatif de num_in_pivot_col_for_row_i par pivot_num et ajoutez
            #idea : assurez-vous que les coefficients de pivot num dans d'autres endroits à part
            #du pivot col sont nuls
            gauss_pivot_row = num_in_pivot_col_for_row_i*-1*new_pivot_row
            new_row = gauss_pivot_row + row_to_be_changed
            #remplacer l'ancienne ligne du tableau par sa nouvelle ligne correspondante
            tableau[i]=new_row
        
        #l'exécution d'une élimination gaussienne définit tous les numéros de ligne de pivot sur zéro
        #par conséquent, nous devons le remplacer par la nouvelle ligne de pivot
        tableau[pivot_row_index]=new_pivot_row 
        return tableau

    def affiche_results_var_val(self,final_tableau, basic_variables):
        answer_variable_and_values=" "
        for i in range(len(basic_variables)):
            #1est ajouté à i car la première ligne contient la fonction objectif
            print(basic_variables[i],"=",final_tableau[i+1][0])
            answer_variable_and_values += basic_variables[i]+"= "+str(final_tableau[i+1][0]) + "    "
        #print("Z = ", final_tableau[-2][0])
        answer_variable_and_values+="Z= "+str(final_tableau[-2][0])
        return answer_variable_and_values



    def get_tableau(self, orig_matrix,augment_matrix):
        #augment_matrix =  get_matrice_augmentee(constraint_equality_signs)
        tableau=np.concatenate((np.array(orig_matrix), augment_matrix),axis=1)

        #ajouter deux lignes vides pour contenir les valeurs zj et cj-zj
        numof_tableau_rows,numof_tableau_cols = tableau.shape
        two_empty_rows = np.zeros((2,numof_tableau_cols), dtype=sympy.Symbol)
        tableau=np.concatenate((tableau,two_empty_rows),axis=0)
        
        return tableau

    def get_var_non_base(self,orig_matrix):
        """
        obtient les variables non basiques dans une liste telle que [x1,x2]
        """
        non_basis_variables=[]
        orig_matrix = np.array(orig_matrix)
        orig_matrix_rows,orig_matrix_cols = orig_matrix.shape
        for i in range(orig_matrix_cols-1):
            non_basis_variables.append(str("x"+str(i+1)))
        return non_basis_variables

    def get_var_ajoutees(self, augment_matrix):
        """
        obtient si une variable ajoutée était une variable lâche ou artificielle
        et le renvoie sous forme de liste telle que [s1,s2,a1,a2]
        """
        first_row = augment_matrix[0]
        ite=1
        added_variables=[]
        artificial_ite=1
        slack_ite = 1
        for i in range(len(first_row)):
            if first_row[i]== -M or first_row[i]== M:
                ite=artificial_ite
                added_variables.append(str("a"+str(ite)))
                artificial_ite+=1
            else: 
                ite=slack_ite
                added_variables.append(str("s"+str(ite)))
                slack_ite+=1
        
        return added_variables

    def get_var_toutes(self,orig_matrix,added_variables):
        #ajoutez d'abord la colonne bi avant d'ajouter les colonnes pour les autres variables
        all_variables =["bi"]
        non_basis_variables=self.get_var_non_base(orig_matrix)
        all_variables+=non_basis_variables
        all_variables+=added_variables
        return all_variables

    def get_var_bases(self, added_variables):
        basis_variables=[]
        for i in range(len(basis_variable_column)):
            basis_variables.append(added_variables[basis_variable_column[i]-1])
        return basis_variables

    def get_bi_values(self,basis_variables,all_variables,tableau):
        cj_value = tableau[0]
        bi_values=[]
        for basis_variable in basis_variables:
            bi_index = all_variables.index(basis_variable)
            bi_value = cj_value[bi_index]
            bi_values.append(bi_value)
        return bi_values
            
    def clear_basis_variable_column(self):
        global basis_variable_column
        basis_variable_column=[]

    def create_table(self, rows, cols,equality_signs=None, horizontal_headers=None,vertical_headers=None):
        table = QTableWidget(self)
        table.setColumnCount(cols)
        table.setRowCount(rows)

        # Définir les en-têtes de tableau
        if horizontal_headers:
            table.setHorizontalHeaderLabels(horizontal_headers)

        if vertical_headers:
            table.setVerticalHeaderLabels(vertical_headers)

        #add <=,>=,= signes afin que la personne puisse choisir si cette contrainte est <=,>= ou =
        #il est également utilisé pour l'objectif fxn mais dans l'objectif fxn nous utilisons simplement = Z donc un signe [=] est passé
        #pour les signes d'égalité dans la création de la table objectif fxn dans la fonction ui_creation_fxn
        if equality_signs:
            numofrows = table.rowCount()
            numofcols = table.columnCount()
            # ajouter des éléments combinés à self.constraint_table
            for index in range(numofrows):
                equality_signs_combo = QComboBox()
                equality_signs_combo.setStyleSheet('background-color : #454d66; color : #efeeb4 ')

                for item in equality_signs:
                    equality_signs_combo.addItem(item)
                table.setCellWidget(index, numofcols - 2, equality_signs_combo)

        # Faire le redimensionnement des colonnes par contenu
        table.resizeColumnsToContents()
        table.resizeRowsToContents()

        return table

    def create_header_labels(self,num_of_variables):
        """Nommez les colonnes pour les tableaux x1,x2,.... donnez un espace puis ajoutez bi"""
        header_labels = [" "*HEADER_SPACE +"x" + str(i + 1) + " " * HEADER_SPACE for i in range(num_of_variables)]
        header_labels.extend([" " * HEADER_SPACE, " " * HEADER_SPACE + "bi" + " " * HEADER_SPACE])
        return header_labels

    def supp_ligne_event(self):
        #autoriser un maximum d'une contrainte
        if self.constraint_table.rowCount()>1:
            self.constraint_table.removeRow(self.constraint_table.rowCount()-1)

    def supp_col_event(self):
        #si nous avons x1,x2 et que les signes et la colonne bi ne permettent pas la suppression de la colonne, sinon supprimez
        if self.constraint_table.columnCount()>4:
            self.constraint_table.removeColumn(self.constraint_table.columnCount()-3)
            self.table_fxn_objectif.removeColumn(self.table_fxn_objectif.columnCount()-3)

    def ajouter_col_event(self):
        self.constraint_table.insertColumn(self.constraint_table.columnCount()-2)
        self.table_fxn_objectif.insertColumn(self.table_fxn_objectif.columnCount()-2)
        self.constraint_table.setHorizontalHeaderLabels(self.create_header_labels(self.constraint_table.columnCount()-2))
        self.table_fxn_objectif.setHorizontalHeaderLabels(self.create_header_labels(self.constraint_table.columnCount()-2))

        # faire en sorte que la taille de la table objective fxn corresponde parfaitement aux lignes et aux colonnes
        self.table_fxn_objectif.setSizePolicy(QSizePolicy.Minimum, QSizePolicy.Minimum)
        self.table_fxn_objectif.setVerticalScrollBarPolicy(Qt.ScrollBarAlwaysOff)
        self.table_fxn_objectif.setFixedHeight(self.table_fxn_objectif.verticalHeader().length() + self.table_fxn_objectif.horizontalHeader().height())

    def ajouter_ligne_event(self):
        self.constraint_table.insertRow(self.constraint_table.rowCount())
        equality_signs_combo = QComboBox()
        equality_signs_combo.setStyleSheet('background-color : #454d66; color : #efeeb4')

        for item in self.CONSTRAINT_EQUALITY_SIGNS:
            equality_signs_combo.addItem(item)
        self.constraint_table.setCellWidget(self.constraint_table.rowCount()-1,self.constraint_table.columnCount() - 2, equality_signs_combo)
        self.constraint_table.resizeRowsToContents()


    def solve_event(self):
        #supprimer tous les nouveaux widgets créés lors de la résolution d'un problème, comme le tableau des itérations
        for item in self.new_widgets:
            item.setParent(None)
            item.deleteLater()

        self.new_widgets=[]
        self.clear_basis_variable_column()
        vertical_header=[]

        #obtenir tous les signes de contrainte de la table de contraintes tels que >= etc dans une liste
        constraint_equality_signs=self.read_equality_signs(self.constraint_table.columnCount()-2, self.constraint_table)
        #obtenir la commande s'il s'agit de maximiser ou de minimiser
        command=self.operation_combo.currentText().lower()

        unaugmented_matrix=self.matrice_nonAugmente_former()
        augment_matrix = self. get_matrice_augmentee(constraint_equality_signs, command)

        tableau = self.get_tableau(unaugmented_matrix, augment_matrix)
        #les variables ajoutées sont de nouvelles introduites telles que les variables d'écart et artificielles
        added_variables = self.get_var_ajoutees(augment_matrix)
        #toutes les variables sont d'origine x1,x2,etc en plus des variables ajoutées
        all_variables = self.get_var_toutes(unaugmented_matrix, added_variables)

        basis_variables = self.get_var_bases(added_variables)
        basis = self.get_bi_values(basis_variables, all_variables, tableau)

        self.calculer_Zj(tableau, basis)
        self.calculer_Cj_Zj(tableau, basis, command)

        #en-tête pour les variables de base, zj et cj-zj
        vertical_header.append("cj       ")
        vertical_header.extend(basis_variables)
        vertical_header.append("zj")
        if command.lower()=="minimize":
            vertical_header.append("zj-cj")
        else:
            vertical_header.append("cj-zj")

        spaced_all_variables = [" " * HEADER_SPACE + item + " " * HEADER_SPACE for item in all_variables]
        gui_tableau = self.creer_gui_table(tableau,spaced_all_variables,basis_variables)
        current_row,current_col=tableau.shape
        self.vbox_layout2.addWidget(gui_tableau)
        gui_tableau.setStyleSheet("border: 2px solid green;")

        #ajouter le tableau gui aux nouveaux widgets afin qu'il puisse être supprimé lorsque nous résolvons un nouveau problème
        self.new_widgets.append(gui_tableau)

        hir = self.get_plusGrand_Cj_Zj_fxn(tableau)
        hir = self.get_expression_comparable(hir)

        while hir > 0:  # tant que hir > 0, nous pouvons augmenter notre valeur z
            pivot_col_index = self.get_index_pivot_col(tableau)
            pivot_row_index = self.get_index_pivot_ligne(tableau, pivot_col_index)
            if pivot_row_index:
                self.get_nv_lignes(tableau, basis, all_variables, basis_variables, pivot_row_index, pivot_col_index)
                self.calculer_Zj(tableau, basis)
                self.calculer_Cj_Zj(tableau, basis, command)

                hir = self.get_plusGrand_Cj_Zj_fxn(tableau)

                hir = self.get_expression_comparable(hir)

                vertical_header.append("cj")
                vertical_header.extend(basis_variables)
                vertical_header.append("zj")
                if command.lower() == "minimize":
                    vertical_header.append("zj-cj")
                else:
                    vertical_header.append("cj-zj")
                self.update_gui_tableau(tableau, gui_tableau,current_row,vertical_header)
                current_row, current_col = tableau.shape
                current_row+= current_row

                self.resulats_label.setText(self.affiche_results_var_val(tableau, basis_variables))
                self.resulats_label.setStyleSheet("background-color:#CF0A0A")

            else:
                w = QWidget()
                QMessageBox.warning(w, "Warning","Le problème est sans limite. Vérifier la formulation du problème. Afficher uniquement les itérations.")
                self.resulats_label.setText(" ")
                break

    def matrice_nonAugmente_former(self):
        obj_fxn = self.get_obj_fxn()
        split1_of_constraints = self.read_table_items(self.constraint_table, 0, self.constraint_table.rowCount(), 0,
                                                      self.constraint_table.columnCount() - 2)
        split2_of_constraints = self.read_table_items(self.constraint_table, 0, self.constraint_table.rowCount(),
                                                      self.constraint_table.columnCount() - 1,
                                                      self.constraint_table.columnCount())
        unaugmented_matrix_without_obj_fxn = np.concatenate((np.array(split2_of_constraints), split1_of_constraints),
                                                            axis=1)
        unaugmented_matrix = np.vstack((obj_fxn, unaugmented_matrix_without_obj_fxn))
        return unaugmented_matrix

    def read_table_items(self,table,start_row,end_row,start_col, end_col):
        read_table = np.zeros((end_row-start_row, end_col-start_col),dtype=sympy.Symbol)
        for i in range(start_row,end_row):
            for j in range(start_col,end_col):
                read_table[i-end_row][j-end_col] = float(table.item(i, j).text())

        return read_table

    def read_equality_signs(self,equality_signs_column,table):
        equality_signs=[]
        for i in range(table.rowCount()):
            equality_signs.append(table.cellWidget(i, equality_signs_column).currentText())
        return equality_signs

    def populatetable(self,table, mylist, start_row, end_row, start_col, end_col):
        for i in range(start_row, end_row):
            for j in range(start_col, end_col):
                table.setItem(i, j, QTableWidgetItem(str(mylist[i - end_row][j - end_col])))
        table.resizeColumnsToContents()

    def get_obj_fxn(self):
        obj_fxn_coeff=self.read_table_items(self.table_fxn_objectif, 0,self.table_fxn_objectif.rowCount(), 0, self.table_fxn_objectif.columnCount()-2)
        obj_fxn = np.insert(obj_fxn_coeff,0,0)
        return obj_fxn

    def creer_gui_table(self,tableau,all_variables,vertical_headers):
        rows,cols=tableau.shape
        gui_tableau=self.create_table(rows, cols, equality_signs=None,horizontal_headers=all_variables,vertical_headers=vertical_headers)
        self.populatetable(gui_tableau, tableau, 0,rows, 0, cols)
        gui_tableau.setStyleSheet("background-color:#d7c7ad")
        return gui_tableau

    def update_gui_tableau(self,tableau,gui_tableau,current_row,vertical_headers):
        #créer de nouvelles lignes et colonnes
        rows, cols = tableau.shape
        for i in range(rows):
            gui_tableau.insertRow(gui_tableau.rowCount())
        self.populatetable(gui_tableau, tableau, current_row, current_row+rows, 0,cols)
        gui_tableau.setVerticalHeaderLabels(vertical_headers)


# fonction principale de test
if __name__ == "__main__":
    import sys
    app = QApplication(sys.argv)
    mw = MainWindow()
    mw.show()
    sys.exit(app.exec())