1import SEE.Externals;

class Main {
    public static void main(String args[]) {

        Externals obj = new Externals();

        obj.inputStudentDetails();
        obj.inputCIEmarks();
        obj.inputSEEmarks();
        obj.calculateFinalMarks();
        obj.displayFinalMarks();
    }
}