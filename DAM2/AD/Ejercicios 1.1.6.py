import random
import time

tiempoTotal = random.randint(8, 15)
numRandom = random.randint(1,100)
print("Este juego consiste en adivinar un numero en unos segundos determinados")
print(f"Tienes {tiempoTotal} segundos para adivinar el numero")

tiempoInicio = time.time()
    
while True:
    tiempoRestante = tiempoTotal - (time.time() - tiempoInicio)
    if (tiempoRestante <= 0):
        print("Has perdido, se acabó el tiempo")
        break
        
    numAdivinar = int(input("Adivina el numero: ").isdigits)
    if(numAdivinar<numRandom):
        print(f"Número introducido: {numAdivinar}")
        print("Es mayor")
    elif(numAdivinar>numRandom):
        print("Número introducido: {numAdivinar}")
        print("Es menor")
    else:
        print("¡¡¡¡¡ENHORABUENA HAS ACERTADO!!!!!")
        break
    