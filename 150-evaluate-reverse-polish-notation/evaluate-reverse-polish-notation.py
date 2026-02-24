class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st=[]

        for token in tokens:
            if token  in ('+', '-', '*',  '/'):
                bottom=int(st.pop())
                top=int(st.pop())
                if token=='+':
                    st.append(top+bottom)
                elif token=='-':
                    st.append( top-bottom)
                elif token=='*':
                    st.append(top*bottom)
                elif token=='/':
                    st.append( top/bottom)

            else:
                st.append(token)
        return int(st[-1])
            

