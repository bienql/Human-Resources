public interface ICalculator {
    int businessleaderpay = 8000000;
    int projectleaderpay = 5000000;
    int techleaderpay = 6000000;


    double pay(double payrate);
}

class calBusinessleader implements ICalculator {
    @Override
    public double pay(double payrate) {
        return payrate * 5000000 + businessleaderpay;
    }
}

class calProjectleader implements ICalculator {
    @Override
    public double pay(double payrate) {
        return payrate * 5000000 + projectleaderpay;
    }
}

class calTechleader implements ICalculator {
    @Override
    public double pay(double payrate) {
        return payrate * 5000000 + techleaderpay;
    }
}

