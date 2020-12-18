package NeuralNet;

import java.util.Random;

public class Perceptron {
    private double weights[], DETAILLIMIT = 0.0000000000001;
    public double adjustment = 0.01;//needs about 100_000 trains before its perfect
    public double smoothFactor = 0.00001;
    Perceptron(int inputCount){
        Random rand = new Random();
        weights = new double[inputCount];
        for(int i = 0; i <  weights.length;i++)
            weights[i] = rand.nextDouble();
    }
    public void adjust(double[] input, double err){
        if(input.length != weights.length){ 
            System.out.println("INPUT SIZE IS REQUIRED TO BE EXACTLY "+weights.length); 
            return;
        }
        for(int i = 0; i < 2;i++){
            weights[i] += input[i] * err * adjustment;
            weights[i] -= weights[i] % DETAILLIMIT;//limits the amout of numbers following decimal point
        }
    }
    public double getOutput(double[] input){
        if(input.length != weights.length){ 
            System.out.println("INPUT SIZE IS REQUIRED TO BE EXACTLY "+weights.length); 
            return -1;
        }
        input[0] *= weights[0];
        input[1] *= weights[1];
        return (input[0]+input[1])/2;
    }
    //this function is a finishing touch after training, it will make values like 0.99999999999999999792834 look like 1.0
    //basically just a fine tune rounding.... this is experimental and im not sure how useful its gunna be in future projects
    public void smooth(){
        for(int i = 0; i < weights.length; i++){
            if(weights[i] % 1 <= 0.5){
                if(weights[i] % 1 < smoothFactor)
                    weights[i] = Math.round(weights[i]);
            }else
                if(weights[i] % 1 > 1 - smoothFactor)
                    weights[i] = Math.round(weights[i]);
        }
    }
    public void print(){System.out.println(weights[0]+":"+weights[1]);}
}
