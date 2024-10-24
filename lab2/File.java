package org.knit.lab2;

public class File extends FileSystemComponent{
    private int size;
    public File(String name, int size){
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display(StringBuilder indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└── ");
        } else {
            System.out.print("├── ");
        }
        System.out.println(name + " (" + size + " bytes)");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Total size of ").append(getName()).append(": ")
                .append(getSize()).append(" bytes").toString();
    }
}
