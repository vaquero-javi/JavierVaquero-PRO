import json
import os
from datetime import datetime

# Clase para representar un nodo de la lista enlazada
class Nodo:
    def __init__(self, animal):
        self.animal = animal
        self.siguiente = None

# Clase para representar una cola implementada con lista enlazada
class ColaAnimales:
    def __init__(self):
        self.frente = None
        self.final = None
        self.tamanio = 0
    
    def cola_vacia(self):
        """Verifica si la cola está vacía"""
        return self.frente is None
    
    def encolar(self, animal):
        """Agrega un animal al final de la cola"""
        nuevo_nodo = Nodo(animal)
        
        if self.cola_vacia():
            self.frente = nuevo_nodo
            self.final = nuevo_nodo
        else:
            self.final.siguiente = nuevo_nodo
            self.final = nuevo_nodo
        
        self.tamanio += 1
        print(f"Animal '{animal['nombre']}' encolado correctamente.")
    
    def desencolar(self):
        """Elimina y retorna el animal del frente de la cola"""
        if self.cola_vacia():
            print("La cola está vacía. No se puede desencolar.")
            return None
        
        animal_desencolado = self.frente.animal
        self.frente = self.frente.siguiente
        
        # Si el frente es None, también actualizamos final a None
        if self.frente is None:
            self.final = None
        
        self.tamanio -= 1
        print(f"Animal '{animal_desencolado['nombre']}' desencolado correctamente.")
        return animal_desencolado
    
    def frente_cola(self):
        """Muestra el animal que está en el frente de la cola"""
        if self.cola_vacia():
            print("La cola está vacía.")
            return None
        
        return self.frente.animal
    
    def imprimir_cola(self):
        """Muestra todos los elementos de la cola"""
        if self.cola_vacia():
            print("La cola está vacía.")
            return
        
        print("\n=== CONTENIDO DE LA COLA ===")
        actual = self.frente
        posicion = 1
        
        while actual:
            animal = actual.animal
            print(f"{posicion}. {animal['nombre']} - {animal['especie']} ({animal['tipo']})")
            actual = actual.siguiente
            posicion += 1
        
        print(f"Total: {self.tamanio} animales\n")
    
    def contar(self):
        """Muestra el número de elementos en la cola"""
        print(f"La cola contiene {self.tamanio} animales.")
        return self.tamanio
    
    def invertir_cola(self):
        """Crea una nueva cola con los elementos en orden inverso"""
        if self.cola_vacia():
            print("La cola está vacía. No se puede invertir.")
            return ColaAnimales()
        
        # Primero, copiamos los animales a una lista
        animales = []
        actual = self.frente
        
        while actual:
            animales.append(actual.animal)
            actual = actual.siguiente
        
        # Creamos una nueva cola con los elementos en orden inverso
        cola_invertida = ColaAnimales()
        
        for animal in reversed(animales):
            cola_invertida.encolar(animal)
        
        print("Cola invertida creada correctamente.")
        return cola_invertida
    
    def copiar_cola(self):
        """Crea una copia exacta de la cola"""
        if self.cola_vacia():
            print("La cola está vacía. No se puede copiar.")
            return ColaAnimales()
        
        cola_copiada = ColaAnimales()
        actual = self.frente
        
        while actual:
            # Crear una copia del diccionario del animal
            animal_copia = actual.animal.copy()
            cola_copiada.encolar(animal_copia)
            actual = actual.siguiente
        
        print("Cola copiada correctamente.")
        return cola_copiada
    
    def vaciar_cola(self):
        """Elimina todos los elementos de la cola"""
        if self.cola_vacia():
            print("La cola ya está vacía.")
            return
        
        # En una lista enlazada, basta con establecer frente y final a None
        self.frente = None
        self.final = None
        elementos_eliminados = self.tamanio
        self.tamanio = 0
        
        print(f"Cola vaciada correctamente. Se eliminaron {elementos_eliminados} animales.")
    
    def guardar_cola(self, nombre_archivo):
        """Guarda el contenido de la cola en un archivo JSON"""
        if self.cola_vacia():
            print("La cola está vacía. No hay nada que guardar.")
            return False
        
        # Recopilar todos los animales de la cola
        animales = []
        actual = self.frente
        
        while actual:
            animales.append(actual.animal)
            actual = actual.siguiente
        
        # Crear diccionario con metadatos y datos
        datos_guardar = {
            "fecha_guardado": datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
            "total_animales": self.tamanio,
            "animales": animales
        }
        
        try:
            with open(nombre_archivo, 'w', encoding='utf-8') as archivo:
                json.dump(datos_guardar, archivo, indent=4, ensure_ascii=False)
            
            print(f"Cola guardada correctamente en '{nombre_archivo}'.")
            return True
        except Exception as e:
            print(f"Error al guardar la cola: {e}")
            return False
    
    def cargar_cola(self, nombre_archivo):
        """Carga una cola desde un archivo JSON"""
        if not os.path.exists(nombre_archivo):
            print(f"El archivo '{nombre_archivo}' no existe.")
            return False
        
        try:
            with open(nombre_archivo, 'r', encoding='utf-8') as archivo:
                datos = json.load(archivo)
            
            # Vaciar la cola actual antes de cargar
            self.vaciar_cola()
            
            # Cargar los animales
            for animal in datos["animales"]:
                self.encolar(animal)
            
            print(f"Cola cargada correctamente desde '{nombre_archivo}'.")
            print(f"Fecha del guardado original: {datos['fecha_guardado']}")
            print(f"Total de animales cargados: {datos['total_animales']}")
            return True
        except Exception as e:
            print(f"Error al cargar la cola: {e}")
            return False

# Funciones auxiliares para la interfaz
def pedir_datos_animal():
    """Solicita al usuario los datos de un animal vertebrado"""
    print("\n=== INGRESO DE ANIMAL VERTEBRADO ===")
    
    nombre = input("Nombre del animal: ").strip()
    while not nombre:
        nombre = input("El nombre no puede estar vacío. Ingrese nombre del animal: ").strip()
    
    especie = input("Especie: ").strip()
    while not especie:
        especie = input("La especie no puede estar vacía. Ingrese especie: ").strip()
    
    print("\nTipos de vertebrados disponibles:")
    print("1. Mamífero")
    print("2. Ave")
    print("3. Reptil")
    print("4. Anfibio")
    print("5. Pez")
    
    tipo_opcion = input("Seleccione el tipo (1-5): ").strip()
    tipos = {
        '1': 'Mamífero',
        '2': 'Ave',
        '3': 'Reptil',
        '4': 'Anfibio',
        '5': 'Pez'
    }
    
    tipo = tipos.get(tipo_opcion, 'Desconocido')
    
    habitat = input("Hábitat (opcional, presione Enter para omitir): ").strip()
    dieta = input("Dieta (opcional, presione Enter para omitir): ").strip()
    
    animal = {
        'nombre': nombre,
        'especie': especie,
        'tipo': tipo,
        'habitat': habitat if habitat else "No especificado",
        'dieta': dieta if dieta else "No especificado",
        'fecha_ingreso': datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    }
    
    return animal

def mostrar_menu():
    """Muestra el menú principal de la aplicación"""
    print("\n" + "="*50)
    print("         GESTIÓN DE COLA DE ANIMALES VERTEBRADOS")
    print("="*50)
    print("1. Encolar un animal")
    print("2. Desencolar un animal")
    print("3. Mostrar animal en el frente")
    print("4. Imprimir toda la cola")
    print("5. Contar animales en la cola")
    print("6. Invertir cola (crear nueva cola invertida)")
    print("7. Copiar cola (crear copia exacta)")
    print("8. Vaciar cola")
    print("9. Guardar cola en archivo")
    print("10. Cargar cola desde archivo")
    print("11. Salir")
    print("="*50)

def main():
    """Función principal de la aplicación"""
    print("BIENVENIDO AL SISTEMA DE GESTIÓN DE ANIMALES VERTEBRADOS")
    print("Este sistema utiliza colas implementadas con listas enlazadas.")
    
    # Crear la cola principal
    cola_principal = ColaAnimales()
    # Variable para almacenar colas adicionales (invertida, copiada, etc.)
    colas_adicionales = {}
    contador_colas = 0
    
    while True:
        mostrar_menu()
        
        opcion = input("\nSeleccione una opción (1-11): ").strip()
        
        if opcion == '1':
            # Encolar un animal
            animal = pedir_datos_animal()
            cola_principal.encolar(animal)
        
        elif opcion == '2':
            # Desencolar un animal
            animal_desencolado = cola_principal.desencolar()
            if animal_desencolado:
                print(f"\nAnimal desencolado:")
                print(f"  Nombre: {animal_desencolado['nombre']}")
                print(f"  Especie: {animal_desencolado['especie']}")
                print(f"  Tipo: {animal_desencolado['tipo']}")
        
        elif opcion == '3':
            # Mostrar animal en el frente
            animal_frente = cola_principal.frente_cola()
            if animal_frente:
                print(f"\nAnimal en el frente de la cola:")
                print(f"  Nombre: {animal_frente['nombre']}")
                print(f"  Especie: {animal_frente['especie']}")
                print(f"  Tipo: {animal_frente['tipo']}")
                print(f"  Hábitat: {animal_frente['habitat']}")
                print(f"  Dieta: {animal_frente['dieta']}")
        
        elif opcion == '4':
            # Imprimir toda la cola
            cola_principal.imprimir_cola()
        
        elif opcion == '5':
            # Contar animales en la cola
            cola_principal.contar()
        
        elif opcion == '6':
            # Invertir cola
            cola_invertida = cola_principal.invertir_cola()
            if not cola_invertida.cola_vacia():
                contador_colas += 1
                nombre_cola = f"cola_invertida_{contador_colas}"
                colas_adicionales[nombre_cola] = cola_invertida
                print(f"\nCola invertida creada y almacenada como '{nombre_cola}'.")
                print("Contenido de la cola invertida:")
                cola_invertida.imprimir_cola()
        
        elif opcion == '7':
            # Copiar cola
            cola_copiada = cola_principal.copiar_cola()
            if not cola_copiada.cola_vacia():
                contador_colas += 1
                nombre_cola = f"cola_copia_{contador_colas}"
                colas_adicionales[nombre_cola] = cola_copiada
                print(f"\nCopia de cola creada y almacenada como '{nombre_cola}'.")
        
        elif opcion == '8':
            # Vaciar cola
            confirmacion = input("¿Está seguro de que desea vaciar la cola? (S/N): ").strip().upper()
            if confirmacion == 'S':
                cola_principal.vaciar_cola()
            else:
                print("Operación cancelada.")
        
        elif opcion == '9':
            # Guardar cola en archivo
            nombre_archivo = input("Ingrese el nombre del archivo (ej: animales.json): ").strip()
            if not nombre_archivo:
                nombre_archivo = "animales_cola.json"
            elif not nombre_archivo.endswith('.json'):
                nombre_archivo += '.json'
            
            cola_principal.guardar_cola(nombre_archivo)
        
        elif opcion == '10':
            # Cargar cola desde archivo
            nombre_archivo = input("Ingrese el nombre del archivo a cargar: ").strip()
            if nombre_archivo:
                cola_principal.cargar_cola(nombre_archivo)
        
        elif opcion == '11':
            # Salir
            confirmacion = input("¿Está seguro de que desea salir? (S/N): ").strip().upper()
            if confirmacion == 'S':
                print("\n¡Gracias por usar el sistema de gestión de animales vertebrados!")
                break
        else:
            print("Opción no válida. Por favor, seleccione una opción del 1 al 11.")
        
        # Mostrar colas adicionales si existen
        if colas_adicionales:
            print(f"\nColas adicionales creadas: {list(colas_adicionales.keys())}")
        
        input("\nPresione Enter para continuar...")

if __name__ == "__main__":
    main()