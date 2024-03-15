package net.minestom.server.plugins;

public final class PluginDescription {

    private final String name;
    private final String version;
    private final String author;
    private final String mainClass;
    private final String[] depends;

    public PluginDescription(String name, String version, String author, String mainClass, String[] depends) {
        this.name = name;
        this.version = version;
        this.author = author;
        this.mainClass = mainClass;
        this.depends = depends;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public String getMainClass() {
        return mainClass;
    }

    public String[] getDepends() {
        return depends;
    }
}
