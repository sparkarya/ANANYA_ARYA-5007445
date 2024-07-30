import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockPrice;

    public void setStockPrice(String stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

interface Observer {
    void update(String stockPrice);
}

class MobileApp implements Observer {
    public void update(String stockPrice) {
        System.out.println("Mobile App received stock price update: " + stockPrice);
    }
}

class WebApp implements Observer {
    public void update(String stockPrice) {
        System.out.println("Web App received stock price update: " + stockPrice);
    }
}

class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockPrice("100 USD");
    }
}
