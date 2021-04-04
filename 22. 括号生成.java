class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> paths = new ArrayList<>();
        if (n == 0) {
            return paths;   
        } 

        backtrace("", n, n, paths);
        return paths;
    }

    private void backtrace(String path, int leftNum, int rightNum, List<String> paths) {
        if (leftNum == 0 && rightNum == 0) {
            paths.add(path);
            return;
        }

        if (leftNum > rightNum) {
            return;
        }

        if (leftNum > 0) {
            backtrace(path + "(", leftNum - 1, rightNum, paths);
        }

        if (rightNum > 0) {
            backtrace(path + ")", leftNum, rightNum - 1, paths);
        }
    }
}