public class TradingEngineApp {
    public static void main(String[] args) {
        TradeEvent event1 = new FIXOrderEvent(
            "FIX", System.currentTimeMillis(), 1000, "ORD101"
        );

        TradeEvent event2 = new ReutersQuoteEvent(
            "Reuters", System.currentTimeMillis(), 105,
            104, 106
        );

        event1.dispatch();
        event2.dispatch();
    }
}
