# import des librairies necessaires
import cv2
import matplotlib.pyplot as plt
import time
from PIL import Image, ImageStat
import numpy as np
import statistics as stat
import math
import os
from matplotlib.image import imread
import random
import pylab as pyl


# menu
img_path = '''
choisir une image 
NB: avec l'extension\n
'''
# Question 1
def AfficherImg(img):
    plt.axis("off")
    plt.imshow(img, interpolation="nearest")
    # plt.imshow(img, cmap="gray")#palette predefinie pour afficher une image
    plt.title('Question 1')
    plt.show()

#Question 2
def ouvrirImage(chemin):
    img=plt.imread(chemin)
    return img

#Question 3
def saveImage(img):
    plt.imsave("outputs//Question 3.png",img)

#Question 4
def image_noire(h, l):
    img = np.zeros((h, l, 3), dtype = np.uint8)
    img = 255*img
    return img

#Question 5
def image_blanche(h, l):
    img = np.ones((h, l, 3), dtype = np.uint8)
    img = 255*img
    return img

#Question 6
def creerImgBlancNoir(l, h):
	def pixel_value(i, j):
		return (i + j) % 2
	return [[pixel_value(i, j) for j in range(l)] for i in range(h)]

# Question 7
def negatif(Img):
    t=np.array( Img)
    n,p,r=t.shape #on sait que r=3
    for i in range(n):
        for j in range(p):
            for k in range(3):
                t[i][j][k]=255-t[i][j][k]
    return Image.fromarray(t)

# Question 9
def luminance(Img):
    #Ouvrir le fichier image
    im = Image.open(Img)

    #Récupérer la largeur et la hauteur de l'image
    width, height = im.size

    #Calculer le nombre total de pixels dans l'image
    total_pixels = width * height
    #Calculer la somme des valeurs du canal L de tous les pixels
    total_luminance = 0
    for x in range(width):
        for y in range(height):
            l, a, b = im.getpixel((x, y))
            total_luminance += l

    #Calculer la luminance moyenne de l'image
    avg_luminance = total_luminance / total_pixels

    return avg_luminance

# Question 10
def constrast(Img):
    im = Image.open(Img)
    #Convertir l'image en niveaux de gris
    gray_image = im.convert("L")

    #Récupérer la largeur et la hauteur de l'image
    width, height = im.size

    #Calculer le nombre total de pixels dans l'image
    total_pixels = width * height

    #Calculer la somme des valeurs de niveaux de gris de tous les pixels
    total_brightness = 0
    for x in range(width):
        for y in range(height):
            total_brightness += gray_image.getpixel((x, y))

    #Calculer la luminosité moyenne de l'image
    avg_brightness = total_brightness / total_pixels

    #Calculer la somme des carrés des différences entre les
    #les valeurs de niveaux de gris de tous les pixels et la luminosité moyenne
    total_difference = 0
    for x in range(width):
        for y in range(height):
            total_difference += (gray_image.getpixel((x, y)) - avg_brightness) ** 2

    #Calculer l'écart type des valeurs de niveaux de gris
    std_dev = (total_difference / total_pixels) ** 0.5

    #Calculer le contraste de l'image
    contrast = std_dev / avg_brightness

    return contrast

# Question 11
def profondeur(Img):
    img = Image.open(Img)
    # Récupérez la profondeur de l'image
    depth = len(img.getbands())
    # Affichez la profondeur de l'image
    return depth

# Question 12    
def Ouvrir(Img):
    # Charger l'image en mémoire en utilisant la fonction imread()
    image = cv2.imread(Img)
    # Vérifier si l'image a été correctement chargée
    if image is None:
        raise ValueError("L'image n'a pas pu être chargée")
    # Convertir l'image en un tableau NumPy et retourner le résultat
    return np.array(image)

# Question 13
# Tout d'abord on fait definir la fonction de lecture en grayscale ou RGB et retourne une matrice 
def read_this(img, gray_scale=False):
    image_src = cv2.imread(img)
    if gray_scale:
        image_src = cv2.cvtColor(image_src, cv2.COLOR_BGR2GRAY)
    else:
        image_src = cv2.cvtColor(image_src, cv2.COLOR_BGR2RGB)
    return image_src

def inverser(img, with_plot=False, gray_scale=False): 
    image_src = read_this(img=img, gray_scale=gray_scale)
    cmap_val = None if not gray_scale else 'gray'
    image_i = cv2.bitwise_not(image_src)
    
    if with_plot:
        fig, (ax1, ax2) = plt.subplots(nrows=1, ncols=2, figsize=(10, 20))

        ax1.axis("off")
        ax1.title.set_text('A')

        ax2.axis("off")
        ax2.title.set_text("B")
        
        ax1.imshow(image_src, cmap=cmap_val)
        ax2.imshow(image_i, cmap=cmap_val)
        return True
    return image_i

# Question 14
# parametre = le chemin de l'image original
def flipH(img):
    original_img = Image.open(img)
    flippedimage = original_img.transpose(method=Image.FLIP_LEFT_RIGHT)
    return flippedimage

# Question 15
def poserV(img,img1):
    final_image = np.concatenate((img1, img), axis=0)
    return final_image

# Question 16
def poserH(img, img1):
    final_image = np.concatenate((img1, img), axis= 1 )
    return final_image

# Question 17 & 22
M=[[[210, 100, 255],[100, 50, 255],[90, 90, 255],[90, 90, 255],[90, 90, 255],[90, 80, 255]],
[[190, 255,89],[ 201, 255,29],[200, 255,100],[100, 255,90],[20, 255,200], [100, 255,80]],
[[255,0, 0],[ 255,0, 0],[255,0, 0],[255,0, 0],[255,0, 0], [255,0, 0]] ]

# Question 24
def initImageRGB(imageRGB):
    #Ouvrez paddington et assurez-vous qu'il s'agit d'un RVB à 3 canaux plutôt que d'une palette
    im = Image.open(imageRGB)
    #Faire de lui un tableau Numpy
    na = np.array(im)
    #Créez un autre tableau Numpy (c'est-à-dire une image) de la même taille que Paddington et plein de nombres aléatoires
    rand = np.random.randint(0,256, na.shape, dtype=np.uint8)
    #Soustraire une image aléatoire de Paddington -ce Numpy vectorisé, rapide et facile à obtenir
    split = na - rand
    #Recréez l'original en ajoutant une image aléatoire à la division -Numpy vectorisé à nouveau
    joined = split + rand
    return joined

# Question 25
def symetrie(img):
    imageSource=Image.open(img)
    # largeur et hauteur en pixels de l’image
    largeur , hauteur=imageSource . size
    
    #définition de la nouvelle image
    imageBut=Image.new( "RGB" , ( largeur , hauteur ) )
   
    # pour chaque lign e :
    for y in range( hauteur ) :
    #pour chaque colonne :
        for x in range( largeur ) :
        # code du pixel ( niveau de gris )
            p = imageSource . getpixel( ( x , y ) )
            # création du pixel correspondant dans la nv image :
            imageBut.putpixel(( x,-y + hauteur - 1) ,p )
    return imageBut


# Question 26
def grayscale(imageRGB):
    # charger l'image
    img = Image.open(imageRGB)
    # convertir l'image en tableau de pixels
    pixels = img.load()
    # parcourir chaque pixel de l'image
    for i in range(img.width):
        for j in range(img.height):
            # récupérer les valeurs RGB du pixel
            r, g, b = pixels[i, j]
            # calculer la valeur grise en utilisant la formule indiquée
            gray = (min(r, g, b) + max(r, g, b)) // 2
            # remplacer la valeur RGB du pixel par la valeur grise
            pixels[i, j] = (gray, gray, gray)
    return img


# lecture de l'image
a =  input(str(img_path))
chemin = r".//Images//"+ a
img = cv2.imread(chemin)
print("image en cours de l'analyse...\n ")
time.sleep(5)

print("________PARTIE I _________")
# Question 1
time.sleep(3)
print("________Question 1________\n Affichage de l'image...")
AfficherImg(img)

# Question 2
time.sleep(2)
print("________Question 2________\n test de la fonction d'ouverture de l'image...")
time.sleep(2)
plt.imshow(ouvrirImage(chemin))
plt.title('Question 2')
plt.show()

# Question 3
time.sleep(2)
print("________Question 3________\ntest de la fonction de Sauvgarde d'une image sous forme jpg ou bmp...")
time.sleep(2)
saveImage(img)
print("terminee !")

# PARTIE 2
# Question 4
time.sleep(2)
print("________PARTIE II _________")
print("________Question 4________\ntest de la fonction de l'image en Noire...")
time.sleep(2)
cv2.imshow('image noire', image_noire(200,600))
plt.imsave("outputs//Question 4.png",image_noire(200,600))
plt.title('question 4')
plt.show()
cv2.waitKey(0)

# Question 5
time.sleep(2)
print("________Question 5________\ntest de la fonction de l'image en Blanc...")
time.sleep(2)
cv2.imshow('image blanche', image_blanche(200,600))
plt.imsave("outputs//Question 5.png",image_blanche(200,600))
plt.title('question 5')
plt.show()
cv2.waitKey(0)

# Question 6
time.sleep(2)
print("________Question 5________\ntest de la fonction de l'image en Noire et Blanc...")
time.sleep(2)
bw_image = creerImgBlancNoir(1000,888)
plt.imshow(bw_image, cmap='gray')
plt.imsave("outputs//Question 6.png",bw_image)
plt.title('question 6')
plt.show()
cv2.waitKey(0)

# Question 7
time.sleep(2)
print("________Question 7________\ntest de la fonction de l'image en Négatif...")
time.sleep(2)
ng = negatif(img)
ng.save(".//outputs//Question 7.png") #sauvegarde
plt.imshow(ng, cmap='gray')
plt.title('question 7')
plt.show()


# PARTIE III
# Question 9
time.sleep(2)
print("________PARTIE III _________")
time.sleep(2)
print("________Question 8________\ntest de la fonction de la luminance...")
time.sleep(2)
print("la luminance de l'image est : "+ str(luminance(chemin)))

# Question 10
time.sleep(2)
print("________Question 10________\ntest de la fonction de la contraste...")
time.sleep(2)
print("la contraste de l'image est : "+ str(constrast(chemin)))

# Question 11
time.sleep(2)
print("________Question 11________\ntest de la fonction de la profondeur...")
time.sleep(2)
print("la profondeur de l'image est : "+ str(profondeur(chemin)))

# # Question 12
time.sleep(2)
print("________Question 12________\ntest de la fonction d'ouverture ...")
time.sleep(2)
print("la matrice de l'image est : ")
print(Ouvrir(chemin))

# PARTIE 4
# Question 13
time.sleep(2)
print("________PARTIE IV _________")
print("________Question 13________\ntest de la fonction de l'image en Inverse...")
time.sleep(2)
cv2.imshow('Question 13', inverser(chemin))
plt.imsave("outputs//Question 13.png",inverser(chemin))
cv2.waitKey(0)

# Question 14
time.sleep(2)
print("________Question 14________\ntest de la fonction flipH...")
time.sleep(2)
ng = flipH(chemin)
ng.save("outputs//Question 14.png") #sauvegarde
plt.imshow(ng)
plt.title('question 14')
plt.show()

# # Question 15
time.sleep(2)
print("________Question 15________\ntest de la fonction poserV...")
time.sleep(2)
ng =  poserV(flipH(chemin), inverser(chemin) )
plt.imsave("outputs//Question 15.png", ng) #sauvegarde
plt.imshow(ng)
plt.title('question 15')
plt.show()

# Question 16
time.sleep(2)
print("________Question 16________\ntest de la fonction poserH...")
time.sleep(2)
ng =  poserH(flipH(chemin), inverser(chemin) )
plt.imsave("outputs//Question 16.png", ng) #sauvegarde
plt.imshow(ng)
plt.title('question 16')
plt.show()

# PARTIE VI
# Question 17
time.sleep(2)
print("________PARTIE VI _________")
time.sleep(2)
print("________Question 17________\n")
time.sleep(2)
plt.imshow(M)
plt.axis("off")
plt.show()

# Question 22
time.sleep(2)
print("________Question 22________\n")
time.sleep(2)
print('M[0][1][1] = '+str(M[0][1][1]))
print('M[1][0][1] = '+str(M[1][0][1]))
print('M[2][1][0] = '+str(M[2][1][0]))

# Question 23
time.sleep(2)
print("________Question 23________\n")
time.sleep(2)
print("RGB est code en 24 bits\n")
a = '''
la couleur 24 bits est la profondeur de couleur la plus élevée normalement utilisée et est disponible sur la plupart des systèmes d'affichage et logiciels modernes. Sa palette de couleurs contient (2^8)^3 = 256^3 = 16 777 216 couleurs. La couleur 24 bits peut être représentée par six chiffres hexadécimaux.
'''
print("__justification: "+ a )

# Question 24
time.sleep(2)
print("________Question 24________\ntest de la fonction initImageRGB...")
time.sleep(2)
ng =  initImageRGB(chemin)
plt.imsave("outputs//Question 24.png", ng) #sauvegarde
plt.imshow(ng)
plt.title('question 24')
plt.show()

# Question 25
time.sleep(2)
print("________Question 25________\ntest de la fonction symetrie...")
time.sleep(2)
ng =  symetrie(chemin)
plt.imsave("outputs//Question 25.png", ng) #sauvegarde
plt.imshow(ng)
plt.title('Question 25')
plt.show()

# Question 26
time.sleep(2)
print("________Question 26________\ntest de la fonction niveaux de gris...")
time.sleep(2)
ng =  grayscale(chemin)
plt.imsave("outputs//Question 26.png", ng) #sauvegarde
plt.imshow(ng)
plt.title('Question 25')
plt.show()

print("________FIN!________")