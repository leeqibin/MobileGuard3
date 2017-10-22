package cn.edu.gdmec.android.mobileguard.m2theftguard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m2theftguard.entity.ContactInfo;

/**
 * Created by student on 17/10/17.
 */

public class ContactAdapter extends BaseAdapter{
    private List<ContactInfo> contactInfos;
    private Context context;
    public ContactAdapter(List<ContactInfo> contactInfos,Context context){
        super();
        this.contactInfos = contactInfos;
        this.context=context;
    }

    @Override
    public int getCount() {
        return contactInfos.size();
    }

    @Override
    public Object getItem(int i) {
        return contactInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item_list_contact_select, null);
           ViewHolder holder1 = new ViewHolder();
            holder1.mNameTV = (TextView) view.findViewById(R.id.tv_name);
            holder1.mPhoneTV = (TextView) view.findViewById(R.id.tv_safephone);
            view.setTag(holder);
        } else {
            holder=(ViewHolder) view.getTag();

        }
        holder.mNameTV.setText(contactInfos.get(i).name);
        holder.mPhoneTV.setText(contactInfos.get(i).phone);
        return view;
    }
    static class ViewHolder{
        TextView mNameTV;
        TextView mPhoneTV;
    }

}