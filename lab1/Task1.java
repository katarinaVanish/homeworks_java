package org.knit.lab1;


public class Task1 {

    public void execute() {
        for(int i = 0; i < 10; i++){
            String line = "";
            for(int j = 1; j <= 10; j++){
                line += (j + i * 10);
                if(j != 10){
                    line += ",";
                }
            }
            System.out.println(line);
        }
    }
}
