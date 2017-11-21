package com.example.nazmuddinmavliwala.languagelist.languages.views.adapterdelegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.nazmuddinmavliwala.languagelist.R;
import com.example.nazmuddinmavliwala.languagelist.base.views.recyclerview.AbstractAdapterDelegate;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewholders.LoaderVO;
import com.example.nazmuddinmavliwala.languagelist.languages.views.viewholders.LoaderViewHolder;

import java.util.List;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LoaderDelegate extends AbstractAdapterDelegate<List<Object>> {

    public LoaderDelegate(int viewType, Context context) {
        super(viewType, context);
    }

    @Override
    public boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof LoaderVO;
    }

    @Override
    public void onBindViewHolder(@NonNull List<Object> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        ((LoaderViewHolder)holder).bind((LoaderVO) items.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new LoaderViewHolder(this.context,itemView);
    }

    @Override
    protected int getViewHolderLayout() {
        return R.layout.loader_row;
    }
}
