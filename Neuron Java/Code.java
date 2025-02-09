import java.util.ArrayList;
import java.util.Arrays;

// Test of a Basic Neuron

public class Code {
    public static void main(String[] args) {

        // Expected activation
        ArrayList<Integer> Expected = new ArrayList<>(Arrays.asList(0,1,0,0));
        ArrayList<Integer> Results = new ArrayList<>();

        // Possibilities 2**Expected Size
        double exponent = Math.log(Expected.size()) / Math.log(2);
        ArrayList<ArrayList<Double>> inputs = new ArrayList<>();
        for (int i = 0; i < Expected.size(); i++){
            inputs.add(binary_combinations(i, (int) exponent));
        }

        Perceptron Neuron = new Perceptron(0, 0, (double) 5);
        int Errors = 0;
        int counter = 0;

        while (!Expected.equals(Results)) {
            System.out.println();
            System.out.println(counter+1);
            Results.clear();

            for(int i=0; i<4; i++){

                if(i%4==0){counter += 1;}
                
                // OutputValues = Neuron.Result(InputValues)
                Results.add(Neuron.Result(inputs.get(i)));
                Errors = Expected.get(i) - Results.get(i);
                Neuron.BaskPropagation(Errors);

                System.err.print(Neuron);
                System.err.print("  Expected: " + Integer.toString(Expected.get(i)) + " Result: " + Integer.toString(Results.get(i)) + "\n");

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
