class Solution:
    def kidsWithCandies(self, candies: list[int], extraCandies: int) -> list[bool]:
        output=[]
        for i in range(0,len(candies)):
            if(candies[i]+extraCandies)>=max(candies):
                output.append(True)
            else:
                output.append(False)
        return output
            
        