//链接：https://leetcode-cn.com/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> paraMap = new HashMap<>();

        paraMap.put('(', ')');
        paraMap.put('[', ']');
        paraMap.put('{', '}');
        paraMap.put('s', 's');

        List<Character> stack = new LinkedList<>();
        stack.add('s');
        if (s.length() > 0 && !paraMap.containsKey(s.charAt(0))) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            if (paraMap.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                if (paraMap.get(stack.remove(stack.size() - 1)) != s.charAt(i)) {
                    return false;
                }
            }
        }

        return stack.size() == 1; //最后栈中可能为's('或者's)'，所以要判断一下栈的大小是否为1
    }
}