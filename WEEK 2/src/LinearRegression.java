

public class LinearRegression {
    private int[]x ;
    private int[]y;
    private double meanX;
    private double meanY;

    /*
    Takes both data sets
     */

    public LinearRegression (int[] xdata, int[] YData) {
        x = xdata;
        this.y = YData;
    }

    /*
    Predicts the value by using y=mx+c and uses x mean and y mean and the first coordinates
     */

    public double predictValue (int inputValue ) {
        int X1 = x[0] ;
        int Y1 = y[0];
        double Xmean = getXMean(x) ;
        double Ymean = getYMean(y) ;
        double lineSlope = CalculateGradient( Xmean , Ymean , X1 , Y1 ) ;
        double YIntercept = CalculateYIntercept( Xmean , Ymean , lineSlope ) ;
        double prediction = ( lineSlope * inputValue ) + YIntercept ;
        return prediction ;
    }



    public  double CalculateGradient ( double Xmean,  double Ymean,  int X1,  int Y1) {
        double num1 = X1 - Xmean;
        double num2 = Y1 - Ymean;
        double denom = (X1 - Xmean) * (X1 - Xmean);
        return (num1 * num2) / denom;
    }

    public  double CalculateYIntercept ( double Xmean,  double Ymean,  double lineSlope) {
        return Ymean - (lineSlope * Xmean);
    }

    public double getXMean (int[] Xdata) {
        meanX = 0.0 ;
        for (int i = 0; i < Xdata.length; i++) {
            meanX += Xdata[i];
        }
        return meanX;
    }

    public double getYMean (int[] Ydata) {
        meanY = 0.0 ;
        for (int i = 0; i < Ydata.length; i++) {
            meanY=+ Ydata[i];
        }
        return meanY;
    }

    public static void main(String[] args) {
        int[] xValues={1,2,3,4,5,6,7,8};
        int[] yValues={2,4,5,6,3,4,5,6};

        LinearRegression test=new LinearRegression(xValues,yValues);
        System.out.println(test.predictValue(1));


    }
}

