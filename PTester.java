package NeuralNet;

import java.util.Random;

public class PTester {
    public static void main(String[] args){
        Perceptron p = new Perceptron(2);
        double[] input = {0.5,0.5};
        double err,output;
        Random rand = new Random();
        double desired = 0;
        //train
        for(int i = 0; i < 100000;i++){
            input[0] = rand.nextDouble()/2;
            input[1] = rand.nextDouble()/2;
            desired = (input[0] + input[1]);
            output = p.getOutput(input);
            err = desired - output;
            p.adjust(input, err); 
        }
        input[0] = 0.2;
        input[1] = 0.3;
        p.smooth();
        System.out.println(p.getOutput(input));
        p.print();
    }
}
