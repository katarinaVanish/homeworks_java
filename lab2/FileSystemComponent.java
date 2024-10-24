package org.knit.lab2;

public abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract int getSize();

    public void add(FileSystemComponent component){
        throw new UnsupportedOperationException("Операция не поддерживается для файлов!");
    }

    public void remove(FileSystemComponent component){
        throw new UnsupportedOperationException("Операция не поддерживается для файлов!");
    }

    public abstract void display(StringBuilder indent, boolean isLast);
}
