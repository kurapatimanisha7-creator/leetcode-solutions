class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        count = 0
        ans = ""

        for ch in s:

            if ch == "(":
                if count > 0:
                    ans += "("
                count += 1

            else:
                count -= 1
                if count > 0:
                    ans += ")"

        return ans
        
        