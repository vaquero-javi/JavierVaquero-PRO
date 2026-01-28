class Nodo:
    """Clase que representa un nodo en un árbol binario."""
    def __init__(self, valor):
        self.valor = valor
        self.izquierda = None
        self.derecha = None


def inorder(raiz):
    """
    Recorrido inorder (izquierda, raíz, derecha)
    En un árbol binario de búsqueda, devuelve los valores en orden ascendente.
    
    Args:
        raiz: El nodo raíz del árbol (o subárbol)
    
    Returns:
        Lista con los valores de los nodos en orden inorder
    """
    resultado = []
    
    # Función recursiva interna
    def _inorder_recursivo(nodo):
        if nodo is not None:
            # Visitar subárbol izquierdo
            _inorder_recursivo(nodo.izquierda)
            # Visitar nodo actual
            resultado.append(nodo.valor)
            # Visitar subárbol derecho
            _inorder_recursivo(nodo.derecha)
    
    _inorder_recursivo(raiz)
    return resultado


def preorder(raiz):
    """
    Recorrido preorder (raíz, izquierda, derecha)
    
    Args:
        raiz: El nodo raíz del árbol (o subárbol)
    
    Returns:
        Lista con los valores de los nodos en orden preorder
    """
    resultado = []
    
    # Función recursiva interna
    def _preorder_recursivo(nodo):
        if nodo is not None:
            # Visitar nodo actual primero
            resultado.append(nodo.valor)
            # Visitar subárbol izquierdo
            _preorder_recursivo(nodo.izquierda)
            # Visitar subárbol derecho
            _preorder_recursivo(nodo.derecha)
    
    _preorder_recursivo(raiz)
    return resultado


def inorder_iterativo(raiz):
    """
    Versión iterativa del recorrido inorder usando una pila.
    
    Args:
        raiz: El nodo raíz del árbol
    
    Returns:
        Lista con los valores de los nodos en orden inorder
    """
    resultado = []
    pila = []
    actual = raiz
    
    while actual is not None or pila:
        # Ir lo más a la izquierda posible
        while actual is not None:
            pila.append(actual)
            actual = actual.izquierda
        
        # Procesar el nodo actual
        actual = pila.pop()
        resultado.append(actual.valor)
        
        # Visitar el subárbol derecho
        actual = actual.derecha
    
    return resultado


def preorder_iterativo(raiz):
    """
    Versión iterativa del recorrido preorder usando una pila.
    
    Args:
        raiz: El nodo raíz del árbol
    
    Returns:
        Lista con los valores de los nodos en orden preorder
    """
    if raiz is None:
        return []
    
    resultado = []
    pila = [raiz]
    
    while pila:
        actual = pila.pop()
        resultado.append(actual.valor)
        
        # Agregar primero la derecha para que la izquierda se procese primero
        if actual.derecha is not None:
            pila.append(actual.derecha)
        if actual.izquierda is not None:
            pila.append(actual.izquierda)
    
    return resultado


# Función para crear un árbol de ejemplo
def crear_arbol_ejemplo():
    """
    Crea un árbol binario de ejemplo:
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
    """
    raiz = Nodo(1)
    raiz.izquierda = Nodo(2)
    raiz.derecha = Nodo(3)
    raiz.izquierda.izquierda = Nodo(4)
    raiz.izquierda.derecha = Nodo(5)
    raiz.derecha.izquierda = Nodo(6)
    raiz.derecha.derecha = Nodo(7)
    
    return raiz


# Función para crear un árbol binario de búsqueda (BST) de ejemplo
def crear_bst_ejemplo():
    """
    Crea un árbol binario de búsqueda (BST) de ejemplo:
          4
        /   \
       2     6
      / \   / \
     1   3 5   7
    """
    raiz = Nodo(4)
    raiz.izquierda = Nodo(2)
    raiz.derecha = Nodo(6)
    raiz.izquierda.izquierda = Nodo(1)
    raiz.izquierda.derecha = Nodo(3)
    raiz.derecha.izquierda = Nodo(5)
    raiz.derecha.derecha = Nodo(7)
    
    return raiz


# Programa principal para demostrar el uso
if __name__ == "__main__":
    print("=== Árbol Binario Simple ===")
    arbol = crear_arbol_ejemplo()
    
    print("\nRecorrido Inorder (recursivo):", inorder(arbol))
    print("Recorrido Inorder (iterativo):", inorder_iterativo(arbol))
    print("Recorrido Preorder (recursivo):", preorder(arbol))
    print("Recorrido Preorder (iterativo):", preorder_iterativo(arbol))
    
    print("\n=== Árbol Binario de Búsqueda (BST) ===")
    bst = crear_bst_ejemplo()
    
    print("\nRecorrido Inorder (BST - orden ascendente):", inorder(bst))
    print("Recorrido Preorder (BST):", preorder(bst))
    
    print("\n=== Árbol Vacío ===")
    arbol_vacio = None
    print("Inorder (árbol vacío):", inorder(arbol_vacio))
    print("Preorder (árbol vacío):", preorder(arbol_vacio))