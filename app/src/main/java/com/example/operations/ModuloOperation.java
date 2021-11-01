package com.example.operations;

public class ModuloOperation {
    String expression;
    long modulo;

    private class ExpressionTree {
        String data;
        ExpressionTree left, right;

        ExpressionTree() {
            data = "";
        }
    }

    //Constructor
    ModuloOperation() {
        expression = "";
        modulo = 1;
    }

    //Operator Value, less the value less the priority
    private int OPvalue(char ch) {
        switch (ch) {
            case '-':
                return 0;
            case '+':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '^':
                return 4;
            case '!':
                return 5;
            default:
                return 10;
        }
    }

    //This function finds the minimum priority operator
    //And returns its position
    private int findMinPri(String str) {
        int l = str.length();
        int i;
        int min_pos = -1;
        int min_val = 10;
        int op;
        int open_brackets = 0;
        int closed_brackets = 0;
        for (i = 0; i < l; i++) {
            if (str.charAt(i) == '(')
                open_brackets++;
            else if (str.charAt(i) == ')')
                closed_brackets++;
            else if (open_brackets == closed_brackets) {
                op = OPvalue(str.charAt(i));
                if (op < min_val) {
                    min_pos = i;
                    min_val = op;
                }
            }
        }
        return min_pos;
    }

    private long powerMod(long a, long n, long mod) {
        if (a == 1)
            return 1;
        long k = (long) (Math.log(mod) / Math.log(a)) + 1;
        if (n >= k)
            return ((powerMod((long) (Math.pow(a, k)) % mod, n / k, mod)) * (long) Math.pow(a, (n % k)) % mod);
        else
            return ((long) Math.pow(a, n));
    }

    private long factorialMod(long a, long mod) {
        if (a > mod)
            return 0;
        if (a==1 ||a==0)
            return (1 % mod);
        return ((factorialMod(a - 1, mod) * (a % mod)) % mod);
    }

    private String removeExternalBrackets(String str) {
        int l = str.length();
        if (str.charAt(0) == '(' && str.charAt(l - 1) == ')') {
            int open;
            open = 1;
            for (int i = 1; i < l -1; i++) {
                if(str.charAt(i) == '(')
                    open++;
                else if (str.charAt(i) == ')')
                    open--;
                if (open == 0)
                    return str;
            }
            str = str.substring(1, l - 1);
        }
        return str;
    }

    private void expressionToTree(ExpressionTree exp, String str) {
        str = removeExternalBrackets(str);//removing outer brackets in case expression is like (A*B)
        int pos = findMinPri(str);//finding the minimum priority operator
        if (pos == -1)
            exp.data = str;
        else {
            String strleft;
            if (str.charAt(pos) == '!') {
                strleft = str.substring(0, pos);
                exp.data = String.valueOf(str.charAt(pos));
                exp.left = new ExpressionTree();
                expressionToTree(exp.left, strleft);
            } else {
                String strright;
                strleft = str.substring(0, pos);
                exp.data = String.valueOf(str.charAt(pos));
                strright = str.substring(pos + 1);
                exp.left = new ExpressionTree();
                exp.right = new ExpressionTree();
                expressionToTree(exp.left, strleft);
                expressionToTree(exp.right, strright);
            }
        }
    }

    private long solve(ExpressionTree exp) {
        if (isNumeric(exp.data))
            return (Long.parseLong(exp.data));
        else {
            long ans;
            switch (exp.data.charAt(0)) {
                case '-':
                    ans = (solve(exp.left) % modulo - solve(exp.right) % modulo) % modulo;
                    break;
                case '+':
                    ans = (solve(exp.left) % modulo + solve(exp.right) % modulo) % modulo;
                    break;
                case '*':
                    ans = (solve(exp.left) % modulo * solve(exp.right) % modulo) % modulo;
                    break;
                case '/':
                    ans = (solve(exp.left) % modulo / solve(exp.right) % modulo) % modulo;
                    break;
                case '^':
                    ans = powerMod(solve(exp.left), solve(exp.right), modulo);
                    break;
                case '!':
                    ans = factorialMod(solve(exp.left), modulo);
                    break;
                default:
                    return -999;
            }
            return ((ans >= 0) ? ans : modulo + ans);
        }
    }


    private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public long calculate(String expression, long modulo) {
        ExpressionTree expressionTree = new ExpressionTree();
        expressionToTree(expressionTree, expression);
        this.modulo = modulo;
        return solve(expressionTree);
    }
}