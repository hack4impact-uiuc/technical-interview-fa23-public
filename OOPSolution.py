from enum import Enum
from collections import defaultdict

class Bag(Enum):
    SMALL = (5, 0.25)
    MEDIUM = (10, 0.5)
    LARGE = (15, 1)
    
    def __init__(self, price, size):
        self.price = price
        self.size = size

# # Alternatively something like this 
# class Bag:
#     def __init__(self, name, size, price):
#         self.name = name
#         self.size = size
#         self.price = price 

class Van:
    
    def __init__(self, id, maxCapacity):
        self.id = id
        self.maxCapacity = maxCapacity
        self.currCapacity = 0
        self.pickupCount = 0
    
    def canFit(self, bag):
        return self.currCapacity + bag.size <= self.maxCapacity
    
    def addBag(self, bag):
        self.currCapacity += bag.size
        self.pickupCount += 1
    
    def getGasCost(self):
        return 4 * (0.1 * self.pickupCount * (self.currCapacity + self.maxCapacity))

class Laundry:

    def __init__(self):
        self.revenue = 0
        self.vans = [Van("Eric's Van", 10)]
    
    def singlePickup(self, address, bag):
        # Part 2 
        if self.van.currCapacity + bag.size <= self.van.maxCapacity:
            self.van.currCapacity += bag.size
            self.revenue += bag.price
        else:
            raise Exception("Max capacity reached, sad.")
    
    def pickup(self, address, bag):
        # Part 3
        for van in self.vans:
            if van.canFit(bag):
                van.addBag(bag)
                self.revenue += bag.price
                return
    
    def getNetIncome(self):
        gas_cost = sum(van.getGasCost() for van in self.vans)
        return self.revenue - gas_cost

class LaundryCorp:
    
    def __init__(self):
        self.franchises = defaultdict(Laundry)
    
    def addFranchise(self, name, laundry):
        self.franchises[name] = laundry
    
    def getLargestRevenueFranchise(self):
        return max(self.franchises, key=lambda name: self.franchises[name].revenue, default="")
        

if __name__ == "__main__":
    # Some tests, not necessary for actual interview 
    clean4impact = Laundry()
    clean4impact.pickup("H4I Road", Bag.SMALL)
    assert(clean4impact.revenue == 5)
    assert(clean4impact.vans[0].currCapacity == 0.25)
    assert(round(clean4impact.getNetIncome(), 2) == 0.9)
    cornell = Laundry()
    hack4impact = LaundryCorp()
    hack4impact.addFranchise("UIUC", clean4impact)
    hack4impact.addFranchise("Cornell", cornell)
    assert(hack4impact.getLargestRevenueFranchise() == "UIUC")
