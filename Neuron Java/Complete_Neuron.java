import java.util.ArrayList;
import java.util.Arrays;

// Test of a Complete Neuron

public class Complete_Neuron {
    public static void main(String[] args) {

        Perceptron A = new Perceptron(0, 0, 1);
        Perceptron B = new Perceptron(0,0, 1);
        Perceptron C = new Perceptron(0, 0, 1);

        ArrayList<ArrayList<Double>> Inputs = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> Layer_01 = new ArrayList<Double>();
        ArrayList<Double> Layer_02 = new ArrayList<Double>();
        ArrayList<Double> Output = new ArrayList<>();
        
        ArrayList<Double> Expected = new ArrayList<>(Arrays.asList(0.0,1.0,1.0,0.0));

        // Possibilities 2**Expected Size | X values

        double exponent = Math.log(Expected.size()) / Math.log(2);
        for (int i = 0; i < Math.pow(2, (int) Math.ceil(exponent)); i++){
            Inputs.add(binary_combinations(i, (int) Math.ceil(exponent)));
        }

        int x = ((int) Math.pow(2, (int) Math.ceil(exponent)) - Expected.size());
        for (int j = 0; j < x; j++){
            Expected.add(0.0);
        }

        // Neuron Code:
        double Errors = 0;
        int counter = 0;
        
        while (!Expected.equals(Output)) {
            System.out.println();
            System.out.println(counter+1);
            Output.clear();

            for(int i=0; i<Expected.size(); i++){
                Layer_01.clear();

                if(i%Expected.size()==0){counter += 1;}
                
                // OutputValues = Neuron.Result(InputValues)

                Layer_01.add(A.Result(Inputs.get(i)));
                Layer_01.add(B.Result(Inputs.get(i)));
                Output.add(C.Result(Layer_01));

                Errors = Expected.get(i) - Output.get(i);
                A.BackPropagation(Errors);
                B.BackPropagation(Errors);
                C.BackPropagation(Errors);

                System.out.println(A + "Result A " + Layer_01.get(0));
                System.out.println(B + "Result B " + Layer_01.get(1));
                System.out.println(C);

                System.err.print("  Expected: " + Double.toString(Expected.get(i)) + " Result: " + Double.toString(Output.get(i)) + "\n");
                System.out.println();
                //if(Errors!=0){break;}
            }
        }   
    }

    public static ArrayList<Double> binary_combinations(int n, int n_characters) {
        
        ArrayList<Double> number = new ArrayList<>();
        String binary = String.format("%" + n_characters + "s", Integer.toBinaryString(n)).replace(' ', '0');

        for (int j = 0; j < binary.length(); j++) { // Recorremos la longitud de binary
            char digit = binary.charAt(j);
            number.add((double) Character.getNumericValue(digit));
        }

        return number;
    }

}
 