package com.example.nazmuddinmavliwala.languagelist.languages.views.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nazmuddinmavliwala.languagelist.R;
import com.example.nazmuddinmavliwala.languagelist.base.views.recyclerview.ReactiveViewHolder;
import com.example.nazmuddinmavliwala.languagelist.languages.models.LanguageVO;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by nazmuddinmavliwala on 21/11/2017.
 */

public class LanguageViewHolder extends ReactiveViewHolder<LanguageVO> {

    @BindView(R.id.iv_language)
    ImageView ivLanguage;

    @BindView(R.id.tv_language)
    TextView tvLanguage;

    public LanguageViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    protected void bindData(LanguageVO data) {

        Picasso.Builder builder = new Picasso.Builder(this.context);
        builder.listener((picasso, uri, exception) -> exception.printStackTrace());
        builder.build().load(data.getImageUri()).into(ivLanguage);

        tvLanguage.setText(data.getName());
    }
}
