package com.pgt.chainResponsibility.chain;

public abstract class AbstractChain<T,V> {
    private AbstractChain nextChain;

    public boolean hasNextChain(){
        if (nextChain != null){
            return true;
        }
        return false;
    }

    public AbstractChain getNextChain() {
        return nextChain;
    }

    public void setNextChain(AbstractChain chain) {
        this.nextChain = chain;
    }

    public abstract boolean canAbleToHandle(T t);

    public abstract String Handler(T t,V v);
}
