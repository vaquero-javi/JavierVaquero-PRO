def ej1():
    numeros = [1,2,3,4,5,6,7,8,9,10]
    contadorSuma = 0
    for num in numeros:
        contadorSuma = contadorSuma+numeros  
    print(contadorSuma)
ej1()   
    
def ej2():
    numero = input("Introduce un numero entero positivo: ")
    if numero < 0:
        print("No se pueden hacer factoriales de negativos.")
    else:
        factorial = 1
        for i in range(1, numero + 1):
            factorial *= i
        print(f"El factorial de {numero} es {factorial}")
ej2()
    
def ej3():
    print("Numeros primos entre 1 y 50:")
    for num in range(2, 51):  
        es_primo = True
        for i in range(2, int(num ** 0.5) + 1):  
            if num % i == 0:
                es_primo = False
                break
        if es_primo:
            print(num)
ej3()

def ej4():
    numero = input("Introduce un numero entero: ")
    numero = numero.lstrip('-')
    if (numero < 0):
        numero = numero * -1
    suma_digitos = 0
    for digito in numero:
        suma_digitos += int(digito)
    print(f"La suma de los digitos es: {suma_digitos}")
ej4()

def ej5():
    pares = 0
    for num in range(1,100):
        if (num % 2 == 0):                                      
            pares = pares + num
        print(f"La suma de los 100 primeros numeros pares es {pares}")
ej5()

def ej6():
    baseTriangulo = input("Introduce la base")
    alturaTriangulo = input("Introduce la altura")
    areaTriangualo =(baseTriangulo * alturaTriangulo) / 2
    print(f"El area del trinagulo es {areaTriangualo}")
ej6()

def ej7():
    for i in range(1, 101):
        if i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("Buzz")
        else:
            print(i)
ej7()

#8


#9
def ej9():
    print("Calculadora de promedio ")
    total = int(input("¿Cuántos números vas a introducir?: "))
    suma = 0
    for i in range(total):
        numero = float(input(f"Introduce el número {i + 1}: "))
        suma += numero
    promedio = suma / total
    print(f"El promedio de los {total} números introducidos es: {promedio:.2f}")
ej9()

#10
def ej10():
    print("Contador de vocales")
    texto = input("Introduce una cadena de texto: ")

    texto = texto.lower()
    contador = 0
    for letra in texto:
        if letra in 'aeiou':
            contador += 1

    print(f"La cantidad de vocales en el texto es: {contador}")
ej10()

#11
def ej11():
    palabra = input("Introduce una palabra: ").lower()
    es_palindromo = True 

    for i in range(len(palabra) // 2):
        if palabra[i] != palabra[-(i + 1)]:
            es_palindromo = False
            break

    if es_palindromo:
        print(f"La palabra '{palabra}' ES un palíndromo.")
    else:
        print(f"La palabra '{palabra}' NO es un palíndromo.")
ej11()

#12
import math  

def ej12():
    print("Calculadora de Área de un Círculo")
    radio = float(input("Introduce el radio del círculo: "))
        
    if radio < 0:
        print("El radio no puede ser negativo.")
        return

    area = math.pi * radio ** 2
    print(f"El área del círculo con radio {radio} es: {area:.2f}")
ej12()

#13
def ej13():
    print("Tabla de multiplicar")
    numero = int(input("Introduce un número entero: "))

    print(f"\nTabla de multiplicar del {numero}:\n")

    for i in range(1, 11):
        resultado = numero * i
        print(f"{numero} x {i} = {resultado}")
ej13()

#14
def ej14():
    suma = 0
    for numero in range(1, 101):
        if numero % 2 != 0:
            suma += numero
    print(f"La suma de los números impares del 1 al 100 es: {suma}")
ej14()

#15
def ej15():
    texto = input("Intoduce un texto: ")
    letra = input("Introduce la letra que quieres buscar: ")

    contador = 0
    for caracter in texto:
        if caracter == letra:
            contador += 1
    print(f"La letra '{letra}' aparece {contador} veces en el texto.")
ej15()

#16

#17

#18
import random

def ej18():
#Lo he pedido a ChatGPT pero lo he entendido, por eso te lo he puesto
    opciones = ['piedra', 'papel', 'tijeras']
    print("Juego: Piedra, Papel o Tijeras")
    print("Escribe 'salir' para terminar el juego.")

    while True:
        eleccion_usuario = input("Elige piedra, papel o tijeras: ").lower()
        
        if eleccion_usuario == 'salir':
            print("Juego terminado.")
            break
        
        if eleccion_usuario not in opciones:
            print("Opción inválida. Intenta de nuevo.")
            continue
        
        eleccion_computadora = random.choice(opciones)
        print(f"El ordenador eligió: {eleccion_computadora}")

        if eleccion_usuario == eleccion_computadora:
            print("Empate.")
        elif (eleccion_usuario == 'piedra' and eleccion_computadora == 'tijeras') or \
             (eleccion_usuario == 'papel' and eleccion_computadora == 'piedra') or \
             (eleccion_usuario == 'tijeras' and eleccion_computadora == 'papel'):
            print("¡Ganaste!")
        else:
            print("Perdiste.")
ej18()













    