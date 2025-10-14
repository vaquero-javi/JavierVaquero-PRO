import random
from colorama import Fore, Style, init

# Inicializar colorama
init(autoreset=True)

#1.Escribe un programa en python que imprima todas las tablas de multiplicar del 1 al 10.
def tablas_multiplicar():
    for i in range(1, 11):
        print(f"Tabla del {i}:")
        for j in range(1, 11):
            print(f"{i} x {j} = {i * j}")
        print()   
#tablas_multiplicar()

#2.Crea un programa que dibuje un semi-triángulo de asteriscos. El usuario debe ingresar la altura por teclado.
def triangulo_asteriscos():
    altura = int(input("Introduce la altura del triángulo: "))
    for i in range(1, altura + 1):
        print('*' * i)
#triangulo_asteriscos()

#3.Patrón de números: Diseña un programa que imprima un patrón de números en forma de cuadrado. 
# Por ejemplo, si el usuario introduce por teclado el número 4, el patrón debería ser:
def patron_numeros():
    n = int(input("Introduce un número para el patrón: "))
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            print(j, end=' ')
        print()
#patron_numeros()

#4a.Matriz de ceros: Escribe un programa que cree una matriz cuadrada de ceros de tamaño nxn, 
# donde es el número de elementos de cada fila y columna y será especificado por el usuario (introducido por teclado).
def matriz_ceros():
    n = int(input("Introduce el tamaño de la matriz (n): "))
    matriz = [[0 for _ in range(n)] for _ in range(n)]
    for fila in matriz:
        print(fila)
#matriz_ceros()

#4b.Modifica el ejemplo anterior (4a) para que en lugar de ceros, 
# introduzca automáticamente (NO por teclado) los números impares que correspondan.(aleatorios)
def matriz_impares():
    n = int(input("Introduce el tamaño de la matriz (n): "))
    matriz = [[random.choice([i for i in range(1, 100) if i % 2 != 0]) for _ in range(n)] for _ in range(n)]
    for fila in matriz:
        print(fila)
#matriz_impares()

#4c.Rellenando matrices. Amplía el ejercicio 4a de forma que el usuario no sólo decida 
# la dimensión de la matriz cuadrada sino que introduzca los datos (números enteros) por teclado.
def matriz_usuario():
    n = int(input("Introduce el tamaño de la matriz (n): "))
    matriz = []
    for i in range(n):
        fila = []
        for j in range(n):
            num = int(input(f"Introduce el número para la posición [{i}][{j}]: "))
            fila.append(num)
        matriz.append(fila)
    for fila in matriz:
        print(fila)
#matriz_usuario()

#5.Suma de matrices: amplía el ejercicio 4c con un programa que sume dos matrices 
# cuadradas con el mismo orden. Todos los datos de la suma son números enteros.
def suma_matrices():
    n = int(input("Introduce el tamaño de las matrices (n): "))
    matriz1 = []
    matriz2 = []
    
    print("Introduce los elementos de la primera matriz:")
    for i in range(n):
        fila = []
        for j in range(n):
            num = int(input(f"Elemento [{i}][{j}]: "))
            fila.append(num)
        matriz1.append(fila)
    
    print("Introduce los elementos de la segunda matriz:")
    for i in range(n):
        fila = []
        for j in range(n):
            num = int(input(f"Elemento [{i}][{j}]: "))
            fila.append(num)
        matriz2.append(fila)
    
    matriz_suma = []
    for i in range(n):
        fila_suma = []
        for j in range(n):
            fila_suma.append(matriz1[i][j] + matriz2[i][j])
        matriz_suma.append(fila_suma)
    
    print("Resultado de la suma de matrices:")
    for fila in matriz_suma:
        print(fila)
#suma_matrices()

#6.Cálculo de la suma de fila y columna en una matriz: Crea una matriz en la que cadaelemento 
# sea la suma del número de fila y columna correspondiente. El usuario indicará por teclado 
# la dimensión de la matriz.
def suma_fila_columna():
    n = int(input("Introduce el tamaño de la matriz (n): "))
    matriz = []
    for i in range(n):
        fila = []
        for j in range(n):
            fila.append(i + j)
        matriz.append(fila)
    for fila in matriz:
        print(fila)
#suma_fila_columna()

#7.Dibujo de un rombo: Diseña un programa que dibuje un rombo equilibrado de asteriscos. 
# El usuario debe ingresar la altura del rombo, siendo esta siempre impar. Si introduce una 
# altura par, deberá indicar por pantalla que vuelva a introducir la altura 
# (rombos con altura par...no son rombos equilibrados).
def rombo_asteriscos():
    altura = int(input("Introduce la altura del rombo (debe ser impar): "))
    if altura % 2 == 0:
        print("La altura debe ser un número impar. Inténtalo de nuevo.")
        return
    mid = altura // 2
    for i in range(altura):
        if i <= mid:
            print(' ' * (mid - i) + '*' * (2 * i + 1))
        else:
            print(' ' * (i - mid) + '*' * (2 * (altura - i) - 1))
#rombo_asteriscos()

#8. Implementa un algoritmo en python que realice la suma de sus diagonales, es decir,
#que sume (1+7+13+19+20)+(21+17+13+9+5). Si te fijas el 13 se repite, puedes dar la
#opción que el usuario decida si se da el resultado repitiendo el elemento central o no.
def suma_diagonales():
    matriz = [
        [1, 2, 3, 4, 5],
        [6, 7, 8, 9, 10],
        [11, 12, 13, 14, 15],
        [16, 17, 18, 19, 20],
        [21, 22, 23, 24, 25]
    ]
    repetir_central = input("¿Deseas repetir el elemento central en la suma? (s/n): ").lower() == 's'
    suma = 0
    n = len(matriz)
    for i in range(n):
        # Diagonal principal
        suma += matriz[i][i]  
        # Diagonal secundaria
        suma += matriz[i][n - i - 1]  
    if not repetir_central:
        # Restar el elemento central si no se repite
        suma -= matriz[n // 2][n // 2]  
    print(f"La suma de las diagonales es: {suma}")
#suma_diagonales()

#9. Igual que el ejercicio 8 pero el usuario introduce los valores por teclado.
def suma_diagonales_usuario():
    n = int(input("Introduce el tamaño de la matriz (n x n): "))
    matriz = []
    print("Introduce los elementos de la matriz:")
    for i in range(n):
        fila = []
        for j in range(n):
            num = int(input(f"Elemento [{i}][{j}]: "))
            fila.append(num)
        matriz.append(fila)
    
    repetir_central = input("¿Deseas repetir el elemento central en la suma? (s/n): ").lower() == 's'
    suma = 0
    for i in range(n):
        # Diagonal primaria
        suma += matriz[i][i]  
        # Diagonal secundaria
        suma += matriz[i][n - i - 1]  
    if not repetir_central and n % 2 == 1:
        # Restar el elemento central si no se repite
        suma -= matriz[n // 2][n // 2]  
    print(f"La suma de las diagonales es: {suma}")
#suma_diagonales_usuario()

#funcion menu
def menu():
    print(Fore.YELLOW + """
------------------------------
1️⃣   Ejercicio1: Tablas de multiplicar
2️⃣   Ejercicio2: Triángulo de asteriscos
3️⃣   Ejercicio3: Patrón de números
4️⃣   Ejercicio4a: Matriz de ceros
5️⃣   Ejercicio4b: Matriz de impares aleatorios
6️⃣   Ejercicio4c: Matriz con datos de usuario
7️⃣   Ejercicio5: Suma de matrices
8️⃣   Ejercicio6: Suma de fila y columna en una matriz
9️⃣   Ejercicio7: Dibujo de un rombo de asteriscos
🔟   Ejercicio8: Suma de diagonales en matriz
1️⃣ 1️⃣   Ejercicio9: Suma de diagonales en matriz con datos de usuario
0️⃣   Apagar calculadora
------------------------------
""" + Style.RESET_ALL)
    
#funcion main
def main():
    print("\n" *3)
    print(Fore.BLUE + "----👨‍🔬🧮 EJERCICIOS LISTAS 🧮👨‍🔬----" + Style.RESET_ALL)
    print(Fore.BLUE + "------------------------------------------------" + Style.RESET_ALL)
    print("\n")
    
    while True:
        menu()
        opcion = input(Fore.BLUE + "Selecciona una opción: " + Style.RESET_ALL)

        if opcion == "1":
            tablas_multiplicar()
        elif opcion == "2":
            triangulo_asteriscos()
        elif opcion == "3":
            patron_numeros()
        elif opcion == "4":
            matriz_ceros()
        elif opcion == "5":
            matriz_impares()
        elif opcion == "6":
            matriz_usuario()
        elif opcion == "7":
            suma_matrices()
        elif opcion == "8":
            suma_fila_columna()
        elif opcion == "9":
            rombo_asteriscos()
        elif opcion == "10":
            suma_diagonales()
        elif opcion == "11":
            suma_diagonales_usuario()
        elif opcion == "0":
            print(Fore.LIGHTYELLOW_EX + "Saliendo de la calculadora... 👋" + Style.RESET_ALL)
            break
        else:
            print(Fore.RED + "❌⛔ Opción no válida, intenta de nuevo. ⛔❌" + Style.RESET_ALL)
main()