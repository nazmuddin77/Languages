package com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.domain.interactors.LanguageData;
import com.example.nazmuddinmavliwala.languagelist.R;
import com.example.nazmuddinmavliwala.languagelist.app.di.identifiers.ActivityContext;
import com.example.nazmuddinmavliwala.languagelist.base.views.BaseViewDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.adapters.LanguageAdapter;
import com.example.nazmuddinmavliwala.languagelist.languages.models.LanguageVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import rx.subjects.PublishSubject;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class DataViewDelegate extends BaseViewDelegate<List<LanguageData>> {

    private final PublishSubject<Boolean> fetchNextSubject = PublishSubject.create();

    @BindView(R.id.rv_languages)
    RecyclerView recyclerView;

    @Inject
    public DataViewDelegate(@NonNull @ActivityContext Context context,
                            @NonNull @Named("Data") View view) {
        super(context, view);
        recyclerView.addOnScrollListener(new RecyclerViewScrollManager() {
            @Override
            public void endOfList() {
                fetchNextSubject.onNext(true);
            }
        });
    }

    @Override
    public void onCreate() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.context);
        recyclerView.setLayoutManager(manager);
        LanguageAdapter adapter = new LanguageAdapter(this.context);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void bind(List<LanguageData> data) {
        List<Object> objects = new ArrayList<>();
        objects.addAll(data);
        ((LanguageAdapter)recyclerView.getAdapter()).append(objects);
    }

    public rx.Observable<Boolean> getNextObservable() {
        return this.fetchNextSubject;
    }
}
