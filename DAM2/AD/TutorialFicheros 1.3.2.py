
import os
import time

def mostrar_titulo():
    print("=" * 70)
    print("          TUTORIAL INTERACTIVO - MANEJO DE FICHEROS EN PYTHON")
    print("=" * 70)
    print()

def pausa():
    input("Presiona Enter para continuar...")
    print()

def paso_1_explicacion():
    print("📖 PASO 1: LECTURA DE FICHEROS")
    print("-" * 50)
    print("Para leer un fichero en Python usamos la función open():")
    print()
    print("📝 Código:")
    print('''with open('palabras.txt', 'r', encoding='utf-8') as archivo:
    contenido = archivo.read()''')
    print()
    print("🔍 Explicación:")
    print("• 'r' = modo lectura (read)")
    print("• encoding='utf-8' = para caracteres especiales (tildes, ñ)")
    print("• with = asegura que el archivo se cierre automáticamente")
    print("• archivo.read() = lee todo el contenido como texto")
    pausa()

def paso_2_explicacion():
    print("📖 PASO 2: PROCESAMIENTO DE TEXTO")
    print("-" * 50)
    print("Una vez leído el contenido, lo procesamos:")
    print()
    print("📝 Código:")
    print('''palabras = contenido.split()  # Divide por espacios
vocales = 'aeiouáéíóúAEIOUÁÉÍÓÚ'
total_vocales = sum(1 for char in contenido if char in vocales)''')
    print()
    print("🔍 Explicación:")
    print("• split() = convierte texto en lista de palabras")
    print("• sum() = cuenta elementos que cumplen condición")
    print("• comprensión de generador = forma eficiente de contar")
    pausa()

def paso_3_explicacion():
    print("📖 PASO 3: CONTEO DE FRECUENCIAS")
    print("-" * 50)
    print("Contamos cuántas veces aparece cada palabra:")
    print()
    print("📝 Código:")
    print('''frecuencia = {}
for palabra in palabras:
    palabra_limpia = palabra.strip('.,!?;:"()[]').lower()
    frecuencia[palabra_limpia] = frecuencia.get(palabra_limpia, 0) + 1''')
    print()
    print("🔍 Explicación:")
    print("• strip() = elimina signos de puntuación")
    print("• lower() = convierte a minúsculas (case-insensitive)")
    print("• dict.get() = método seguro para diccionarios")
    pausa()

def paso_4_explicacion():
    print("📖 PASO 4: ESCRITURA DE FICHEROS")
    print("-" * 50)
    print("Guardamos los resultados en nuevos ficheros:")
    print()
    print("📝 Código:")
    print('''with open('salida.txt', 'w', encoding='utf-8') as archivo:
    archivo.write("Resultados del análisis\\\\n")
    archivo.write(f"Total palabras: {total_palabras}\\\\n")''')
    print()
    print("🔍 Explicación:")
    print("• 'w' = modo escritura (write - sobrescribe)")
    print("• 'a' = modo añadir (append - agrega al final)")
    print("• f-strings = formato moderno de strings")
    pausa()

def demostracion_practica():
    print("🎯 DEMOSTRACIÓN PRÁCTICA")
    print("-" * 50)
    
    # Crear archivo de ejemplo si no existe
    if not os.path.exists('palabras.txt'):
        print("📝 Creando archivo de ejemplo 'palabras.txt'...")
        texto_ejemplo = """hola mundo hola python programación
canción niña año café mundo python hola
este es un ejemplo de texto para el tutorial"""
        
        with open('palabras.txt', 'w', encoding='utf-8') as f:
            f.write(texto_ejemplo)
        print("✅ Archivo creado con éxito")
        pausa()
    
    # Leer y mostrar contenido
    print("📖 Leyendo contenido del archivo...")
    with open('palabras.txt', 'r', encoding='utf-8') as archivo:
        contenido = archivo.read()
    
    print("Contenido del archivo:")
    print("┌" + "─" * 50 + "┐")
    print(contenido)
    print("└" + "─" * 50 + "┘")
    pausa()
    
    # Procesar palabras
    print("🔍 Procesando palabras...")
    palabras = contenido.split()
    print(f"Lista de palabras: {palabras}")
    print(f"Total de palabras: {len(palabras)}")
    pausa()
    
    # Contar vocales
    print("🔢 Contando vocales...")
    vocales = 'aeiouáéíóúAEIOUÁÉÍÓÚ'
    total_vocales = sum(1 for caracter in contenido if caracter in vocales)
    print(f"Total de vocales encontradas: {total_vocales}")
    pausa()
    
    # Contar frecuencia
    print("📊 Analizando frecuencia de palabras...")
    frecuencia_palabras = {}
    for palabra in palabras:
        palabra_limpia = palabra.strip('.,!?;:"()[]').lower()
        if palabra_limpia:
            frecuencia_palabras[palabra_limpia] = frecuencia_palabras.get(palabra_limpia, 0) + 1
    
    print("Frecuencia de palabras:")
    for palabra, count in sorted(frecuencia_palabras.items(), key=lambda x: x[1], reverse=True):
        print(f"  '{palabra}': {count} veces")
    
    # Encontrar las más repetidas
    max_repeticiones = max(frecuencia_palabras.values())
    palabras_mas_repetidas = [p for p, c in frecuencia_palabras.items() if c == max_repeticiones]
    
    print(f"\n🏆 Palabra(s) más repetida(s): {', '.join(palabras_mas_repetidas)} ({max_repeticiones} veces)")
    pausa()
    
    # Guardar resultados
    print("💾 Guardando resultados en 'salida.txt'...")
    with open('salida.txt', 'w', encoding='utf-8') as archivo:
        archivo.write("=== ANÁLISIS DE TEXTO ===\n\n")
        archivo.write(f"📊 Total de palabras: {len(palabras)}\n")
        archivo.write(f"🔢 Total de vocales: {total_vocales}\n\n")
        archivo.write("📈 Frecuencia de palabras:\n")
        for palabra, count in sorted(frecuencia_palabras.items(), key=lambda x: x[1], reverse=True):
            archivo.write(f"   '{palabra}': {count} veces\n")
        archivo.write(f"\n🏆 Palabra(s) más repetida(s): {', '.join(palabras_mas_repetidas)} ({max_repeticiones} veces)\n")
    
    print("✅ Resultados guardados en 'salida.txt'")
    
    # Crear segundo archivo
    print("💾 Creando 'salida2.txt' con formato diferente...")
    with open('salida2.txt', 'w', encoding='utf-8') as archivo:
        archivo.write("INFORME DETALLADO\n")
        archivo.write("=" * 30 + "\n\n")
        archivo.write(f"PALABRAS ÚNICAS: {len(frecuencia_palabras)}\n")
        archivo.write(f"PALABRAS TOTALES: {len(palabras)}\n\n")
        archivo.write("TOP 5 PALABRAS MÁS FRECUENTES:\n")
        top_5 = sorted(frecuencia_palabras.items(), key=lambda x: x[1], reverse=True)[:5]
        for i, (palabra, count) in enumerate(top_5, 1):
            archivo.write(f"{i}. {palabra}: {count} veces\n")
    
    print("✅ Segundo archivo creado: 'salida2.txt'")
    pausa()

def mostrar_resumen():
    print("🎓 RESUMEN DEL TUTORIAL")
    print("-" * 50)
    print("✅ Hemos aprendido:")
    print("   • Lectura de ficheros con open() y with")
    print("   • Procesamiento de texto (split, strip, lower)")
    print("   • Conteo y análisis de datos")
    print("   • Escritura de ficheros en diferentes formatos")
    print("   • Manejo de codificación UTF-8 para caracteres especiales")
    print()
    print("📁 Archivos creados:")
    print("   • palabras.txt (ejemplo)")
    print("   • salida.txt (resultados completos)")
    print("   • salida2.txt (formato alternativo)")
    print()
    print("🚀 ¡Ahora puedes aplicar estos conceptos a tus propios proyectos!")

def tutorial_ficheros():
    mostrar_titulo()
    
    print("Bienvenido al tutorial interactivo de manejo de ficheros en Python.")
    print("Este tutorial te guiará paso a paso por el proceso completo.")
    pausa()
    
    # Explicaciones teóricas
    paso_1_explicacion()
    paso_2_explicacion()
    paso_3_explicacion()
    paso_4_explicacion()
    
    # Demostración práctica
    demostracion_practica()
    
    # Resumen
    mostrar_resumen()
    
    print("\n" + "=" * 70)
    print("¡Tutorial completado! Revisa los archivos generados.")
    print("=" * 70)

# Ejecutar el tutorial
if __name__ == "__main__":
    tutorial_ficheros()