package com.mane.umakant.designPatterns.Observer;

import java.util.*;

interface Observer {
    void update(String news);
}

interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers();
}

class NewsAgency implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String latestNews;

    public void setNews(String news) {
        this.latestNews = news;
        notifyObservers();
    }

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(latestNews);
        }
    }
}

class NewsChannel implements Observer {

    private String name;

    NewsChannel(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

public class ObserverBasicTest {
    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Observer ch1 = new NewsChannel("Channel-1");
        Observer ch2 = new NewsChannel("Channel-2");

        agency.subscribe(ch1);
        agency.subscribe(ch2);

        agency.setNews("Election Results Declared");
    }
}

