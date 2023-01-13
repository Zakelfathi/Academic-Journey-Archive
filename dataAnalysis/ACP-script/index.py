# -*- coding: utf-8 -*

'''
import des librairies necessaires
'''
import pandas as pd 
import numpy as np  
import matplotlib.pyplot as plt
import fanalysis.pca as fanal
from sklearn.decomposition import PCA
import time
'''
recuperation des donnees sources
'''


data = pd.read_excel("data.xlsx",sheet_name="Sheet1",index_col=0)
print('lecture des donnees...\n','_'*60)
time.sleep(3)
a = pd.DataFrame(data)
print(a)
print("_"*60)

# moyenne empirique
time.sleep(2)
print('calcule de la moyenne empirique de chacune des variables... ')
time.sleep(3)
d = pd.DataFrame(data)
moyenne = d.mean(axis=0)
moy = np.mean(d.values,axis=0)
moyenne = np.mean(data, axis=0)
for i in moy:
    print(i,'\n')
print("_"*60)

# Tableau X des donnees centrees
time.sleep(2)
print("Generation du Tableau X des donnees centrees...")
time.sleep(3)
tableauCentre = data.values
for i in range(0,2):
	for row in tableauCentre:
		row[i] = row[i] - moyenne.values[i]
a = pd.DataFrame(tableauCentre,index=data.index, columns=data.columns)
print(a)
print("_"*60)


# Matrice de covariance 
time.sleep(2)
print("Generation de la Matrice de covariance ...")
time.sleep(3)
X = tableauCentre - moyenne.values
matriceCov = np.cov(X,ddof=0,rowvar=False) 
a = pd.DataFrame(matriceCov)
print(a)
print("_"*60)

# l’écart type empirique de chacune des variables
time.sleep(2)
print("Generation de l’écart type empirique de chacune des variables ...".encode('utf8').decode('mbcs'))
time.sleep(3)
S = np.std(X,axis=0,ddof=0)
a = pd.DataFrame(S,index=data.columns)
print(a)
print("_"*60)

# Le tableau Z des données centrées réduites
time.sleep(2)
char = "Generation du tableau Z des données centrées réduites ...".encode('utf8').decode('mbcs')
print(char)
time.sleep(3)
Z = X
for i in range(0,2):
	for row in Z:
		row[i] = row[i] / S[i]

a = pd.DataFrame(Z,index=data.index)
print(a)
print("_"*60)

# La matrice de covariance R des données Z
time.sleep(2)
print("Generation de La matrice de covariance R des données Z ...")
time.sleep(3)
matriceCov = np.cov(Z,ddof=0,rowvar=False)
a =pd.DataFrame(matriceCov) 
print(a)
print("_"*60)

# La matrice de correlation des données Z
time.sleep(2)
print("Generation de La matrice de correlation des données Z ...")
time.sleep(3)
matriceCorr = pd.DataFrame(Z, columns=data.columns, index=data.index).corr()
print(matriceCorr)
print("_"*60)


# Les valeurs propres
time.sleep(2)
print("calcul des valeurs propres ...")
time.sleep(3)
valPropres = np.linalg.eigvals(matriceCorr)
a = pd.DataFrame(valPropres,index=["a1","a2","a3"])
print(a)
print("_"*60)

# l’éboulis des valeurs propres
time.sleep(2)
print("generation de l’éboulis des valeurs propres ...".encode('utf8').decode('mbcs'))
time.sleep(3)
plt.plot(np.arange(1,data.shape[1]+1), valPropres)
plt.title("Eboulis des valeurs propres")
plt.ylabel("Valeurs propres")
plt.xlabel("Nombre de composantes principales")
plt.show()
print("_"*60)

# représentation des individus dans l’espace des 2 axes principaux d’inertie
time.sleep(2)
print("generation de la représentation des individus dans l’espace des 2 axes principaux d’inertie ...".encode('utf8').decode('mbcs'))
time.sleep(3)
model_acp = PCA(svd_solver='full')
acpCord = model_acp.fit_transform(Z)
figure = plt.figure(figsize=(12,12)) # définir une figure de taille : 12 x 12
#placement des étiquettes des observations
for i in range(data.shape[0]):
    plt.scatter(acpCord[i,0],acpCord[i,1])
    plt.annotate(data.index[i],(acpCord[i,0],acpCord[i,1]))
#ajout les axes
plt.plot([-3,3],[0,0],color='silver',linestyle='-',linewidth=1)
plt.plot([0,0],[-3,3],color='silver',linestyle='-',linewidth=1)
plt.show()
print("_"*60)

# qualité de la représentation des individus dans cet espace
time.sleep(2)
print("calcul de la qualité de la représentation des individus dans cet espace ...".encode('utf8').decode('mbcs'))
time.sleep(3)
di = np.sum(Z**2,axis=1) 
cos2 = acpCord**2
for j in range(data.shape[1]):
    cos2[:,j] = cos2[:,j]/di
a = pd.DataFrame({'COS2_1':cos2[:,0],'COS2_2':cos2[:,1]}, index=data.index)
print(a)
print("_"*60)

# Cercle de correlation
time.sleep(2)
print("generation du Cercle de correlation ...")
time.sleep(3)
acp=fanal.PCA(std_unit=True,row_labels=data.index,col_labels=data.columns)
acp.fit(data.values)
acp.correlation_circle(num_x_axis=1, num_y_axis=2)
print("_"*60)


# Contribution des variables 
time.sleep(2)
print("calcul des Contributions des variables ...")
time.sleep(3)
a = pd.DataFrame(acp.row_contrib_[:,:4],index=data.index)
print(a)
print("______________________FIN!_______________________")
