package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private final List<User> userList;
    private final LayoutInflater inflater;

    public GridViewAdapter(Context context, List<User> userList) {
        this.userList = userList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_user, parent, false);
        }

        User user = userList.get(position);

        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewAge = convertView.findViewById(R.id.textViewAge);
        TextView textViewHeight = convertView.findViewById(R.id.textViewHeight);
        TextView textViewEmail = convertView.findViewById(R.id.textViewEmail);
        TextView textViewPhone = convertView.findViewById(R.id.textViewPhone);

        textViewName.setText(user.getName());
        textViewAge.setText("Age: " + user.getAge());
        textViewHeight.setText("Height: " + user.getHeight() + " cm");
        textViewEmail.setText("Email: " + user.getEmail());
        textViewPhone.setText("Phone: " + user.getPhone());

        return convertView;
    }
}
