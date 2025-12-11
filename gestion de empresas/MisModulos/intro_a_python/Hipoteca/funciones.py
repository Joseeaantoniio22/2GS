def cuota(h,n,i):
    r = i / (100*12)
    m = (h * r )/(1-(1+r)**(-12*n))
    return(round(m,2))

def importe_total(h,n,i):
    pago = cuota(h,n,i)
    t = n * 12
    total = pago*t
    return total

def menu():

    print("Seleccione la opcion que quiera realizar: ")
    print("1. Calcular importe total de la hipoteca")
    print("2. Obtener cuota de la hipoteca")
    print("3. Salir")
    opcion = int(input("> "))

    while (opcion > 3 or opcion < 0 ):
        print("Seleccione la opcion que quiera realizar: ")
        print("1. Calcular importe total de la hipoteca")
        print("2. Obtener cuota de la hipoteca")
        print("3. Salir")

        opcion = int (input(" "))
        return opcion 
    

    while (opcion):
        match opcion:
            case 1:
                print ("Me puedes decir la cuantia total de la hipoteca solicitada")
                h = int(input("> "))
                print("Me puedes decir cuanto tiempo estas con la hipoteca")
                n = int(input("> "))
                print("Me puedes decir el interes que tienes en la hipoteca")
                i = float(input("> "))
                print(f"La cuantía total de la hipoteca es de {importe_total(h,n,i)}")
                menu()
            case 2:
                print ("Me puedes decir la cuantia total de la hipoteca solicitada")
                h = int (input("> "))
                print("Me puedes decir cuanto tiempo estas con la hipoteca")
                n = int (input("> "))
                print("Me puedes decir el interes que tienes en la hipoteca")
                i = float (input("> "))
                print(f"La cuota de la hipoteca es de {cuota(h,n,i)}")
                menu()
            case 3:
                print("Saliendo...")
                break
    