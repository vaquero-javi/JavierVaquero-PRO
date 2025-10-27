
# Listas para guardar los datos
usuarios = []
materiales_almacen = []
materiales_norte = []
materiales_sur = []
materiales_este = []
materiales_oeste = []

# Datos de los distritos
distritos = ["Norte", "Sur", "Este", "Oeste"]
actividades = {
    "Norte": ["Natación", "Baloncesto", "Tenis", "Pádel", "Fitness"],
    "Sur": ["Natación", "Baloncesto", "Fútbol", "Artes Marciales", "Ciclismo"],
    "Este": ["Natación", "Tenis", "Pádel", "Voleibol", "Gimnasia"],
    "Oeste": ["Natación", "Baloncesto", "Fitness", "Boxeo", "Escalada"]
}

# Variables globales
usuario_actual = None
ubicacion_actual = "Almacén Central"

def inicializar_datos():
    """Poner algunos datos de ejemplo para probar"""
    global materiales_almacen, materiales_norte, materiales_sur, materiales_este, materiales_oeste
    
    # Materiales del almacén central
    materiales_almacen = [
        {"nombre": "Pelota Fútbol", "marca": "Nike", "fecha": "2023-01-15", "estado": "disponible"},
        {"nombre": "Raqueta Tenis", "marca": "Wilson", "fecha": "2023-02-20", "estado": "disponible"},
        {"nombre": "Red Voleibol", "marca": "Mikasa", "fecha": "2023-03-10", "estado": "disponible"},
        {"nombre": "Aro Baloncesto", "marca": "Spalding", "fecha": "2023-01-25", "estado": "disponible"},
        {"nombre": "Colchoneta", "marca": "Reebok", "fecha": "2023-04-05", "estado": "disponible"}
    ]
    
    # Materiales para cada distrito
    materiales_norte = [
        {"nombre": "Balón Baloncesto", "marca": "Spalding", "fecha": "2023-01-10", "estado": "disponible"},
        {"nombre": "Gafas Natación", "marca": "Speedo", "fecha": "2023-02-15", "estado": "disponible"},
        {"nombre": "Raqueta Tenis", "marca": "Wilson", "fecha": "2023-03-20", "estado": "disponible"},
        {"nombre": "Paleta Pádel", "marca": "Bullpadel", "fecha": "2023-04-25", "estado": "disponible"},
        {"nombre": "Mancuernas", "marca": "Decathlon", "fecha": "2023-05-30", "estado": "disponible"}
    ]
    
    materiales_sur = [
        {"nombre": "Pelota Fútbol", "marca": "Adidas", "fecha": "2023-01-05", "estado": "disponible"},
        {"nombre": "Balón Baloncesto", "marca": "Nike", "fecha": "2023-02-10", "estado": "disponible"},
        {"nombre": "Guantes Boxeo", "marca": "Everlast", "fecha": "2023-03-15", "estado": "disponible"},
        {"nombre": "Casco Ciclismo", "marca": "Trek", "fecha": "2023-04-20", "estado": "disponible"},
        {"nombre": "Kimono Karate", "marca": "Mizuno", "fecha": "2023-05-25", "estado": "disponible"}
    ]
    
    # Agregar algunos usuarios de ejemplo
    usuarios.append({
        "id": 1,
        "nombre": "Ana García",
        "distrito": "Norte", 
        "actividad": "Natación",
        "password": "1234",
        "reservas": []
    })
    
    usuarios.append({
        "id": 2, 
        "nombre": "Carlos López",
        "distrito": "Sur",
        "actividad": "Fútbol", 
        "password": "1234",
        "reservas": []
    })

def alta_usuario():
    print("\n--- ALTA DE USUARIO ---")
    
    nombre = input("Nombre: ")
    if nombre == "":
        print("Error: El nombre no puede estar vacío")
        return
    
    # Mostrar distritos
    print("Distritos disponibles:")
    for i, distrito in enumerate(distritos, 1):
        print(f"{i}. {distrito}")
    
    try:
        opcion_distrito = int(input("Elige el número de distrito: ")) - 1
        if opcion_distrito < 0 or opcion_distrito >= len(distritos):
            print("Error: Número de distrito no válido")
            return
        distrito = distritos[opcion_distrito]
    except:
        print("Error: Debes escribir un número")
        return
    
    # Mostrar actividades del distrito
    print(f"Actividades en {distrito}:")
    for i, actividad in enumerate(actividades[distrito], 1):
        print(f"{i}. {actividad}")
    
    try:
        opcion_actividad = int(input("Elige el número de actividad: ")) - 1
        if opcion_actividad < 0 or opcion_actividad >= len(actividades[distrito]):
            print("Error: Número de actividad no válido")
            return
        actividad = actividades[distrito][opcion_actividad]
    except:
        print("Error: Debes escribir un número")
        return
    
    # Verificar cupo
    contador = 0
    for usuario in usuarios:
        if usuario["distrito"] == distrito and usuario["actividad"] == actividad:
            contador += 1
    
    if contador >= 5:
        print("Error: Esta actividad ya tiene 5 usuarios, no hay cupo")
        return
    
    password = input("Contraseña: ")
    if password == "":
        print("Error: La contraseña no puede estar vacía")
        return
    
    # Crear nuevo usuario
    nuevo_id = len(usuarios) + 1
    nuevo_usuario = {
        "id": nuevo_id,
        "nombre": nombre,
        "distrito": distrito,
        "actividad": actividad,
        "password": password,
        "reservas": []
    }
    
    usuarios.append(nuevo_usuario)
    print(f"Usuario creado con éxito! Tu ID es: {nuevo_id}")

def baja_usuario():
    print("\n--- BAJA DE USUARIO ---")
    
    try:
        id_usuario = int(input("ID del usuario a eliminar: "))
    except:
        print("Error: El ID debe ser un número")
        return
    
    for usuario in usuarios:
        if usuario["id"] == id_usuario:
            # Devolver materiales reservados
            for reserva in usuario["reservas"]:
                reserva["estado"] = "disponible"
            
            usuarios.remove(usuario)
            print("Usuario eliminado correctamente")
            return
    
    print("Error: No se encontró usuario con ese ID")

def listar_almacen():
    print("\n--- ALMACÉN CENTRAL ---")
    if len(materiales_almacen) == 0:
        print("No hay materiales en el almacén")
        return
    
    for i, material in enumerate(materiales_almacen, 1):
        print(f"{i}. {material['nombre']} - {material['marca']} - {material['estado']}")

def acceder_distrito():
    global ubicacion_actual
    
    print("\n--- ACCEDER A DISTRITO ---")
    print("Distritos disponibles:")
    for i, distrito in enumerate(distritos, 1):
        print(f"{i}. {distrito}")
    
    try:
        opcion = int(input("Elige el número de distrito: ")) - 1
        if opcion < 0 or opcion >= len(distritos):
            print("Error: Número no válido")
            return
        distrito = distritos[opcion]
    except:
        print("Error: Debes escribir un número")
        return
    
    ubicacion_actual = f"Centro {distrito}"
    
    while True:
        print(f"\n--- CENTRO DEPORTIVO {distrito.upper()} ---")
        print("1. Listar materiales del centro")
        print("2. Mostrar materiales de otros distritos")
        print("3. Volver al menú principal")
        
        opcion_menu = input("Elige una opción: ")
        
        if opcion_menu == "1":
            listar_materiales_distrito(distrito)
        elif opcion_menu == "2":
            mostrar_materiales_otros_distritos(distrito)
        elif opcion_menu == "3":
            ubicacion_actual = "Almacén Central"
            break
        else:
            print("Opción no válida")

def listar_materiales_distrito(distrito):
    if distrito == "Norte":
        materiales = materiales_norte
    elif distrito == "Sur":
        materiales = materiales_sur
    elif distrito == "Este":
        materiales = materiales_este
    elif distrito == "Oeste":
        materiales = materiales_oeste
    else:
        print("Distrito no válido")
        return
    
    print(f"\n--- MATERIALES EN {distrito.upper()} ---")
    if len(materiales) == 0:
        print("No hay materiales en este centro")
        return
    
    for i, material in enumerate(materiales, 1):
        print(f"{i}. {material['nombre']} - {material['marca']} - {material['estado']}")

def mostrar_materiales_otros_distritos(distrito_actual):
    print(f"\n--- MATERIALES DE OTROS DISTRITOS EN {distrito_actual.upper()} ---")
    
    # En esta versión simple, mostramos algunos materiales fijos
    otros_materiales = [
        "Pelota de Rugby (de Sur)",
        "Raqueta Bádminton (de Este)", 
        "Red Tenis (de Oeste)",
        "Pesa Rusa (de Norte)"
    ]
    
    for i, material in enumerate(otros_materiales, 1):
        print(f"{i}. {material}")

def autenticar_usuario():
    global usuario_actual, ubicacion_actual
    
    print("\n--- ACCESO A ACTIVIDAD ---")
    
    try:
        id_usuario = int(input("ID de usuario: "))
        password = input("Contraseña: ")
    except:
        print("Error: El ID debe ser un número")
        return
    
    for usuario in usuarios:
        if usuario["id"] == id_usuario and usuario["password"] == password:
            usuario_actual = usuario
            ubicacion_actual = f"Actividad {usuario['actividad']} - {usuario['distrito']}"
            print(f"Bienvenido {usuario['nombre']}!")
            return
    
    print("Error: Usuario o contraseña incorrectos")

def listar_materiales_ubicacion():
    print(f"\n--- MATERIALES EN {ubicacion_actual.upper()} ---")
    
    if "Almacén Central" in ubicacion_actual:
        materiales = materiales_almacen
    elif "Norte" in ubicacion_actual:
        materiales = materiales_norte
    elif "Sur" in ubicacion_actual:
        materiales = materiales_sur
    elif "Este" in ubicacion_actual:
        materiales = materiales_este
    elif "Oeste" in ubicacion_actual:
        materiales = materiales_oeste
    else:
        print("No se pueden listar materiales aquí")
        return
    
    if len(materiales) == 0:
        print("No hay materiales disponibles")
        return
    
    # Si hay usuario autenticado, preguntar si filtrar
    if usuario_actual:
        print("1. Ver todos los materiales")
        print("2. Ver solo materiales de mi actividad")
        opcion = input("Elige opción: ")
        
        if opcion == "2":
            actividad = usuario_actual["actividad"]
            print(f"Materiales relacionados con {actividad}:")
            # Filtro simple por nombre
            for material in materiales:
                if any(palabra in material["nombre"].lower() for palabra in actividad.lower().split()):
                    print(f"- {material['nombre']} - {material['marca']} - {material['estado']}")
            return
    
    # Mostrar todos los materiales
    for i, material in enumerate(materiales, 1):
        print(f"{i}. {material['nombre']} - {material['marca']} - {material['estado']}")

def buscar_material():
    print("\n--- BUSCAR MATERIAL ---")
    
    print("Buscar por:")
    print("1. Nombre")
    print("2. Marca") 
    print("3. Estado")
    opcion = input("Elige opción: ")
    
    texto = input("Texto a buscar: ").lower()
    
    resultados = []
    
    # Buscar en almacén central
    for material in materiales_almacen:
        if opcion == "1" and texto in material["nombre"].lower():
            resultados.append(("Almacén Central", material))
        elif opcion == "2" and texto in material["marca"].lower():
            resultados.append(("Almacén Central", material))
        elif opcion == "3" and texto in material["estado"].lower():
            resultados.append(("Almacén Central", material))
    
    # Buscar en todos los distritos
    for distrito in distritos:
        if distrito == "Norte":
            materiales = materiales_norte
        elif distrito == "Sur":
            materiales = materiales_sur
        elif distrito == "Este":
            materiales = materiales_este
        elif distrito == "Oeste":
            materiales = materiales_oeste
        
        for material in materiales:
            if opcion == "1" and texto in material["nombre"].lower():
                resultados.append((f"Centro {distrito}", material))
            elif opcion == "2" and texto in material["marca"].lower():
                resultados.append((f"Centro {distrito}", material))
            elif opcion == "3" and texto in material["estado"].lower():
                resultados.append((f"Centro {distrito}", material))
    
    if len(resultados) == 0:
        print("No se encontraron materiales")
        return
    
    print(f"\nSe encontraron {len(resultados)} materiales:")
    for ubicacion, material in resultados:
        print(f"- {ubicacion}: {material['nombre']} - {material['marca']} - {material['estado']}")

def reservar_material():
    if usuario_actual is None:
        print("Error: Debes iniciar sesión primero")
        return
    
    if len(usuario_actual["reservas"]) >= 3:
        print("Error: Ya tienes 3 materiales reservados")
        return
    
    print("\n--- RESERVAR MATERIAL ---")
    
    # Mostrar materiales disponibles según ubicación
    if "Almacén Central" in ubicacion_actual:
        materiales = materiales_almacen
    elif "Norte" in ubicacion_actual:
        materiales = materiales_norte
    elif "Sur" in ubicacion_actual:
        materiales = materiales_sur
    elif "Este" in ubicacion_actual:
        materiales = materiales_este
    elif "Oeste" in ubicacion_actual:
        materiales = materiales_oeste
    else:
        print("No se pueden reservar materiales aquí")
        return
    
    # Mostrar solo materiales disponibles
    disponibles = []
    for material in materiales:
        if material["estado"] == "disponible":
            disponibles.append(material)
    
    if len(disponibles) == 0:
        print("No hay materiales disponibles para reservar")
        return
    
    print("Materiales disponibles:")
    for i, material in enumerate(disponibles, 1):
        print(f"{i}. {material['nombre']} - {material['marca']}")
    
    try:
        opcion = int(input("Elige el material a reservar: ")) - 1
        if opcion < 0 or opcion >= len(disponibles):
            print("Error: Número no válido")
            return
        
        material = disponibles[opcion]
        material["estado"] = "reservado"
        usuario_actual["reservas"].append(material)
        print("Material reservado correctamente!")
        print("Tienes 4 días para devolverlo")
        
    except:
        print("Error: Debes escribir un número")

def ver_mis_reservas():
    if usuario_actual is None:
        print("Error: Debes iniciar sesión primero")
        return
    
    print(f"\n--- MIS RESERVAS - {usuario_actual['nombre']} ---")
    
    if len(usuario_actual["reservas"]) == 0:
        print("No tienes reservas activas")
        return
    
    for i, material in enumerate(usuario_actual["reservas"], 1):
        print(f"{i}. {material['nombre']} - {material['marca']}")
        print(f"   Distrito: {usuario_actual['distrito']} - Actividad: {usuario_actual['actividad']}")

def devolver_material():
    if usuario_actual is None:
        print("Error: Debes iniciar sesión primero")
        return
    
    if len(usuario_actual["reservas"]) == 0:
        print("No tienes reservas para devolver")
        return
    
    print("\n--- DEVOLVER MATERIAL ---")
    print("Tus reservas activas:")
    for i, material in enumerate(usuario_actual["reservas"], 1):
        print(f"{i}. {material['nombre']} - {material['marca']}")
    
    try:
        opcion = int(input("Elige el material a devolver: ")) - 1
        if opcion < 0 or opcion >= len(usuario_actual["reservas"]):
            print("Error: Número no válido")
            return
        
        material = usuario_actual["reservas"][opcion]
        material["estado"] = "disponible"
        usuario_actual["reservas"].pop(opcion)
        print("Material devuelto correctamente!")
        
    except:
        print("Error: Debes escribir un número")

def mostrar_menu():
    print("\n" + "="*50)
    print("SISTEMA DE CENTROS DEPORTIVOS MUNICIPALES")
    print("="*50)
    print(f"Ubicación actual: {ubicacion_actual}")
    if usuario_actual:
        print(f"Usuario: {usuario_actual['nombre']} (ID: {usuario_actual['id']})")
    
    print("\1. Alta de usuario")
    print("2. Baja de usuario")
    print("3. Ver almacén central")
    print("4. Acceder a un distrito")
    print("5. Acceder a actividad (login)")
    print("6. Listar materiales actuales")
    print("7. Buscar material")
    print("8. Reservar material")
    print("9. Ver mis reservas")
    print("10. Devolver material")
    print("11. Salir")
    
    opcion = input("\nElige una opción: ")
    return opcion


def main():
    print("Bienvenido al Sistema de Centros Deportivos Municipales")
    inicializar_datos()
    
    while True:
        opcion = mostrar_menu()
        
        if opcion == "1":
            alta_usuario()
        elif opcion == "2":
            baja_usuario()
        elif opcion == "3":
            listar_almacen()
        elif opcion == "4":
            acceder_distrito()
        elif opcion == "5":
            autenticar_usuario()
        elif opcion == "6":
            listar_materiales_ubicacion()
        elif opcion == "7":
            buscar_material()
        elif opcion == "8":
            reservar_material()
        elif opcion == "9":
            ver_mis_reservas()
        elif opcion == "10":
            devolver_material()
        elif opcion == "11":
            print("¡Hasta pronto!")
            break
        else:
            print("Opción no válida, intenta de nuevo")
main()







