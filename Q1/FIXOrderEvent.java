class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp,
                         double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015;
        System.out.println("FIX Order ID: " + clOrdId);
        System.out.println("Purchase Price: " + basePrice);
        System.out.println("Transaction Fee: " + fee);
        System.out.println("Total: " + (basePrice + fee));
    }
}
