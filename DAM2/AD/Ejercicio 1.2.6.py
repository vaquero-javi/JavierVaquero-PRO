import random
from colorama import Fore, Style, init

init(autoreset=True)

# Ejercicio 1
def ejercicio1():
    mi_tupla = (1, 2, 3, "cuatro", "cinco")
    print("Ejercicio 1:")
    for elemento in mi_tupla:
        print(elemento)

# Ejercicio 2
def ejercicio2():
    mi_tupla = (1, 2, 3, "cuatro", "cinco")
    print("\nEjercicio 2:")
    print(len(mi_tupla))

# Ejercicio 3
def ejercicio3():
    mi_tupla = (1, 2, 3, "cuatro", "cinco")
    print("\nEjercicio 3:")
    for valor in ["cuatro", "2", 2]:
        print(f"¿{valor} está en la tupla? {'Sí' if valor in mi_tupla else 'No'}")

# Ejercicio 4
def ejercicio4():
    mi_tupla = (1, 2, 3, "cuatro", "cinco")
    print("\nEjercicio 4:")
    entrada = input("Introduce un valor a buscar: ")
    if entrada.isdigit():
        valor_buscar = int(entrada)
    else:
        valor_buscar = entrada
    print(f"¿{valor_buscar} está en la tupla? {'Sí' if valor_buscar in mi_tupla else 'No'}")

# Ejercicio 5
def ejercicio5():
    print("\nEjercicio 5:")
    x = input("Introduce el primer valor: ")
    y = input("Introduce el segundo valor: ")
    z = input("Introduce el tercer valor: ")
    mi_tupla_nueva = (x, y, z)
    print("Tupla resultante:", mi_tupla_nueva)

# Ejercicio 6
def ejercicio6():
    print("\nEjercicio 6:")
    a = input("Introduce una letra: ")
    while True:
        x = input("Introduce un número: ")
        if x.isdigit():
            x = int(x)
            break
    mi_tupla_par = (a, x)
    print("Tupla:", mi_tupla_par)

# Ejercicio 7
def ejercicio7():
    print("\nEjercicio 7:")
    pares = []
    for i in range(3):
        letra = input(f"Introduce la letra {i+1}: ")
        while True:
            numero = input(f"Introduce el número {i+1}: ")
            if numero.isdigit():
                numero = int(numero)
                break
        pares.append((letra, numero))
    tupla_pares = tuple(pares)
    for letra, numero in tupla_pares:
        print(f"El valor {letra} vale {numero}")
    return tupla_pares  

# Ejercicio 8
def ejercicio8(tupla_pares):
    print("\nEjercicio 8:")
    (a, x), (b, y), (c, z) = tupla_pares
    print(f"El valor {a} vale {x}")
    print(f"El valor {b} vale {y}")
    print(f"El valor {c} vale {z}")

# Ejercicio 9
def ejercicio9():
    print("\nEjercicio 9:")
    tupla1 = (1, 2, 3, 4, 5)
    tupla2 = (3, 4, 5, 6, 7)
    interseccion = tuple(i for i in tupla1 if i in tupla2)
    diferencia = tuple(i for i in tupla1 + tupla2 if i not in interseccion)
    print("Intersección:", interseccion)
    print("Diferencia:", diferencia)

# Ejercicio 10
def ejercicio10():
    print("\nEjercicio 10:")
    ciudades_temperaturas = (
        ("Madrid", (30, 32, 31)),
        ("Barcelona", (20, 26, 21)),
        ("Valencia", (28, 29, 27))
    )
    ciudad_buscar = input("Introduce el nombre de la ciudad: ")
    encontrada = False
    for ciudad, temperaturas in ciudades_temperaturas:
        if ciudad.lower() == ciudad_buscar.lower():
            media = sum(temperaturas) / len(temperaturas)
            print(f"La media de temperaturas de {ciudad} es {media:.1f}")
            encontrada = True
            break
    if not encontrada:
        print("Ciudad no encontrada.")

# Ejercicio 11
def ejercicio11():
    print("\nEjercicio 11:")
    digitos = tuple(str(i) for i in range(10))
    letras = tuple("abcdefghijklmnopqrstuvwxyz")
    caracteres = tuple("!\"#$%&/()=?¿{}[]+*-_@<>")

    while True:
        longitud = input("Introduce la longitud de la contraseña (8-64): ")
        if longitud.isdigit() and 8 <= int(longitud) <= 64:
            longitud = int(longitud)
            break

    # Contraseña fuerte
    num_digitos = max(1, longitud * 20 // 100)
    num_letras = max(1, longitud * 40 // 100)
    num_carac = max(1, longitud - num_digitos - num_letras)

    contraseña_fuerte = tuple(
        random.choice(digitos) for _ in range(num_digitos)
    ) + tuple(
        random.choice(letras) for _ in range(num_letras)
    ) + tuple(
        random.choice(caracteres) for _ in range(num_carac)
    )
    contraseña_fuerte = tuple(random.sample(contraseña_fuerte, len(contraseña_fuerte)))

    # Contraseña débil
    num_digitos_d = max(1, longitud * 80 // 100)
    num_letras_d = max(1, longitud * 15 // 100)
    num_carac_d = max(1, longitud - num_digitos_d - num_letras_d)

    contraseña_debil = tuple(
        random.choice(digitos) for _ in range(num_digitos_d)
    ) + tuple(
        random.choice(letras) for _ in range(num_letras_d)
    ) + tuple(
        random.choice(caracteres) for _ in range(num_carac_d)
    )
    contraseña_debil = tuple(random.sample(contraseña_debil, len(contraseña_debil)))

    print("Contraseña fuerte:", "".join(contraseña_fuerte))
    print("Contraseña débil:", "".join(contraseña_debil))

def menu():
    print(Fore.YELLOW + """
------------------------------
1️⃣   Ejercicio1:
2️⃣   Ejercicio2:
3️⃣   Ejercicio3: 
4️⃣   Ejercicio4: 
5️⃣   Ejercicio5: 
6️⃣   Ejercicio6: 
7️⃣   Ejercicio7: 
8️⃣   Ejercicio8: 
9️⃣   Ejercicio9: 
🔟   Ejercicio10: 
1️⃣ 1️⃣   Ejercicio11: 
0️⃣   Apagar calculadora
------------------------------
""" + Style.RESET_ALL)



#Haz un menu para ejecutar los ejercicios
def main():
    print("\n" *3)
    print(Fore.BLUE + "----👨‍🔬🧮 EJERCICIOS TUPLAS 🧮👨‍🔬----" + Style.RESET_ALL)
    print(Fore.BLUE + "------------------------------------------------" + Style.RESET_ALL)
    print("\n")
    
    while True:
        menu()
        opcion = input(Fore.BLUE + "Selecciona una opción: " + Style.RESET_ALL)

        if opcion == "1":
            ejercicio1()
        elif opcion == "2":
            ejercicio2()
        elif opcion == "3":
            ejercicio3()
        elif opcion == "4":
            ejercicio4()
        elif opcion == "5":
            ejercicio5()
        elif opcion == "6":
            ejercicio6()
        elif opcion == "7":
            ej7= ejercicio7()
        elif opcion == "8":
            ejercicio8(ej7)
        elif opcion == "9":
            ejercicio9()
        elif opcion == "10":
            ejercicio10()
        elif opcion == "11":
            ejercicio11()
        elif opcion == "0":
            print(Fore.LIGHTYELLOW_EX + "Saliendo de la calculadora... 👋" + Style.RESET_ALL)
            break
        else:
            print(Fore.RED + "❌⛔ Opción no válida, intenta de nuevo. ⛔❌" + Style.RESET_ALL)
main()