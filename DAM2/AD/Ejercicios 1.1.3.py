
#Ejercicio 6.1
#Suma de números: Escribe un programa que sume dos números enteros
#ingresados por el usuario mediante teclado y muestre el resultado por pantalla.
num1 = int(input("Ingresa el primer número "))
num2 = int(input("Ingresa el segundo número "))
suma = num1 + num2
print("La suma es " , suma)

#Ejercicio 6.2
#Calculadora de área de un cuadrado: Crea un programa que calcule el área de
#un cuadrado cuando el usuario ingresa la longitud de un lado.
ladoCuadrado = int(input("Ingresa la medida de uno de los lados de un cuadrado "))
areaCuadrado = ladoCuadrado * ladoCuadrado
print("El área de este cuadrado es " , areaCuadrado)

#Ejercicio 6.3
#Conversión de temperatura: Escribe un programa que convierta grados Celsius a grados Fahrenheit. 
#Pide al usuario ingresar la temperatura en Celsius. 
gradosCelsius = float(input("Introduce los grados celsius para convertirlos a fahrenheint "))
gradosFahrenheint = (gradosCelsius * (9/5) + 32)
print(gradosCelsius , "grados celsius equivalen a ", gradosFahrenheint , "grados fahrenheint ")

#Ejercicio 6.4
#Calculadora de IMC (Índice de Masa Corporal): Desarrolla un programa que
#calcule el IMC a partir del peso y la altura ingresados por el usuario.
peso = float(input("Introduce tu peso en kilos "))
altura = float(input("Introduce tu altura en metros "))
imc = peso / (altura**2)
print("El imc segun tu altura y peso es " , imc)

#Ejercicio 6.5
#Concatenación de cadenas: Crea un programa que tome dos cadenas como
#entrada del usuario y las concatene en una sola cadena.
palabra1 = input("Introduce una palabra ")
palabra2 = input("Introduce otra palabra ")
palabrasconcatenadas = palabra1 + palabra2
print("La palabra concatenada es ", palabrasconcatenadas)

#Ejercicio 6.6
#Determinar el tipo de dato: Escribe un programa que determine el 
# tipo de dato de una variable ingresada por el usuario.
dato = input("Introduce un dato ")
if dato.isdecimal():
    print("Es decimal")
elif dato.isdigit():
    print("Es entero")
else:
    print("Es un texto")

#Ejercicio 6.7
#Calcular el promedio de tres números: Desarrolla un programa que calcule el
# promedio de tres números ingresados por el usuario.
numero1 = int(input("Introduce un número"))
numero2 = int(input("Introduce otro número"))
numero3 = int(input("Introduce el ultimo número"))
media = (numero1 + numero2 + numero3) / 3
print("La media de estos 3 números es ", media)

#Ejercicio 6.8
#Área de un triángulo: Crea un programa que calcule el área de un triángulo a
# partir de la base y la altura ingresadas por el usuario.
alturaTriangulo = int(input("Introduce la altura del triangulo"))
baseTriangulo = int(input("Introduce la base del triangulo"))
areaTriangulo = (baseTriangulo * alturaTriangulo) / 2
print("El área del triángulo es ", areaTriangulo)

#Ejercicio 6.9
#Edad en el futuro: Escribe un programa que pida la edad actual del usuario y un
# número de años, y calcule la edad que tendrá el usuario en ese futuro número de años.
anios = int(input("Introduce tu edad"))
aniosFuturo = int(input("Introduce una cifra y calculamos tu edad en esos años a futuro"))
calculoAniosFuturo = anios + aniosFuturo
print("Tienes ", anios , "ahora mismo, pero en ", aniosFuturo, "años tendrás ", calculoAniosFuturo)

#Ejercicio 6.10
#Área de un rectángulo: Crea un programa que calcule el área de un
# rectángulo a partir de su longitud y ancho ingresados por el usuario.
alturaRectangulo = int(input("Introduce la altura del rectangulo"))
baseRectangulo = int(input("Introduce la base del rectangulo"))
areaRectangulo = (baseTriangulo * areaTriangulo) 
print("El área del rectangulo es ", areaRectangulo)

#Ejercicio 6.11
#Días a segundos: Crea un programa que convierta un número 
#de días ingresado por el usuario a segundos.
dias = int(input("Introduce un número de días para convertirlos a segundos"))
segundos = (dias*24)*60*60
print(dias, "dias son ",segundos, "segundos")

#Ejercicios 6.12
#Raíz cuadrada: Desarrolla un programa que calcule la raíz cuadrada de un
# número ingresado por el usuario.
import math
numeroRaizCuadrada = int(input("Introduce un numero"))
calculoRaizCuadrada = math.sqrt(numeroRaizCuadrada)
print("La raiz cuadrada de ",numeroRaizCuadrada,"es ",calculoRaizCuadrada)

#Ejercicio 6.13
#Conversión de moneda: Escribe un programa que convierta una cantidad de
#dólares a euros. El tipo de cambio debe ser ingresado por el usuario.
cambioMoneda = float(input("Introduce dinero que tienes en dolares"))
calculoCambioMoneda = cambioMoneda * 0,85
print(cambioMoneda," dolares son ",calculoCambioMoneda,"euros al cambio")