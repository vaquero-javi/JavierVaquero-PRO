#1
def ej1():
    suma = 0
    for i in range(1, 11):
        suma += i
    print(f"La suma de los 10 primeros números es: {suma}")
ej1()

#2
def ej2():
    n = int(input("Introduce un número entero no negativo: "))
    if n < 0:
        print("Error: el número debe ser no negativo.")
        return
    factorial = 1
    for i in range(1, n + 1):
        factorial *= i
    print(f"El factorial de {n} es: {factorial}")
ej2()

#3
def ej3():
    suma = 0
    for numero in range(1, 101):
        if numero % 2 == 0:
            suma += numero
    print(f"La suma de los números pares del 1 al 100 es: {suma}")
ej3()

#4
def ej4():
    base = float(input("Introduce la base del triángulo: "))
    altura = float(input("Introduce la altura del triángulo: "))

    if base < 0 or altura < 0:
        print("Error: la base y la altura deben ser valores positivos.")
        return

    area = (base * altura) / 2
    print(f"El área del triángulo es: {area:.2f}")
ej4()

#5
def ej5():
    for i in range(1, 101):
        if i % 3 == 0:
            print("Triplete")
        elif i % 5 == 0:
            print("Cinquillo")
        else:
            print(i)
ej5()

#6
import random

def ej6():
    numero_aleatorio = random.randint(1, 100)
    print("Adivina el número entre 1 y 100.")

    while True:
        intento = int(input("Introduce tu intento: "))
        if intento < 1 or intento > 100:
            print("Por favor, introduce un número entre 1 y 100.")
            continue

        if intento < numero_aleatorio:
            print("Demasiado bajo.")
        elif intento > numero_aleatorio:
            print("Demasiado alto.")
        else:
            print("Adivinaste el número.")
            break
ej6()

#7
import math

def ej7():
    radio = float(input("Introduce el radio del círculo: "))
    if radio < 0:
        print("Error: el radio no puede ser negativo.")
        return

    area = math.pi * radio ** 2
    print(f"El área del círculo es: {area:.2f}")
ej7()

#8
def ej8():
    numero = int(input("Introduce un número entero: "))
    print(f"Tabla de multiplicar del {numero}:")

    for i in range(1, 11):
        resultado = numero * i
        print(f"{numero} x {i} = {resultado}")
ej8()

#9
def ej9():
    suma = 0
    for numero in range(1, 101):
        if numero % 2 != 0:
            suma += numero
    print(f"La suma de los números impares del 1 al 100 es: {suma}")
ej9()

#10
def ej10():
    texto = input("Introduce una cadena de texto: ")
    letra = input("Introduce la letra que quieres buscar: ")

    contador = 0
    for caracter in texto:
        if caracter == letra:
            contador += 1

    print(f"La letra '{letra}' aparece {contador} veces en el texto.")
ej10()
