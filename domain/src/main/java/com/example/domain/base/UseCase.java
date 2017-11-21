package com.example.domain.base;

import com.example.domain.executers.ExecutionThread;
import com.example.domain.executers.PostExecutionThread;

import rx.Observable;
import rx.Subscription;

/**
 * Created by nazmuddinmavliwala on 12/03/17.
 */

public abstract class UseCase<T extends Repository> {

    protected final ExecutionThread executionThread;
    protected final PostExecutionThread postExecutionThread;
    protected final T repository;
    protected Subscription subscriber;

    public UseCase(ExecutionThread executionThread,
                   PostExecutionThread postExecutionThread,
                   T repository) {
        this.executionThread = executionThread;
        this.postExecutionThread = postExecutionThread;
        this.repository = repository;
    }

    protected  <P> Observable<P> getScheduledObservable(Observable<P> observable) {
        return observable.subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }

    protected <P> Observable.Transformer<P, P> applySchedulers() {
        return observable -> observable.subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }


    public void unsubscribe() {
        if (this.subscriber != null) this.subscriber.unsubscribe();
    }

}
