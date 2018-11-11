package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String menuName;

    protected BaseAction(final int key, final String menuName) {
        this.key = key;
        this.menuName = menuName;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.menuName);
    }
}
