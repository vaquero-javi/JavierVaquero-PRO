#TORRRES DE HANOI
niveles = input("Introduce el numero de niveles que quieres que tenga la torre: ")

def hanoi(niveles, origen, destino, auxiliar):
    if niveles == 1:    # X(1) = 1
        print("Mueve el disco 1 desde la torre", origen, "hasta la torre", destino)
        return
    hanoi(niveles - 1, origen, auxiliar, destino)   #(X(n-1)) movimientos
    print("Mueve el disco", niveles, "desde la torre", origen, "hasta la torre", destino) # +1 movimiento
    hanoi(niveles - 1, auxiliar, destino, origen)   #(X(n-1)) movimientos
hanoi(int(niveles), 'A', 'C', 'B')