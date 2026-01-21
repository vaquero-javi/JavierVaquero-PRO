"""
Programa para implementar listas mediante la simulación de punteros usando diccionarios.
Autor: [Tu nombre]
Fecha: [Fecha actual]
"""

import json
import os

# ============================================================
# CLASE BASE PARA TODAS LAS LISTAS
# ============================================================
class ListaBase:
    """Clase base que contiene las funcionalidades comunes a todas las listas"""
    
    def __init__(self):
        """Inicializa una lista vacía"""
        self.inicio = None
        self.fin = None
        self.contador_nodos = 0
        self.tipo_lista = "base"
        
    def validar_valor(self, valor):
        """
        Valida que el valor esté entre 1 y 98.
        0 y 99 tienen significados especiales según la especificación.
        
        Args:
            valor: Valor a validar
            
        Returns:
            bool: True si el valor es válido, False en caso contrario
        """
        if valor == 0 or valor == 99:
            return True  # Valores especiales permitidos
        return 1 <= valor <= 98
    
    def crear_nodo(self, valor):
        """
        Crea un nuevo nodo (diccionario) con el valor especificado.
        
        Args:
            valor: Valor a almacenar en el nodo
            
        Returns:
            dict: Nodo creado o None si el valor no es válido
        """
        if not self.validar_valor(valor):
            print(f"Error: El valor {valor} no está entre 1 y 98 (0 y 99 son valores especiales)")
            return None
            
        nodo = {
            'valor': valor,
            'siguiente': None,
            'anterior': None,
            'id': self.contador_nodos + 1  # ID único para facilitar la identificación
        }
        return nodo
    
    def insertar_inicio(self, valor):
        """
        Inserta un nodo al inicio de la lista.
        Si la lista está vacía, la crea con este nodo.
        
        Args:
            valor: Valor a insertar
        """
        raise NotImplementedError("Método no implementado en la clase base")
    
    def insertar_nodo(self, valor, posicion):
        """
        Inserta un nodo en una posición específica.
        Si la posición es 0, inserta al inicio.
        Si la posición es mayor que el número de nodos, inserta al final.
        
        Args:
            valor: Valor a insertar
            posicion: Posición donde insertar (0-indexed)
        """
        raise NotImplementedError("Método no implementado en la clase base")
    
    def insertar_final(self, valor):
        """
        Inserta un nodo al final de la lista.
        
        Args:
            valor: Valor a insertar
        """
        raise NotImplementedError("Método no implementado en la clase base")
    
    def contar_nodos(self):
        """
        Cuenta el número de nodos en la lista.
        
        Returns:
            int: Número de nodos en la lista
        """
        return self.contador_nodos
    
    def eliminar_nodo(self, valor):
        """
        Elimina el nodo con el valor especificado.
        
        Args:
            valor: Valor del nodo a eliminar
            
        Returns:
            bool: True si se eliminó, False si no se encontró
        """
        raise NotImplementedError("Método no implementado en la clase base")
    
    def imprimir_valor_lista(self):
        """Imprime solo los valores de los nodos de la lista"""
        if self.inicio is None:
            print("Lista vacía")
            return
            
        actual = self.inicio
        print("Valores de la lista: ", end="")
        while actual is not None:
            print(actual['valor'], end=" -> " if actual['siguiente'] is not None else "")
            actual = actual['siguiente']
            # Para listas circulares, necesitamos detenernos para evitar bucle infinito
            if actual == self.inicio:
                print("↻ (circular)")
                break
        if self.inicio and actual != self.inicio:
            print()
    
    def imprimir_lista_completa(self):
        """Imprime todos los campos de cada nodo de la lista"""
        if self.inicio is None:
            print("Lista vacía")
            return
            
        actual = self.inicio
        contador = 0
        
        print("\n" + "="*60)
        print(f"LISTA COMPLETA ({self.tipo_lista}) - {self.contador_nodos} nodos")
        print("="*60)
        
        while actual is not None:
            print(f"Nodo ID: {actual['id']}")
            print(f"  Valor: {actual['valor']}")
            print(f"  Siguiente: {actual['siguiente']['valor'] if actual['siguiente'] else 'None'}")
            print(f"  Anterior: {actual['anterior']['valor'] if actual['anterior'] else 'None'}")
            print("-" * 40)
            
            actual = actual['siguiente']
            contador += 1
            
            # Para evitar bucles infinitos en listas circulares
            if actual == self.inicio or contador > self.contador_nodos:
                break
    
    def imprimir_reves(self):
        """
        Imprime la lista desde el final al principio.
        Solo implementado para listas doblemente enlazadas.
        """
        raise NotImplementedError("Esta operación solo está disponible para listas doblemente enlazadas")
    
    def buscar_nodo(self, valor):
        """
        Busca un nodo con el valor especificado.
        
        Args:
            valor: Valor a buscar
            
        Returns:
            dict: Nodo encontrado o None si no existe
        """
        if self.inicio is None:
            return None
            
        actual = self.inicio
        while actual is not None:
            if actual['valor'] == valor:
                return actual
            actual = actual['siguiente']
            
            # Para listas circulares
            if actual == self.inicio:
                break
                
        return None
    
    def copiar_lista(self):
        """
        Copia la lista a un archivo de texto con formato legible.
        """
        if self.inicio is None:
            print("No se puede copiar una lista vacía")
            return
            
        nombre_archivo = f"lista_{self.tipo_lista}.txt"
        
        try:
            with open(nombre_archivo, 'w', encoding='utf-8') as archivo:
                archivo.write(f"Tipo de lista: {self.tipo_lista}\n")
                archivo.write(f"Número de nodos: {self.contador_nodos}\n")
                archivo.write("=" * 50 + "\n\n")
                
                actual = self.inicio
                contador = 0
                
                while actual is not None:
                    archivo.write(f"Nodo {contador + 1}:\n")
                    archivo.write(f"  ID: {actual['id']}\n")
                    archivo.write(f"  Valor: {actual['valor']}\n")
                    
                    # Información del siguiente nodo
                    if actual['siguiente']:
                        sig_valor = actual['siguiente']['valor']
                        sig_id = actual['siguiente']['id']
                        archivo.write(f"  → Siguiente: Nodo ID {sig_id} (Valor: {sig_valor})\n")
                    else:
                        archivo.write(f"  → Siguiente: None\n")
                    
                    # Información del nodo anterior (si existe)
                    if actual['anterior']:
                        ant_valor = actual['anterior']['valor']
                        ant_id = actual['anterior']['id']
                        archivo.write(f"  ← Anterior: Nodo ID {ant_id} (Valor: {ant_valor})\n")
                    else:
                        archivo.write(f"  ← Anterior: None\n")
                    
                    archivo.write("-" * 30 + "\n")
                    
                    actual = actual['siguiente']
                    contador += 1
                    
                    # Para evitar bucles infinitos en listas circulares
                    if actual == self.inicio or contador >= self.contador_nodos:
                        break
                
                # Información sobre conexiones especiales
                if self.tipo_lista in ["circular", "circular_d"]:
                    archivo.write(f"\nCONEXIÓN CIRCULAR:\n")
                    archivo.write(f"El último nodo apunta al primer nodo\n")
                    
                archivo.write(f"\nArchivo generado automáticamente por el sistema de listas")
            
            print(f"Lista copiada exitosamente en '{nombre_archivo}'")
            
        except Exception as e:
            print(f"Error al copiar la lista: {e}")
    
    def ordenar_lista(self):
        """
        Ordena la lista de menor a mayor usando el algoritmo de ordenación por inserción.
        Esta es una funcionalidad extra.
        """
        if self.contador_nodos < 2:
            return  # No hay nada que ordenar
            
        print("Ordenando lista...")
        # Implementación específica en cada subclase
        raise NotImplementedError("Método no implementado en la clase base")
    
    def esta_vacia(self):
        """Verifica si la lista está vacía"""
        return self.inicio is None

# ============================================================
# LISTA ENLAZADA SIMPLE
# ============================================================
class ListaEnlazada(ListaBase):
    """Implementación de lista enlazada simple"""
    
    def __init__(self):
        super().__init__()
        self.tipo_lista = "enlazada"
    
    def insertar_inicio(self, valor):
        """Inserta un nodo al inicio de la lista"""
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        if self.inicio is None:
            # Lista vacía
            self.inicio = nuevo_nodo
            self.fin = nuevo_nodo
        else:
            # Lista no vacía
            nuevo_nodo['siguiente'] = self.inicio
            self.inicio = nuevo_nodo
            
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al inicio")
        return True
    
    def insertar_final(self, valor):
        """Inserta un nodo al final de la lista"""
        if self.inicio is None:
            print("Error: No se puede insertar al final en una lista vacía")
            return False
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        self.fin['siguiente'] = nuevo_nodo
        self.fin = nuevo_nodo
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al final")
        return True
    
    def insertar_nodo(self, valor, posicion):
        """Inserta un nodo en la posición especificada"""
        if posicion <= 0:
            return self.insertar_inicio(valor)
            
        if posicion >= self.contador_nodos:
            return self.insertar_final(valor)
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        # Buscar la posición anterior a donde insertar
        actual = self.inicio
        for _ in range(posicion - 1):
            actual = actual['siguiente']
        
        # Insertar en la posición
        nuevo_nodo['siguiente'] = actual['siguiente']
        actual['siguiente'] = nuevo_nodo
        
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado en posición {posicion}")
        return True
    
    def eliminar_nodo(self, valor):
        """Elimina el nodo con el valor especificado"""
        if self.inicio is None:
            print("Lista vacía, no hay nodos para eliminar")
            return False
            
        # Caso especial: eliminar el primer nodo
        if self.inicio['valor'] == valor:
            self.inicio = self.inicio['siguiente']
            if self.inicio is None:
                self.fin = None
            self.contador_nodos -= 1
            print(f"Nodo con valor {valor} eliminado")
            return True
        
        # Buscar el nodo a eliminar
        actual = self.inicio
        while actual['siguiente'] is not None and actual['siguiente']['valor'] != valor:
            actual = actual['siguiente']
        
        # Si encontramos el nodo
        if actual['siguiente'] is not None:
            # Si estamos eliminando el último nodo
            if actual['siguiente'] == self.fin:
                self.fin = actual
            # Eliminar el nodo
            actual['siguiente'] = actual['siguiente']['siguiente']
            self.contador_nodos -= 1
            print(f"Nodo con valor {valor} eliminado")
            return True
        
        print(f"Nodo con valor {valor} no encontrado")
        return False
    
    def ordenar_lista(self):
        """Ordena la lista enlazada simple de menor a mayor"""
        if self.contador_nodos < 2:
            return
            
        print("Ordenando lista enlazada simple...")
        
        # Algoritmo de ordenación por inserción para listas enlazadas
        if self.inicio is None or self.inicio['siguiente'] is None:
            return
            
        # Crear una nueva lista ordenada
        lista_ordenada = None
        
        actual = self.inicio
        while actual is not None:
            siguiente = actual['siguiente']
            
            # Insertar actual en la lista ordenada
            if lista_ordenada is None or lista_ordenada['valor'] >= actual['valor']:
                actual['siguiente'] = lista_ordenada
                lista_ordenada = actual
            else:
                temp = lista_ordenada
                while temp['siguiente'] is not None and temp['siguiente']['valor'] < actual['valor']:
                    temp = temp['siguiente']
                actual['siguiente'] = temp['siguiente']
                temp['siguiente'] = actual
            
            actual = siguiente
        
        # Actualizar inicio y fin de la lista
        self.inicio = lista_ordenada
        
        # Actualizar fin
        actual = self.inicio
        while actual['siguiente'] is not None:
            actual = actual['siguiente']
        self.fin = actual
        
        print("Lista ordenada correctamente")

# ============================================================
# LISTA DOBLEMENTE ENLAZADA
# ============================================================
class ListaDoblementeEnlazada(ListaEnlazada):
    """Implementación de lista doblemente enlazada"""
    
    def __init__(self):
        super().__init__()
        self.tipo_lista = "enlazada_d"
    
    def crear_nodo(self, valor):
        """Crea un nodo con referencias anterior y siguiente"""
        nodo = super().crear_nodo(valor)
        return nodo  # Ya tiene el campo 'anterior'
    
    def insertar_inicio(self, valor):
        """Inserta un nodo al inicio de la lista doblemente enlazada"""
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        if self.inicio is None:
            self.inicio = nuevo_nodo
            self.fin = nuevo_nodo
        else:
            nuevo_nodo['siguiente'] = self.inicio
            self.inicio['anterior'] = nuevo_nodo
            self.inicio = nuevo_nodo
            
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al inicio")
        return True
    
    def insertar_final(self, valor):
        """Inserta un nodo al final de la lista doblemente enlazada"""
        if self.inicio is None:
            print("Error: No se puede insertar al final en una lista vacía")
            return False
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        nuevo_nodo['anterior'] = self.fin
        self.fin['siguiente'] = nuevo_nodo
        self.fin = nuevo_nodo
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al final")
        return True
    
    def insertar_nodo(self, valor, posicion):
        """Inserta un nodo en la posición especificada"""
        if posicion <= 0:
            return self.insertar_inicio(valor)
            
        if posicion >= self.contador_nodos:
            return self.insertar_final(valor)
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        # Buscar la posición donde insertar
        actual = self.inicio
        for _ in range(posicion):
            actual = actual['siguiente']
        
        # Insertar antes del nodo actual
        nuevo_nodo['siguiente'] = actual
        nuevo_nodo['anterior'] = actual['anterior']
        actual['anterior']['siguiente'] = nuevo_nodo
        actual['anterior'] = nuevo_nodo
        
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado en posición {posicion}")
        return True
    
    def eliminar_nodo(self, valor):
        """Elimina el nodo con el valor especificado"""
        if self.inicio is None:
            print("Lista vacía, no hay nodos para eliminar")
            return False
        
        # Buscar el nodo
        actual = self.inicio
        while actual is not None and actual['valor'] != valor:
            actual = actual['siguiente']
        
        if actual is None:
            print(f"Nodo con valor {valor} no encontrado")
            return False
        
        # Ajustar punteros
        if actual['anterior'] is not None:
            actual['anterior']['siguiente'] = actual['siguiente']
        else:
            # Es el primer nodo
            self.inicio = actual['siguiente']
        
        if actual['siguiente'] is not None:
            actual['siguiente']['anterior'] = actual['anterior']
        else:
            # Es el último nodo
            self.fin = actual['anterior']
        
        self.contador_nodos -= 1
        print(f"Nodo con valor {valor} eliminado")
        return True
    
    def imprimir_reves(self):
        """Imprime la lista desde el final al principio"""
        if self.fin is None:
            print("Lista vacía")
            return
            
        actual = self.fin
        print("Lista en orden inverso: ", end="")
        while actual is not None:
            print(actual['valor'], end=" <- " if actual['anterior'] is not None else "")
            actual = actual['anterior']
        print()
    
    def ordenar_lista(self):
        """Ordena la lista doblemente enlazada de menor a mayor"""
        if self.contador_nodos < 2:
            return
            
        print("Ordenando lista doblemente enlazada...")
        
        # Algoritmo de burbuja adaptado para lista doblemente enlazada
        cambiado = True
        while cambiado:
            cambiado = False
            actual = self.inicio
            
            while actual['siguiente'] is not None:
                if actual['valor'] > actual['siguiente']['valor']:
                    # Intercambiar valores
                    actual['valor'], actual['siguiente']['valor'] = actual['siguiente']['valor'], actual['valor']
                    cambiado = True
                actual = actual['siguiente']
        
        print("Lista ordenada correctamente")

# ============================================================
# LISTA CIRCULAR SIMPLE
# ============================================================
class ListaCircular(ListaEnlazada):
    """Implementación de lista circular simple"""
    
    def __init__(self):
        super().__init__()
        self.tipo_lista = "circular"
    
    def insertar_inicio(self, valor):
        """Inserta un nodo al inicio de la lista circular"""
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        if self.inicio is None:
            self.inicio = nuevo_nodo
            self.fin = nuevo_nodo
            nuevo_nodo['siguiente'] = nuevo_nodo  # Apunta a sí mismo
        else:
            nuevo_nodo['siguiente'] = self.inicio
            self.inicio = nuevo_nodo
            self.fin['siguiente'] = self.inicio  # El último apunta al nuevo primero
            
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al inicio")
        return True
    
    def insertar_final(self, valor):
        """Inserta un nodo al final de la lista circular"""
        if self.inicio is None:
            print("Error: No se puede insertar al final en una lista vacía")
            return False
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        nuevo_nodo['siguiente'] = self.inicio  # El nuevo último apunta al primero
        self.fin['siguiente'] = nuevo_nodo
        self.fin = nuevo_nodo
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al final")
        return True
    
    def insertar_nodo(self, valor, posicion):
        """Inserta un nodo en la posición especificada"""
        if posicion <= 0 or self.contador_nodos == 0:
            return self.insertar_inicio(valor)
            
        if posicion >= self.contador_nodos:
            return self.insertar_final(valor)
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        # Buscar la posición anterior a donde insertar
        actual = self.inicio
        for _ in range(posicion - 1):
            actual = actual['siguiente']
        
        # Insertar en la posición
        nuevo_nodo['siguiente'] = actual['siguiente']
        actual['siguiente'] = nuevo_nodo
        
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado en posición {posicion}")
        return True
    
    def eliminar_nodo(self, valor):
        """Elimina el nodo con el valor especificado"""
        if self.inicio is None:
            print("Lista vacía, no hay nodos para eliminar")
            return False
            
        actual = self.inicio
        anterior = self.fin  # En lista circular, el anterior al primero es el último
        
        # Buscar el nodo a eliminar
        encontrado = False
        for _ in range(self.contador_nodos):
            if actual['valor'] == valor:
                encontrado = True
                break
            anterior = actual
            actual = actual['siguiente']
        
        if not encontrado:
            print(f"Nodo con valor {valor} no encontrado")
            return False
        
        # Caso especial: solo hay un nodo
        if self.contador_nodos == 1:
            self.inicio = None
            self.fin = None
        else:
            # Eliminar el nodo
            anterior['siguiente'] = actual['siguiente']
            
            # Actualizar inicio y fin si es necesario
            if actual == self.inicio:
                self.inicio = actual['siguiente']
            if actual == self.fin:
                self.fin = anterior
        
        self.contador_nodos -= 1
        print(f"Nodo con valor {valor} eliminado")
        return True
    
    def imprimir_valor_lista(self):
        """Imprime los valores de la lista circular"""
        if self.inicio is None:
            print("Lista vacía")
            return
            
        actual = self.inicio
        print("Valores de la lista circular: ", end="")
        
        for i in range(self.contador_nodos):
            print(actual['valor'], end="")
            if i < self.contador_nodos - 1:
                print(" -> ", end="")
            actual = actual['siguiente']
        print(" -> (vuelve al inicio)")
    
    def ordenar_lista(self):
        """Ordena la lista circular de menor a mayor"""
        if self.contador_nodos < 2:
            return
            
        print("Ordenando lista circular...")
        
        # Convertir temporalmente a lista no circular para ordenar
        if self.contador_nodos > 0:
            # Romper la circularidad temporalmente
            self.fin['siguiente'] = None
            
            # Ordenar usando el método de la clase padre
            super().ordenar_lista()
            
            # Restaurar la circularidad
            actual = self.inicio
            while actual['siguiente'] is not None:
                actual = actual['siguiente']
            self.fin = actual
            self.fin['siguiente'] = self.inicio
            
        print("Lista circular ordenada correctamente")

# ============================================================
# LISTA CIRCULAR DOBLEMENTE ENLAZADA
# ============================================================
class ListaCircularDoble(ListaDoblementeEnlazada):
    """Implementación de lista circular doblemente enlazada"""
    
    def __init__(self):
        super().__init__()
        self.tipo_lista = "circular_d"
    
    def insertar_inicio(self, valor):
        """Inserta un nodo al inicio de la lista circular doble"""
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        if self.inicio is None:
            self.inicio = nuevo_nodo
            self.fin = nuevo_nodo
            nuevo_nodo['siguiente'] = nuevo_nodo
            nuevo_nodo['anterior'] = nuevo_nodo
        else:
            nuevo_nodo['siguiente'] = self.inicio
            nuevo_nodo['anterior'] = self.fin
            self.inicio['anterior'] = nuevo_nodo
            self.fin['siguiente'] = nuevo_nodo
            self.inicio = nuevo_nodo
            
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al inicio")
        return True
    
    def insertar_final(self, valor):
        """Inserta un nodo al final de la lista circular doble"""
        if self.inicio is None:
            print("Error: No se puede insertar al final en una lista vacía")
            return False
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        nuevo_nodo['siguiente'] = self.inicio
        nuevo_nodo['anterior'] = self.fin
        self.fin['siguiente'] = nuevo_nodo
        self.inicio['anterior'] = nuevo_nodo
        self.fin = nuevo_nodo
        
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado al final")
        return True
    
    def insertar_nodo(self, valor, posicion):
        """Inserta un nodo en la posición especificada"""
        if posicion <= 0 or self.contador_nodos == 0:
            return self.insertar_inicio(valor)
            
        if posicion >= self.contador_nodos:
            return self.insertar_final(valor)
            
        nuevo_nodo = self.crear_nodo(valor)
        if nuevo_nodo is None:
            return False
            
        # Buscar la posición donde insertar
        actual = self.inicio
        for _ in range(posicion):
            actual = actual['siguiente']
        
        # Insertar antes del nodo actual
        nuevo_nodo['siguiente'] = actual
        nuevo_nodo['anterior'] = actual['anterior']
        actual['anterior']['siguiente'] = nuevo_nodo
        actual['anterior'] = nuevo_nodo
        
        self.contador_nodos += 1
        print(f"Nodo con valor {valor} insertado en posición {posicion}")
        return True
    
    def eliminar_nodo(self, valor):
        """Elimina el nodo con el valor especificado"""
        if self.inicio is None:
            print("Lista vacía, no hay nodos para eliminar")
            return False
        
        actual = self.inicio
        encontrado = False
        
        # Buscar el nodo
        for _ in range(self.contador_nodos):
            if actual['valor'] == valor:
                encontrado = True
                break
            actual = actual['siguiente']
        
        if not encontrado:
            print(f"Nodo con valor {valor} no encontrado")
            return False
        
        # Caso especial: solo hay un nodo
        if self.contador_nodos == 1:
            self.inicio = None
            self.fin = None
        else:
            # Eliminar el nodo
            actual['anterior']['siguiente'] = actual['siguiente']
            actual['siguiente']['anterior'] = actual['anterior']
            
            # Actualizar inicio y fin si es necesario
            if actual == self.inicio:
                self.inicio = actual['siguiente']
            if actual == self.fin:
                self.fin = actual['anterior']
        
        self.contador_nodos -= 1
        print(f"Nodo con valor {valor} eliminado")
        return True
    
    def imprimir_valor_lista(self):
        """Imprime los valores de la lista circular doble"""
        if self.inicio is None:
            print("Lista vacía")
            return
            
        actual = self.inicio
        print("Valores de la lista circular doble: ", end="")
        
        for i in range(self.contador_nodos):
            print(actual['valor'], end="")
            if i < self.contador_nodos - 1:
                print(" ⇄ ", end="")
            actual = actual['siguiente']
        print(" ⇄ (vuelve al inicio)")
    
    def imprimir_reves(self):
        """Imprime la lista circular doble en orden inverso"""
        if self.fin is None:
            print("Lista vacía")
            return
            
        actual = self.fin
        print("Lista circular doble en orden inverso: ", end="")
        
        for i in range(self.contador_nodos):
            print(actual['valor'], end="")
            if i < self.contador_nodos - 1:
                print(" ⇄ ", end="")
            actual = actual['anterior']
        print(" ⇄ (vuelve al final)")
    
    def ordenar_lista(self):
        """Ordena la lista circular doble de menor a mayor"""
        if self.contador_nodos < 2:
            return
            
        print("Ordenando lista circular doble...")
        
        # Convertir temporalmente a lista no circular para ordenar
        if self.contador_nodos > 0:
            # Romper la circularidad temporalmente
            self.fin['siguiente'] = None
            self.inicio['anterior'] = None
            
            # Ordenar usando el método de la clase padre
            super().ordenar_lista()
            
            # Restaurar la circularidad
            actual = self.inicio
            while actual['siguiente'] is not None:
                actual = actual['siguiente']
            self.fin = actual
            self.fin['siguiente'] = self.inicio
            self.inicio['anterior'] = self.fin
            
        print("Lista circular doble ordenada correctamente")

# ============================================================
# FUNCIÓN PRINCIPAL Y MENÚ
# ============================================================
def mostrar_menu():
    """Muestra el menú principal del programa"""
    print("\n" + "="*60)
    print("SISTEMA DE GESTIÓN DE LISTAS CON PUNTEROS SIMULADOS")
    print("="*60)
    print("1. Crear nueva lista")
    print("2. Insertar nodo al inicio")
    print("3. Insertar nodo en posición específica")
    print("4. Insertar nodo al final")
    print("5. Eliminar nodo por valor")
    print("6. Contar nodos")
    print("7. Buscar nodo")
    print("8. Imprimir valores de la lista")
    print("9. Imprimir lista completa")
    print("10. Imprimir lista al revés (solo doblemente enlazadas)")
    print("11. Copiar lista a archivo")
    print("12. Ordenar lista (funcionalidad extra)")
    print("13. Cambiar tipo de lista")
    print("14. Salir")
    print("="*60)

def mostrar_menu_tipos():
    """Muestra el menú para seleccionar el tipo de lista"""
    print("\n" + "="*60)
    print("SELECCIONE EL TIPO DE LISTA")
    print("="*60)
    print("1. Lista Enlazada Simple")
    print("2. Lista Doblemente Enlazada")
    print("3. Lista Circular Simple")
    print("4. Lista Circular Doblemente Enlazada")
    print("="*60)

def main():
    """Función principal del programa"""
    lista_actual = None
    tipo_lista_actual = "No seleccionado"
    
    print("Bienvenido al Sistema de Gestión de Listas con Punteros Simulados")
    
    # Primero pedimos al usuario que seleccione un tipo de lista
    while lista_actual is None:
        mostrar_menu_tipos()
        try:
            opcion = int(input("Seleccione una opción (1-4): "))
            
            if opcion == 1:
                lista_actual = ListaEnlazada()
                tipo_lista_actual = "Lista Enlazada Simple"
            elif opcion == 2:
                lista_actual = ListaDoblementeEnlazada()
                tipo_lista_actual = "Lista Doblemente Enlazada"
            elif opcion == 3:
                lista_actual = ListaCircular()
                tipo_lista_actual = "Lista Circular Simple"
            elif opcion == 4:
                lista_actual = ListaCircularDoble()
                tipo_lista_actual = "Lista Circular Doblemente Enlazada"
            else:
                print("Opción inválida. Por favor, seleccione 1-4.")
        except ValueError:
            print("Por favor, ingrese un número válido.")
    
    print(f"\n¡Lista creada exitosamente! Tipo: {tipo_lista_actual}")
    
    # Bucle principal del programa
    while True:
        mostrar_menu()
        print(f"Tipo de lista actual: {tipo_lista_actual}")
        print(f"Nodos en lista: {lista_actual.contador_nodos}")
        
        try:
            opcion = int(input("\nSeleccione una opción (1-14): "))
            
            if opcion == 1:
                # Crear nueva lista (perderá la actual)
                confirmar = input("¿Está seguro? Se perderá la lista actual. (s/n): ")
                if confirmar.lower() == 's':
                    mostrar_menu_tipos()
                    tipo_opcion = int(input("Seleccione el tipo de lista (1-4): "))
                    
                    if tipo_opcion == 1:
                        lista_actual = ListaEnlazada()
                        tipo_lista_actual = "Lista Enlazada Simple"
                    elif tipo_opcion == 2:
                        lista_actual = ListaDoblementeEnlazada()
                        tipo_lista_actual = "Lista Doblemente Enlazada"
                    elif tipo_opcion == 3:
                        lista_actual = ListaCircular()
                        tipo_lista_actual = "Lista Circular Simple"
                    elif tipo_opcion == 4:
                        lista_actual = ListaCircularDoble()
                        tipo_lista_actual = "Lista Circular Doblemente Enlazada"
                    else:
                        print("Opción inválida")
                        
                    print(f"\n¡Nueva lista creada exitosamente! Tipo: {tipo_lista_actual}")
            
            elif opcion == 2:
                # Insertar al inicio
                try:
                    valor = int(input("Ingrese el valor a insertar (1-98, 0 y 99 son especiales): "))
                    lista_actual.insertar_inicio(valor)
                except ValueError:
                    print("Por favor, ingrese un número válido")
            
            elif opcion == 3:
                # Insertar en posición específica
                try:
                    valor = int(input("Ingrese el valor a insertar (1-98, 0 y 99 son especiales): "))
                    posicion = int(input(f"Ingrese la posición (0-{lista_actual.contador_nodos()}): "))
                    lista_actual.insertar_nodo(valor, posicion)
                except ValueError:
                    print("Por favor, ingrese números válidos")
            
            elif opcion == 4:
                # Insertar al final
                try:
                    valor = int(input("Ingrese el valor a insertar (1-98, 0 y 99 son especiales): "))
                    lista_actual.insertar_final(valor)
                except ValueError:
                    print("Por favor, ingrese un número válido")
            
            elif opcion == 5:
                # Eliminar nodo
                try:
                    valor = int(input("Ingrese el valor del nodo a eliminar: "))
                    lista_actual.eliminar_nodo(valor)
                except ValueError:
                    print("Por favor, ingrese un número válido")
            
            elif opcion == 6:
                # Contar nodos
                print(f"La lista tiene {lista_actual.contar_nodos()} nodos")
            
            elif opcion == 7:
                # Buscar nodo
                try:
                    valor = int(input("Ingrese el valor del nodo a buscar: "))
                    nodo = lista_actual.buscar_nodo(valor)
                    if nodo:
                        print(f"Nodo encontrado: Valor={nodo['valor']}, ID={nodo['id']}")
                    else:
                        print("Nodo no encontrado")
                except ValueError:
                    print("Por favor, ingrese un número válido")
            
            elif opcion == 8:
                # Imprimir valores
                lista_actual.imprimir_valor_lista()
            
            elif opcion == 9:
                # Imprimir lista completa
                lista_actual.imprimir_lista_completa()
            
            elif opcion == 10:
                # Imprimir al revés
                if hasattr(lista_actual, 'imprimir_reves'):
                    lista_actual.imprimir_reves()
                else:
                    print("Esta operación solo está disponible para listas doblemente enlazadas")
            
            elif opcion == 11:
                # Copiar lista a archivo
                lista_actual.copiar_lista()
            
            elif opcion == 12:
                # Ordenar lista
                lista_actual.ordenar_lista()
            
            elif opcion == 13:
                # Cambiar tipo de lista (perderá la actual)
                confirmar = input("¿Está seguro? Se perderá la lista actual. (s/n): ")
                if confirmar.lower() == 's':
                    mostrar_menu_tipos()
                    tipo_opcion = int(input("Seleccione el tipo de lista (1-4): "))
                    
                    if tipo_opcion == 1:
                        lista_actual = ListaEnlazada()
                        tipo_lista_actual = "Lista Enlazada Simple"
                    elif tipo_opcion == 2:
                        lista_actual = ListaDoblementeEnlazada()
                        tipo_lista_actual = "Lista Doblemente Enlazada"
                    elif tipo_opcion == 3:
                        lista_actual = ListaCircular()
                        tipo_lista_actual = "Lista Circular Simple"
                    elif tipo_opcion == 4:
                        lista_actual = ListaCircularDoble()
                        tipo_lista_actual = "Lista Circular Doblemente Enlazada"
                    else:
                        print("Opción inválida")
                        
                    print(f"\n¡Lista cambiada exitosamente! Tipo: {tipo_lista_actual}")
            
            elif opcion == 14:
                # Salir
                print("\n¡Gracias por usar el Sistema de Gestión de Listas!")
                print("Archivos generados:")
                archivos = ["lista_enlazada.txt", "lista_enlazada_d.txt", 
                           "lista_circular.txt", "lista_circular_d.txt"]
                for archivo in archivos:
                    if os.path.exists(archivo):
                        print(f"  - {archivo}")
                break
            
            else:
                print("Opción inválida. Por favor, seleccione 1-14.")
        
        except ValueError:
            print("Por favor, ingrese un número válido")
        except Exception as e:
            print(f"Error inesperado: {e}")

# ============================================================
# EJECUCIÓN DEL PROGRAMA
# ============================================================
if __name__ == "__main__":
    main()
    