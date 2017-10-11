
package gaussseidelMethod;

import java.util.Arrays;


public class GaussSeidel {

    public static void main(String[] args) {
        double[][] equation = {{19,3,2,9},{3,15,1,11},{1,2,-3,10}};
        solve(equation);
    }
    
    static void solve(double[][] equation){
        double[] init={1,8,0};
        double eps=0.1;
        int size = equation.length;
        double[] prevX = new double[size];
        prevX=init.clone();
        double[] X = new double[size];
        X=init.clone();
        //Arrays.fill(X,0);
        
        int iterations = 0;
        double prevErr=0f,err=0f;
        
        while (true) {            
            iterations++;
            System.out.print(iterations+"\t");
            for (int i = 0; i < size; i++) {
                double variableValue = equation[i][size];
                
                for (int j = 0; j < size; j++) {
                    if(i!=j){
                        variableValue-=equation[i][j]*X[j];
                    }
                }
                X[i]=(1/equation[i][i])*variableValue;
                System.out.printf(" %15.4f ",X[i]);
            }    
            System.out.println("");
            System.out.printf("Err => ");;
            err=checkErr(prevX, X, eps);
            System.out.println("\n");
            if(Math.abs(err)<eps) break;
            
            prevErr=err;
            prevX=X.clone();
        }
       
        System.out.println("Iterations = "+iterations);
        System.out.println("Epsilon = "+eps);
        System.out.printf("relative approximate error = %5.4f\n",Math.abs(err));
        for (int i = 0; i < X.length; i++) {
            System.out.printf("X_%d: %5.4f\n",(i+1),X[i]);
        }
    }
    
    static double checkErr(double[] prevX,double[] X,double eps){
        //Math.abs((xNew-xOld)/xNew
        double maxErr = 0f;
        double err = 0f;
        for(int i=0 ; i < prevX.length ; i++){
            err=Math.abs((X[i]-prevX[i])/X[i])*100;
            if(err>maxErr){
                maxErr = err;
            }
        }
        
        //if(maxErr<eps) return true;
        return maxErr;
    }

}

//        double[][] equation = {{12,3,-5,1},
//                               {1,5,3,28},
//                               {3,7,13,76}};

//        double[][] equation = {{2,2,-1,3},
//                               {3,-2,2,10},
//                               {1,3,-3,-4}};

//        double[][] equation = {{12,3,-5,1},
//                               {1,5,3,28},
//                               {3,7,13,76}};
//        double[][] equation = {{3,7,13,76},
//                               {1,5,3,28},
//                               {12,3,-5,1}};

//        double[][] equation = {{25,5,1,106.8},
//                               {64,8,1,177.2},
//                               {144,12,1,279.2}};

//        double[][] equation = {{144,12,1,279.2},
//                               {64,8,1,177.2},
//                               {25,5,1,106.8}};
//            double[][] equation ={
//            { 2, 3,  5,-5},
//            { 1, 8,  0,28},
//            { 1, 7, 13,76}};
//        double[][] equation = {{5,1,2,76},
//                               {3,6,3,1},
//                               {1,3,23,-2}};
//            double[][] equation = {{19,3,2,8},{4,3,1,10},{1,2,-3,4}};
//double[][] equation = {{19,3,2,8},{4,6,1,10},{1,2,-3,10}};