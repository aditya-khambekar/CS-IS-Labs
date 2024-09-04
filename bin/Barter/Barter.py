with open (r'barter.dat') as f:
    file = f.read()

lines = file.splitlines()
for line in lines:
    two = str.split(line, " - ")
    two[0] = two[0][1:-1]
    two[1] = two[1][1:-1]
    user = str.split(two[0], "/")
    wanted = str.split(two[1], "/")
    
    gw = 1
    pc = 3
    b = 5
    t = 6
    gf = 8
    f = 9
    l = 100
    
    ugw = int(user[0])
    upc = int(user[1])
    ub = int(user[2])
    ut = int(user[3])
    ugf = int(user[4])
    uf = int(user[5])
    ul = int(user[6])
    
    vgw = int(wanted[0])
    vpc = int(wanted[1])
    vb = int(wanted[2])
    vt = int(wanted[3])
    vgf = int(wanted[4])
    vf = int(wanted[5])
    vl = int(wanted[6])
    
    prices = [vgw*gw, vpc*pc, vb*b, vt*t, vgf*gf, vf*f, vl*l]
    
    sum = 0
    for price in prices:
        sum += price
    
    accepteds = 0
    
    for watergallons in range(ugw+1):
        #print(1)
        for pieces in range(upc+1):
            #print(2)
            for batteries in range(ub+1):
                #print(3)
                for tools in range(ut+1):
                    #print(4)
                    for fuelgallons in range(ugf+1):
                        #print(5)
                        for food in range(uf+1):
                            #print(6)
                            for livestock in range(ul+1):
                                #print(7)
                                offer = watergallons*gw + pieces*pc + batteries*b + tools*t + fuelgallons*gf + food*f + livestock*l
                                #print("Offer "+str(offer))
                                if offer>=sum:
                                    accepteds+= 1

    print(accepteds)
                                    
    
    
    
    