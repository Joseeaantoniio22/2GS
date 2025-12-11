class Listin:
    def __init__(self):
        self.listin = {}
    
    def anadirPersona(self, nombre, telefono):
        self.listin[nombre] = telefono
        print(f"--> Añadiste a {nombre} con el teléfono {telefono}")
    
    def borrarPersona(self, nombre):
        if nombre in self.listin:
            del self.listin[nombre]
            print(f"--> Has borrado a {nombre}")
        else:
            print("--> Esa persona no existe en el listín.")
    
    def listarPersonas(self):
        print("\n--- LISTA DE CONTACTOS ---")
        if len(self.listin) == 0:
            print("El listín está vacío.")
        else:
            for nombre, telefono in self.listin.items():
                print(f"Nombre: {nombre} - Teléfono: {telefono}")
        print("--------------------------\n")

mi_agenda = Listin()

def menu():
    print("\n--- MTO Listín ---")
    print("1. Añadir persona")
    print("2. Borrar persona")
    print("3. Listar Listín")
    print("4. Salir")
    print("Seleccione la opción que quieras realizar:")
    opcion = int(input("> "))
    return opcion

opcion = 0

while opcion != 4:
    opcion = menu() 

    if opcion == 1:
        print("Dime el nombre de la persona:")
        nombre = input()
        print("Dime el teléfono:")
        telefono = input()
        mi_agenda.anadirPersona(nombre, telefono)
        
    elif opcion == 2:
        print("Dime el nombre de la persona a borrar:")
        nombre = input()
        mi_agenda.borrarPersona(nombre)
            
    elif opcion == 3:
        mi_agenda.listarPersonas()
        
    elif opcion == 4:
        print("Saliendo del programa...")
        
    else:
        print("Opción no válida, intenta de nuevo (1-4).")