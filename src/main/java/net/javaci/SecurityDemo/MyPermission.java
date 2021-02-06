package net.javaci.SecurityDemo;

public enum MyPermission {

    READ("read"),
    CREATE("create"),
    DELETE("delete"),
    UPDATE("update");

    private String permission;

    MyPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
