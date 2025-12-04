class persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
    def mayorEdad(self):
        if self.edad>18:
           return("Es mayor de edad")
        else:
            return ("No es mayor de edad")

empleado1 = persona("Javier", 32)
empleado2 = persona("Marcos", 7)

print(f"El empleado {empleado1.nombre} tiene {empleado1.edad} años")

print(empleado1.mayorEdad())
