package org.knit.lab2;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent{
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name){
        super(name);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component: components){
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void add(FileSystemComponent component){
        components.add(component);
    }

    @Override
    public void remove(FileSystemComponent component){
        components.remove(component);
    }

    @Override
    public void display(StringBuilder indent, boolean isLast) {
        System.out.print(indent);
        if (isLast){
            System.out.print("└── ");
        } else {
            System.out.print("├── ");
        }
        indent.append("\t");
        System.out.println(name);

        for (int i = 0; i < components.size(); i++){
            components.get(i).display(indent, i == components.size() - 1);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Total size of ").append(getName()).append(": ")
                .append(getSize()).append(" bytes").toString();
    }
}
