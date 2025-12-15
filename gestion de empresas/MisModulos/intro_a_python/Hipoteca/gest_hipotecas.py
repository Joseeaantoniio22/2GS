import funciones
def menu():
    opcion = 0
    try: 
        while (opcion >=1 or opcion <=3 ):
            print("Seleccione la opcion que quiera realizar: ")            
            print("1. Calcular importe total de la hipoteca")
            print("2. Obtener cuota de la hipoteca")
            print("3. Salir")
            opcion = int (input(" "))



            match opcion:
                case 1:
                    print ("Me puedes decir la cuantia total de la hipoteca solicitada")
                    h = int(input("> "))
                    print("Me puedes decir cuanto tiempo estas con la hipoteca")
                    n = int(input("> "))
                    print("Me puedes decir el interes que tienes en la hipoteca")
                    i = float(input("> "))
                    print(f"La cuantía total de la hipoteca es de {funciones.importe_total(h,n,i)}")
                    menu()
                case 2:
                    print ("Me puedes decir la cuantia total de la hipoteca solicitada")
                    h = int (input("> "))
                    print("Me puedes decir cuanto tiempo estas con la hipoteca")
                    n = int (input("> "))
                    print("Me puedes decir el interes que tienes en la hipoteca")
                    i = float (input("> "))
                    print(f"La cuota de la hipoteca es de {funciones.cuota(h,n,i)}")
                    menu()
                case 3:
                    print("Saliendo...")
                    break
    except ValueError:
        print("Introduzca un numero entero, dentro de los valores")
        input("Pulse enter para volver a intentarlo")
        menu()
