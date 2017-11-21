package com.example.nazmuddinmavliwala.languagelist.languages.views.viewdelegates;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by nazmuddinmavliwala on 21/01/17.
 */

public abstract class RecyclerViewScrollManager extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (isLastItemDisplaying(recyclerView)) {
            endOfList();
        }
    }

    private boolean isLastItemDisplaying(RecyclerView recyclerView) {
        return isLastItemDisplaying(recyclerView, 1);
    }

    private boolean isLastItemDisplaying(RecyclerView recyclerView, int threshold) {
        if (recyclerView.getAdapter().getItemCount() != 0) {
            int lastVisibleItemPosition = RecyclerView.NO_POSITION;
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                lastVisibleItemPosition = ((LinearLayoutManager)
                        recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                lastVisibleItemPosition = ((GridLayoutManager)
                        recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            }

            if (lastVisibleItemPosition != RecyclerView.NO_POSITION
                    && lastVisibleItemPosition == recyclerView.getAdapter().getItemCount() - threshold)
                return true;
        }
        return false;
    }

    public void endOfList() {
    }
}
