package StructuralPatterns.Adapter;

class UsdToEurAdapter implements CurrencyAdapter {
    private double exchangeRate = 0.85;

    @Override
    public double convert(double amount) {
        return amount * exchangeRate;
    }
}