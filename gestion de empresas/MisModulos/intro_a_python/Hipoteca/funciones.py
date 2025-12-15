def cuota(h,n,i):
    r = i / (100*12)
    m = (h * r )/(1-(1+r)**(-12*n))
    return(round(m,2))

def importe_total(h,n,i):
    pago = cuota(h,n,i)
    t = n * 12
    total = pago*t
    return total

