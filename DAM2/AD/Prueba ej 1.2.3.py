
#3.Patrón de números: Diseña un programa que imprima un patrón de números en forma de cuadrado. 
# Por ejemplo, si el usuario introduce por teclado el número 4, el patrón debería ser:
def patron_numeros():
    n = int(input("Introduce un número para el patrón: "))
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            print(j, end=' ')
        print()
patron_numeros()