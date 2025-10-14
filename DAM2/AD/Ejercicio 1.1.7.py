import math
from colorama import Fore, Style, init

# Inicializar colorama
init(autoreset=True)

# CONTRASEÑA 
contraseña = "1234"

#FUNCION PARA PEDIR NUMEROS
def pedir_numero(msg="Introduce un número: "):
    while True:
        try:
            return float(input(Fore.BLUE + msg + Style.RESET_ALL))
        except ValueError:
            print(Fore.RED + "❌ ⛔Error: introduce un número válido.❌ ⛔" + Style.RESET_ALL)

#FUNCION SUMA
def suma():
    a = pedir_numero("Primer número: ")
    b = pedir_numero("Segundo número: ")
    print(Fore.BLUE + "Resultado:", a + b, Style.RESET_ALL)

#FUNCION RESTA
def resta():
    a = pedir_numero("Primer número: ")
    b = pedir_numero("Segundo número: ")
    print(Fore.BLUE + "Resultado:", a - b, Style.RESET_ALL)

#FUNCION MULTIPLICACION
def multiplicacion():
    a = pedir_numero("Primer número: ")
    b = pedir_numero("Segundo número: ")
    print(Fore.BLUE + "Resultado:", a * b, Style.RESET_ALL)

#FUNCION DIVISION
def division():
    a = pedir_numero("Primer número: ")
    b = pedir_numero("Segundo número: ")
    if b != 0:
        print(Fore.BLUE + "Resultado:", a / b, Style.RESET_ALL)
    else:
        print(Fore.RED + "❌ ⛔Error: no se puede dividir entre 0.❌ ⛔" + Style.RESET_ALL)

#FUNCION VALOR ABSOLUTO
def valor_absoluto():
    a = pedir_numero("Número: ")
    print(Fore.BLUE + "Resultado:", abs(a), Style.RESET_ALL)

#FUNCION SENO
def seno():
    grados = pedir_numero("Ángulo en grados: ")
    rad = math.radians(grados)
    print(Fore.BLUE + "Seno:", math.sin(rad), Style.RESET_ALL)

#FUNCION COSENO
def coseno():
    grados = pedir_numero("Ángulo en grados: ")
    rad = math.radians(grados)
    print(Fore.BLUE + "Coseno:", math.cos(rad), Style.RESET_ALL)

#FUNCION TANGENTE
def tangente():
    grados = pedir_numero("Ángulo en grados: ")
    rad = math.radians(grados)
    print(Fore.BLUE + "Tangente:", math.tan(rad), Style.RESET_ALL)

#FUNCION LOGARITMO BASE 10
def logaritmo_base_10():
    a = pedir_numero("Número: ")
    if a > 0:
        print(Fore.BLUE + "Logaritmo base 10:", math.log10(a), Style.RESET_ALL)
    else:
        print(Fore.RED + "❌ ⛔Error: el número tiene que ser positivo.❌ ⛔" + Style.RESET_ALL)

#FUNCION LOGARITMO NEPERIANO
def logaritmo_neperiano():
    a = pedir_numero("Número: ")
    if a > 0:
        print(Fore.BLUE + "Logaritmo neperiano:", math.log(a), Style.RESET_ALL)
    else:
        print(Fore.RED + "❌ ⛔Error: el número tiene que ser positivo.❌ ⛔" + Style.RESET_ALL)

#FUNCION E ELEVADO A X
def e_elevado_x():
    a = pedir_numero("Número: ")
    print(Fore.BLUE + "e elevado a x:", math.exp(a), Style.RESET_ALL)

#FUNCION RAIZ CUADRADA
def raiz_cuadrada():
    a = pedir_numero("Número: ")
    if a >= 0:
        print(Fore.BLUE + "Raíz cuadrada:", math.sqrt(a), Style.RESET_ALL)
    else:
        print(Fore.RED + "❌ ⛔Error: no se puede calcular la raíz de un número negativo.❌ ⛔" + Style.RESET_ALL)

#FUNCION CAMBIAR CONTRASEÑA
def cambiar_contraseña():
    global contraseña
    nueva = input(Fore.BLUE + "Introduce la nueva contraseña: " + Style.RESET_ALL)
    contraseña = nueva
    print(Fore.GREEN + "✅ Contraseña cambiada con éxito ✅" + Style.RESET_ALL)

#FUNCION MENU
def menu():
    print(Fore.BLUE + """
Calculadora Científica
------------------------------
1️⃣   Suma
2️⃣   Resta
3️⃣   Multiplicación
4️⃣   División
5️⃣   Valor absoluto
6️⃣   Seno
7️⃣   Coseno
8️⃣   Tangente
9️⃣   Logaritmo base 10
1️⃣0️⃣     Logaritmo neperiano
1️⃣1️⃣     e elevado a x
1️⃣2️⃣     Raíz cuadrada
1️⃣3️⃣     Cambiar contraseña
0️⃣   Apagar calculadora
------------------------------
""" + Style.RESET_ALL)

#FUNCION MAIN
def main():
    print("\n" *3)
    print(Fore.BLUE + "----👨‍🔬🧮 CALCULADORA CIENTÍFICA 🧮👨‍🔬----" + Style.RESET_ALL)
    print(Fore.BLUE + "------------------------------------------------" + Style.RESET_ALL)
    print("\n")
    
    intentos = 3
    while intentos > 0:
        clave = input(Fore.BLUE + "Introduce la contraseña: " + Style.RESET_ALL)
        if clave == contraseña:
            break
        else:
            intentos -= 1
            print(Fore.RED + f"❌⛔ Contraseña incorrecta. Te quedan {intentos} intentos. ⛔❌" + Style.RESET_ALL)
    else:
        print(Fore.RED + "❌ ⛔ Demasiados intentos fallidos. Calculadora bloqueada. ⛔❌" + Style.RESET_ALL)
        return

    print(Fore.GREEN + "✅🔓🗝️ Bienvenido a la Calculadora Científica 🗝️🔓✅" + Style.RESET_ALL)

    while True:
        menu()
        opcion = input(Fore.BLUE + "Selecciona una opción: " + Style.RESET_ALL)

        if opcion == "1":
            suma()
        elif opcion == "2":
            resta()
        elif opcion == "3":
            multiplicacion()
        elif opcion == "4":
            division()
        elif opcion == "5":
            valor_absoluto()
        elif opcion == "6":
            seno()
        elif opcion == "7":
            coseno()
        elif opcion == "8":
            tangente()
        elif opcion == "9":
            logaritmo_base_10()
        elif opcion == "10":
            logaritmo_neperiano()
        elif opcion == "11":
            e_elevado_x()
        elif opcion == "12":
            raiz_cuadrada()
        elif opcion == "13":
            cambiar_contraseña()
        elif opcion == "0":
            print(Fore.BLUE + "Saliendo de la calculadora... 👋" + Style.RESET_ALL)
            break
        else:
            print(Fore.RED + "❌⛔ Opción no válida, intenta de nuevo. ⛔❌" + Style.RESET_ALL)

main()