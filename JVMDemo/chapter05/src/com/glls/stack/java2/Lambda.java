package com.glls.stack.java2;

/**
 * @ClassName : Lambda
 * @Author : glls
 * @Date: 2022/2/4 18:22
 * @Description :
 */
public class Lambda {
    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        Func func = s -> {
            return true;
        };

        lambda.lambda(func);

        lambda.lambda(s -> {
            return true;
        });
    }
}


@FunctionalInterface
interface Func {
    public boolean func(String str);
}