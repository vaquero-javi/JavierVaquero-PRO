
def procesar_palabras():
    # Leer el archivo palabras.txt
    try:
        with open('palabras.txt', 'r', encoding='utf-8') as archivo:
            contenido = archivo.read()
    except FileNotFoundError:
        print("Error: No se encontró el archivo 'palabras.txt'")
        return
    
    # Dividir el contenido en palabras
    palabras = contenido.split()
    
    # Contar total de palabras
    total_palabras = len(palabras)
    
    # Contar total de vocales
    vocales = 'aeiouáéíóúAEIOUÁÉÍÓÚ'
    total_vocales = sum(1 for caracter in contenido if caracter in vocales)
    
    # Contar frecuencia de palabras
    frecuencia_palabras = {}
    for palabra in palabras:
        palabra_limpia = palabra.strip('.,!?;:"()[]').lower()
        if palabra_limpia:  # Evitar strings vacíos
            frecuencia_palabras[palabra_limpia] = frecuencia_palabras.get(palabra_limpia, 0) + 1
    
    # Encontrar palabras que se repiten (más de una vez)
    palabras_repetidas = {palabra: count for palabra, count in frecuencia_palabras.items() if count > 1}
    
    # Encontrar la(s) palabra(s) que más se repite(n)
    if frecuencia_palabras:
        max_repeticiones = max(frecuencia_palabras.values())
        palabras_mas_repetidas = [palabra for palabra, count in frecuencia_palabras.items() 
                                if count == max_repeticiones]
    else:
        max_repeticiones = 0
        palabras_mas_repetidas = []
    
    # Mostrar resultados por pantalla
    print("/n"*3)
    print("=== RESULTADOS ===")
    print(f"Número total de palabras: {total_palabras}")
    print(f"Número total de vocales: {total_vocales}")
    print("\nPalabras que se repiten:")
    for palabra, count in sorted(palabras_repetidas.items(), key=lambda x: x[1], reverse=True):
        print(f"  '{palabra}': {count} veces")
    
    print(f"\nPalabra(s) que más se repite(n):")
    for palabra in palabras_mas_repetidas:
        print(f"  '{palabra}': {max_repeticiones} veces")
    
    # Escribir en salida.txt
    with open('salida.txt', 'w', encoding='utf-8') as archivo_salida:
        archivo_salida.write("=== RESULTADOS ===\n")
        archivo_salida.write(f"Número total de palabras: {total_palabras}\n")
        archivo_salida.write(f"Número total de vocales: {total_vocales}\n")
        archivo_salida.write("\nPalabras que se repiten:\n")
        for palabra, count in sorted(palabras_repetidas.items(), key=lambda x: x[1], reverse=True):
            archivo_salida.write(f"  '{palabra}': {count} veces\n")
        
        archivo_salida.write(f"\nPalabra(s) que más se repite(n):\n")
        for palabra in palabras_mas_repetidas:
            archivo_salida.write(f"  '{palabra}': {max_repeticiones} veces\n")
    
    # Escribir en salida2.txt (solo información de repeticiones)
    with open('salida2.txt', 'w', encoding='utf-8') as archivo_salida2:
        archivo_salida2.write("=== PALABRAS REPETIDAS ===\n")
        archivo_salida2.write("\nPalabras que se repiten:\n")
        for palabra, count in sorted(palabras_repetidas.items(), key=lambda x: x[1], reverse=True):
            archivo_salida2.write(f"  '{palabra}': {count} veces\n")
        
        archivo_salida2.write(f"\nPalabra(s) que más se repite(n):\n")
        for palabra in palabras_mas_repetidas:
            archivo_salida2.write(f"  '{palabra}': {max_repeticiones} veces\n")
    
    print(f"\nResultados guardados en 'salida.txt' y 'salida2.txt'")

# Ejecutar la función
if __name__ == "__main__":
    procesar_palabras()