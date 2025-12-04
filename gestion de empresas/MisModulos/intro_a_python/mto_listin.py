class Listin:
    def __init__(self):
        self.listin = {}
    
    def anadirPersona(self, nombre, telefono):
        self.listin[nombre] = telefono
        print(f"Añadiste a {nombre}, con telefono {telefono}")
    
    def borrarPersona(self, nombre):
        del self.listin[nombre]
        print(f"Has borrado ha {nombre}")
    
    def listarPersonas(self):
        for nombre, telefono in self.listin:
            return self.listin[nombre]
        print("Lista mostrada")

listin = Listin()
def menu():
    opcion = 0
    while(opcion<1 or opcion > 4):
        print("MTO Listin")
        print("1. Añadir persona")
        print("2. Borrar persona")
        print("3. Listar Listin")
        print("4. Salir")
        print ("Seleccione la opcion que quieras realizar")
        opcion = int(input(" "))
    return opcion

opcion = 0
while(opcion!=4):
    opcion= menu()
    match(opcion):
            case 1:
                print("Dime el nombre de la persona que quieras añadir")
                nombre = input()
                print("Dime el telefono correspondiente")
                telefono = input()
                listin.anadirPersona(nombre, telefono)
            
            case 2:
                print("Dime el nombre de la persona que quieras ")
                nombre = input()
                borrarPersona(nombre)
                
            case 3:
                listin.listarPersonas()
            case 4: 
                exit()


    





