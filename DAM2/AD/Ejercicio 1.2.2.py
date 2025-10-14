
def ejercicio1():
    print("Ejercicio 1")
    listaFrutas = ["manzana","pera","platano","mandarina","kiwi"]
    print(listaFrutas)
    print(listaFrutas[0])
    print(listaFrutas[-1])
ejercicio1()

def ejercicio2():
    print("Ejercicio 2")
    listaVacia = []
    listaVacia.append(1)
    listaVacia.append(2)
    listaVacia.append(3)
    listaVacia.remove(2)
    print(listaVacia)
ejercicio2()

def ejercicio3():
    print("Ejercicio 3")
    recorrerLista = [1,2,3,4,5]
    for item in recorrerLista:
        item * 2
        print(item)
ejercicio3

def ejercicio4():
    print("Ejercicio 4")
    buscarLista = ["manzana","pera","naranja"]
    palabra = input("introduce una palabra para saber si esta en la lista")
    if palabra in buscarLista:
        print(palabra+" esta en la lista")
    else:
        print(palabra+" no esta en la lista")
ejercicio4()