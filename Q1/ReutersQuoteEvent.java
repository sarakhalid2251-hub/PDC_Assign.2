class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;

    public ReutersQuoteEvent(String senderId, long timestamp,
                             double basePrice, double bidPrice,
                             double askPrice) {
        super(senderId, timestamp, basePrice);
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    @Override
    public void dispatch() {
        System.out.println("Reuters Quote");
        System.out.println("Bid Price: " + bidPrice);
        System.out.println("Ask Price: " + askPrice);
        System.out.println("Spread: " + (askPrice - bidPrice));
    }
}
