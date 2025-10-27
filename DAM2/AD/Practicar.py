
def cambiar_contraseña():
	print("\n" * 3)
	contraseña = 1234
	intentos = 3
	intentos_nueva_contraseña = 3

	while intentos > 0:
		contraseña_vieja = int(input("Introduce tu actual contraseña para cambiarla "))
		if(contraseña == contraseña_vieja):
			print("Enhorabuena, acertaste.")
			while intentos_nueva_contraseña > 0:
				nueva_contraseña_1 = int(input("Introduce nueva contraseña "))
				nueva_contraseña_2 = int(input("Vuelve a introducir la contraseña para confirmarla "))
				if (nueva_contraseña_1 == nueva_contraseña_2):
					contraseña = nueva_contraseña_2
					print("Cambio de contraseña hecho con éxito ")
					break
				else:
					intentos_nueva_contraseña -= 1
					print(f"Error, vuelva a intentarlo, le quedan {intentos_nueva_contraseña} intentos ")
			if(intentos_nueva_contraseña == 0):
				print("Has agotado todos los intentos, vuelve a intentarlo en 1 minuto ")
				break
		else:
			intentos -= 1
			print(f"Error al introducir la contraseña, te quedan {intentos} intentos ")
	if(intentos == 0):
		print("Has agotado todos los intentos, vuelve a intentarlo en 1 minuto ")
cambiar_contraseña()