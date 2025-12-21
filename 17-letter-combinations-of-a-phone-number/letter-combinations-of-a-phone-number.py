class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res=[]
        digitstoChar = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
       

        def backtrack(index, part):
            if len(part) == len(digits):
                res.append(part)
                return
            for ch in digitstoChar[digits[index]]:
                backtrack(index+1,part+ ch)

        if digits:
            backtrack(0,"")
        return res
