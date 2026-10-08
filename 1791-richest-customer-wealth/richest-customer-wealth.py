class Solution:
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        maximum =float('-inf')
        for i in range(0,len(accounts)):
            if sum(accounts[i])> maximum:
                maximum=sum(accounts[i])
        return maximum
        