package com.test.currency.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.currency.R;
import com.test.currency.model.Bank;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Антон on 04.04.2016.
 */
public class BankSpinnerAdapter extends BaseAdapter {
    private List<Bank> mData;

    public BankSpinnerAdapter(List<Bank> mData) {
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Bank getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bindData(getItem(position));
        return convertView;
    }

    static class ViewHolder {
        View view;
        @Bind(R.id.text_view_filter)
        TextView title;

        public ViewHolder(View view) {
            this.view = view;
        }

        public void bindData(Bank bank) {
            ButterKnife.bind(this,view);
            title.setText(bank.getTitle());
        }
    }

}
