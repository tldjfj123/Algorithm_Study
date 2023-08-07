def solution(phone_book):
    phone_book.sort()
    table = dict()
    
    for p in phone_book :
        if not table.keys() :
            table[p] = 1
        else :
            for key in table.keys() :
                if key == p[:len(key)] :
                    return False
            else :
                table[p] = 1
    else :
        return True
        
    
    
    