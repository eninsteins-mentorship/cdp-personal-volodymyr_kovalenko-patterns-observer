package com.kovalenkovolodymyr.observer.subject;

import com.kovalenkovolodymyr.observer.IObserver;

public interface ISubject {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void trigger();
}
