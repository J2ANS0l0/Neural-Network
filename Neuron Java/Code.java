import java.util.ArrayList;
import java.util.Arrays;

// Test of a Basic Neuron

public class Code {
    public static void main(String[] args) {

        // Possibilities 2**2 | X values
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>(Arrays.asList(
        new ArrayList<>(Arrays.asList(0,0)),
        new ArrayList<>(Arrays.asList(0,1)),
        new ArrayList<>(Arrays.asList(1,0)),
        new ArrayList<>(Arrays.asList(1,1))
        ));

        // Expected activation
        ArrayList<Integer> Expected = new ArrayList<>(Arrays.asList(1,0,0,0));
        ArrayList<Integer> Results = new ArrayList<>();

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
}
