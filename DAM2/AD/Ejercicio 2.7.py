import os
import json
from datetime import datetime

# Clase Nodo para la lista enlazada
class Nodo:
    def __init__(self, dato):
        self.dato = dato
        self.siguiente = None

# Clase Pila implementada con lista enlazada
class Pila:
    def __init__(self):
        self.tope = None
        self.tamaño = 0
    
    def pila_vacia(self):
        """Verifica si la pila está vacía"""
        return self.tope is None
    
    def apilar(self, dato):
        """Apila un nuevo elemento en la pila"""
        nuevo_nodo = Nodo(dato)
        nuevo_nodo.siguiente = self.tope
        self.tope = nuevo_nodo
        self.tamaño += 1
        print(f"Se ha apilado: {dato}")
        return True
    
    def desapilar(self):
        """Desapila el elemento del tope de la pila"""
        if self.pila_vacia():
            print("La pila está vacía, no se puede desapilar.")
            return None
        
        dato_desapilado = self.tope.dato
        self.tope = self.tope.siguiente
        self.tamaño -= 1
        print(f"Se ha desapilado: {dato_desapilado}")
        return dato_desapilado
    
    def tope_pila(self):
        """Devuelve el elemento en el tope de la pila sin desapilarlo"""
        if self.pila_vacia():
            print("La pila está vacía.")
            return None
        return self.tope.dato
    
    def imprimir_pila(self):
        """Muestra todos los elementos de la pila"""
        if self.pila_vacia():
            print("La pila está vacía.")
            return
        
        print("Elementos de la pila (desde el tope hasta la base):")
        actual = self.tope
        contador = 1
        while actual:
            print(f"{contador}. {actual.dato}")
            actual = actual.siguiente
            contador += 1
    
    def contar(self):
        """Muestra el número de elementos de la pila"""
        print(f"La pila tiene {self.tamaño} elementos.")
        return self.tamaño
    
    def invertir_pila(self):
        """Crea y devuelve una nueva pila con los elementos en orden inverso"""
        pila_invertida = Pila()
        actual = self.tope
        
        while actual:
            pila_invertida.apilar(actual.dato)
            actual = actual.siguiente
        
        print("Pila invertida creada correctamente.")
        return pila_invertida
    
    def copiar_pila(self):
        """Crea y devuelve una copia exacta de la pila"""
        pila_copia = Pila()
        
        # Primero invertimos la pila original para mantener el orden
        pila_temp = Pila()
        actual = self.tope
        
        # Apilamos todos los elementos en pila_temp (esto los invierte)
        while actual:
            pila_temp.apilar(actual.dato)
            actual = actual.siguiente
        
        # Desapilamos de pila_temp para restaurar el orden original en pila_copia
        while not pila_temp.pila_vacia():
            pila_copia.apilar(pila_temp.desapilar())
        
        # Ajustamos el tamaño
        pila_copia.tamaño = self.tamaño
        
        print("Pila copiada correctamente.")
        return pila_copia
    
    def vaciar_pila(self):
        """Vacía completamente la pila"""
        while not self.pila_vacia():
            self.desapilar()
        print("La pila ha sido vaciada completamente.")
    
    def guardar_pila(self, nombre_archivo="pila_marcas.json"):
        """Guarda la pila en un archivo JSON"""
        if self.pila_vacia():
            print("La pila está vacía, no hay nada que guardar.")
            return False
        
        # Preparar los datos para guardar
        datos_pila = {
            "fecha_guardado": datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
            "tamaño_pila": self.tamaño,
            "elementos": []
        }
        
        # Recorrer la pila para obtener los elementos
        actual = self.tope
        while actual:
            datos_pila["elementos"].append(actual.dato)
            actual = actual.siguiente
        
        # Guardar en archivo JSON
        try:
            with open(nombre_archivo, 'w', encoding='utf-8') as archivo:
                json.dump(datos_pila, archivo, indent=2, ensure_ascii=False)
            print(f"Pila guardada correctamente en '{nombre_archivo}'")
            return True
        except Exception as e:
            print(f"Error al guardar la pila: {e}")
            return False
    
    def cargar_pila(self, nombre_archivo="pila_marcas.json"):
        """Carga una pila desde un archivo JSON"""
        try:
            with open(nombre_archivo, 'r', encoding='utf-8') as archivo:
                datos_pila = json.load(archivo)
            
            # Vaciar la pila actual
            self.vaciar_pila()
            
            # Apilar los elementos (nota: el JSON guarda desde la base al tope)
            elementos = datos_pila["elementos"]
            # Necesitamos invertir la lista para apilar en el orden correcto
            for elemento in reversed(elementos):
                self.apilar(elemento)
            
            print(f"Pila cargada correctamente desde '{nombre_archivo}'")
            print(f"Fecha del guardado original: {datos_pila.get('fecha_guardado', 'Desconocida')}")
            return True
        except FileNotFoundError:
            print(f"Error: El archivo '{nombre_archivo}' no existe.")
            return False
        except Exception as e:
            print(f"Error al cargar la pila: {e}")
            return False

# Función principal del programa
def main():
    pila_principal = Pila()
    
    while True:
        print("\n" + "="*50)
        print("MENÚ PRINCIPAL - PILA DE MARCAS DE COCHES")
        print("="*50)
        print("1. Apilar una marca de coche")
        print("2. Desapilar una marca de coche")
        print("3. Ver el tope de la pila")
        print("4. Verificar si la pila está vacía")
        print("5. Imprimir todos los elementos de la pila")
        print("6. Contar elementos de la pila")
        print("7. Invertir la pila")
        print("8. Copiar la pila")
        print("9. Vaciar la pila")
        print("10. Guardar pila en archivo")
        print("11. Cargar pila desde archivo")
        print("0. Salir")
        print("="*50)
        
        opcion = input("Seleccione una opción: ")
        
        if opcion == "1":
            marca = input("Introduzca la marca de coche a apilar: ").strip()
            if marca:
                pila_principal.apilar(marca)
            else:
                print("Error: No se puede apilar una marca vacía.")
        
        elif opcion == "2":
            if not pila_principal.pila_vacia():
                desapilado = pila_principal.desapilar()
            else:
                print("La pila ya está vacía.")
        
        elif opcion == "3":
            tope = pila_principal.tope_pila()
            if tope is not None:
                print(f"El tope de la pila es: {tope}")
        
        elif opcion == "4":
            if pila_principal.pila_vacia():
                print("La pila está vacía.")
            else:
                print("La pila NO está vacía.")
        
        elif opcion == "5":
            pila_principal.imprimir_pila()
        
        elif opcion == "6":
            pila_principal.contar()
        
        elif opcion == "7":
            if not pila_principal.pila_vacia():
                pila_invertida = pila_principal.invertir_pila()
                print("\nContenido de la pila invertida:")
                pila_invertida.imprimir_pila()
                
                # Preguntar si desea guardar la pila invertida
                guardar = input("\n¿Desea guardar la pila invertida en un archivo? (s/n): ").lower()
                if guardar == 's':
                    nombre = input("Nombre del archivo (presione Enter para usar 'pila_invertida.json'): ").strip()
                    if not nombre:
                        nombre = "pila_invertida.json"
                    pila_invertida.guardar_pila(nombre)
            else:
                print("No se puede invertir una pila vacía.")
        
        elif opcion == "8":
            if not pila_principal.pila_vacia():
                pila_copia = pila_principal.copiar_pila()
                print("\nContenido de la copia de la pila:")
                pila_copia.imprimir_pila()
                
                # Preguntar si desea guardar la copia
                guardar = input("\n¿Desea guardar la copia en un archivo? (s/n): ").lower()
                if guardar == 's':
                    nombre = input("Nombre del archivo (presione Enter para usar 'pila_copia.json'): ").strip()
                    if not nombre:
                        nombre = "pila_copia.json"
                    pila_copia.guardar_pila(nombre)
            else:
                print("No se puede copiar una pila vacía.")
        
        elif opcion == "9":
            if not pila_principal.pila_vacia():
                confirmar = input("¿Está seguro de que desea vaciar la pila? (s/n): ").lower()
                if confirmar == 's':
                    pila_principal.vaciar_pila()
                else:
                    print("Operación cancelada.")
            else:
                print("La pila ya está vacía.")
        
        elif opcion == "10":
            if not pila_principal.pila_vacia():
                nombre = input("Nombre del archivo (presione Enter para usar 'pila_marcas.json'): ").strip()
                if not nombre:
                    nombre = "pila_marcas.json"
                pila_principal.guardar_pila(nombre)
            else:
                print("No se puede guardar una pila vacía.")
        
        elif opcion == "11":
            nombre = input("Nombre del archivo a cargar (presione Enter para usar 'pila_marcas.json'): ").strip()
            if not nombre:
                nombre = "pila_marcas.json"
            
            # Preguntar si desea guardar la pila actual antes de cargar
            if not pila_principal.pila_vacia():
                guardar = input("¿Desea guardar la pila actual antes de cargar una nueva? (s/n): ").lower()
                if guardar == 's':
                    nombre_guardar = input("Nombre del archivo para guardar: ").strip()
                    if not nombre_guardar:
                        nombre_guardar = "pila_actual.json"
                    pila_principal.guardar_pila(nombre_guardar)
            
            pila_principal.cargar_pila(nombre)
        
        elif opcion == "0":
            # Preguntar si desea guardar antes de salir
            if not pila_principal.pila_vacia():
                guardar = input("¿Desea guardar la pila antes de salir? (s/n): ").lower()
                if guardar == 's':
                    nombre = input("Nombre del archivo (presione Enter para usar 'pila_marcas.json'): ").strip()
                    if not nombre:
                        nombre = "pila_marcas.json"
                    pila_principal.guardar_pila(nombre)
            
            print("¡Gracias por usar la aplicación! ¡Hasta pronto!")
            break
        
        else:
            print("Opción no válida. Por favor, seleccione una opción del menú.")

# Ejecutar la aplicación
if __name__ == "__main__":
    print("BIENVENIDO A LA APLICACIÓN DE PILAS DE MARCAS DE COCHES")
    print("Implementada con listas enlazadas")
    print("-" * 50)
    main()