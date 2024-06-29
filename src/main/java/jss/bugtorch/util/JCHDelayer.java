package jss.bugtorch.util;

public class JCHDelayer {

    long last;
    long delay;

    public JCHDelayer(long delay) {
        setDelay(delay);
    }

    public JCHDelayer() {

    }

    public boolean isRedy(int nDelay) {

        boolean isDone = isRedy();

        if (isDone) {
            setDelay(nDelay);
        }
        return isDone;

    }

    public boolean isRedy() {

        if (getPassed() > delay) {
            updateLast();
            return true;
        }
        return false;

    }

    public void updateLast() {
        last = System.currentTimeMillis();
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getPassed() {
        return System.currentTimeMillis() - last;

    }

}
