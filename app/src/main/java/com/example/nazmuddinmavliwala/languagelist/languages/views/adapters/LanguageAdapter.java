package com.example.nazmuddinmavliwala.languagelist.languages.views.adapters;

import android.content.Context;

import com.example.nazmuddinmavliwala.languagelist.base.views.recyclerview.AdapterDelegate;
import com.example.nazmuddinmavliwala.languagelist.base.views.recyclerview.ReactiveRecyclerAdapter;
import com.example.nazmuddinmavliwala.languagelist.languages.views.adapterdelegates.LanguageDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.adapterdelegates.LoaderDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewholders.LoaderVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageAdapter extends ReactiveRecyclerAdapter {

    private static final int LANGUAGE = 0;
    private static final int LOADER = 1;

    public LanguageAdapter(Context context) {
        super(context);
    }

    @Override
    protected List<AdapterDelegate> initAdapterDelegates() {
        List<AdapterDelegate> adapterDelegates = new ArrayList<>();
        adapterDelegates.add(new LanguageDelegate(LANGUAGE,this.context));
        adapterDelegates.add(new LoaderDelegate(LOADER,this.context));
        return adapterDelegates;
    }

    @Override
    public void append(List<Object> items) {
        if (this.items.size() == 0) {
            this.items.addAll(items);
            notifyDataSetChanged();
        } else {
            if (loaderPresent()) {
                removeLoader();
            }
            int offset = this.items.size();
            int count = items.size();
            this.items.addAll(items);
            notifyItemRangeInserted(offset,count);
        }
    }

    private boolean loaderPresent() {
        if (this.items.size() == 0) return false;
        for (Object o : items) {
            if (o instanceof LoaderVO) return true;
        }
        return false;
    }

    public void removeLoader() {
        int pos = -1;
        for (Object o : items) {
            if (o instanceof LoaderVO) {
                pos = this.items.indexOf(o);
                break;
            }
        }
        if (pos == -1) throw new IllegalStateException();
        this.items.remove(pos);
        notifyItemRemoved(pos);
    }

}
