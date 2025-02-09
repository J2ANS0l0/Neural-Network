import java.util.ArrayList;

public class Perceptron {
    
    private ArrayList<Double> Inputs = new ArrayList<>();
    private ArrayList<Double> Weights = new ArrayList<>();
    private double Bias = 0;
    private double Learning_Rate = 0;

    private boolean Activate = false;
    private double Basic_weith = 0;

    public Perceptron(double bias, double basic_weith, double learning_rate){
        this.Bias = bias;
        this.Basic_weith = basic_weith;
        this.Learning_Rate = learning_rate;
    }

    public double Result(ArrayList<Double> input){

        double result = 0;
        double e = (double) Math.E;
        double sigmoid = 0.0;
        double summation = (double) 0.0;
        this.Inputs = new ArrayList<Double>(input);

        if(!Activate){
            for(int i=0; i<this.Inputs.size(); i++){
                this.Weights.add(this.Basic_weith);
            }
            this.Activate = true;
        }

        for(int j=0; j<this.Inputs.size(); j++){
            summation += this.Inputs.get(j)*this.Weights.get(j);
        }

        sigmoid = 1 / (1 + Math.pow(e, -(summation - this.Bias)));

        if(sigmoid >= 0.5){result = 1;}
        else {result = 0;}

        return result;
    }

    public void BackPropagation(double errors){
        this.Bias = this.Bias - errors*this.Learning_Rate;
        for(int k=0; k<this.Weights.size(); k++){
            this.Weights.set(k, this.Weights.get(k)+errors*this.Learning_Rate*this.Inputs.get(k));
        }
    }

    @Override
    public String toString() {
        String Information = "";

        Information += "bias: " + String.format("%.2f", this.Bias) + "    ";
        for(int l=0; l<Weights.size(); l++){
            Information += "w" + Integer.toString(l+1) + ": " + String.format("%.2f", this.Weights.get(l)) + " ";
        }
        return Information;
    }
}